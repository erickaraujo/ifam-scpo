/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import api.dto.EstadoDTO;
import api.response.EstadoResponse;
import core.dao.EstadoDAO;
import core.modelo.Estado;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import core.transformer.EstadoTransformer;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{sigla}")
    public Response buscaEstado(@PathParam("sigla") String sigla, EstadoDTO estadoDTO){
        if(sigla == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        
        final Estado estado = estadoDAO.consultarPorSigla(sigla);
        
        if(estado == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(estadoTransformer.toDTO(estado)).build();
    }  
}
