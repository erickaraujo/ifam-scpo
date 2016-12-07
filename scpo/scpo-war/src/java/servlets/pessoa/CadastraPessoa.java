/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.pessoa;

import api.dto.LogradouroDTO;
import api.dto.PessoaDTO;
import api.resources.LogradouroResource;
import core.transformer.LogradouroTransformer;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa/cadastro"})
public class CadastraPessoa extends HttpServlet {

    private PessoaDTO pessoaDTO;

    @Inject
    private LogradouroResource logradouroResource;

    @Inject
    private LogradouroTransformer logradouroTransformer;

    @EJB
    LogradouroDTO logradouroDTO;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        pessoaDTO = new PessoaDTO();

        pessoaDTO.setNome("Joao");
        char c = 'M';
        pessoaDTO.setSexo(c);
        pessoaDTO.setOcupacao("Empresário");
        Date data = new Date();
        pessoaDTO.setNascimento(data);
        pessoaDTO.setLogradouro(logradouroResource.consultaCep("69070-750", logradouroDTO));
        pessoaDTO.setEmail("joao@adm.com");

        String path = "pessoa";
        String URL = "http://localhost:8080/scpo/api/" + path;
        OkHttpClient client = new OkHttpClient();

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(pessoaDTO);
        System.out.println("json: " + json);

        MediaType type = MediaType.parse("application/json; charset=utf-8");

        Request request = new Request.Builder()
                .url(URL)
                .post(RequestBody.create(type, json))
                .build();

        Response response = client.newCall(request).execute();

        System.out.println("RESPOSTA ---> " + response.body().string());

    }

}
