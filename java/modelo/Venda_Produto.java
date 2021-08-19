 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author zscrollock
 */
@Entity
@Table(name = "venda_produto")
public class Venda_Produto implements Serializable{
    
    @EmbeddedId
    private Venda_ProdutoPK venda_ProdutoPK;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "valortotal", nullable = false)
    private float valortotal;
    
    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private Venda venda;
    
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    public Venda_ProdutoPK getVenda_ProdutoPK() {
        return venda_ProdutoPK;
    }

    public void setVenda_ProdutoPK(Venda_ProdutoPK venda_ProdutoPK) {
        this.venda_ProdutoPK = venda_ProdutoPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.venda_ProdutoPK);
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
        final Venda_Produto other = (Venda_Produto) obj;
        if (!Objects.equals(this.venda_ProdutoPK, other.venda_ProdutoPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda_Produto{" + "venda_ProdutoPK=" + venda_ProdutoPK + ", quantidade=" + quantidade + ", valortotal=" + valortotal + ", venda=" + venda + ", produto=" + produto + '}';
    }
}
