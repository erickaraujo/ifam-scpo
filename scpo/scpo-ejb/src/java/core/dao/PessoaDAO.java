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
import core.modelo.Pessoa;
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
public class PessoaDAO {

    @PersistenceContext
    private EntityManager em;

    private DAOBase<Pessoa> dao;
    
    @Inject
    Logger log;

    @PostConstruct
    private void init() {
        dao = new DAOBase<Pessoa>(em, Pessoa.class);
    }

    public void inserir(Pessoa entidade) {
        dao.inserir(entidade);
    }

    public Pessoa consultar(Integer id) {
        return dao.consultar(id);
    }
    
    public Pessoa consultarPorEmail(String email) {
        TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p where p.email = :email", Pessoa.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }

    public List<Pessoa> listarTodos() {
        return dao.listarTodos();
    }

    public void remover(Pessoa entidade) {
        dao.remover(entidade);
    }

    public Pessoa atualizar(Pessoa entidade) {
        return dao.atualizar(entidade);
    }
}
