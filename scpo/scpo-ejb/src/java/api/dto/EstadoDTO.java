/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

import javax.ejb.Stateless;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author erick.araujo
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Stateless
public class EstadoDTO {
    private Integer id;
    private String nome;
    private String sigla;
    
    public EstadoDTO(){
    }
    
    public EstadoDTO(Integer id, String nome, String sigla){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "---------------" + 
                "\nid=" + id + 
                "\nnome=" + nome + 
                "\nsigla=" + sigla + "}\n";
    }
    
    
}
