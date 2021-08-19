/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zscrollock
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenda", nullable = false)
    private int idVenda;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Date data;
    
    @Column(name = "valortotal", nullable = false)
    private float valortotal;
      
    @Column(name = "tipopagmt", nullable = false)
    @Enumerated(EnumType.STRING)
    private VendaTipoPagmt tipoPagmt;
    
    @Column(name = "parcelas", nullable = false)
    private int parcelas;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    

    public Venda() {
    
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }  

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public VendaTipoPagmt getTipoPagmt() {
        return tipoPagmt;
    }

    public void setTipoPagmt(VendaTipoPagmt tipoPagmt) {
        this.tipoPagmt = tipoPagmt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idVenda;
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
        final Venda other = (Venda) obj;
        if (this.idVenda != other.idVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", data=" + data + ", valortotal=" + valortotal + ", tipoPagmt=" + tipoPagmt + ", parcelas=" + parcelas + ", usuario=" + usuario + '}';
    } 
}
