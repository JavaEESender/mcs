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
@Table(name = "customer_address_entity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAddressEntity.findAll", query = "SELECT c FROM CustomerAddressEntity c"),
    @NamedQuery(name = "CustomerAddressEntity.findByEntityId", query = "SELECT c FROM CustomerAddressEntity c WHERE c.entityId = :entityId"),
    @NamedQuery(name = "CustomerAddressEntity.findByEntityTypeId", query = "SELECT c FROM CustomerAddressEntity c WHERE c.entityTypeId = :entityTypeId"),
    @NamedQuery(name = "CustomerAddressEntity.findByAttributeSetId", query = "SELECT c FROM CustomerAddressEntity c WHERE c.attributeSetId = :attributeSetId"),
    @NamedQuery(name = "CustomerAddressEntity.findByIncrementId", query = "SELECT c FROM CustomerAddressEntity c WHERE c.incrementId = :incrementId"),
    @NamedQuery(name = "CustomerAddressEntity.findByCreatedAt", query = "SELECT c FROM CustomerAddressEntity c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CustomerAddressEntity.findByUpdatedAt", query = "SELECT c FROM CustomerAddressEntity c WHERE c.updatedAt = :updatedAt"),
    @NamedQuery(name = "CustomerAddressEntity.findByIsActive", query = "SELECT c FROM CustomerAddressEntity c WHERE c.isActive = :isActive")})
public class CustomerAddressEntity implements Serializable {

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
    @JoinColumn(name = "parent_id", referencedColumnName = "entity_id")
    @ManyToOne
    private CustomerEntity parentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityId")
    private Collection<CustomerAddressEntityText> customerAddressEntityTextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityId")
    private Collection<CustomerAddressEntityVarchar> customerAddressEntityVarcharCollection;

    public CustomerAddressEntity() {
    }

    public CustomerAddressEntity(Integer entityId) {
        this.entityId = entityId;
    }

    public CustomerAddressEntity(Integer entityId, short entityTypeId, short attributeSetId, Date createdAt, Date updatedAt, short isActive) {
        this.entityId = entityId;
        this.entityTypeId = entityTypeId;
        this.attributeSetId = attributeSetId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
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

    public CustomerEntity getParentId() {
        return parentId;
    }

    public void setParentId(CustomerEntity parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public Collection<CustomerAddressEntityText> getCustomerAddressEntityTextCollection() {
        return customerAddressEntityTextCollection;
    }

    public void setCustomerAddressEntityTextCollection(Collection<CustomerAddressEntityText> customerAddressEntityTextCollection) {
        this.customerAddressEntityTextCollection = customerAddressEntityTextCollection;
    }

    @XmlTransient
    public Collection<CustomerAddressEntityVarchar> getCustomerAddressEntityVarcharCollection() {
        return customerAddressEntityVarcharCollection;
    }

    public void setCustomerAddressEntityVarcharCollection(Collection<CustomerAddressEntityVarchar> customerAddressEntityVarcharCollection) {
        this.customerAddressEntityVarcharCollection = customerAddressEntityVarcharCollection;
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
        if (!(object instanceof CustomerAddressEntity)) {
            return false;
        }
        CustomerAddressEntity other = (CustomerAddressEntity) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CustomerAddressEntity[ entityId=" + entityId + " ]";
    }
    
}
