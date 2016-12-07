/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.cidade;

import api.dto.CidadeDTO;
import api.resources.CidadeResource;
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
@WebServlet(name = "cidade", urlPatterns = {"/cidade"})
public class ListaCidade extends HttpServlet{
    
    private CidadeDTO cidadeDTO;
    
    @Inject
    private OkClient okClient;
    
    @Inject
    private CidadeResource cidadeResource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        String jsonData = okClient.receberEndpoint("cidade");
        
        JSONObject jObject = new JSONObject(jsonData);
        JSONArray jArray = jObject.getJSONArray("cidades");

        List<CidadeDTO> lista = new ArrayList<CidadeDTO>();

        for (int i = 0; i < jArray.length(); i++) {
            cidadeDTO = new CidadeDTO();
            JSONObject objeto = jArray.getJSONObject(i);
            cidadeDTO.setId(objeto.getInt("id"));
            cidadeDTO.setLocalidade(objeto.getString("localidade"));
            JSONObject objetoUF = jArray.getJSONObject(i).getJSONObject("uf");
            cidadeDTO.setUf(cidadeResource.consultaSigla(objetoUF.getString("sigla")));
            lista.add(cidadeDTO);
        }

        req.setAttribute("lista", lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/cidade/listagem.jsp");
        dispatcher.forward(req, resp);
    }
}
