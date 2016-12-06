/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import core.modelo.Cidade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author erick.araujo
 */
@Stateless
public class CidadeDAO {

    @PersistenceContext
    private EntityManager em;
    private DAOBase<Cidade> dao;

    @Inject
    Logger log;

    @PostConstruct
    private void init() {
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

    public Cidade consultarPorNome(String cidade) {
        TypedQuery<Cidade> query = em.createQuery("select c from Cidade c where c.localidade :cidade", Cidade.class);
        query.setParameter("cidade", cidade);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }
    
    public List<Cidade> consultarPorEstado(String estado){
        TypedQuery<Cidade> query = em.createQuery("SELECT c FROM Cidade c INNER JOIN c.estado e WHERE e.nome = :estado", Cidade.class);
        query.setParameter("estado", estado);
        try{
            return query.getResultList();
        }catch(NoResultException ex){
            log.info(ex.getMessage());
            return null;
        }
    }

    public void remover(Cidade entidade) {
        dao.remover(entidade);
    }

    public Cidade atualizar(Cidade entidade) {
        return dao.atualizar(entidade);
    }
}
