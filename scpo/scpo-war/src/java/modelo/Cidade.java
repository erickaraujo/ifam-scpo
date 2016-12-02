/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;

/**
 *
 * @author erick.araujo
 */

public class Cidade extends EntidadeBase{
    private String nome;
    private Integer codigoIbge;
    private Estado estado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
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
        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 17 * hash + (this.codigoIbge != null ? this.codigoIbge.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || getClass() != obj.getClass()) {return false;}
        
        final Cidade other = (Cidade) obj;
        
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.codigoIbge != other.codigoIbge && (this.codigoIbge == null || !this.codigoIbge.equals(other.codigoIbge))) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + ", codigoIbge=" + codigoIbge + '}';
    }    
}
