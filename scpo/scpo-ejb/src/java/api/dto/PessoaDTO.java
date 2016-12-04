/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto;

import java.util.Date;

/**
 *
 * @author erick.araujo
 */
public class PessoaDTO {
    private Integer id;
    private String nome;
    private Integer idade;
    private Date nascimento;
    private char sexo;
    private String ocupacao;
    private String email;
    private LogradouroDTO logradouro;

    public PessoaDTO(String nome, Integer idade, Date nascimento, char sexo, String ocupacao, String email, LogradouroDTO logradouro) {
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.ocupacao = ocupacao;
        this.email = email;
        this.logradouro = logradouro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public PessoaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
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

    public LogradouroDTO getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(LogradouroDTO logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return "\b----------------- "  + 
                "\n{id = "+ id + "\nnome=" + nome +
                "\n idade=" + idade + 
                "\n nascimento=" + nascimento + 
                "\n sexo=" + sexo + 
                "\n ocupacao=" + ocupacao + 
                "\n email=" + email + 
                "\n logradouro=" + logradouro + "}\n";
    }
    
}
