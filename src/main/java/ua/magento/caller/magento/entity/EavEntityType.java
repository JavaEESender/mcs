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
@Table(name = "eav_entity_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EavEntityType.findAll", query = "SELECT e FROM EavEntityType e"),
    @NamedQuery(name = "EavEntityType.findByEntityTypeId", query = "SELECT e FROM EavEntityType e WHERE e.entityTypeId = :entityTypeId"),
    @NamedQuery(name = "EavEntityType.findByEntityTypeCode", query = "SELECT e FROM EavEntityType e WHERE e.entityTypeCode = :entityTypeCode"),
    @NamedQuery(name = "EavEntityType.findByEntityModel", query = "SELECT e FROM EavEntityType e WHERE e.entityModel = :entityModel"),
    @NamedQuery(name = "EavEntityType.findByAttributeModel", query = "SELECT e FROM EavEntityType e WHERE e.attributeModel = :attributeModel"),
    @NamedQuery(name = "EavEntityType.findByEntityTable", query = "SELECT e FROM EavEntityType e WHERE e.entityTable = :entityTable"),
    @NamedQuery(name = "EavEntityType.findByValueTablePrefix", query = "SELECT e FROM EavEntityType e WHERE e.valueTablePrefix = :valueTablePrefix"),
    @NamedQuery(name = "EavEntityType.findByEntityIdField", query = "SELECT e FROM EavEntityType e WHERE e.entityIdField = :entityIdField"),
    @NamedQuery(name = "EavEntityType.findByIsDataSharing", query = "SELECT e FROM EavEntityType e WHERE e.isDataSharing = :isDataSharing"),
    @NamedQuery(name = "EavEntityType.findByDataSharingKey", query = "SELECT e FROM EavEntityType e WHERE e.dataSharingKey = :dataSharingKey"),
    @NamedQuery(name = "EavEntityType.findByDefaultAttributeSetId", query = "SELECT e FROM EavEntityType e WHERE e.defaultAttributeSetId = :defaultAttributeSetId"),
    @NamedQuery(name = "EavEntityType.findByIncrementModel", query = "SELECT e FROM EavEntityType e WHERE e.incrementModel = :incrementModel"),
    @NamedQuery(name = "EavEntityType.findByIncrementPerStore", query = "SELECT e FROM EavEntityType e WHERE e.incrementPerStore = :incrementPerStore"),
    @NamedQuery(name = "EavEntityType.findByIncrementPadLength", query = "SELECT e FROM EavEntityType e WHERE e.incrementPadLength = :incrementPadLength"),
    @NamedQuery(name = "EavEntityType.findByIncrementPadChar", query = "SELECT e FROM EavEntityType e WHERE e.incrementPadChar = :incrementPadChar"),
    @NamedQuery(name = "EavEntityType.findByAdditionalAttributeTable", query = "SELECT e FROM EavEntityType e WHERE e.additionalAttributeTable = :additionalAttributeTable"),
    @NamedQuery(name = "EavEntityType.findByEntityAttributeCollection", query = "SELECT e FROM EavEntityType e WHERE e.entityAttributeCollection = :entityAttributeCollection")})
