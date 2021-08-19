/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author zscrollock
 */
@Entity
@Table(name = "user")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "login", nullable = false)
    private String login;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioEnum level;
    
    public Usuario(){
        
    }

    public Usuario(int id, String name, String login, String password, UsuarioEnum level) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioEnum getLevel() {
        return level;
    }

    public void setLevel(UsuarioEnum level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", level=" + level + '}';
    }

      
}
