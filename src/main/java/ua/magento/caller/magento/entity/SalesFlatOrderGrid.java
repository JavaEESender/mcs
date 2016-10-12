/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.magento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "sales_flat_order_grid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatOrderGrid.findAll", query = "SELECT s FROM SalesFlatOrderGrid s"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByEntityId", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.entityId = :entityId"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByStatus", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.status = :status"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByStoreName", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.storeName = :storeName"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByBaseGrandTotal", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.baseGrandTotal = :baseGrandTotal"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByBaseTotalPaid", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.baseTotalPaid = :baseTotalPaid"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByGrandTotal", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.grandTotal = :grandTotal"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByTotalPaid", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.totalPaid = :totalPaid"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByIncrementId", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.incrementId = :incrementId"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByBaseCurrencyCode", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.baseCurrencyCode = :baseCurrencyCode"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByOrderCurrencyCode", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.orderCurrencyCode = :orderCurrencyCode"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByShippingName", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.shippingName = :shippingName"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByBillingName", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.billingName = :billingName"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByCreatedAt", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SalesFlatOrderGrid.findByUpdatedAt", query = "SELECT s FROM SalesFlatOrderGrid s WHERE s.updatedAt = :updatedAt")})
public class SalesFlatOrderGrid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    @Column(name = "status")
    private String status;
    @Column(name = "store_name")
    private String storeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "base_grand_total")
    private BigDecimal baseGrandTotal;
    @Column(name = "base_total_paid")
    private BigDecimal baseTotalPaid;
    @Column(name = "grand_total")
    private BigDecimal grandTotal;
    @Column(name = "total_paid")
    private BigDecimal totalPaid;
    @Column(name = "increment_id")
    private String incrementId;
    @Column(name = "base_currency_code")
    private String baseCurrencyCode;
    @Column(name = "order_currency_code")
    private String orderCurrencyCode;
    @Column(name = "shipping_name")
    private String shippingName;
    @Column(name = "billing_name")
    private String billingName;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "customer_id", referencedColumnName = "entity_id")
    @ManyToOne
    private CustomerEntity customerId;
    @JoinColumn(name = "entity_id", referencedColumnName = "entity_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SalesFlatOrder salesFlatOrder;
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne
    private CoreStore storeId;

    public SalesFlatOrderGrid() {
    }

    public SalesFlatOrderGrid(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getBaseGrandTotal() {
        return baseGrandTotal;
    }

    public void setBaseGrandTotal(BigDecimal baseGrandTotal) {
        this.baseGrandTotal = baseGrandTotal;
    }

    public BigDecimal getBaseTotalPaid() {
        return baseTotalPaid;
    }

    public void setBaseTotalPaid(BigDecimal baseTotalPaid) {
        this.baseTotalPaid = baseTotalPaid;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(String incrementId) {
        this.incrementId = incrementId;
    }

    public String getBaseCurrencyCode() {
        return baseCurrencyCode;
    }

    public void setBaseCurrencyCode(String baseCurrencyCode) {
        this.baseCurrencyCode = baseCurrencyCode;
    }

    public String getOrderCurrencyCode() {
        return orderCurrencyCode;
    }

    public void setOrderCurrencyCode(String orderCurrencyCode) {
        this.orderCurrencyCode = orderCurrencyCode;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
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

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public SalesFlatOrder getSalesFlatOrder() {
        return salesFlatOrder;
    }

    public void setSalesFlatOrder(SalesFlatOrder salesFlatOrder) {
        this.salesFlatOrder = salesFlatOrder;
    }

    public CoreStore getStoreId() {
        return storeId;
    }

    public void setStoreId(CoreStore storeId) {
        this.storeId = storeId;
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
        if (!(object instanceof SalesFlatOrderGrid)) {
            return false;
        }
        SalesFlatOrderGrid other = (SalesFlatOrderGrid) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatOrderGrid[ entityId=" + entityId + " ]";
    }
    
}
