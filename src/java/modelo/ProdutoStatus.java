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
public enum ProdutoStatus {
    DISPONIVEL, INDISPONIVEL;
    
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
