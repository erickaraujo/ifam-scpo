/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import api.response.EstadoResponse;
import core.dao.EstadoDAO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import core.transformer.EstadoTransformer;
import javax.ws.rs.core.Response;

/**
 *
 * @author erick.araujo
 */
@Path("/estado")
public class EstadoResource {

    @Inject
    private EstadoTransformer estadoTransformer;

    @Inject
    private EstadoDAO estadoDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response listarEstados() {
        return Response.ok(new EstadoResponse(
                estadoTransformer.toDTOList(estadoDAO.listarTodos()))
        ).build();
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/")
//    public void listarEstados(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
//        List<EstadoDTO> lista = new ArrayList<EstadoDTO>();
//        lista = estadoTransformer.toDTOList(estadoDAO.listarTodos());
//        System.out.println("t: " + estadoTransformer.toDTOList(estadoDAO.listarTodos()));
//        request.setAttribute("listaEstados", lista);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8080/scpo/");
//        dispatcher.forward(request, response);
//    }
    
    
}
