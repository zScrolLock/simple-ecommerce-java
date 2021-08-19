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
import modelo.Produto;

/**
 *
 * @author zscrollock
 */

@Stateless
public class ProdutoEJB {
    
    @PersistenceContext(unitName = "projeto-vendasPU")
    private EntityManager em;
    
    public List<Produto> findAll(){
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
    
    public List<Produto> findByCode(int codigo){
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.productCode = :codigo", Produto.class);
        query.setParameter(codigo, "codigo");
        return query.getResultList();
    }
    
    public List<Produto> findByName(String name){
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.name LIKE :name", Produto.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
    
    public void insert(Produto product){
        em.persist(product);
    }
    
    public void delete(Produto product){
        em.remove(em.merge(product));
    }
}
