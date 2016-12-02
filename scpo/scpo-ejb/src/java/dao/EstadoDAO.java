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
import modelo.Estado;

/**
 *
 * @author erick.araujo
 */

public class EstadoDAO{
    
    private DAOBase<Estado> dao;
    
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    private void init(){
        dao = new DAOBase<Estado>(em, Estado.class);
    }
    
    public void inserir(Estado entidade) {
        dao.inserir(entidade);
    }

    public Estado consultar(Integer id) {
        return dao.consultar(id);
    }

    public List<Estado> listarTodos() {
        return dao.listarTodos();
    }

    public void remover(Estado entidade) {
        dao.remover(entidade);
    }

    public Estado atualizar(Estado entidade) {
        return dao.atualizar(entidade);
    }
    
    
}
