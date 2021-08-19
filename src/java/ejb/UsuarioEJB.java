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
import modelo.Usuario;

/**
 *
 * @author zscrollock
 */

@Stateless
public class UsuarioEJB {
     @PersistenceContext(unitName = "projeto-vendasPU")
    private EntityManager em;
    
    public List<Usuario> findAll(){
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }
    
    public List<Usuario> findByLogin(String login, String senha){
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.password = :senha", Usuario.class);
        query.setParameter("login", login).setParameter("senha", senha);
        return query.getResultList();
    }
    
    public void insert(Usuario user){
        em.persist(user);
    }
    
    public void delete(Usuario user){
        em.remove(em.merge(user));
    }
}
