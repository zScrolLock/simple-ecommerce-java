/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author zscrollock
 */
public enum VendaTipoPagmt {
    CREDITO, A_VISTA;
    
    public static VendaTipoPagmt getCREDITO() {    
        return CREDITO;
    }

    public static VendaTipoPagmt getA_VISTA() {
        return A_VISTA;
    }    
}


