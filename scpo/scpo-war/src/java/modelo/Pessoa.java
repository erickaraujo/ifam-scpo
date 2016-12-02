/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author erick.araujo
 */

public class Pessoa extends EntidadeBase{
    private String nome;
    private Integer idade;    
    private Date nascimento;
    private char sexo;
    private String ocupacao;
    private String email;
    private Logradouro logradouro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    private void setIdade() {
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.setTime(nascimento);
        
        Calendar dataHoje = Calendar.getInstance();
        Integer idade = dataHoje.get(Calendar.YEAR) - dataInicio.get(Calendar.YEAR);
        this.idade = idade;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", nascimento=" + nascimento + ", sexo=" + sexo + ", ocupacao=" + ocupacao + ", email=" + email + ", logradouro=" + logradouro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.idade != null ? this.idade.hashCode() : 0);
        hash = 41 * hash + (this.nascimento != null ? this.nascimento.hashCode() : 0);
        hash = 41 * hash + this.sexo;
        hash = 41 * hash + (this.ocupacao != null ? this.ocupacao.hashCode() : 0);
        hash = 41 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 41 * hash + (this.logradouro != null ? this.logradouro.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.ocupacao == null) ? (other.ocupacao != null) : !this.ocupacao.equals(other.ocupacao)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.idade != other.idade && (this.idade == null || !this.idade.equals(other.idade))) {
            return false;
        }
        if (this.nascimento != other.nascimento && (this.nascimento == null || !this.nascimento.equals(other.nascimento))) {
            return false;
        }
        if (this.logradouro != other.logradouro && (this.logradouro == null || !this.logradouro.equals(other.logradouro))) {
            return false;
        }
        return true;
    }
    
}
