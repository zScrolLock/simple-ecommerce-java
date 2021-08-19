/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import controle.ProdutoControle;
import controle.UsuarioControle;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import modelo.UsuarioEnum;

/**
 *
 * @author zscrollock
 */
public class LifeCycleListener implements PhaseListener{
    
    @Inject
    private UsuarioControle userControl;

    @Override
    public void afterPhase(PhaseEvent pe) {
        System.out.println("After Phase: " + pe.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        System.out.println("Before Phase:" + pe.getPhaseId());
        
        ExternalContext ec = pe.getFacesContext().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        String pagina = request.getPathInfo();
        

        
        if(pagina.startsWith("/clientes/tablePageCliente.xhtml")){
            if(userControl.getUser().getLevel().equals(UsuarioEnum.FUNCIONARIO) || userControl.getUser().getLevel().equals(UsuarioEnum.ADMINISTRADOR)){
                try{
                    ec.redirect(ec.getRequestContextPath() + "/faces/produtos/tablePage.xhtml");
                }catch(IOException ex){
                    System.out.println("Falha ao redirecionar");
                }
            }
        }
        
        if(pagina.startsWith("/faces/produtos/tablePage.xhtml")){
            if(!userControl.getUser().getLevel().equals(UsuarioEnum.FUNCIONARIO) || !userControl.getUser().getLevel().equals(UsuarioEnum.ADMINISTRADOR)){
                try{
                    ec.redirect(ec.getRequestContextPath() + "/faces/clientes/tablePageCliente.xhtml");
                }catch(IOException ex){
                    System.out.println("Falha ao redirecionar");
                }
            }
        }      
        
        if(pagina.startsWith("/menu.xhtml")){
            if(userControl == null && userControl.getUser()== null){
                try{
                    ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
                }catch(IOException e){
                    System.out.println("Falha ao Logar");
                }
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
