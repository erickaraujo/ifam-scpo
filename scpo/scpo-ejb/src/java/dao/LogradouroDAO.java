/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Logradouro;
import javax.ejb.Stateless;

/**
 *
 * @author erick.araujo
 */

@Stateless
public class LogradouroDAO {
    
    private DAOBase<Logradouro> dao;
    
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void init(){
        dao = new DAOBase<Logradouro>(em, Logradouro.class);
    }
    
    public void inserir(Logradouro entidade) {
        dao.inserir(entidade);
    }

    public Logradouro consultar(Integer id) {
        return dao.consultar(id);
    }

    public List<Logradouro> listarTodos() {
        return dao.listarTodos();
    }

    public void remover(Logradouro entidade) {
        dao.remover(entidade);
    }

    public Logradouro atualizar(Logradouro entidade) {
        return dao.atualizar(entidade);
    }
}
