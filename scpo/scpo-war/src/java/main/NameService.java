/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author erick.araujo
 */
import javax.ejb.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import resource.LogradouroResource;

@Path("name")
@Stateless
public class NameService {
    
    @Inject
    private LogradouroResource logradouroResource;
    
    @EJB
    private NameBean nameBean;
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHtml() { 
        return logradouroResource.listarEstados();
    }
    
    @PUT    
    @Consumes("text/plain")
    public void put(String content) {
        nameBean.setName(content);
    }}
