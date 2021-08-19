/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Venda;

/**
 *
 * @author zscrollock
 */
@Stateless
public class Venda_EJB {
    
    @PersistenceContext(unitName = "projeto-vendasPU")
    private EntityManager em;
    
    public List<Venda> findAll(){
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v", Venda.class);
        return query.getResultList();
    }
    
    public List<Venda> findByCode(int codigo){
        TypedQuery<Venda> query = em.createQuery("SELECT v FROM Venda v WHERE v.idVenda = :codigo", Venda.class);
        query.setParameter(codigo, "codigo");
        return query.getResultList();
    }
    
    public void insert(Venda venda){
        em.persist(venda);
    }
    
    public void update(Venda venda){
        em.merge(venda);
    }
    
    public void delete(Venda venda){
        em.remove(em.merge(venda));
    }
}
