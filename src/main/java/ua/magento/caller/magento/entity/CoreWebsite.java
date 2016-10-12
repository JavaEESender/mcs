/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.magento.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "core_website")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreWebsite.findAll", query = "SELECT c FROM CoreWebsite c"),
    @NamedQuery(name = "CoreWebsite.findByWebsiteId", query = "SELECT c FROM CoreWebsite c WHERE c.websiteId = :websiteId"),
    @NamedQuery(name = "CoreWebsite.findByCode", query = "SELECT c FROM CoreWebsite c WHERE c.code = :code"),
    @NamedQuery(name = "CoreWebsite.findByName", query = "SELECT c FROM CoreWebsite c WHERE c.name = :name"),
    @NamedQuery(name = "CoreWebsite.findBySortOrder", query = "SELECT c FROM CoreWebsite c WHERE c.sortOrder = :sortOrder"),
    @NamedQuery(name = "CoreWebsite.findByDefaultGroupId", query = "SELECT c FROM CoreWebsite c WHERE c.defaultGroupId = :defaultGroupId"),
    @NamedQuery(name = "CoreWebsite.findByIsDefault", query = "SELECT c FROM CoreWebsite c WHERE c.isDefault = :isDefault")})
public class CoreWebsite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "website_id")
    private Short websiteId;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "sort_order")
    private short sortOrder;
    @Basic(optional = false)
    @Column(name = "default_group_id")
    private short defaultGroupId;
    @Column(name = "is_default")
    private Short isDefault;
    @OneToMany(mappedBy = "websiteId")
    private Collection<CustomerEntity> customerEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "websiteId")
    private Collection<CoreStore> coreStoreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "websiteId")
    private Collection<CoreStoreGroup> coreStoreGroupCollection;

    public CoreWebsite() {
    }

    public CoreWebsite(Short websiteId) {
        this.websiteId = websiteId;
    }

    public CoreWebsite(Short websiteId, short sortOrder, short defaultGroupId) {
        this.websiteId = websiteId;
        this.sortOrder = sortOrder;
        this.defaultGroupId = defaultGroupId;
    }

    public Short getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Short websiteId) {
        this.websiteId = websiteId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public short getDefaultGroupId() {
        return defaultGroupId;
    }

    public void setDefaultGroupId(short defaultGroupId) {
        this.defaultGroupId = defaultGroupId;
    }

    public Short getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Short isDefault) {
        this.isDefault = isDefault;
    }

    @XmlTransient
    public Collection<CustomerEntity> getCustomerEntityCollection() {
        return customerEntityCollection;
    }

    public void setCustomerEntityCollection(Collection<CustomerEntity> customerEntityCollection) {
        this.customerEntityCollection = customerEntityCollection;
    }

    @XmlTransient
    public Collection<CoreStore> getCoreStoreCollection() {
        return coreStoreCollection;
    }

    public void setCoreStoreCollection(Collection<CoreStore> coreStoreCollection) {
        this.coreStoreCollection = coreStoreCollection;
    }

    @XmlTransient
    public Collection<CoreStoreGroup> getCoreStoreGroupCollection() {
        return coreStoreGroupCollection;
    }

    public void setCoreStoreGroupCollection(Collection<CoreStoreGroup> coreStoreGroupCollection) {
        this.coreStoreGroupCollection = coreStoreGroupCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (websiteId != null ? websiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoreWebsite)) {
            return false;
        }
        CoreWebsite other = (CoreWebsite) object;
        if ((this.websiteId == null && other.websiteId != null) || (this.websiteId != null && !this.websiteId.equals(other.websiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CoreWebsite[ websiteId=" + websiteId + " ]";
    }
    
}
