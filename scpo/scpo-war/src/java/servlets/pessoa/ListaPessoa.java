/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.pessoa;

import api.dto.EstadoDTO;
import api.dto.PessoaDTO;
import api.resources.LogradouroResource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import util.OkClient;

/**
 *
 * @author erick.araujo
 */
@WebServlet(name = "listaPessoa", urlPatterns = {"/pessoa"})
public class ListaPessoa extends HttpServlet {

    private PessoaDTO pessoaDTO;

    @Inject
    private OkClient okClient;

    @Inject
    private LogradouroResource logradouroResource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = okClient.receberEndpoint("pessoa");

        JSONObject jObject = new JSONObject(jsonData);
        JSONArray jArray = jObject.getJSONArray("pessoas");

        List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (int i = 0; i < jArray.length(); i++) {

                pessoaDTO = new PessoaDTO();
                JSONObject objeto = jArray.getJSONObject(i);
                pessoaDTO.setNome(objeto.getString("nome"));
                pessoaDTO.setSexo(objeto.getString("sexo").charAt(0));
                pessoaDTO.setOcupacao(objeto.getString("ocupacao"));
                pessoaDTO.setLogradouro(logradouroResource.verificaCep(objeto.getString("cep")));
                pessoaDTO.setNascimento(sdf.parse(objeto.getString("nascimento")));
                pessoaDTO.setEmail(objeto.getString("email"));
                lista.add(pessoaDTO);
            }
        } catch (ParseException ex) {
            Logger.getLogger(ListaPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("lista", lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/pessoa/listagem.jsp");
        dispatcher.forward(req, resp);
    }

}
