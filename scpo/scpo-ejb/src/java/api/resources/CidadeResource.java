/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import api.dto.CidadeDTO;
import api.response.CidadeResponse;
import core.dao.CidadeDAO;
import core.dao.EstadoDAO;
import core.modelo.Estado;
import core.transformer.CidadeTransformer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author erick.araujo
 */
@Path("/cidade")
public class CidadeResource {

    @Inject
    private CidadeTransformer cidadeTransformer;

    @Inject
    private CidadeDAO cidadeDAO;

    @Inject
    private EstadoDAO estadoDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response listarCidades() {
        return Response.ok(new CidadeResponse(
                cidadeTransformer.toDTOList(cidadeDAO.listarTodos()))
        ).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cidade}")
    public Response buscaCidadePorEstado(@PathParam("cidade") String nomeEstado, CidadeDTO cidadeDTO) throws IOException {
        if (nomeEstado == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        final Estado estado = estadoDAO.consultarPorSigla(nomeEstado);

        return Response.ok(converteXmlToJson(consultaApi(estado.getSigla()))).build();

//        if (cidades.isEmpty()) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//        return Response.ok().entity(new CidadeResponse(cidadeTransformer
//                .toDTOList(cidades)))
//                .build();
    }

    private String consultaApi(String sigla) throws IOException {
        try {
            StringBuilder url = new StringBuilder();
            url.append("http://dadosabertos.almg.gov.br/ws/brasil/localidades/ufs/");
            url.append(sigla);
            url.append("/municipios");
            InputStream isUrl = new URL(url.toString()).openStream();
            return getStringFromInputStream(isUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CidadeResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private JSONObject converteXmlToJson(String resultado) {
        if (resultado == null) {
            return null;
        }
        JSONObject xmlJson = XML.toJSONObject(resultado);
        return xmlJson;
    }

    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
