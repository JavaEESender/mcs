/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.entity;

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
@Table(name = "sales_flat_order_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatOrderAddress.findAll", query = "SELECT s FROM SalesFlatOrderAddress s"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByEntityId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.entityId = :entityId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByCustomerAddressId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.customerAddressId = :customerAddressId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByQuoteAddressId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.quoteAddressId = :quoteAddressId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByRegionId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.regionId = :regionId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByCustomerId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.customerId = :customerId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByFax", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.fax = :fax"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByRegion", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.region = :region"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByPostcode", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.postcode = :postcode"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByLastname", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByStreet", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.street = :street"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByCity", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.city = :city"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByEmail", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.email = :email"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByTelephone", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.telephone = :telephone"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByCountryId", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.countryId = :countryId"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByFirstname", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByAddressType", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.addressType = :addressType"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByPrefix", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.prefix = :prefix"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByMiddlename", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.middlename = :middlename"),
    @NamedQuery(name = "SalesFlatOrderAddress.findBySuffix", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.suffix = :suffix"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByCompany", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.company = :company"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByVatIsValid", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.vatIsValid = :vatIsValid"),
    @NamedQuery(name = "SalesFlatOrderAddress.findByVatRequestSuccess", query = "SELECT s FROM SalesFlatOrderAddress s WHERE s.vatRequestSuccess = :vatRequestSuccess")})
public class SalesFlatOrderAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    @Column(name = "customer_address_id")
    private Integer customerAddressId;
    @Column(name = "quote_address_id")
    private Integer quoteAddressId;
    @Column(name = "region_id")
    private Integer regionId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "fax")
    private String fax;
    @Column(name = "region")
    private String region;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "country_id")
    private String countryId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "address_type")
    private String addressType;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "company")
    private String company;
    @Lob
    @Column(name = "vat_id")
    private String vatId;
    @Column(name = "vat_is_valid")
    private Short vatIsValid;
    @Lob
    @Column(name = "vat_request_id")
    private String vatRequestId;
    @Lob
    @Column(name = "vat_request_date")
    private String vatRequestDate;
    @Column(name = "vat_request_success")
    private Short vatRequestSuccess;
    @JoinColumn(name = "parent_id", referencedColumnName = "entity_id")
    @ManyToOne
    private SalesFlatOrder parentId;

    public SalesFlatOrderAddress() {
    }

    public SalesFlatOrderAddress(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(Integer customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public Integer getQuoteAddressId() {
        return quoteAddressId;
    }

    public void setQuoteAddressId(Integer quoteAddressId) {
        this.quoteAddressId = quoteAddressId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public Short getVatIsValid() {
        return vatIsValid;
    }

    public void setVatIsValid(Short vatIsValid) {
        this.vatIsValid = vatIsValid;
    }

    public String getVatRequestId() {
        return vatRequestId;
    }

    public void setVatRequestId(String vatRequestId) {
        this.vatRequestId = vatRequestId;
    }

    public String getVatRequestDate() {
        return vatRequestDate;
    }

    public void setVatRequestDate(String vatRequestDate) {
        this.vatRequestDate = vatRequestDate;
    }

    public Short getVatRequestSuccess() {
        return vatRequestSuccess;
    }

    public void setVatRequestSuccess(Short vatRequestSuccess) {
        this.vatRequestSuccess = vatRequestSuccess;
    }

    public SalesFlatOrder getParentId() {
        return parentId;
    }

    public void setParentId(SalesFlatOrder parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof SalesFlatOrderAddress)) {
            return false;
        }
        SalesFlatOrderAddress other = (SalesFlatOrderAddress) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatOrderAddress[ entityId=" + entityId + " ]";
    }
    
}
