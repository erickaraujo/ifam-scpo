/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import dao.EstadoDAO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Estado;
import modelo.Logradouro;
import response.EstadoResponse;
import transformer.EstadoTransformer;

/**
 *
 * @author erick.araujo
 */

@Path("/logradouro")
public class LogradouroResource {
    
    @Inject
    private EstadoTransformer estadoTransformer;
    
    @Inject
    private EstadoDAO estadoDAO;
    
    @GET
    @Path("/cep/{cep}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Logradouro respostaCep(@PathParam("cep") String cep){
        Logradouro log = new Logradouro();
        
        log.setCep(cep);

        return log;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response listarEstados(){
        
        List<Estado> estados = estadoDAO.listarTodos();
        
        return Response.ok().entity(new EstadoResponse(
            estadoTransformer.toDTOList(estados))).build();
    }
}
