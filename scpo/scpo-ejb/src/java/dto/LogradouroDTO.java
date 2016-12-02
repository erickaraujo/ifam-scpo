/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.ejb.Stateless;

/**
 *
 * @author erick.araujo
 */

@Stateless
public class LogradouroDTO {
    private Integer id;
    private String descricaoLog;
    private String bairro;
    private String cep;
    private CidadeDTO cidade;
    
    public LogradouroDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getDescricaoLog() {
        return descricaoLog;
    }

    public void setDescricaoLog(String descricaoLog) {
        this.descricaoLog = descricaoLog;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CidadeDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDTO cidade) {
        this.cidade = cidade;
    }
    
}
