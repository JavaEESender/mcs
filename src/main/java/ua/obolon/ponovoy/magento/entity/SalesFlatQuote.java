/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Lob;
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
@Table(name = "sales_flat_quote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatQuote.findAll", query = "SELECT s FROM SalesFlatQuote s"),
    @NamedQuery(name = "SalesFlatQuote.findByEntityId", query = "SELECT s FROM SalesFlatQuote s WHERE s.entityId = :entityId"),
    @NamedQuery(name = "SalesFlatQuote.findByCreatedAt", query = "SELECT s FROM SalesFlatQuote s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SalesFlatQuote.findByUpdatedAt", query = "SELECT s FROM SalesFlatQuote s WHERE s.updatedAt = :updatedAt"),
    @NamedQuery(name = "SalesFlatQuote.findByConvertedAt", query = "SELECT s FROM SalesFlatQuote s WHERE s.convertedAt = :convertedAt"),
    @NamedQuery(name = "SalesFlatQuote.findByIsActive", query = "SELECT s FROM SalesFlatQuote s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "SalesFlatQuote.findByIsVirtual", query = "SELECT s FROM SalesFlatQuote s WHERE s.isVirtual = :isVirtual"),
    @NamedQuery(name = "SalesFlatQuote.findByIsMultiShipping", query = "SELECT s FROM SalesFlatQuote s WHERE s.isMultiShipping = :isMultiShipping"),
    @NamedQuery(name = "SalesFlatQuote.findByItemsCount", query = "SELECT s FROM SalesFlatQuote s WHERE s.itemsCount = :itemsCount"),
    @NamedQuery(name = "SalesFlatQuote.findByItemsQty", query = "SELECT s FROM SalesFlatQuote s WHERE s.itemsQty = :itemsQty"),
    @NamedQuery(name = "SalesFlatQuote.findByOrigOrderId", query = "SELECT s FROM SalesFlatQuote s WHERE s.origOrderId = :origOrderId"),
    @NamedQuery(name = "SalesFlatQuote.findByStoreToBaseRate", query = "SELECT s FROM SalesFlatQuote s WHERE s.storeToBaseRate = :storeToBaseRate"),
    @NamedQuery(name = "SalesFlatQuote.findByStoreToQuoteRate", query = "SELECT s FROM SalesFlatQuote s WHERE s.storeToQuoteRate = :storeToQuoteRate"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseCurrencyCode", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseCurrencyCode = :baseCurrencyCode"),
    @NamedQuery(name = "SalesFlatQuote.findByStoreCurrencyCode", query = "SELECT s FROM SalesFlatQuote s WHERE s.storeCurrencyCode = :storeCurrencyCode"),
    @NamedQuery(name = "SalesFlatQuote.findByQuoteCurrencyCode", query = "SELECT s FROM SalesFlatQuote s WHERE s.quoteCurrencyCode = :quoteCurrencyCode"),
    @NamedQuery(name = "SalesFlatQuote.findByGrandTotal", query = "SELECT s FROM SalesFlatQuote s WHERE s.grandTotal = :grandTotal"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseGrandTotal", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseGrandTotal = :baseGrandTotal"),
    @NamedQuery(name = "SalesFlatQuote.findByCheckoutMethod", query = "SELECT s FROM SalesFlatQuote s WHERE s.checkoutMethod = :checkoutMethod"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerId", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerId = :customerId"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerTaxClassId", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerTaxClassId = :customerTaxClassId"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerGroupId", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerGroupId = :customerGroupId"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerEmail", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerEmail = :customerEmail"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerPrefix", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerPrefix = :customerPrefix"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerFirstname", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerFirstname = :customerFirstname"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerMiddlename", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerMiddlename = :customerMiddlename"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerLastname", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerLastname = :customerLastname"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerSuffix", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerSuffix = :customerSuffix"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerDob", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerDob = :customerDob"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerNote", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerNote = :customerNote"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerNoteNotify", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerNoteNotify = :customerNoteNotify"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerIsGuest", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerIsGuest = :customerIsGuest"),
    @NamedQuery(name = "SalesFlatQuote.findByRemoteIp", query = "SELECT s FROM SalesFlatQuote s WHERE s.remoteIp = :remoteIp"),
    @NamedQuery(name = "SalesFlatQuote.findByAppliedRuleIds", query = "SELECT s FROM SalesFlatQuote s WHERE s.appliedRuleIds = :appliedRuleIds"),
    @NamedQuery(name = "SalesFlatQuote.findByReservedOrderId", query = "SELECT s FROM SalesFlatQuote s WHERE s.reservedOrderId = :reservedOrderId"),
    @NamedQuery(name = "SalesFlatQuote.findByPasswordHash", query = "SELECT s FROM SalesFlatQuote s WHERE s.passwordHash = :passwordHash"),
    @NamedQuery(name = "SalesFlatQuote.findByCouponCode", query = "SELECT s FROM SalesFlatQuote s WHERE s.couponCode = :couponCode"),
    @NamedQuery(name = "SalesFlatQuote.findByGlobalCurrencyCode", query = "SELECT s FROM SalesFlatQuote s WHERE s.globalCurrencyCode = :globalCurrencyCode"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseToGlobalRate", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseToGlobalRate = :baseToGlobalRate"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseToQuoteRate", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseToQuoteRate = :baseToQuoteRate"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerTaxvat", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerTaxvat = :customerTaxvat"),
    @NamedQuery(name = "SalesFlatQuote.findByCustomerGender", query = "SELECT s FROM SalesFlatQuote s WHERE s.customerGender = :customerGender"),
    @NamedQuery(name = "SalesFlatQuote.findBySubtotal", query = "SELECT s FROM SalesFlatQuote s WHERE s.subtotal = :subtotal"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseSubtotal", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseSubtotal = :baseSubtotal"),
    @NamedQuery(name = "SalesFlatQuote.findBySubtotalWithDiscount", query = "SELECT s FROM SalesFlatQuote s WHERE s.subtotalWithDiscount = :subtotalWithDiscount"),
    @NamedQuery(name = "SalesFlatQuote.findByBaseSubtotalWithDiscount", query = "SELECT s FROM SalesFlatQuote s WHERE s.baseSubtotalWithDiscount = :baseSubtotalWithDiscount"),
    @NamedQuery(name = "SalesFlatQuote.findByIsChanged", query = "SELECT s FROM SalesFlatQuote s WHERE s.isChanged = :isChanged"),
    @NamedQuery(name = "SalesFlatQuote.findByTriggerRecollect", query = "SELECT s FROM SalesFlatQuote s WHERE s.triggerRecollect = :triggerRecollect"),
    @NamedQuery(name = "SalesFlatQuote.findByGiftMessageId", query = "SELECT s FROM SalesFlatQuote s WHERE s.giftMessageId = :giftMessageId"),
    @NamedQuery(name = "SalesFlatQuote.findByIsPersistent", query = "SELECT s FROM SalesFlatQuote s WHERE s.isPersistent = :isPersistent")})
