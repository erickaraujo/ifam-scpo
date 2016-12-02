/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package endpoint;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import resource.LogradouroResource;

/**
 *
 * @author erick.araujo
 */

@Path("/teste")
@Stateless
public class teste {
    
    @Inject
    private LogradouroResource logradouroResource;
    
    @GET    
    @Produces(MediaType.APPLICATION_XML)
    public Response getListaEstados() { 
        return logradouroResource.listarEstados();
    }
}
