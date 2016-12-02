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
import modelo.Pessoa;
import javax.ejb.Stateless;

/**
 *
 * @author erick.araujo
 */

@Stateless
public class PessoaDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    private DAOBase<Pessoa> dao;
    
    @PostConstruct
    private void init(){
        dao = new DAOBase<Pessoa>(em, Pessoa.class);
    }

    public void inserir(Pessoa entidade) {
        dao.inserir(entidade);
    }

    public Pessoa consultar(Integer id) {
        return dao.consultar(id);
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