public class SalesFlatQuote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "converted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date convertedAt;
    @Column(name = "is_active")
    private Short isActive;
    @Column(name = "is_virtual")
    private Short isVirtual;
    @Column(name = "is_multi_shipping")
    private Short isMultiShipping;
    @Column(name = "items_count")
    private Integer itemsCount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "items_qty")
    private BigDecimal itemsQty;
    @Column(name = "orig_order_id")
    private Integer origOrderId;
    @Column(name = "store_to_base_rate")
    private BigDecimal storeToBaseRate;
    @Column(name = "store_to_quote_rate")
    private BigDecimal storeToQuoteRate;
    @Column(name = "base_currency_code")
    private String baseCurrencyCode;
    @Column(name = "store_currency_code")
    private String storeCurrencyCode;
    @Column(name = "quote_currency_code")
    private String quoteCurrencyCode;
    @Column(name = "grand_total")
    private BigDecimal grandTotal;
    @Column(name = "base_grand_total")
    private BigDecimal baseGrandTotal;
    @Column(name = "checkout_method")
    private String checkoutMethod;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "customer_tax_class_id")
    private Integer customerTaxClassId;
    @Column(name = "customer_group_id")
    private Integer customerGroupId;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_prefix")
    private String customerPrefix;
    @Column(name = "customer_firstname")
    private String customerFirstname;
    @Column(name = "customer_middlename")
    private String customerMiddlename;
    @Column(name = "customer_lastname")
    private String customerLastname;
    @Column(name = "customer_suffix")
    private String customerSuffix;
    @Column(name = "customer_dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerDob;
    @Column(name = "customer_note")
    private String customerNote;
    @Column(name = "customer_note_notify")
    private Short customerNoteNotify;
    @Column(name = "customer_is_guest")
    private Short customerIsGuest;
    @Column(name = "remote_ip")
    private String remoteIp;
    @Column(name = "applied_rule_ids")
    private String appliedRuleIds;
    @Column(name = "reserved_order_id")
    private String reservedOrderId;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "global_currency_code")
    private String globalCurrencyCode;
    @Column(name = "base_to_global_rate")
    private BigDecimal baseToGlobalRate;
    @Column(name = "base_to_quote_rate")
    private BigDecimal baseToQuoteRate;
    @Column(name = "customer_taxvat")
    private String customerTaxvat;
    @Column(name = "customer_gender")
    private String customerGender;
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "base_subtotal")
    private BigDecimal baseSubtotal;
    @Column(name = "subtotal_with_discount")
    private BigDecimal subtotalWithDiscount;
    @Column(name = "base_subtotal_with_discount")
    private BigDecimal baseSubtotalWithDiscount;
    @Column(name = "is_changed")
    private Integer isChanged;
    @Basic(optional = false)
    @Column(name = "trigger_recollect")
    private short triggerRecollect;
    @Lob
    @Column(name = "ext_shipping_info")
    private String extShippingInfo;
    @Column(name = "gift_message_id")
    private Integer giftMessageId;
    @Column(name = "is_persistent")
    private Short isPersistent;
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne(optional = false)
    private CoreStore storeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quoteId")
    private Collection<SalesFlatQuotePayment> salesFlatQuotePaymentCollection;

    public SalesFlatQuote() {
    }

    public SalesFlatQuote(Integer entityId) {
        this.entityId = entityId;
    }

    public SalesFlatQuote(Integer entityId, Date createdAt, Date updatedAt, short triggerRecollect) {
        this.entityId = entityId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.triggerRecollect = triggerRecollect;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
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

    public Date getConvertedAt() {
        return convertedAt;
    }

    public void setConvertedAt(Date convertedAt) {
        this.convertedAt = convertedAt;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Short getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Short isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Short getIsMultiShipping() {
        return isMultiShipping;
    }

    public void setIsMultiShipping(Short isMultiShipping) {
        this.isMultiShipping = isMultiShipping;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public BigDecimal getItemsQty() {
        return itemsQty;
    }

    public void setItemsQty(BigDecimal itemsQty) {
        this.itemsQty = itemsQty;
    }

    public Integer getOrigOrderId() {
        return origOrderId;
    }

    public void setOrigOrderId(Integer origOrderId) {
        this.origOrderId = origOrderId;
    }

    public BigDecimal getStoreToBaseRate() {
        return storeToBaseRate;
    }

    public void setStoreToBaseRate(BigDecimal storeToBaseRate) {
        this.storeToBaseRate = storeToBaseRate;
    }

    public BigDecimal getStoreToQuoteRate() {
        return storeToQuoteRate;
    }

    public void setStoreToQuoteRate(BigDecimal storeToQuoteRate) {
        this.storeToQuoteRate = storeToQuoteRate;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getStoreCurrencyCode() {
        return storeCurrencyCode;
    }

    public void setStoreCurrencyCode(String storeCurrencyCode) {
        this.storeCurrencyCode = storeCurrencyCode;
    }

    public String getQuoteCurrencyCode() {
        return quoteCurrencyCode;
    }

    public void setQuoteCurrencyCode(String quoteCurrencyCode) {
        this.quoteCurrencyCode = quoteCurrencyCode;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(BigDecimal baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public String getCheckoutMethod() {
        return checkoutMethod;
    }

    public void setCheckoutMethod(String checkoutMethod) {
        this.checkoutMethod = checkoutMethod;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerTaxClassId() {
        return customerTaxClassId;
    }

    public void setCustomerTaxClassId(Integer customerTaxClassId) {
        this.customerTaxClassId = customerTaxClassId;
    }

    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPrefix() {
        return customerPrefix;
    }

    public void setCustomerPrefix(String customerPrefix) {
        this.customerPrefix = customerPrefix;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerMiddlename() {
        return customerMiddlename;
    }

    public void setCustomerMiddlename(String customerMiddlename) {
        this.customerMiddlename = customerMiddlename;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public String getCustomerSuffix() {
        return customerSuffix;
    }

    public void setCustomerSuffix(String customerSuffix) {
        this.customerSuffix = customerSuffix;
    }

    public Date getCustomerDob() {
        return customerDob;
    }

    public void setCustomerDob(Date customerDob) {
        this.customerDob = customerDob;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public Short getCustomerNoteNotify() {
        return customerNoteNotify;
    }

    public void setCustomerNoteNotify(Short customerNoteNotify) {
        this.customerNoteNotify = customerNoteNotify;
    }

    public Short getCustomerIsGuest() {
        return customerIsGuest;
    }

    public void setCustomerIsGuest(Short customerIsGuest) {
        this.customerIsGuest = customerIsGuest;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getAppliedRuleIds() {
        return appliedRuleIds;
    }

    public void setAppliedRuleIds(String appliedRuleIds) {
        this.appliedRuleIds = appliedRuleIds;
    }

    public String getReservedOrderId() {
        return reservedOrderId;
    }

    public void setReservedOrderId(String reservedOrderId) {
        this.reservedOrderId = reservedOrderId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getGlobalCurrencyCode() {
        return globalCurrencyCode;
    }

    public void setGlobalCurrencyCode(String globalCurrencyCode) {
        this.globalCurrencyCode = globalCurrencyCode;
    }

    public BigDecimal getBaseToGlobalRate() {
        return baseToGlobalRate;
    }

    public void setBaseToGlobalRate(BigDecimal baseToGlobalRate) {
        this.baseToGlobalRate = baseToGlobalRate;
    }

    public BigDecimal getBaseToQuoteRate() {
        return baseToQuoteRate;
    }

    public void setBaseToQuoteRate(BigDecimal baseToQuoteRate) {
        this.baseToQuoteRate = baseToQuoteRate;
    }

    public String getCustomerTaxvat() {
        return customerTaxvat;
    }

    public void setCustomerTaxvat(String customerTaxvat) {
        this.customerTaxvat = customerTaxvat;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getBaseSubtotal() {
        return baseSubtotal;
    }

    public void setBaseSubtotal(BigDecimal baseSubtotal) {
        this.baseSubtotal = baseSubtotal;
    }

    public BigDecimal getSubtotalWithDiscount() {
        return subtotalWithDiscount;
    }

    public void setSubtotalWithDiscount(BigDecimal subtotalWithDiscount) {
        this.subtotalWithDiscount = subtotalWithDiscount;
    }

    public BigDecimal getBaseSubtotalWithDiscount() {
        return baseSubtotalWithDiscount;
    }

    public void setBaseSubtotalWithDiscount(BigDecimal baseSubtotalWithDiscount) {
        this.baseSubtotalWithDiscount = baseSubtotalWithDiscount;
    }

    public Integer getIsChanged() {
        return isChanged;
    }

    public void setIsChanged(Integer isChanged) {
        this.isChanged = isChanged;
    }

    public short getTriggerRecollect() {
        return triggerRecollect;
    }

    public void setTriggerRecollect(short triggerRecollect) {
        this.triggerRecollect = triggerRecollect;
    }

    public String getExtShippingInfo() {
        return extShippingInfo;
    }

    public void setExtShippingInfo(String extShippingInfo) {
        this.extShippingInfo = extShippingInfo;
    }

    public Integer getGiftMessageId() {
        return giftMessageId;
    }

    public void setGiftMessageId(Integer giftMessageId) {
        this.giftMessageId = giftMessageId;
    }

    public Short getIsPersistent() {
        return isPersistent;
    }

    public void setIsPersistent(Short isPersistent) {
        this.isPersistent = isPersistent;
    }

    public CoreStore getStoreId() {
        return storeId;
    }

    public void setStoreId(CoreStore storeId) {
        this.storeId = storeId;
    }

    @XmlTransient
    public Collection<SalesFlatQuotePayment> getSalesFlatQuotePaymentCollection() {
        return salesFlatQuotePaymentCollection;
    }

    public void setSalesFlatQuotePaymentCollection(Collection<SalesFlatQuotePayment> salesFlatQuotePaymentCollection) {
        this.salesFlatQuotePaymentCollection = salesFlatQuotePaymentCollection;
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
        if (!(object instanceof SalesFlatQuote)) {
            return false;
        }
        SalesFlatQuote other = (SalesFlatQuote) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatQuote[ entityId=" + entityId + " ]";
    }
    
}
