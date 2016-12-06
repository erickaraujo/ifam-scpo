/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.response;

import api.dto.EstadoDTO;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author erick.araujo
 */
public class EstadoResponse {

    private List<EstadoDTO> estados;

    public EstadoResponse(List<EstadoDTO> estados) {
        this.estados = estados;
    }

    public EstadoResponse(EstadoDTO... estado) {
        this.estados = Arrays.asList(estado);
    }

    public List<EstadoDTO> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoDTO> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "EstadoResponse{" + "estados=" + estados + '}';
    }
    
    
}
