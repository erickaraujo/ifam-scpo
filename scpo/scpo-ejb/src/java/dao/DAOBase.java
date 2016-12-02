/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author erick.araujo
 */
public class DAOBase<E> {
    
    private final EntityManager em;
    private final Class<E> classe;
    
    
    public DAOBase(EntityManager em, Class<E> classe){
        this.em = em;
        this.classe = classe;
    }
    
    public void inserir(E entidade){
        em.persist(entidade);
    }
    
    public E consultar(Integer id){
        return em.find(classe, id);
    }
    
    public List<E> listarTodos(){
        return em.createQuery("select a from " + classe.getName() + " a", classe).getResultList();
    }
    
    public void remover(E entidade){
        em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
    }
    
    public E atualizar(E entidade){
        return em.merge(entidade);
    }
}
