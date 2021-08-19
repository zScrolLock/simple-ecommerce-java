/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author zscrollock
 */
@Embeddable
public class Venda_ProdutoPK implements Serializable {
    
    @Column(name = "id_venda", insertable = false, updatable = false)
    private int venda;
    
    @Column(name = "id_produto", insertable = false, updatable = false)
    private int produto;

    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.venda;
        hash = 89 * hash + this.produto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda_ProdutoPK other = (Venda_ProdutoPK) obj;
        if (this.venda != other.venda) {
            return false;
        }
        if (this.produto != other.produto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda_ProdutoPK{" + "venda=" + venda + ", produto=" + produto + '}';
    }
}
