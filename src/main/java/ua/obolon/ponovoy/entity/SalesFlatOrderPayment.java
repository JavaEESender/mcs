/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sales_flat_order_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatOrderPayment.findAll", query = "SELECT s FROM SalesFlatOrderPayment s"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEntityId", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.entityId = :entityId"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseShippingCaptured", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseShippingCaptured = :baseShippingCaptured"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByShippingCaptured", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.shippingCaptured = :shippingCaptured"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAmountRefunded", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.amountRefunded = :amountRefunded"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountPaid", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountPaid = :baseAmountPaid"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAmountCanceled", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.amountCanceled = :amountCanceled"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountAuthorized", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountAuthorized = :baseAmountAuthorized"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountPaidOnline", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountPaidOnline = :baseAmountPaidOnline"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountRefundedOnline", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountRefundedOnline = :baseAmountRefundedOnline"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseShippingAmount", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseShippingAmount = :baseShippingAmount"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByShippingAmount", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.shippingAmount = :shippingAmount"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAmountPaid", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.amountPaid = :amountPaid"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAmountAuthorized", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.amountAuthorized = :amountAuthorized"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountOrdered", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountOrdered = :baseAmountOrdered"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseShippingRefunded", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseShippingRefunded = :baseShippingRefunded"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByShippingRefunded", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.shippingRefunded = :shippingRefunded"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountRefunded", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountRefunded = :baseAmountRefunded"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAmountOrdered", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.amountOrdered = :amountOrdered"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByBaseAmountCanceled", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.baseAmountCanceled = :baseAmountCanceled"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByQuotePaymentId", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.quotePaymentId = :quotePaymentId"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcExpMonth", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccExpMonth = :ccExpMonth"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcSsStartYear", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccSsStartYear = :ccSsStartYear"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEcheckBankName", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.echeckBankName = :echeckBankName"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByMethod", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.method = :method"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcDebugRequestBody", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccDebugRequestBody = :ccDebugRequestBody"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcSecureVerify", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccSecureVerify = :ccSecureVerify"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByProtectionEligibility", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.protectionEligibility = :protectionEligibility"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcApproval", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccApproval = :ccApproval"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcLast4", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccLast4 = :ccLast4"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcStatusDescription", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccStatusDescription = :ccStatusDescription"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEcheckType", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.echeckType = :echeckType"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcDebugResponseSerialized", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccDebugResponseSerialized = :ccDebugResponseSerialized"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcSsStartMonth", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccSsStartMonth = :ccSsStartMonth"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEcheckAccountType", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.echeckAccountType = :echeckAccountType"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByLastTransId", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.lastTransId = :lastTransId"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcCidStatus", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccCidStatus = :ccCidStatus"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcOwner", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccOwner = :ccOwner"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcType", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccType = :ccType"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByPoNumber", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.poNumber = :poNumber"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcExpYear", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccExpYear = :ccExpYear"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcStatus", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccStatus = :ccStatus"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEcheckRoutingNumber", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.echeckRoutingNumber = :echeckRoutingNumber"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAccountStatus", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.accountStatus = :accountStatus"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAnetTransMethod", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.anetTransMethod = :anetTransMethod"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcDebugResponseBody", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccDebugResponseBody = :ccDebugResponseBody"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcSsIssue", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccSsIssue = :ccSsIssue"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByEcheckAccountName", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.echeckAccountName = :echeckAccountName"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcAvsStatus", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccAvsStatus = :ccAvsStatus"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcNumberEnc", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccNumberEnc = :ccNumberEnc"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByCcTransId", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.ccTransId = :ccTransId"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByPayboxRequestNumber", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.payboxRequestNumber = :payboxRequestNumber"),
    @NamedQuery(name = "SalesFlatOrderPayment.findByAddressStatus", query = "SELECT s FROM SalesFlatOrderPayment s WHERE s.addressStatus = :addressStatus")})
