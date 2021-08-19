/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import ejb.UsuarioEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;
import modelo.UsuarioEnum;
import modelo.Venda_Produto;
import util.Mensagem;

/**
 *
 * @author zscrollock
 */
@Named(value = "usuarioControle")
@SessionScoped
public class UsuarioControle implements Serializable{
    
    @EJB
    private UsuarioEJB userEJB;
    
    private Usuario user;
    private Usuario logado = new Usuario();
    private List<Usuario> usuarios;
    
    public UsuarioControle(){
   
    }
    
    @PostConstruct
    private void initValues(){
        
//        this.user = new Usuario();
//        this.user.setName("Admin");
//        this.user.setLogin("admin");
//        this.user.setPassword("admin");
//        this.user.setLevel(UsuarioEnum.ADMINISTRADOR);
//        userEJB.insert(this.user);
//        
//        this.user = new Usuario();
//        this.user.setName("Cliente");
//        this.user.setLogin("cliente");
//        this.user.setPassword("cliente");
//        this.user.setLevel(UsuarioEnum.CLIENTE);
//        userEJB.insert(this.user);
//        
//        this.user = new Usuario();
//        this.user.setName("Funcionario");
//        this.user.setLogin("funcionario");
//        this.user.setPassword("funcionario");
//        this.user.setLevel(UsuarioEnum.FUNCIONARIO);
//        userEJB.insert(this.user); 
    }
    
    public void insertUsers(){
        this.user = new Usuario();
        this.user.setName("Admin");
        this.user.setLogin("admin");
        this.user.setPassword("admin");
        this.user.setLevel(UsuarioEnum.ADMINISTRADOR);
        userEJB.insert(this.user);
        
        this.user = new Usuario();
        this.user.setName("Cliente");
        this.user.setLogin("cliente");
        this.user.setPassword("cliente");
        this.user.setLevel(UsuarioEnum.CLIENTE);
        userEJB.insert(this.user);
        
        this.user = new Usuario();
        this.user.setName("Funcionario");
        this.user.setLogin("funcionario");
        this.user.setPassword("funcionario");
        this.user.setLevel(UsuarioEnum.FUNCIONARIO);
        userEJB.insert(this.user); 
    }
    
    public String logar(){
        String login = logado.getLogin();
        String senha = logado.getPassword();
        
        usuarios = userEJB.findByLogin(login, senha);
                
        if(usuarios.isEmpty()){
            Mensagem.showErro("Wrong Login or Wrong Password");
            return "/index.xhtml";
        }else{
            user = usuarios.get(usuarios.size()-1);
            Mensagem.showInformacao("Sign-in Sucessful");
            return "/menu.xhtml";
        }
    }
    
    public String logout(){
        Venda_ProdutoControle vp = new Venda_ProdutoControle();
        List<Venda_Produto> itens = new ArrayList<>();
        vp.setItens(itens);
        this.logado.setLogin("");
        this.logado.setPassword("");
        this.logado = null;
        this.user = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        Mensagem.showInformacao("Sign-out Sucessful");
        return "/index.xhtml";
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getLogado() {
        return logado;
    }

    public void setLogado(Usuario logado) {
        this.logado = logado;
    }
    
    
}
