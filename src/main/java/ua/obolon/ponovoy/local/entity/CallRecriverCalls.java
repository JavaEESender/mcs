/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.local.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "call_recriver_calls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CallRecriverCalls.findAll", query = "SELECT c FROM CallRecriverCalls c"),
    @NamedQuery(name = "CallRecriverCalls.findById", query = "SELECT c FROM CallRecriverCalls c WHERE c.id = :id"),
    @NamedQuery(name = "CallRecriverCalls.findByLogin", query = "SELECT c FROM CallRecriverCalls c WHERE c.login = :login"),
    @NamedQuery(name = "CallRecriverCalls.findByClient", query = "SELECT c FROM CallRecriverCalls c WHERE c.client = :client"),
    @NamedQuery(name = "CallRecriverCalls.findByCallData", query = "SELECT c FROM CallRecriverCalls c WHERE c.callData = :callData")})
public class CallRecriverCalls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "client")
    private String client;
    @Basic(optional = false)
    @Column(name = "call_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callData;

    public CallRecriverCalls() {
    }

    public CallRecriverCalls(Integer id) {
        this.id = id;
    }

    public CallRecriverCalls(Integer id, String login, String client, Date callData) {
        this.id = id;
        this.login = login;
        this.client = client;
        this.callData = callData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getCallData() {
        return callData;
    }

    public void setCallData(Date callData) {
        this.callData = callData;
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
        if (!(object instanceof CallRecriverCalls)) {
            return false;
        }
        CallRecriverCalls other = (CallRecriverCalls) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.local.entity.CallRecriverCalls[ id=" + id + " ]";
    }
    
}
