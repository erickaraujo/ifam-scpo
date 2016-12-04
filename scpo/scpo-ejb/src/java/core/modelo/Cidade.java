/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.modelo;

import javax.persistence.*;

/**
 *
 * @author erick.araujo
 */

@Entity
@Table(name = "cidade")
public class Cidade extends EntidadeBase{
    
    @Column(nullable = false)
    private String localidade;
    
    private Integer ibge;
    
    @ManyToOne(optional = false)
    private Estado estado;

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.localidade != null ? this.localidade.hashCode() : 0);
        hash = 17 * hash + (this.ibge != null ? this.ibge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        
        final Cidade other = (Cidade) obj;
        
        if ((this.localidade == null) ? (other.localidade != null) : !this.localidade.equals(other.localidade)) {
            return false;
        }
        if (this.ibge != other.ibge && (this.ibge == null || !this.ibge.equals(other.ibge))) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
        return "Cidade{" + "nome=" + localidade + ", codigoIbge=" + ibge + '}';
    }    
}
