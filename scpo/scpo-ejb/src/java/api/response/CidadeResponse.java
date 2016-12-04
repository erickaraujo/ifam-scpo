/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.response;

import api.dto.CidadeDTO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author erick.araujo
 */
public class CidadeResponse {

    private List<CidadeDTO> estados;

    public CidadeResponse(List<CidadeDTO> estados) {
        this.estados = estados;
    }

    public CidadeResponse(CidadeDTO... estado) {
        this.estados = Arrays.asList(estado);
    }

    public List<CidadeDTO> getCidades() {
        return estados;
    }

    public void setCidades(List<CidadeDTO> estados) {
        this.estados = estados;
    }
}
