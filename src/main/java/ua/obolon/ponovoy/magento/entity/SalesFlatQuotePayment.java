/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "sales_flat_quote_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatQuotePayment.findAll", query = "SELECT s FROM SalesFlatQuotePayment s"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByPaymentId", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.paymentId = :paymentId"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCreatedAt", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByUpdatedAt", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.updatedAt = :updatedAt"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByMethod", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.method = :method"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcType", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccType = :ccType"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcNumberEnc", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccNumberEnc = :ccNumberEnc"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcLast4", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccLast4 = :ccLast4"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcCidEnc", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccCidEnc = :ccCidEnc"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcOwner", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccOwner = :ccOwner"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcExpMonth", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccExpMonth = :ccExpMonth"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcExpYear", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccExpYear = :ccExpYear"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcSsOwner", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccSsOwner = :ccSsOwner"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcSsStartMonth", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccSsStartMonth = :ccSsStartMonth"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcSsStartYear", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccSsStartYear = :ccSsStartYear"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByPoNumber", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.poNumber = :poNumber"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByCcSsIssue", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.ccSsIssue = :ccSsIssue"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByPaypalPayerId", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.paypalPayerId = :paypalPayerId"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByPaypalPayerStatus", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.paypalPayerStatus = :paypalPayerStatus"),
    @NamedQuery(name = "SalesFlatQuotePayment.findByPaypalCorrelationId", query = "SELECT s FROM SalesFlatQuotePayment s WHERE s.paypalCorrelationId = :paypalCorrelationId")})
public class SalesFlatQuotePayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "method")
    private String method;
    @Column(name = "cc_type")
    private String ccType;
    @Column(name = "cc_number_enc")
    private String ccNumberEnc;
    @Column(name = "cc_last4")
    private String ccLast4;
    @Column(name = "cc_cid_enc")
    private String ccCidEnc;
    @Column(name = "cc_owner")
    private String ccOwner;
    @Column(name = "cc_exp_month")
    private Short ccExpMonth;
    @Column(name = "cc_exp_year")
    private Short ccExpYear;
    @Column(name = "cc_ss_owner")
    private String ccSsOwner;
    @Column(name = "cc_ss_start_month")
    private Short ccSsStartMonth;
    @Column(name = "cc_ss_start_year")
    private Short ccSsStartYear;
    @Column(name = "po_number")
    private String poNumber;
    @Lob
    @Column(name = "additional_data")
    private String additionalData;
    @Column(name = "cc_ss_issue")
    private String ccSsIssue;
    @Lob
    @Column(name = "additional_information")
    private String additionalInformation;
    @Column(name = "paypal_payer_id")
    private String paypalPayerId;
    @Column(name = "paypal_payer_status")
    private String paypalPayerStatus;
    @Column(name = "paypal_correlation_id")
    private String paypalCorrelationId;
    @JoinColumn(name = "quote_id", referencedColumnName = "entity_id")
    @ManyToOne(optional = false)
    private SalesFlatQuote quoteId;

    public SalesFlatQuotePayment() {
    }

    public SalesFlatQuotePayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public SalesFlatQuotePayment(Integer paymentId, Date createdAt, Date updatedAt) {
        this.paymentId = paymentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public String getCcNumberEnc() {
        return ccNumberEnc;
    }

    public void setCcNumberEnc(String ccNumberEnc) {
        this.ccNumberEnc = ccNumberEnc;
    }

    public String getCcLast4() {
        return ccLast4;
    }

    public void setCcLast4(String ccLast4) {
        this.ccLast4 = ccLast4;
    }

    public String getCcCidEnc() {
        return ccCidEnc;
    }

    public void setCcCidEnc(String ccCidEnc) {
        this.ccCidEnc = ccCidEnc;
    }

    public String getCcOwner() {
        return ccOwner;
    }

    public void setCcOwner(String ccOwner) {
        this.ccOwner = ccOwner;
    }

    public Short getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(Short ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public Short getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(Short ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCcSsOwner() {
        return ccSsOwner;
    }

    public void setCcSsOwner(String ccSsOwner) {
        this.ccSsOwner = ccSsOwner;
    }

    public Short getCcSsStartMonth() {
        return ccSsStartMonth;
    }

    public void setCcSsStartMonth(Short ccSsStartMonth) {
        this.ccSsStartMonth = ccSsStartMonth;
    }

    public Short getCcSsStartYear() {
        return ccSsStartYear;
    }

    public void setCcSsStartYear(Short ccSsStartYear) {
        this.ccSsStartYear = ccSsStartYear;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getCcSsIssue() {
        return ccSsIssue;
    }

    public void setCcSsIssue(String ccSsIssue) {
        this.ccSsIssue = ccSsIssue;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getPaypalPayerId() {
        return paypalPayerId;
    }

    public void setPaypalPayerId(String paypalPayerId) {
        this.paypalPayerId = paypalPayerId;
    }

    public String getPaypalPayerStatus() {
        return paypalPayerStatus;
    }

    public void setPaypalPayerStatus(String paypalPayerStatus) {
        this.paypalPayerStatus = paypalPayerStatus;
    }

    public String getPaypalCorrelationId() {
        return paypalCorrelationId;
    }

    public void setPaypalCorrelationId(String paypalCorrelationId) {
        this.paypalCorrelationId = paypalCorrelationId;
    }

    public SalesFlatQuote getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(SalesFlatQuote quoteId) {
        this.quoteId = quoteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesFlatQuotePayment)) {
            return false;
        }
        SalesFlatQuotePayment other = (SalesFlatQuotePayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatQuotePayment[ paymentId=" + paymentId + " ]";
    }
    
}