public class SalesFlatOrderPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "entity_id")
    private Integer entityId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "base_shipping_captured")
    private BigDecimal baseShippingCaptured;
    @Column(name = "shipping_captured")
    private BigDecimal shippingCaptured;
    @Column(name = "amount_refunded")
    private BigDecimal amountRefunded;
    @Column(name = "base_amount_paid")
    private BigDecimal baseAmountPaid;
    @Column(name = "amount_canceled")
    private BigDecimal amountCanceled;
    @Column(name = "base_amount_authorized")
    private BigDecimal baseAmountAuthorized;
    @Column(name = "base_amount_paid_online")
    private BigDecimal baseAmountPaidOnline;
    @Column(name = "base_amount_refunded_online")
    private BigDecimal baseAmountRefundedOnline;
    @Column(name = "base_shipping_amount")
    private BigDecimal baseShippingAmount;
    @Column(name = "shipping_amount")
    private BigDecimal shippingAmount;
    @Column(name = "amount_paid")
    private BigDecimal amountPaid;
    @Column(name = "amount_authorized")
    private BigDecimal amountAuthorized;
    @Column(name = "base_amount_ordered")
    private BigDecimal baseAmountOrdered;
    @Column(name = "base_shipping_refunded")
    private BigDecimal baseShippingRefunded;
    @Column(name = "shipping_refunded")
    private BigDecimal shippingRefunded;
    @Column(name = "base_amount_refunded")
    private BigDecimal baseAmountRefunded;
    @Column(name = "amount_ordered")
    private BigDecimal amountOrdered;
    @Column(name = "base_amount_canceled")
    private BigDecimal baseAmountCanceled;
    @Column(name = "quote_payment_id")
    private Integer quotePaymentId;
    @Lob
    @Column(name = "additional_data")
    private String additionalData;
    @Column(name = "cc_exp_month")
    private String ccExpMonth;
    @Column(name = "cc_ss_start_year")
    private String ccSsStartYear;
    @Column(name = "echeck_bank_name")
    private String echeckBankName;
    @Column(name = "method")
    private String method;
    @Column(name = "cc_debug_request_body")
    private String ccDebugRequestBody;
    @Column(name = "cc_secure_verify")
    private String ccSecureVerify;
    @Column(name = "protection_eligibility")
    private String protectionEligibility;
    @Column(name = "cc_approval")
    private String ccApproval;
    @Column(name = "cc_last4")
    private String ccLast4;
    @Column(name = "cc_status_description")
    private String ccStatusDescription;
    @Column(name = "echeck_type")
    private String echeckType;
    @Column(name = "cc_debug_response_serialized")
    private String ccDebugResponseSerialized;
    @Column(name = "cc_ss_start_month")
    private String ccSsStartMonth;
    @Column(name = "echeck_account_type")
    private String echeckAccountType;
    @Column(name = "last_trans_id")
    private String lastTransId;
    @Column(name = "cc_cid_status")
    private String ccCidStatus;
    @Column(name = "cc_owner")
    private String ccOwner;
    @Column(name = "cc_type")
    private String ccType;
    @Column(name = "po_number")
    private String poNumber;
    @Column(name = "cc_exp_year")
    private String ccExpYear;
    @Column(name = "cc_status")
    private String ccStatus;
    @Column(name = "echeck_routing_number")
    private String echeckRoutingNumber;
    @Column(name = "account_status")
    private String accountStatus;
    @Column(name = "anet_trans_method")
    private String anetTransMethod;
    @Column(name = "cc_debug_response_body")
    private String ccDebugResponseBody;
    @Column(name = "cc_ss_issue")
    private String ccSsIssue;
    @Column(name = "echeck_account_name")
    private String echeckAccountName;
    @Column(name = "cc_avs_status")
    private String ccAvsStatus;
    @Column(name = "cc_number_enc")
    private String ccNumberEnc;
    @Column(name = "cc_trans_id")
    private String ccTransId;
    @Column(name = "paybox_request_number")
    private String payboxRequestNumber;
    @Column(name = "address_status")
    private String addressStatus;
    @Lob
    @Column(name = "additional_information")
    private String additionalInformation;
    @JoinColumn(name = "parent_id", referencedColumnName = "entity_id")
    @ManyToOne(optional = false)
    private SalesFlatOrder parentId;

    public SalesFlatOrderPayment() {
    }

    public SalesFlatOrderPayment(Integer entityId) {
        this.entityId = entityId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public BigDecimal getBaseShippingCaptured() {
        return baseShippingCaptured;
    }

    public void setBaseShippingCaptured(BigDecimal baseShippingCaptured) {
        this.baseShippingCaptured = baseShippingCaptured;
    }

    public BigDecimal getShippingCaptured() {
        return shippingCaptured;
    }

    public void setShippingCaptured(BigDecimal shippingCaptured) {
        this.shippingCaptured = shippingCaptured;
    }

    public BigDecimal getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(BigDecimal amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public BigDecimal getBaseAmountPaid() {
        return baseAmountPaid;
    }

    public void setBaseAmountPaid(BigDecimal baseAmountPaid) {
        this.baseAmountPaid = baseAmountPaid;
    }

    public BigDecimal getAmountCanceled() {
        return amountCanceled;
    }

    public void setAmountCanceled(BigDecimal amountCanceled) {
        this.amountCanceled = amountCanceled;
    }

    public BigDecimal getBaseAmountAuthorized() {
        return baseAmountAuthorized;
    }

    public void setBaseAmountAuthorized(BigDecimal baseAmountAuthorized) {
        this.baseAmountAuthorized = baseAmountAuthorized;
    }

    public BigDecimal getBaseAmountPaidOnline() {
        return baseAmountPaidOnline;
    }

    public void setBaseAmountPaidOnline(BigDecimal baseAmountPaidOnline) {
        this.baseAmountPaidOnline = baseAmountPaidOnline;
    }

    public BigDecimal getBaseAmountRefundedOnline() {
        return baseAmountRefundedOnline;
    }

    public void setBaseAmountRefundedOnline(BigDecimal baseAmountRefundedOnline) {
        this.baseAmountRefundedOnline = baseAmountRefundedOnline;
    }

    public BigDecimal getBaseShippingAmount() {
        return baseShippingAmount;
    }

    public void setBaseShippingAmount(BigDecimal baseShippingAmount) {
        this.baseShippingAmount = baseShippingAmount;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public BigDecimal getAmountAuthorized() {
        return amountAuthorized;
    }

    public void setAmountAuthorized(BigDecimal amountAuthorized) {
        this.amountAuthorized = amountAuthorized;
    }

    public BigDecimal getBaseAmountOrdered() {
        return baseAmountOrdered;
    }

    public void setBaseAmountOrdered(BigDecimal baseAmountOrdered) {
        this.baseAmountOrdered = baseAmountOrdered;
    }

    public BigDecimal getBaseShippingRefunded() {
        return baseShippingRefunded;
    }

    public void setBaseShippingRefunded(BigDecimal baseShippingRefunded) {
        this.baseShippingRefunded = baseShippingRefunded;
    }

    public BigDecimal getShippingRefunded() {
        return shippingRefunded;
    }

    public void setShippingRefunded(BigDecimal shippingRefunded) {
        this.shippingRefunded = shippingRefunded;
    }

    public BigDecimal getBaseAmountRefunded() {
        return baseAmountRefunded;
    }

    public void setBaseAmountRefunded(BigDecimal baseAmountRefunded) {
        this.baseAmountRefunded = baseAmountRefunded;
    }

    public BigDecimal getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(BigDecimal amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    public BigDecimal getBaseAmountCanceled() {
        return baseAmountCanceled;
    }

    public void setBaseAmountCanceled(BigDecimal baseAmountCanceled) {
        this.baseAmountCanceled = baseAmountCanceled;
    }

    public Integer getQuotePaymentId() {
        return quotePaymentId;
    }

    public void setQuotePaymentId(Integer quotePaymentId) {
        this.quotePaymentId = quotePaymentId;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getCcSsStartYear() {
        return ccSsStartYear;
    }

    public void setCcSsStartYear(String ccSsStartYear) {
        this.ccSsStartYear = ccSsStartYear;
    }

    public String getEcheckBankName() {
        return echeckBankName;
    }

    public void setEcheckBankName(String echeckBankName) {
        this.echeckBankName = echeckBankName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCcDebugRequestBody() {
        return ccDebugRequestBody;
    }

    public void setCcDebugRequestBody(String ccDebugRequestBody) {
        this.ccDebugRequestBody = ccDebugRequestBody;
    }

    public String getCcSecureVerify() {
        return ccSecureVerify;
    }

    public void setCcSecureVerify(String ccSecureVerify) {
        this.ccSecureVerify = ccSecureVerify;
    }

    public String getProtectionEligibility() {
        return protectionEligibility;
    }

    public void setProtectionEligibility(String protectionEligibility) {
        this.protectionEligibility = protectionEligibility;
    }

    public String getCcApproval() {
        return ccApproval;
    }

    public void setCcApproval(String ccApproval) {
        this.ccApproval = ccApproval;
    }

    public String getCcLast4() {
        return ccLast4;
    }

    public void setCcLast4(String ccLast4) {
        this.ccLast4 = ccLast4;
    }

    public String getCcStatusDescription() {
        return ccStatusDescription;
    }

    public void setCcStatusDescription(String ccStatusDescription) {
        this.ccStatusDescription = ccStatusDescription;
    }

    public String getEcheckType() {
        return echeckType;
    }

    public void setEcheckType(String echeckType) {
        this.echeckType = echeckType;
    }

    public String getCcDebugResponseSerialized() {
        return ccDebugResponseSerialized;
    }

    public void setCcDebugResponseSerialized(String ccDebugResponseSerialized) {
        this.ccDebugResponseSerialized = ccDebugResponseSerialized;
    }

    public String getCcSsStartMonth() {
        return ccSsStartMonth;
    }

    public void setCcSsStartMonth(String ccSsStartMonth) {
        this.ccSsStartMonth = ccSsStartMonth;
    }

    public String getEcheckAccountType() {
        return echeckAccountType;
    }

    public void setEcheckAccountType(String echeckAccountType) {
        this.echeckAccountType = echeckAccountType;
    }

    public String getLastTransId() {
        return lastTransId;
    }

    public void setLastTransId(String lastTransId) {
        this.lastTransId = lastTransId;
    }

    public String getCcCidStatus() {
        return ccCidStatus;
    }

    public void setCcCidStatus(String ccCidStatus) {
        this.ccCidStatus = ccCidStatus;
    }

    public String getCcOwner() {
        return ccOwner;
    }

    public void setCcOwner(String ccOwner) {
        this.ccOwner = ccOwner;
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCcStatus() {
        return ccStatus;
    }

    public void setCcStatus(String ccStatus) {
        this.ccStatus = ccStatus;
    }

    public String getEcheckRoutingNumber() {
        return echeckRoutingNumber;
    }

    public void setEcheckRoutingNumber(String echeckRoutingNumber) {
        this.echeckRoutingNumber = echeckRoutingNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAnetTransMethod() {
        return anetTransMethod;
    }

    public void setAnetTransMethod(String anetTransMethod) {
        this.anetTransMethod = anetTransMethod;
    }

    public String getCcDebugResponseBody() {
        return ccDebugResponseBody;
    }

    public void setCcDebugResponseBody(String ccDebugResponseBody) {
        this.ccDebugResponseBody = ccDebugResponseBody;
    }

    public String getCcSsIssue() {
        return ccSsIssue;
    }

    public void setCcSsIssue(String ccSsIssue) {
        this.ccSsIssue = ccSsIssue;
    }

    public String getEcheckAccountName() {
        return echeckAccountName;
    }

    public void setEcheckAccountName(String echeckAccountName) {
        this.echeckAccountName = echeckAccountName;
    }

    public String getCcAvsStatus() {
        return ccAvsStatus;
    }

    public void setCcAvsStatus(String ccAvsStatus) {
        this.ccAvsStatus = ccAvsStatus;
    }

    public String getCcNumberEnc() {
        return ccNumberEnc;
    }

    public void setCcNumberEnc(String ccNumberEnc) {
        this.ccNumberEnc = ccNumberEnc;
    }

    public String getCcTransId() {
        return ccTransId;
    }

    public void setCcTransId(String ccTransId) {
        this.ccTransId = ccTransId;
    }

    public String getPayboxRequestNumber() {
        return payboxRequestNumber;
    }

    public void setPayboxRequestNumber(String payboxRequestNumber) {
        this.payboxRequestNumber = payboxRequestNumber;
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
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
        if (!(object instanceof SalesFlatOrderPayment)) {
            return false;
        }
        SalesFlatOrderPayment other = (SalesFlatOrderPayment) object;
        if ((this.entityId == null && other.entityId != null) || (this.entityId != null && !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatOrderPayment[ entityId=" + entityId + " ]";
    }
    
}
