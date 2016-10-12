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
import javax.persistence.Lob;
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
@Table(name = "eav_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EavAttribute.findAll", query = "SELECT e FROM EavAttribute e"),
    @NamedQuery(name = "EavAttribute.findByAttributeId", query = "SELECT e FROM EavAttribute e WHERE e.attributeId = :attributeId"),
    @NamedQuery(name = "EavAttribute.findByAttributeCode", query = "SELECT e FROM EavAttribute e WHERE e.attributeCode = :attributeCode"),
    @NamedQuery(name = "EavAttribute.findByAttributeModel", query = "SELECT e FROM EavAttribute e WHERE e.attributeModel = :attributeModel"),
    @NamedQuery(name = "EavAttribute.findByBackendModel", query = "SELECT e FROM EavAttribute e WHERE e.backendModel = :backendModel"),
    @NamedQuery(name = "EavAttribute.findByBackendType", query = "SELECT e FROM EavAttribute e WHERE e.backendType = :backendType"),
    @NamedQuery(name = "EavAttribute.findByBackendTable", query = "SELECT e FROM EavAttribute e WHERE e.backendTable = :backendTable"),
    @NamedQuery(name = "EavAttribute.findByFrontendModel", query = "SELECT e FROM EavAttribute e WHERE e.frontendModel = :frontendModel"),
    @NamedQuery(name = "EavAttribute.findByFrontendInput", query = "SELECT e FROM EavAttribute e WHERE e.frontendInput = :frontendInput"),
    @NamedQuery(name = "EavAttribute.findByFrontendLabel", query = "SELECT e FROM EavAttribute e WHERE e.frontendLabel = :frontendLabel"),
    @NamedQuery(name = "EavAttribute.findByFrontendClass", query = "SELECT e FROM EavAttribute e WHERE e.frontendClass = :frontendClass"),
    @NamedQuery(name = "EavAttribute.findBySourceModel", query = "SELECT e FROM EavAttribute e WHERE e.sourceModel = :sourceModel"),
    @NamedQuery(name = "EavAttribute.findByIsRequired", query = "SELECT e FROM EavAttribute e WHERE e.isRequired = :isRequired"),
    @NamedQuery(name = "EavAttribute.findByIsUserDefined", query = "SELECT e FROM EavAttribute e WHERE e.isUserDefined = :isUserDefined"),
    @NamedQuery(name = "EavAttribute.findByIsUnique", query = "SELECT e FROM EavAttribute e WHERE e.isUnique = :isUnique"),
    @NamedQuery(name = "EavAttribute.findByNote", query = "SELECT e FROM EavAttribute e WHERE e.note = :note")})
public class EavAttribute implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeId")
    private Collection<CustomerAddressEntityText> customerAddressEntityTextCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeId")
    private Collection<CustomerAddressEntityVarchar> customerAddressEntityVarcharCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attribute_id")
    private Short attributeId;
    @Column(name = "attribute_code")
    private String attributeCode;
    @Column(name = "attribute_model")
    private String attributeModel;
    @Column(name = "backend_model")
    private String backendModel;
    @Basic(optional = false)
    @Column(name = "backend_type")
    private String backendType;
    @Column(name = "backend_table")
    private String backendTable;
    @Column(name = "frontend_model")
    private String frontendModel;
    @Column(name = "frontend_input")
    private String frontendInput;
    @Column(name = "frontend_label")
    private String frontendLabel;
    @Column(name = "frontend_class")
    private String frontendClass;
    @Column(name = "source_model")
    private String sourceModel;
    @Basic(optional = false)
    @Column(name = "is_required")
    private short isRequired;
    @Basic(optional = false)
    @Column(name = "is_user_defined")
    private short isUserDefined;
    @Lob
    @Column(name = "default_value")
    private String defaultValue;
    @Basic(optional = false)
    @Column(name = "is_unique")
    private short isUnique;
    @Column(name = "note")
    private String note;
    @JoinColumn(name = "entity_type_id", referencedColumnName = "entity_type_id")
    @ManyToOne(optional = false)
    private EavEntityType entityTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeId")
    private Collection<CustomerEntityVarchar> customerEntityVarcharCollection;

    public EavAttribute() {
    }

    public EavAttribute(Short attributeId) {
        this.attributeId = attributeId;
    }

    public EavAttribute(Short attributeId, String backendType, short isRequired, short isUserDefined, short isUnique) {
        this.attributeId = attributeId;
        this.backendType = backendType;
        this.isRequired = isRequired;
        this.isUserDefined = isUserDefined;
        this.isUnique = isUnique;
    }

    public Short getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Short attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getAttributeModel() {
        return attributeModel;
    }

    public void setAttributeModel(String attributeModel) {
        this.attributeModel = attributeModel;
    }

    public String getBackendModel() {
        return backendModel;
    }

    public void setBackendModel(String backendModel) {
        this.backendModel = backendModel;
    }

    public String getBackendType() {
        return backendType;
    }

    public void setBackendType(String backendType) {
        this.backendType = backendType;
    }

    public String getBackendTable() {
        return backendTable;
    }

    public void setBackendTable(String backendTable) {
        this.backendTable = backendTable;
    }

    public String getFrontendModel() {
        return frontendModel;
    }

    public void setFrontendModel(String frontendModel) {
        this.frontendModel = frontendModel;
    }

    public String getFrontendInput() {
        return frontendInput;
    }

    public void setFrontendInput(String frontendInput) {
        this.frontendInput = frontendInput;
    }

    public String getFrontendLabel() {
        return frontendLabel;
    }

    public void setFrontendLabel(String frontendLabel) {
        this.frontendLabel = frontendLabel;
    }

    public String getFrontendClass() {
        return frontendClass;
    }

    public void setFrontendClass(String frontendClass) {
        this.frontendClass = frontendClass;
    }

    public String getSourceModel() {
        return sourceModel;
    }

    public void setSourceModel(String sourceModel) {
        this.sourceModel = sourceModel;
    }

    public short getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(short isRequired) {
        this.isRequired = isRequired;
    }

    public short getIsUserDefined() {
        return isUserDefined;
    }

    public void setIsUserDefined(short isUserDefined) {
        this.isUserDefined = isUserDefined;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public short getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(short isUnique) {
        this.isUnique = isUnique;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EavEntityType getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(EavEntityType entityTypeId) {
        this.entityTypeId = entityTypeId;
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
        hash += (attributeId != null ? attributeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EavAttribute)) {
            return false;
        }
        EavAttribute other = (EavAttribute) object;
        if ((this.attributeId == null && other.attributeId != null) || (this.attributeId != null && !this.attributeId.equals(other.attributeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.EavAttribute[ attributeId=" + attributeId + " ]";
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
