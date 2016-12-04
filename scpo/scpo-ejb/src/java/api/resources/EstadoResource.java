/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import core.dao.EstadoDAO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import core.modelo.Estado;
import api.response.EstadoResponse;
import core.transformer.EstadoTransformer;

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

        List<Estado> estados = estadoDAO.listarTodos();

        return Response.ok().entity(new EstadoResponse(
                estadoTransformer.toDTOList(estados))).build();
    }
}
