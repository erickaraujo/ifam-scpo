/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.util;

import core.dao.CidadeDAO;
import core.dao.EstadoDAO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import core.modelo.Cidade;
import core.modelo.Estado;
import org.json.XML;

/**
 *
 * @author erick.araujo
 */

@Singleton
@Startup
public class StartupListener{
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private EstadoDAO estadoDAO;
    
    @Inject
    private CidadeDAO cidadeDAO;

    @PostConstruct
    public void init() {
        populaEstados();
    }

    private void populaEstados(){
        TypedQuery<Estado> query = em.createQuery("select e from Estado e", Estado.class);
        query.setMaxResults(1);
        List<Estado> cidades = query.getResultList();
        
        if(cidades.isEmpty()){

            String line;
            String cvsSplit = ",";

           try {
                System.out.println("ff:"+ getClass().getResourceAsStream("/util/lista_estados.csv"));
                InputStream is = getClass().getResourceAsStream("/util/lista_estados.csv");
                InputStreamReader file = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(file);

                while ((line = br.readLine()) != null) {
                    String[] estados = line.split(cvsSplit);

                    Estado estado = new Estado();
                    Cidade cidade = new Cidade();
//                    estado.setId(Integer.parseInt(estados[1]));
                    estado.setNome(estados[1]);
                    estado.setSigla(estados[2]);
                    cidade.setLocalidade(estados[3]);
                    cidade.setEstado(estado);
                    estadoDAO.inserir(estado);
                    cidadeDAO.inserir(cidade);
                    
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    
}
