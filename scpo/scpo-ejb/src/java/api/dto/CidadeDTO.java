/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

import java.io.Serializable;
import javax.ejb.Stateless;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author erick.araujo
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Stateless
public class CidadeDTO implements Serializable{
    private Integer id;
    private String localidade;
    private EstadoDTO estado;
    private Integer ibge;

    public CidadeDTO(Integer id, String localidade, EstadoDTO estado, Integer ibge) {
        this.id = id;
        this.localidade = localidade;
        this.estado = estado;
        this.ibge = ibge;
    }

    public CidadeDTO(String localidade) {
        this.localidade = localidade;
    }
    
    
    public CidadeDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    @Override
    public String toString() {
        return "-----------" + 
                "\nid=" + id + 
                "\n localidade=" + localidade + 
                "\n estado=" + estado + 
                "\n ibge=" + ibge + "}\n";
    }
    
    

}
