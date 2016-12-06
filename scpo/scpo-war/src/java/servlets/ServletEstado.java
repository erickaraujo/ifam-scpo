/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import api.dto.EstadoDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "estado", urlPatterns = {"/estado"})
public class ServletEstado extends HttpServlet {

    private EstadoDTO estadoDTO;

    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String URL = "http://localhost:8080/scpo/api/estado";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();

        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();

        JSONObject jObject = new JSONObject(jsonData);
        JSONArray jArray = jObject.getJSONArray("estados");

        List<EstadoDTO> lista = new ArrayList<EstadoDTO>();

        for (int i = 0; i < jArray.length(); i++) {
            estadoDTO = new EstadoDTO();
            JSONObject objeto = jArray.getJSONObject(i);
            estadoDTO.setId(objeto.getInt("id"));
            estadoDTO.setNome(objeto.getString("nome"));
            estadoDTO.setSigla(objeto.getString("sigla"));
            lista.add(estadoDTO);
        }
        System.out.println("lista ---->" + lista);

        req.setAttribute("lista", lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/estado/listagem.jsp");
        dispatcher.forward(req, res);
    }

}
