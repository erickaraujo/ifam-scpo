/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.*;
import modelo.Cidade;

/**
 *
 * @author erick.araujo
 */

public class CidadeDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    private DAOBase<Cidade> dao;
    
    @PostConstruct
    private void init(){
        dao = new DAOBase<Cidade>(em, Cidade.class);
    }

    public void inserir(Cidade entidade) {
        dao.inserir(entidade);
    }

    public Cidade consultar(Integer id) {
        return dao.consultar(id);
    }

    public List<Cidade> listarTodos() {
        return dao.listarTodos();
    }

    public void remover(Cidade entidade) {
        dao.remover(entidade);
    }

    public Cidade atualizar(Cidade entidade) {
        return dao.atualizar(entidade);
    }  
}
