/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.magento.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "customer_address_entity_text")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAddressEntityText.findAll", query = "SELECT c FROM CustomerAddressEntityText c"),
    @NamedQuery(name = "CustomerAddressEntityText.findByValueId", query = "SELECT c FROM CustomerAddressEntityText c WHERE c.valueId = :valueId")})
public class CustomerAddressEntityText implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "value_id")
    private Integer valueId;
    @Basic(optional = false)
    @Lob
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")
    @ManyToOne(optional = false)
    private EavAttribute attributeId;
    @JoinColumn(name = "entity_id", referencedColumnName = "entity_id")
    @ManyToOne(optional = false)
    private CustomerAddressEntity entityId;
    @JoinColumn(name = "entity_type_id", referencedColumnName = "entity_type_id")
    @ManyToOne(optional = false)
    private EavEntityType entityTypeId;

    public CustomerAddressEntityText() {
    }

    public CustomerAddressEntityText(Integer valueId) {
        this.valueId = valueId;
    }

    public CustomerAddressEntityText(Integer valueId, String value) {
        this.valueId = valueId;
        this.value = value;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EavAttribute getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(EavAttribute attributeId) {
        this.attributeId = attributeId;
    }

    public CustomerAddressEntity getEntityId() {
        return entityId;
    }

    public void setEntityId(CustomerAddressEntity entityId) {
        this.entityId = entityId;
    }

    public EavEntityType getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(EavEntityType entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valueId != null ? valueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAddressEntityText)) {
            return false;
        }
        CustomerAddressEntityText other = (CustomerAddressEntityText) object;
        if ((this.valueId == null && other.valueId != null) || (this.valueId != null && !this.valueId.equals(other.valueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.CustomerAddressEntityText[ valueId=" + valueId + " ]";
    }
    
}
