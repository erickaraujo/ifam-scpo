/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick.araujo
 */
@Entity
@Table(name = "logradouro")
public class Logradouro extends EntidadeBase{
    
    @Column(nullable = false)
    private String logradouro;
    
    private String complemento;
    private String descricaoLog;

    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cep;
    
    @ManyToOne
    private Cidade localidade;
    
    public Logradouro(){
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

    public Cidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Cidade localidade) {
        this.localidade = localidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.logradouro != null ? this.logradouro.hashCode() : 0);
        hash = 97 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 97 * hash + (this.descricaoLog != null ? this.descricaoLog.hashCode() : 0);
        hash = 97 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 97 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 97 * hash + (this.localidade != null ? this.localidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Logradouro other = (Logradouro) obj;
        if ((this.logradouro == null) ? (other.logradouro != null) : !this.logradouro.equals(other.logradouro)) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if ((this.descricaoLog == null) ? (other.descricaoLog != null) : !this.descricaoLog.equals(other.descricaoLog)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if (this.localidade != other.localidade && (this.localidade == null || !this.localidade.equals(other.localidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "logradouro=" + logradouro + ", complemento=" + complemento + ", descricaoLog=" + descricaoLog + ", bairro=" + bairro + ", cep=" + cep + ", localidade=" + localidade + '}';
    }
    
    
}
