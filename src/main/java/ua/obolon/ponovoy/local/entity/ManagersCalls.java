/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.local.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "managers_calls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManagersCalls.findAll", query = "SELECT m FROM ManagersCalls m"),
    @NamedQuery(name = "ManagersCalls.findById", query = "SELECT m FROM ManagersCalls m WHERE m.id = :id"),
    @NamedQuery(name = "ManagersCalls.findByUsername", query = "SELECT m FROM ManagersCalls m WHERE m.username = :username"),
    @NamedQuery(name = "ManagersCalls.findByPassword", query = "SELECT m FROM ManagersCalls m WHERE m.password = :password")})
public class ManagersCalls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public ManagersCalls() {
    }

    public ManagersCalls(Integer id) {
        this.id = id;
    }

    public ManagersCalls(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManagersCalls)) {
            return false;
        }
        ManagersCalls other = (ManagersCalls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.local.entity.ManagersCalls[ id=" + id + " ]";
    }
    
}
