/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloList;

import api.dto.EstadoDTO;
import java.util.List;

/**
 *
 * @author erick.araujo
 */
public class EstadoList {

    private List<EstadoDTO> estados;

    public EstadoList() {
    }

    public EstadoList(List<EstadoDTO> estados) {
        this.estados = estados;
    }

    public List<EstadoDTO> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoDTO> estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "EstadoList{" + "estados=" + estados + '}';
    }
}
