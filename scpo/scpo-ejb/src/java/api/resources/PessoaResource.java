/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.resources;

import api.dto.PessoaDTO;
import api.response.PessoaResponse;
import core.dao.PessoaDAO;
import core.modelo.Pessoa;
import core.transformer.PessoaTransformer;
import java.io.IOException;
import javax.inject.Inject;
import javax.management.j2ee.statistics.Stats;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author erick.araujo
 */
@Path("/pessoa")
public class PessoaResource {

    @Inject
    private PessoaTransformer pessoaTransformer;

    @Inject
    private PessoaDAO pessoaDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response listar() {
        return Response.ok().entity(new PessoaResponse(
                pessoaTransformer.toDTOList(pessoaDAO.listarTodos()))
        ).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response cadastrar(PessoaDTO pessoaDTO) {
        try {
            Pessoa pessoaCadastro = pessoaTransformer.toEntity(pessoaDTO);

            pessoaDAO.atualizar(pessoaCadastro);

            return Response.ok().status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response editar(@PathParam("id") Integer id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaDAO.consultar(id);
        if(pessoa==null){
            return Response.noContent().status(Response.Status.NOT_FOUND).build();
        }
        
        try{
            Pessoa pessoaAtualizada = pessoaTransformer.toEntity(pessoaDTO);
            pessoaAtualizada.setId(id);
            pessoaDAO.atualizar(pessoaAtualizada);
            
            return Response.accepted(pessoaAtualizada).build();
        }catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deletar(@PathParam("id") Integer id){
        Pessoa pessoa = pessoaDAO.consultar(id);
        
        try{
            pessoaDAO.remover(pessoa);
            return Response.accepted().build();
        }catch(Exception ex){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
    }
}
