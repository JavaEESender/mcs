/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.entity;

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
@Table(name = "core_store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoreStore.findAll", query = "SELECT c FROM CoreStore c"),
    @NamedQuery(name = "CoreStore.findByStoreId", query = "SELECT c FROM CoreStore c WHERE c.storeId = :storeId"),
    @NamedQuery(name = "CoreStore.findByCode", query = "SELECT c FROM CoreStore c WHERE c.code = :code"),
    @NamedQuery(name = "CoreStore.findByName", query = "SELECT c FROM CoreStore c WHERE c.name = :name"),
    @NamedQuery(name = "CoreStore.findBySortOrder", query = "SELECT c FROM CoreStore c WHERE c.sortOrder = :sortOrder"),
    @NamedQuery(name = "CoreStore.findByIsActive", query = "SELECT c FROM CoreStore c WHERE c.isActive = :isActive")})
public class CoreStore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_id")
    private Short storeId;
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "sort_order")
    private short sortOrder;
    @Basic(optional = false)
    @Column(name = "is_active")
    private short isActive;
    @OneToMany(mappedBy = "storeId")
    private Collection<CustomerEntity> customerEntityCollection;
    @OneToMany(mappedBy = "storeId")
    private Collection<SalesFlatOrderGrid> salesFlatOrderGridCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "storeId")
    private Collection<SalesFlatQuote> salesFlatQuoteCollection;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false)
    private CoreStoreGroup groupId;
    @JoinColumn(name = "website_id", referencedColumnName = "website_id")
    @ManyToOne(optional = false)
    private CoreWebsite websiteId;
    @OneToMany(mappedBy = "storeId")
    private Collection<SalesFlatOrder> salesFlatOrderCollection;
    @OneToMany(mappedBy = "storeId")
    private Collection<SalesFlatOrderItem> salesFlatOrderItemCollection;

    public CoreStore() {
    }

    public CoreStore(Short storeId) {
        this.storeId = storeId;
    }

    public CoreStore(Short storeId, String name, short sortOrder, short isActive) {
        this.storeId = storeId;
        this.name = name;
        this.sortOrder = sortOrder;
        this.isActive = isActive;
    }

    public Short getStoreId() {
        return storeId;
    }

    public void setStoreId(Short storeId) {
        this.storeId = storeId;
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

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<CustomerEntity> getCustomerEntityCollection() {
        return customerEntityCollection;
    }

    public void setCustomerEntityCollection(Collection<CustomerEntity> customerEntityCollection) {
        this.customerEntityCollection = customerEntityCollection;
    }

    @XmlTransient
    public Collection<SalesFlatOrderGrid> getSalesFlatOrderGridCollection() {
        return salesFlatOrderGridCollection;
    }

    public void setSalesFlatOrderGridCollection(Collection<SalesFlatOrderGrid> salesFlatOrderGridCollection) {
        this.salesFlatOrderGridCollection = salesFlatOrderGridCollection;
    }

    @XmlTransient
    public Collection<SalesFlatQuote> getSalesFlatQuoteCollection() {
        return salesFlatQuoteCollection;
    }

    public void setSalesFlatQuoteCollection(Collection<SalesFlatQuote> salesFlatQuoteCollection) {
        this.salesFlatQuoteCollection = salesFlatQuoteCollection;
    }

    public CoreStoreGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(CoreStoreGroup groupId) {
        this.groupId = groupId;
    }

    public CoreWebsite getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(CoreWebsite websiteId) {
        this.websiteId = websiteId;
    }

    @XmlTransient
    public Collection<SalesFlatOrder> getSalesFlatOrderCollection() {
        return salesFlatOrderCollection;
    }

    public void setSalesFlatOrderCollection(Collection<SalesFlatOrder> salesFlatOrderCollection) {
        this.salesFlatOrderCollection = salesFlatOrderCollection;
    }

    @XmlTransient
    public Collection<SalesFlatOrderItem> getSalesFlatOrderItemCollection() {
        return salesFlatOrderItemCollection;
    }

    public void setSalesFlatOrderItemCollection(Collection<SalesFlatOrderItem> salesFlatOrderItemCollection) {
        this.salesFlatOrderItemCollection = salesFlatOrderItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoreStore)) {
            return false;
        }
        CoreStore other = (CoreStore) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CoreStore[ storeId=" + storeId + " ]";
    }
    
}
