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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "core_store_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreStoreGroup.findAll", query = "SELECT c FROM CoreStoreGroup c"),
    @NamedQuery(name = "CoreStoreGroup.findByGroupId", query = "SELECT c FROM CoreStoreGroup c WHERE c.groupId = :groupId"),
    @NamedQuery(name = "CoreStoreGroup.findByName", query = "SELECT c FROM CoreStoreGroup c WHERE c.name = :name"),
    @NamedQuery(name = "CoreStoreGroup.findByRootCategoryId", query = "SELECT c FROM CoreStoreGroup c WHERE c.rootCategoryId = :rootCategoryId"),
    @NamedQuery(name = "CoreStoreGroup.findByDefaultStoreId", query = "SELECT c FROM CoreStoreGroup c WHERE c.defaultStoreId = :defaultStoreId")})
public class CoreStoreGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Short groupId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "root_category_id")
    private int rootCategoryId;
    @Basic(optional = false)
    @Column(name = "default_store_id")
    private short defaultStoreId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<CoreStore> coreStoreCollection;
    @JoinColumn(name = "website_id", referencedColumnName = "website_id")
    @ManyToOne(optional = false)
    private CoreWebsite websiteId;

    public CoreStoreGroup() {
    }

    public CoreStoreGroup(Short groupId) {
        this.groupId = groupId;
    }

    public CoreStoreGroup(Short groupId, String name, int rootCategoryId, short defaultStoreId) {
        this.groupId = groupId;
        this.name = name;
        this.rootCategoryId = rootCategoryId;
        this.defaultStoreId = defaultStoreId;
    }

    public Short getGroupId() {
        return groupId;
    }

    public void setGroupId(Short groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRootCategoryId() {
        return rootCategoryId;
    }

    public void setRootCategoryId(int rootCategoryId) {
        this.rootCategoryId = rootCategoryId;
    }

    public short getDefaultStoreId() {
        return defaultStoreId;
    }

    public void setDefaultStoreId(short defaultStoreId) {
        this.defaultStoreId = defaultStoreId;
    }

    @XmlTransient
    public Collection<CoreStore> getCoreStoreCollection() {
        return coreStoreCollection;
    }

    public void setCoreStoreCollection(Collection<CoreStore> coreStoreCollection) {
        this.coreStoreCollection = coreStoreCollection;
    }

    public CoreWebsite getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(CoreWebsite websiteId) {
        this.websiteId = websiteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoreStoreGroup)) {
            return false;
        }
        CoreStoreGroup other = (CoreStoreGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CoreStoreGroup[ groupId=" + groupId + " ]";
    }
    
}
