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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zscrollock
 */
@Entity
@Table(name = "product")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productCode", nullable = false)
    private int productCode;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "validadeDate", nullable = false)
    private Date validadeDate;
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "photoName", length = 40, nullable = false)
    private String photoName;
    
    @Lob
    @Column(name = "archive", nullable = false)
    private byte[] archive;
    
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProdutoStatus status;
    
    public Produto(){
        
    }

    public Produto(int productCode, String name, String description, double price, Date validadeDate, int quantity, String photoName, byte[] archive, ProdutoStatus status) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.validadeDate = validadeDate;
        this.quantity = quantity;
        this.photoName = photoName;
        this.archive = archive;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProdutoStatus getStatus() {
        return status;
    }

    public void setStatus(ProdutoStatus status) {
        this.status = status;
    } 

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public byte[] getArchive() {
        return archive;
    }

    public void setArchive(byte[] archive) {
        this.archive = archive;
    }
  
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getValidadeDate() {
        return validadeDate;
    }

    public void setValidadeDate(Date validadeDate) {
        this.validadeDate = validadeDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.productCode;
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
        final Produto other = (Produto) obj;
        if (this.productCode != other.productCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "productCode=" + productCode + ", name=" + name + ", description=" + description + ", price=" + price + ", validadeDate=" + validadeDate + ", quantity=" + quantity + ", photoName=" + photoName + ", archive=" + archive + ", status=" + status + '}';
    }          
}
