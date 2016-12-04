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
public class LogradouroDTO {
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private CidadeDTO localidade;
    private String descricaoLog;

    public LogradouroDTO(Integer id, String cep, String logradouro, String complemento, String bairro, CidadeDTO localidade, String descricaoLog) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.descricaoLog = descricaoLog;
    }
    
    
    
    public LogradouroDTO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public CidadeDTO getLocalidade() {
        return localidade;
    }

    public void setLocalidade(CidadeDTO localidade) {
        this.localidade = localidade;
    }

    public String getDescricaoLog() {
        return descricaoLog;
    }

    public void setDescricaoLog(String descricaoLog) {
        this.descricaoLog = descricaoLog;
    }

    @Override
    public String toString() {
        return "--------------"
                + "\n{id=" + id + "\n cep=" + cep + "\n logradouro=" + logradouro + "\n complemento=" + complemento + 
                "\n bairro=" + bairro +
                "\n localidade=" + localidade + 
                "\n descricaoLog=" + descricaoLog + "}\n";
    }

    

}
