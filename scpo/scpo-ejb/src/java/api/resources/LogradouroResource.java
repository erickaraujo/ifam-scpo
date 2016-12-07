/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import core.dao.CidadeDAO;
import core.dao.LogradouroDAO;
import api.dto.CidadeDTO;
import api.dto.LogradouroDTO;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import core.modelo.Logradouro;
import org.codehaus.jackson.map.ObjectMapper;
import core.transformer.CidadeTransformer;
import core.transformer.LogradouroTransformer;

/**
 *
 * @author erick.araujo
 */
@Path("/logradouro")
public class LogradouroResource {

    @Inject
    private LogradouroTransformer logradouroTransformer;

    @Inject
    private LogradouroDAO logradouroDAO;

    @Inject
    private CidadeDTO cidadeDTO;

    @Inject
    private CidadeTransformer cidadeTransformer;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response recebeCep(LogradouroDTO logradouroDTO) {
        List<Logradouro> logradouros = logradouroDAO.listarTodos();
        return Response.ok().entity(logradouroTransformer.toDTOList(logradouros)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cep}")
    public Response buscaCep(@PathParam("cep") String cep, LogradouroDTO logradouroDTO) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            logradouroDTO = mapper.readValue(new URL("http://viacep.com.br/ws/" + cep + "/json/"), LogradouroDTO.class);
            
            LogradouroDTO existe = logradouroTransformer.toDTO(logradouroDAO.consultarPorCep(logradouroDTO.getCep()));
            
            if(!existe.equals(logradouroDTO)){
                logradouroDAO.inserir(logradouroTransformer.toEntity(logradouroDTO));
                return Response.ok().entity(logradouroTransformer.toEntity(logradouroDTO)).build();
            }
            
            logradouroDAO.atualizar(logradouroTransformer.toEntity(logradouroDTO));
            return Response.ok().entity(logradouroTransformer.toEntity(logradouroDTO)).build();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
    
    public LogradouroDTO verificaCep(String cep){
        if(cep.isEmpty()){
            return null;
        }
        
        final LogradouroDTO logradouro = logradouroTransformer.toDTO(logradouroDAO.consultarPorCep(cep));
        
        return logradouro;
    }
    
    public LogradouroDTO consultaCep(String cep, LogradouroDTO logradouroDTO) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            logradouroDTO = mapper.readValue(new URL("http://viacep.com.br/ws/" + cep + "/json/"), LogradouroDTO.class);
            
            LogradouroDTO logradouro = logradouroTransformer.toDTO(logradouroDAO.consultarPorCep(logradouroDTO.getCep()));
            
            if(logradouro == null){
                return null;
            }
            
            return logradouroDTO;
            
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
}
