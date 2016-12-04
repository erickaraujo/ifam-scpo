/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.response;

import api.dto.PessoaDTO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author erick.araujo
 */
public class PessoaResponse {
    private List<PessoaDTO> pessoas;

    public PessoaResponse(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoaResponse(PessoaDTO... pessoa) {
        this.pessoas = Arrays.asList(pessoa);
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }
}
