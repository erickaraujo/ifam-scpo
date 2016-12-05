/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import core.dao.CidadeDAO;
import core.dao.LogradouroDAO;
import api.dto.CidadeDTO;
import api.dto.LogradouroDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import core.modelo.Logradouro;
import org.codehaus.jackson.map.ObjectMapper;
import core.transformer.CidadeTransformer;
import core.transformer.LogradouroTransformer;

/**
 *
 * @author erick.araujo
 */
@Path("/logradouro")
public class LogradouroResource {

    @Inject
    private LogradouroTransformer logradouroTransformer;

    @Inject
    private LogradouroDAO logradouroDAO;

    @Inject
    private CidadeDTO cidadeDTO;

    @Inject
    private CidadeTransformer cidadeTransformer;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response recebeCep(LogradouroDTO logradouroDTO) {
        List<Logradouro> logradouros = logradouroDAO.listarTodos();
        return Response.ok().entity(logradouroTransformer.toDTOList(logradouros)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cep}")
    public Response buscaCep(@PathParam("cep") String cep, LogradouroDTO logradouroDTO) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            logradouroDTO = mapper.readValue(new URL("http://viacep.com.br/ws/" + cep + "/json/"), LogradouroDTO.class);
            
            //verifica se logradouro teve cep ou nao
            boolean c = logradouroDTO.getCep() != null;
            
            //implementar. Se true tem/possui string. Se false, algo errado. Escrever teste.
            logradouroDAO.atualizar(logradouroTransformer.toEntity(logradouroDTO));

            return Response.ok().entity(logradouroTransformer.toEntity(logradouroDTO)).build();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
}
