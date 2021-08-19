/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author zscrollock
 */
@Named
@RequestScoped
public class Mensagem {
    
    private static void addMessagem(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public static void showInformacao(String mensagem) {
        addMessagem(FacesMessage.SEVERITY_INFO, "Informação", mensagem);
    }

    public static void showAlerta(String mensagem) {
        addMessagem(FacesMessage.SEVERITY_WARN, "Alerta", mensagem);
    }

    public static void showErro(String mensagem) {
        addMessagem(FacesMessage.SEVERITY_ERROR, "Erro", mensagem);
    }
}
