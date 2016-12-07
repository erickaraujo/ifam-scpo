/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cidade;

import api.dto.CidadeDTO;
import api.dto.EstadoDTO;
import api.resources.CidadeResource;
import core.transformer.EstadoTransformer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import util.OkClient;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "cidade", urlPatterns = {"/cidade/busca"})
public class BuscaCidade extends HttpServlet {

    private CidadeDTO cidadeDTO;
    
    @Inject
    private EstadoTransformer estadoTransformer; 

    @Inject
    private OkClient okClient;
    
    @Inject
    private CidadeResource cidadeResource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String sigla = req.getParameter("sigla");
        
        String jsonData = okClient.receberEndpoint("cidade/"+sigla);

        JSONObject jObject = new JSONObject(jsonData);
        JSONObject jArray = jObject.getJSONObject("listaMunicipio");
        JSONArray jArray2 = jArray.getJSONArray("municipio");

        List<CidadeDTO> lista = new ArrayList<CidadeDTO>();

        for (int i = 0; i < jArray.length(); i++) {
            cidadeDTO = new CidadeDTO();
            JSONObject objeto = jArray2.getJSONObject(i);
            cidadeDTO.setLocalidade(objeto.getString("nome"));
            cidadeDTO.setUf(cidadeResource.consultaSigla(objeto.getString("uf")));
            cidadeDTO.setIbge(objeto.getInt("codigoIbge9"));
            lista.add(cidadeDTO);
        }
        
        req.setAttribute("lista", lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/cidade/listagem.jsp");
        dispatcher.forward(req, resp);

    }

}
