/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "customer_entity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerEntity.findAll", query = "SELECT c FROM CustomerEntity c"),
    @NamedQuery(name = "CustomerEntity.findByEntityId", query = "SELECT c FROM CustomerEntity c WHERE c.entityId = :entityId"),
    @NamedQuery(name = "CustomerEntity.findByEntityTypeId", query = "SELECT c FROM CustomerEntity c WHERE c.entityTypeId = :entityTypeId"),
    @NamedQuery(name = "CustomerEntity.findByAttributeSetId", query = "SELECT c FROM CustomerEntity c WHERE c.attributeSetId = :attributeSetId"),
    @NamedQuery(name = "CustomerEntity.findByEmail", query = "SELECT c FROM CustomerEntity c WHERE c.email = :email"),
    @NamedQuery(name = "CustomerEntity.findByGroupId", query = "SELECT c FROM CustomerEntity c WHERE c.groupId = :groupId"),
    @NamedQuery(name = "CustomerEntity.findByIncrementId", query = "SELECT c FROM CustomerEntity c WHERE c.incrementId = :incrementId"),
    @NamedQuery(name = "CustomerEntity.findByCreatedAt", query = "SELECT c FROM CustomerEntity c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CustomerEntity.findByUpdatedAt", query = "SELECT c FROM CustomerEntity c WHERE c.updatedAt = :updatedAt"),
    @NamedQuery(name = "CustomerEntity.findByIsActive", query = "SELECT c FROM CustomerEntity c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CustomerEntity.findByDisableAutoGroupChange", query = "SELECT c FROM CustomerEntity c WHERE c.disableAutoGroupChange = :disableAutoGroupChange")})
public class CustomerEntity implements Serializable {

    @OneToMany(mappedBy = "parentId")
    private Collection<CustomerAddressEntity> customerAddressEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityId")
    private Collection<CustomerEntityVarchar> customerEntityVarcharCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    @Basic(optional = false)
    @Column(name = "entity_type_id")
    private short entityTypeId;
    @Basic(optional = false)
    @Column(name = "attribute_set_id")
    private short attributeSetId;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "group_id")
    private short groupId;
    @Column(name = "increment_id")
    private String incrementId;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "is_active")
    private short isActive;
    @Basic(optional = false)
    @Column(name = "disable_auto_group_change")
    private short disableAutoGroupChange;
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne
    private CoreStore storeId;
    @JoinColumn(name = "website_id", referencedColumnName = "website_id")
    @ManyToOne
    private CoreWebsite websiteId;
    @OneToMany(mappedBy = "customerId")
    private Collection<SalesFlatOrderGrid> salesFlatOrderGridCollection;
    @OneToMany(mappedBy = "customerId")
    private Collection<SalesFlatOrder> salesFlatOrderCollection;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer entityId) {
        this.entityId = entityId;
    }

    public CustomerEntity(Integer entityId, short entityTypeId, short attributeSetId, short groupId, Date createdAt, Date updatedAt, short isActive, short disableAutoGroupChange) {
        this.entityId = entityId;
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.groupId = groupId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
        this.disableAutoGroupChange = disableAutoGroupChange;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public short getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(short entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public short getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(short attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public String getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(String incrementId) {
        this.incrementId = incrementId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public short getDisableAutoGroupChange() {
        return disableAutoGroupChange;
    }

    public void setDisableAutoGroupChange(short disableAutoGroupChange) {
        this.disableAutoGroupChange = disableAutoGroupChange;
    }

    public CoreStore getStoreId() {
        return storeId;
    }

    public void setStoreId(CoreStore storeId) {
        this.storeId = storeId;
    }

    public CoreWebsite getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(CoreWebsite websiteId) {
        this.websiteId = websiteId;
    }

    @XmlTransient
    public Collection<SalesFlatOrderGrid> getSalesFlatOrderGridCollection() {
        return salesFlatOrderGridCollection;
    }

    public void setSalesFlatOrderGridCollection(Collection<SalesFlatOrderGrid> salesFlatOrderGridCollection) {
        this.salesFlatOrderGridCollection = salesFlatOrderGridCollection;
    }

    @XmlTransient
    public Collection<SalesFlatOrder> getSalesFlatOrderCollection() {
        return salesFlatOrderCollection;
    }

    public void setSalesFlatOrderCollection(Collection<SalesFlatOrder> salesFlatOrderCollection) {
        this.salesFlatOrderCollection = salesFlatOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityId != null ? entityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CustomerEntity[ entityId=" + entityId + " ]";
    }

    @XmlTransient
    public Collection<CustomerEntityVarchar> getCustomerEntityVarcharCollection() {
        return customerEntityVarcharCollection;
    }

    public void setCustomerEntityVarcharCollection(Collection<CustomerEntityVarchar> customerEntityVarcharCollection) {
        this.customerEntityVarcharCollection = customerEntityVarcharCollection;
    }

    @XmlTransient
    public Collection<CustomerAddressEntity> getCustomerAddressEntityCollection() {
        return customerAddressEntityCollection;
    }

    public void setCustomerAddressEntityCollection(Collection<CustomerAddressEntity> customerAddressEntityCollection) {
        this.customerAddressEntityCollection = customerAddressEntityCollection;
    }
    
}
