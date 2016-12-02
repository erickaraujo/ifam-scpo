/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.EstadoDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Estado;

/**
 *
 * @author erick.araujo
 */

@Singleton
@Startup
public class StartupListener {
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private EstadoDAO estadoDAO;
    
    @PostConstruct
    public void init(){
        TypedQuery<Estado> query = em.createQuery("select e from Estado e", Estado.class);
        query.setMaxResults(1);
        List<Estado> cidades = query.getResultList();
        
        if(cidades.isEmpty()){
            try{
                Estado estado = new Estado();
                estado.setNome("Para");
                estado.setSigla("PA");
                estadoDAO.inserir(estado);
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println("blabla");
        }
    }
}
