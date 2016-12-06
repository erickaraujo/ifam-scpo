/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.util.List;
import org.slf4j.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import core.modelo.Estado;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author erick.araujo
 */
@Stateless
public class EstadoDAO {

    private DAOBase<Estado> dao;

    @Inject
    Logger log;

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    private void init() {
        dao = new DAOBase<Estado>(em, Estado.class);
    }

    public void inserir(Estado entidade) {
        dao.inserir(entidade);
    }

    public Estado consultar(Integer id) {
        return dao.consultar(id);
    }

    public Estado consultarPorNome(String nome) {
        TypedQuery<Estado> query = em.createQuery("select e from Estado e where e.nome = :nome", Estado.class);
        query.setParameter("nome", nome);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }

    public Estado consultarPorSigla(String sigla) {
        TypedQuery<Estado> query = em.createQuery("select e from Estado e where e.sigla = :sigla", Estado.class);
        query.setParameter("sigla", sigla);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            log.info(ex.getMessage());
            return null;
        }
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
