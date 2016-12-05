/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import core.modelo.Logradouro;
import static java.lang.Math.log;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author erick.araujo
 */

@Stateless
public class LogradouroDAO {
    
    private DAOBase<Logradouro> dao;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    Logger log;

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
    
    public Logradouro consultarPorCep(String cep){
        TypedQuery<Logradouro> query = em.createQuery("select l from Logradouro l where l.cep = :cep", Logradouro.class);
        query.setParameter("cep", cep);
            try{
                return query.getSingleResult();
            }catch(NoResultException ex){
                log.info(ex.getMessage());
                return null;
            }
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