public class EavEntityType implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityTypeId")
    private Collection<CustomerAddressEntityText> customerAddressEntityTextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityTypeId")
    private Collection<CustomerAddressEntityVarchar> customerAddressEntityVarcharCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_type_id")
    private Short entityTypeId;
    @Basic(optional = false)
    @Column(name = "entity_type_code")
    private String entityTypeCode;
    @Basic(optional = false)
    @Column(name = "entity_model")
    private String entityModel;
    @Column(name = "attribute_model")
    private String attributeModel;
    @Column(name = "entity_table")
    private String entityTable;
    @Column(name = "value_table_prefix")
    private String valueTablePrefix;
    @Column(name = "entity_id_field")
    private String entityIdField;
    @Basic(optional = false)
    @Column(name = "is_data_sharing")
    private short isDataSharing;
    @Column(name = "data_sharing_key")
    private String dataSharingKey;
    @Basic(optional = false)
    @Column(name = "default_attribute_set_id")
    private short defaultAttributeSetId;
    @Column(name = "increment_model")
    private String incrementModel;
    @Basic(optional = false)
    @Column(name = "increment_per_store")
    private short incrementPerStore;
    @Basic(optional = false)
    @Column(name = "increment_pad_length")
    private short incrementPadLength;
    @Basic(optional = false)
    @Column(name = "increment_pad_char")
    private String incrementPadChar;
    @Column(name = "additional_attribute_table")
    private String additionalAttributeTable;
    @Column(name = "entity_attribute_collection")
    private String entityAttributeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityTypeId")
    private Collection<EavAttribute> eavAttributeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entityTypeId")
    private Collection<CustomerEntityVarchar> customerEntityVarcharCollection;

    public EavEntityType() {
    }

    public EavEntityType(Short entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public EavEntityType(Short entityTypeId, String entityTypeCode, String entityModel, short isDataSharing, short defaultAttributeSetId, short incrementPerStore, short incrementPadLength, String incrementPadChar) {
        this.entityTypeId = entityTypeId;
        this.entityTypeCode = entityTypeCode;
        this.entityModel = entityModel;
        this.isDataSharing = isDataSharing;
        this.defaultAttributeSetId = defaultAttributeSetId;
        this.incrementPerStore = incrementPerStore;
        this.incrementPadLength = incrementPadLength;
        this.incrementPadChar = incrementPadChar;
    }

    public Short getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(Short entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public String getEntityTypeCode() {
        return entityTypeCode;
    }

    public void setEntityTypeCode(String entityTypeCode) {
        this.entityTypeCode = entityTypeCode;
    }

    public String getEntityModel() {
        return entityModel;
    }

    public void setEntityModel(String entityModel) {
        this.entityModel = entityModel;
    }

    public String getAttributeModel() {
        return attributeModel;
    }

    public void setAttributeModel(String attributeModel) {
        this.attributeModel = attributeModel;
    }

    public String getEntityTable() {
        return entityTable;
    }

    public void setEntityTable(String entityTable) {
        this.entityTable = entityTable;
    }

    public String getValueTablePrefix() {
        return valueTablePrefix;
    }

    public void setValueTablePrefix(String valueTablePrefix) {
        this.valueTablePrefix = valueTablePrefix;
    }

    public String getEntityIdField() {
        return entityIdField;
    }

    public void setEntityIdField(String entityIdField) {
        this.entityIdField = entityIdField;
    }

    public short getIsDataSharing() {
        return isDataSharing;
    }

    public void setIsDataSharing(short isDataSharing) {
        this.isDataSharing = isDataSharing;
    }

    public String getDataSharingKey() {
        return dataSharingKey;
    }

    public void setDataSharingKey(String dataSharingKey) {
        this.dataSharingKey = dataSharingKey;
    }

    public short getDefaultAttributeSetId() {
        return defaultAttributeSetId;
    }

    public void setDefaultAttributeSetId(short defaultAttributeSetId) {
        this.defaultAttributeSetId = defaultAttributeSetId;
    }

    public String getIncrementModel() {
        return incrementModel;
    }

    public void setIncrementModel(String incrementModel) {
        this.incrementModel = incrementModel;
    }

    public short getIncrementPerStore() {
        return incrementPerStore;
    }

    public void setIncrementPerStore(short incrementPerStore) {
        this.incrementPerStore = incrementPerStore;
    }

    public short getIncrementPadLength() {
        return incrementPadLength;
    }

    public void setIncrementPadLength(short incrementPadLength) {
        this.incrementPadLength = incrementPadLength;
    }

    public String getIncrementPadChar() {
        return incrementPadChar;
    }

    public void setIncrementPadChar(String incrementPadChar) {
        this.incrementPadChar = incrementPadChar;
    }

    public String getAdditionalAttributeTable() {
        return additionalAttributeTable;
    }

    public void setAdditionalAttributeTable(String additionalAttributeTable) {
        this.additionalAttributeTable = additionalAttributeTable;
    }

    public String getEntityAttributeCollection() {
        return entityAttributeCollection;
    }

    public void setEntityAttributeCollection(String entityAttributeCollection) {
        this.entityAttributeCollection = entityAttributeCollection;
    }

    @XmlTransient
    public Collection<EavAttribute> getEavAttributeCollection() {
        return eavAttributeCollection;
    }

    public void setEavAttributeCollection(Collection<EavAttribute> eavAttributeCollection) {
        this.eavAttributeCollection = eavAttributeCollection;
    }

    @XmlTransient
    public Collection<CustomerEntityVarchar> getCustomerEntityVarcharCollection() {
        return customerEntityVarcharCollection;
    }

    public void setCustomerEntityVarcharCollection(Collection<CustomerEntityVarchar> customerEntityVarcharCollection) {
        this.customerEntityVarcharCollection = customerEntityVarcharCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityTypeId != null ? entityTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EavEntityType)) {
            return false;
        }
        EavEntityType other = (EavEntityType) object;
        if ((this.entityTypeId == null && other.entityTypeId != null) || (this.entityTypeId != null && !this.entityTypeId.equals(other.entityTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.EavEntityType[ entityTypeId=" + entityTypeId + " ]";
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
    
}
