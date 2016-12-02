/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erick.araujo
 */
@XmlRootElement(name = "logradouro")
@Entity
@Table(name = "logradouro")
public class Logradouro extends EntidadeBase{
    
    @Column(nullable = false)
    private String descricaoLog;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cep;
    
    @ManyToOne
    private Cidade cidade;
    
    public Logradouro(){
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

    @XmlElement
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    @XmlElement
    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    @XmlElement
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.descricaoLog != null ? this.descricaoLog.hashCode() : 0);
        hash = 67 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 67 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 67 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
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
        if ((this.descricaoLog == null) ? (other.descricaoLog != null) : !this.descricaoLog.equals(other.descricaoLog)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if (this.cidade != other.cidade && (this.cidade == null || !this.cidade.equals(other.cidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "descricaoLog=" + descricaoLog + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + '}';
    }
}
