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
import resource.LogradouroResource;

/**
 *
 * @author erick.araujo
 */

@Path("/teste")
@Stateless
public class teste {
    
    @Inject
    private LogradouroResource resource;
    
    @GET
    @Path("/")
    public String teste(){
        //resource.listarEstados();
        return "teste!";
    }
}
