/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import api.dto.EstadoDTO;
import api.resources.EstadoResource;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import modeloList.EstadoList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "estado", urlPatterns = {"/listarEstado"})
public class ServletEstado extends HttpServlet {

//    @Inject
//    private EstadoResource estadoResource;
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        ResteasyClient client = new ResteasyClientBuilder().build();
//        ResteasyWebTarget resourceApi = client.target("http://localhost:8080/scpo/api/");
//        ResteasyWebTarget estadoApi = resourceApi.path("/estado");
//        Response response = estadoApi.request().get();
//        
//        System.out.println(response.getStatus());
//        System.out.println(response.readEntity(estadoDTO.getClass()));
//        response.close();
//
//        req.setAttribute("listarEstado", "hua");
//        System.out.println("BLA " + estadoResource.listarEstados());
//        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
//        dispatcher.forward(req, res);
//    }
    
    @EJB
        private EstadoDTO estadoDTO;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String URL = "http://localhost:8080/scpo/api/estado";
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(URL);
        HttpResponse response = httpClient.execute(httpget);

        System.out.println("RESPONSE ---> " + response);

        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        
        System.out.println("STRING RESULT ---> " + result);

        ObjectMapper mapper = new ObjectMapper();
        EstadoList estadoResponse = mapper.readValue(result, EstadoList.class);
        
        System.out.println("LISTA ---> " + estadoResponse);

        req.setAttribute("listarEstado", estadoResponse);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, res);
    }

}
