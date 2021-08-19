/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Venda_Produto;

/**
 *
 * @author zscrollock
 */
@Stateless
public class Venda_ProdutoEJB implements Serializable {
    
    @PersistenceContext(unitName = "projeto-vendasPU")
    private EntityManager em;
        
    public void insert(Venda_Produto vendaProduto){
        em.persist(vendaProduto);
    }
    
    public void delete(Venda_Produto vendaProduto){
        em.remove(em.merge(vendaProduto));
    }
    
    public List<Venda_Produto> findByVenda(int id_venda){
        TypedQuery<Venda_Produto> query = em.createQuery("SELECT vp FROM Venda_Produto vp WHERE vp.venda_ProdutoPK.venda = :id_venda", Venda_Produto.class);
        query.setParameter("id_venda", id_venda);
        return query.getResultList();
    }
    
    public List<Venda_Produto> findByProdVenda(int id_venda, int id_produto){
        TypedQuery<Venda_Produto> query = em.createQuery("SELECT vp FROM Venda_Produto vp WHERE vp.venda.idVenda = :id_venda AND vp.produto.productCode = :id_produto", Venda_Produto.class);
        query.setParameter("id_venda", id_venda).setParameter("id_produto", id_produto);
        return query.getResultList();
    }
    
}
