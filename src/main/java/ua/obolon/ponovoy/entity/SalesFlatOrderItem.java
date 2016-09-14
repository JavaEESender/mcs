/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "sales_flat_order_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesFlatOrderItem.findAll", query = "SELECT s FROM SalesFlatOrderItem s"),
    @NamedQuery(name = "SalesFlatOrderItem.findByItemId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.itemId = :itemId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByParentItemId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.parentItemId = :parentItemId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQuoteItemId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.quoteItemId = :quoteItemId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByCreatedAt", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SalesFlatOrderItem.findByUpdatedAt", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.updatedAt = :updatedAt"),
    @NamedQuery(name = "SalesFlatOrderItem.findByProductId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.productId = :productId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByProductType", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.productType = :productType"),
    @NamedQuery(name = "SalesFlatOrderItem.findByWeight", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.weight = :weight"),
    @NamedQuery(name = "SalesFlatOrderItem.findByIsVirtual", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.isVirtual = :isVirtual"),
    @NamedQuery(name = "SalesFlatOrderItem.findBySku", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.sku = :sku"),
    @NamedQuery(name = "SalesFlatOrderItem.findByName", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.name = :name"),
    @NamedQuery(name = "SalesFlatOrderItem.findByFreeShipping", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.freeShipping = :freeShipping"),
    @NamedQuery(name = "SalesFlatOrderItem.findByIsQtyDecimal", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.isQtyDecimal = :isQtyDecimal"),
    @NamedQuery(name = "SalesFlatOrderItem.findByNoDiscount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.noDiscount = :noDiscount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyBackordered", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyBackordered = :qtyBackordered"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyCanceled", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyCanceled = :qtyCanceled"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyInvoiced = :qtyInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyOrdered", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyOrdered = :qtyOrdered"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyRefunded = :qtyRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByQtyShipped", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.qtyShipped = :qtyShipped"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseCost", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseCost = :baseCost"),
    @NamedQuery(name = "SalesFlatOrderItem.findByPrice", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.price = :price"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBasePrice", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.basePrice = :basePrice"),
    @NamedQuery(name = "SalesFlatOrderItem.findByOriginalPrice", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.originalPrice = :originalPrice"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseOriginalPrice", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseOriginalPrice = :baseOriginalPrice"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxPercent", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxPercent = :taxPercent"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxAmount = :taxAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseTaxAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseTaxAmount = :baseTaxAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxInvoiced = :taxInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseTaxInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseTaxInvoiced = :baseTaxInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByDiscountPercent", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.discountPercent = :discountPercent"),
    @NamedQuery(name = "SalesFlatOrderItem.findByDiscountAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.discountAmount = :discountAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseDiscountAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseDiscountAmount = :baseDiscountAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByDiscountInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.discountInvoiced = :discountInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseDiscountInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseDiscountInvoiced = :baseDiscountInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByAmountRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.amountRefunded = :amountRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseAmountRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseAmountRefunded = :baseAmountRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByRowTotal", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.rowTotal = :rowTotal"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseRowTotal", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseRowTotal = :baseRowTotal"),
    @NamedQuery(name = "SalesFlatOrderItem.findByRowInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.rowInvoiced = :rowInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseRowInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseRowInvoiced = :baseRowInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByRowWeight", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.rowWeight = :rowWeight"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseTaxBeforeDiscount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseTaxBeforeDiscount = :baseTaxBeforeDiscount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxBeforeDiscount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxBeforeDiscount = :taxBeforeDiscount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByExtOrderItemId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.extOrderItemId = :extOrderItemId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByLockedDoInvoice", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.lockedDoInvoice = :lockedDoInvoice"),
    @NamedQuery(name = "SalesFlatOrderItem.findByLockedDoShip", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.lockedDoShip = :lockedDoShip"),
    @NamedQuery(name = "SalesFlatOrderItem.findByPriceInclTax", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.priceInclTax = :priceInclTax"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBasePriceInclTax", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.basePriceInclTax = :basePriceInclTax"),
    @NamedQuery(name = "SalesFlatOrderItem.findByRowTotalInclTax", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.rowTotalInclTax = :rowTotalInclTax"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseRowTotalInclTax", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseRowTotalInclTax = :baseRowTotalInclTax"),
    @NamedQuery(name = "SalesFlatOrderItem.findByHiddenTaxAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.hiddenTaxAmount = :hiddenTaxAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseHiddenTaxAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseHiddenTaxAmount = :baseHiddenTaxAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByHiddenTaxInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.hiddenTaxInvoiced = :hiddenTaxInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseHiddenTaxInvoiced", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseHiddenTaxInvoiced = :baseHiddenTaxInvoiced"),
    @NamedQuery(name = "SalesFlatOrderItem.findByHiddenTaxRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.hiddenTaxRefunded = :hiddenTaxRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseHiddenTaxRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseHiddenTaxRefunded = :baseHiddenTaxRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByIsNominal", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.isNominal = :isNominal"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxCanceled", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxCanceled = :taxCanceled"),
    @NamedQuery(name = "SalesFlatOrderItem.findByHiddenTaxCanceled", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.hiddenTaxCanceled = :hiddenTaxCanceled"),
    @NamedQuery(name = "SalesFlatOrderItem.findByTaxRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.taxRefunded = :taxRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseTaxRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseTaxRefunded = :baseTaxRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByDiscountRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.discountRefunded = :discountRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseDiscountRefunded", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseDiscountRefunded = :baseDiscountRefunded"),
    @NamedQuery(name = "SalesFlatOrderItem.findByGiftMessageId", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.giftMessageId = :giftMessageId"),
    @NamedQuery(name = "SalesFlatOrderItem.findByGiftMessageAvailable", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.giftMessageAvailable = :giftMessageAvailable"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseWeeeTaxAppliedAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseWeeeTaxAppliedAmount = :baseWeeeTaxAppliedAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseWeeeTaxAppliedRowAmnt", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseWeeeTaxAppliedRowAmnt = :baseWeeeTaxAppliedRowAmnt"),
    @NamedQuery(name = "SalesFlatOrderItem.findByWeeeTaxAppliedAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.weeeTaxAppliedAmount = :weeeTaxAppliedAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByWeeeTaxAppliedRowAmount", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.weeeTaxAppliedRowAmount = :weeeTaxAppliedRowAmount"),
    @NamedQuery(name = "SalesFlatOrderItem.findByWeeeTaxDisposition", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.weeeTaxDisposition = :weeeTaxDisposition"),
    @NamedQuery(name = "SalesFlatOrderItem.findByWeeeTaxRowDisposition", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.weeeTaxRowDisposition = :weeeTaxRowDisposition"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseWeeeTaxDisposition", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseWeeeTaxDisposition = :baseWeeeTaxDisposition"),
    @NamedQuery(name = "SalesFlatOrderItem.findByBaseWeeeTaxRowDisposition", query = "SELECT s FROM SalesFlatOrderItem s WHERE s.baseWeeeTaxRowDisposition = :baseWeeeTaxRowDisposition")})
public class SalesFlatOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "parent_item_id")
    private Integer parentItemId;
    @Column(name = "quote_item_id")
    private Integer quoteItemId;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_type")
    private String productType;
    @Lob
    @Column(name = "product_options")
    private String productOptions;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private BigDecimal weight;
    @Column(name = "is_virtual")
    private Short isVirtual;
    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "applied_rule_ids")
    private String appliedRuleIds;
    @Lob
    @Column(name = "additional_data")
    private String additionalData;
    @Basic(optional = false)
    @Column(name = "free_shipping")
    private short freeShipping;
    @Column(name = "is_qty_decimal")
    private Short isQtyDecimal;
    @Basic(optional = false)
    @Column(name = "no_discount")
    private short noDiscount;
    @Column(name = "qty_backordered")
    private BigDecimal qtyBackordered;
    @Column(name = "qty_canceled")
    private BigDecimal qtyCanceled;
    @Column(name = "qty_invoiced")
    private BigDecimal qtyInvoiced;
    @Column(name = "qty_ordered")
    private BigDecimal qtyOrdered;
    @Column(name = "qty_refunded")
    private BigDecimal qtyRefunded;
    @Column(name = "qty_shipped")
    private BigDecimal qtyShipped;
    @Column(name = "base_cost")
    private BigDecimal baseCost;
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Column(name = "original_price")
    private BigDecimal originalPrice;
    @Column(name = "base_original_price")
    private BigDecimal baseOriginalPrice;
    @Column(name = "tax_percent")
    private BigDecimal taxPercent;
    @Column(name = "tax_amount")
    private BigDecimal taxAmount;
    @Column(name = "base_tax_amount")
    private BigDecimal baseTaxAmount;
    @Column(name = "tax_invoiced")
    private BigDecimal taxInvoiced;
    @Column(name = "base_tax_invoiced")
    private BigDecimal baseTaxInvoiced;
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;
    @Column(name = "base_discount_amount")
    private BigDecimal baseDiscountAmount;
    @Column(name = "discount_invoiced")
    private BigDecimal discountInvoiced;
    @Column(name = "base_discount_invoiced")
    private BigDecimal baseDiscountInvoiced;
    @Column(name = "amount_refunded")
    private BigDecimal amountRefunded;
    @Column(name = "base_amount_refunded")
    private BigDecimal baseAmountRefunded;
    @Basic(optional = false)
    @Column(name = "row_total")
    private BigDecimal rowTotal;
    @Basic(optional = false)
    @Column(name = "base_row_total")
    private BigDecimal baseRowTotal;
    @Basic(optional = false)
    @Column(name = "row_invoiced")
    private BigDecimal rowInvoiced;
    @Basic(optional = false)
    @Column(name = "base_row_invoiced")
    private BigDecimal baseRowInvoiced;
    @Column(name = "row_weight")
    private BigDecimal rowWeight;
    @Column(name = "base_tax_before_discount")
    private BigDecimal baseTaxBeforeDiscount;
    @Column(name = "tax_before_discount")
    private BigDecimal taxBeforeDiscount;
    @Column(name = "ext_order_item_id")
    private String extOrderItemId;
    @Column(name = "locked_do_invoice")
    private Short lockedDoInvoice;
    @Column(name = "locked_do_ship")
    private Short lockedDoShip;
    @Column(name = "price_incl_tax")
    private BigDecimal priceInclTax;
    @Column(name = "base_price_incl_tax")
    private BigDecimal basePriceInclTax;
    @Column(name = "row_total_incl_tax")
    private BigDecimal rowTotalInclTax;
    @Column(name = "base_row_total_incl_tax")
    private BigDecimal baseRowTotalInclTax;
    @Column(name = "hidden_tax_amount")
    private BigDecimal hiddenTaxAmount;
    @Column(name = "base_hidden_tax_amount")
    private BigDecimal baseHiddenTaxAmount;
    @Column(name = "hidden_tax_invoiced")
    private BigDecimal hiddenTaxInvoiced;
    @Column(name = "base_hidden_tax_invoiced")
    private BigDecimal baseHiddenTaxInvoiced;
    @Column(name = "hidden_tax_refunded")
    private BigDecimal hiddenTaxRefunded;
    @Column(name = "base_hidden_tax_refunded")
    private BigDecimal baseHiddenTaxRefunded;
    @Basic(optional = false)
    @Column(name = "is_nominal")
    private int isNominal;
    @Column(name = "tax_canceled")
    private BigDecimal taxCanceled;
    @Column(name = "hidden_tax_canceled")
    private BigDecimal hiddenTaxCanceled;
    @Column(name = "tax_refunded")
    private BigDecimal taxRefunded;
    @Column(name = "base_tax_refunded")
    private BigDecimal baseTaxRefunded;
    @Column(name = "discount_refunded")
    private BigDecimal discountRefunded;
    @Column(name = "base_discount_refunded")
    private BigDecimal baseDiscountRefunded;
    @Column(name = "gift_message_id")
    private Integer giftMessageId;
    @Column(name = "gift_message_available")
    private Integer giftMessageAvailable;
    @Column(name = "base_weee_tax_applied_amount")
    private BigDecimal baseWeeeTaxAppliedAmount;
    @Column(name = "base_weee_tax_applied_row_amnt")
    private BigDecimal baseWeeeTaxAppliedRowAmnt;
    @Column(name = "weee_tax_applied_amount")
    private BigDecimal weeeTaxAppliedAmount;
    @Column(name = "weee_tax_applied_row_amount")
    private BigDecimal weeeTaxAppliedRowAmount;
    @Lob
    @Column(name = "weee_tax_applied")
    private String weeeTaxApplied;
    @Column(name = "weee_tax_disposition")
    private BigDecimal weeeTaxDisposition;
    @Column(name = "weee_tax_row_disposition")
    private BigDecimal weeeTaxRowDisposition;
    @Column(name = "base_weee_tax_disposition")
    private BigDecimal baseWeeeTaxDisposition;
    @Column(name = "base_weee_tax_row_disposition")
    private BigDecimal baseWeeeTaxRowDisposition;
    @JoinColumn(name = "order_id", referencedColumnName = "entity_id")
    @ManyToOne(optional = false)
    private SalesFlatOrder orderId;
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    @ManyToOne
    private CoreStore storeId;

    public SalesFlatOrderItem() {
    }

    public SalesFlatOrderItem(Integer itemId) {
        this.itemId = itemId;
    }

    public SalesFlatOrderItem(Integer itemId, Date createdAt, Date updatedAt, short freeShipping, short noDiscount, BigDecimal price, BigDecimal basePrice, BigDecimal rowTotal, BigDecimal baseRowTotal, BigDecimal rowInvoiced, BigDecimal baseRowInvoiced, int isNominal) {
        this.itemId = itemId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.freeShipping = freeShipping;
        this.noDiscount = noDiscount;
        this.price = price;
        this.basePrice = basePrice;
        this.rowTotal = rowTotal;
        this.baseRowTotal = baseRowTotal;
        this.rowInvoiced = rowInvoiced;
        this.baseRowInvoiced = baseRowInvoiced;
        this.isNominal = isNominal;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Integer getQuoteItemId() {
        return quoteItemId;
    }

    public void setQuoteItemId(Integer quoteItemId) {
        this.quoteItemId = quoteItemId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(String productOptions) {
        this.productOptions = productOptions;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Short getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Short isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppliedRuleIds() {
        return appliedRuleIds;
    }

    public void setAppliedRuleIds(String appliedRuleIds) {
        this.appliedRuleIds = appliedRuleIds;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public short getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(short freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Short getIsQtyDecimal() {
        return isQtyDecimal;
    }

    public void setIsQtyDecimal(Short isQtyDecimal) {
        this.isQtyDecimal = isQtyDecimal;
    }

    public short getNoDiscount() {
        return noDiscount;
    }

    public void setNoDiscount(short noDiscount) {
        this.noDiscount = noDiscount;
    }

    public BigDecimal getQtyBackordered() {
        return qtyBackordered;
    }

    public void setQtyBackordered(BigDecimal qtyBackordered) {
        this.qtyBackordered = qtyBackordered;
    }

    public BigDecimal getQtyCanceled() {
        return qtyCanceled;
    }

    public void setQtyCanceled(BigDecimal qtyCanceled) {
        this.qtyCanceled = qtyCanceled;
    }

    public BigDecimal getQtyInvoiced() {
        return qtyInvoiced;
    }

    public void setQtyInvoiced(BigDecimal qtyInvoiced) {
        this.qtyInvoiced = qtyInvoiced;
    }

    public BigDecimal getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(BigDecimal qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public BigDecimal getQtyRefunded() {
        return qtyRefunded;
    }

    public void setQtyRefunded(BigDecimal qtyRefunded) {
        this.qtyRefunded = qtyRefunded;
    }

    public BigDecimal getQtyShipped() {
        return qtyShipped;
    }

    public void setQtyShipped(BigDecimal qtyShipped) {
        this.qtyShipped = qtyShipped;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getBaseOriginalPrice() {
        return baseOriginalPrice;
    }

    public void setBaseOriginalPrice(BigDecimal baseOriginalPrice) {
        this.baseOriginalPrice = baseOriginalPrice;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getBaseTaxAmount() {
        return baseTaxAmount;
    }

    public void setBaseTaxAmount(BigDecimal baseTaxAmount) {
        this.baseTaxAmount = baseTaxAmount;
    }

    public BigDecimal getTaxInvoiced() {
        return taxInvoiced;
    }

    public void setTaxInvoiced(BigDecimal taxInvoiced) {
        this.taxInvoiced = taxInvoiced;
    }

    public BigDecimal getBaseTaxInvoiced() {
        return baseTaxInvoiced;
    }

    public void setBaseTaxInvoiced(BigDecimal baseTaxInvoiced) {
        this.baseTaxInvoiced = baseTaxInvoiced;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getBaseDiscountAmount() {
        return baseDiscountAmount;
    }

    public void setBaseDiscountAmount(BigDecimal baseDiscountAmount) {
        this.baseDiscountAmount = baseDiscountAmount;
    }

    public BigDecimal getDiscountInvoiced() {
        return discountInvoiced;
    }

    public void setDiscountInvoiced(BigDecimal discountInvoiced) {
        this.discountInvoiced = discountInvoiced;
    }

    public BigDecimal getBaseDiscountInvoiced() {
        return baseDiscountInvoiced;
    }

    public void setBaseDiscountInvoiced(BigDecimal baseDiscountInvoiced) {
        this.baseDiscountInvoiced = baseDiscountInvoiced;
    }

    public BigDecimal getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(BigDecimal amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public BigDecimal getBaseAmountRefunded() {
        return baseAmountRefunded;
    }

    public void setBaseAmountRefunded(BigDecimal baseAmountRefunded) {
        this.baseAmountRefunded = baseAmountRefunded;
    }

    public BigDecimal getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(BigDecimal rowTotal) {
        this.rowTotal = rowTotal;
    }

    public BigDecimal getBaseRowTotal() {
        return baseRowTotal;
    }

    public void setBaseRowTotal(BigDecimal baseRowTotal) {
        this.baseRowTotal = baseRowTotal;
    }

    public BigDecimal getRowInvoiced() {
        return rowInvoiced;
    }

    public void setRowInvoiced(BigDecimal rowInvoiced) {
        this.rowInvoiced = rowInvoiced;
    }

    public BigDecimal getBaseRowInvoiced() {
        return baseRowInvoiced;
    }

    public void setBaseRowInvoiced(BigDecimal baseRowInvoiced) {
        this.baseRowInvoiced = baseRowInvoiced;
    }

    public BigDecimal getRowWeight() {
        return rowWeight;
    }

    public void setRowWeight(BigDecimal rowWeight) {
        this.rowWeight = rowWeight;
    }

    public BigDecimal getBaseTaxBeforeDiscount() {
        return baseTaxBeforeDiscount;
    }

    public void setBaseTaxBeforeDiscount(BigDecimal baseTaxBeforeDiscount) {
        this.baseTaxBeforeDiscount = baseTaxBeforeDiscount;
    }

    public BigDecimal getTaxBeforeDiscount() {
        return taxBeforeDiscount;
    }

    public void setTaxBeforeDiscount(BigDecimal taxBeforeDiscount) {
        this.taxBeforeDiscount = taxBeforeDiscount;
    }

    public String getExtOrderItemId() {
        return extOrderItemId;
    }

    public void setExtOrderItemId(String extOrderItemId) {
        this.extOrderItemId = extOrderItemId;
    }

    public Short getLockedDoInvoice() {
        return lockedDoInvoice;
    }

    public void setLockedDoInvoice(Short lockedDoInvoice) {
        this.lockedDoInvoice = lockedDoInvoice;
    }

    public Short getLockedDoShip() {
        return lockedDoShip;
    }

    public void setLockedDoShip(Short lockedDoShip) {
        this.lockedDoShip = lockedDoShip;
    }

    public BigDecimal getPriceInclTax() {
        return priceInclTax;
    }

    public void setPriceInclTax(BigDecimal priceInclTax) {
        this.priceInclTax = priceInclTax;
    }

    public BigDecimal getBasePriceInclTax() {
        return basePriceInclTax;
    }

    public void setBasePriceInclTax(BigDecimal basePriceInclTax) {
        this.basePriceInclTax = basePriceInclTax;
    }

    public BigDecimal getRowTotalInclTax() {
        return rowTotalInclTax;
    }

    public void setRowTotalInclTax(BigDecimal rowTotalInclTax) {
        this.rowTotalInclTax = rowTotalInclTax;
    }

    public BigDecimal getBaseRowTotalInclTax() {
        return baseRowTotalInclTax;
    }

    public void setBaseRowTotalInclTax(BigDecimal baseRowTotalInclTax) {
        this.baseRowTotalInclTax = baseRowTotalInclTax;
    }

    public BigDecimal getHiddenTaxAmount() {
        return hiddenTaxAmount;
    }

    public void setHiddenTaxAmount(BigDecimal hiddenTaxAmount) {
        this.hiddenTaxAmount = hiddenTaxAmount;
    }

    public BigDecimal getBaseHiddenTaxAmount() {
        return baseHiddenTaxAmount;
    }

    public void setBaseHiddenTaxAmount(BigDecimal baseHiddenTaxAmount) {
        this.baseHiddenTaxAmount = baseHiddenTaxAmount;
    }

    public BigDecimal getHiddenTaxInvoiced() {
        return hiddenTaxInvoiced;
    }

    public void setHiddenTaxInvoiced(BigDecimal hiddenTaxInvoiced) {
        this.hiddenTaxInvoiced = hiddenTaxInvoiced;
    }

    public BigDecimal getBaseHiddenTaxInvoiced() {
        return baseHiddenTaxInvoiced;
    }

    public void setBaseHiddenTaxInvoiced(BigDecimal baseHiddenTaxInvoiced) {
        this.baseHiddenTaxInvoiced = baseHiddenTaxInvoiced;
    }

    public BigDecimal getHiddenTaxRefunded() {
        return hiddenTaxRefunded;
    }

    public void setHiddenTaxRefunded(BigDecimal hiddenTaxRefunded) {
        this.hiddenTaxRefunded = hiddenTaxRefunded;
    }

    public BigDecimal getBaseHiddenTaxRefunded() {
        return baseHiddenTaxRefunded;
    }

    public void setBaseHiddenTaxRefunded(BigDecimal baseHiddenTaxRefunded) {
        this.baseHiddenTaxRefunded = baseHiddenTaxRefunded;
    }

    public int getIsNominal() {
        return isNominal;
    }

    public void setIsNominal(int isNominal) {
        this.isNominal = isNominal;
    }

    public BigDecimal getTaxCanceled() {
        return taxCanceled;
    }

    public void setTaxCanceled(BigDecimal taxCanceled) {
        this.taxCanceled = taxCanceled;
    }

    public BigDecimal getHiddenTaxCanceled() {
        return hiddenTaxCanceled;
    }

    public void setHiddenTaxCanceled(BigDecimal hiddenTaxCanceled) {
        this.hiddenTaxCanceled = hiddenTaxCanceled;
    }

    public BigDecimal getTaxRefunded() {
        return taxRefunded;
    }

    public void setTaxRefunded(BigDecimal taxRefunded) {
        this.taxRefunded = taxRefunded;
    }

    public BigDecimal getBaseTaxRefunded() {
        return baseTaxRefunded;
    }

    public void setBaseTaxRefunded(BigDecimal baseTaxRefunded) {
        this.baseTaxRefunded = baseTaxRefunded;
    }

    public BigDecimal getDiscountRefunded() {
        return discountRefunded;
    }

    public void setDiscountRefunded(BigDecimal discountRefunded) {
        this.discountRefunded = discountRefunded;
    }

    public BigDecimal getBaseDiscountRefunded() {
        return baseDiscountRefunded;
    }

    public void setBaseDiscountRefunded(BigDecimal baseDiscountRefunded) {
        this.baseDiscountRefunded = baseDiscountRefunded;
    }

    public Integer getGiftMessageId() {
        return giftMessageId;
    }

    public void setGiftMessageId(Integer giftMessageId) {
        this.giftMessageId = giftMessageId;
    }

    public Integer getGiftMessageAvailable() {
        return giftMessageAvailable;
    }

    public void setGiftMessageAvailable(Integer giftMessageAvailable) {
        this.giftMessageAvailable = giftMessageAvailable;
    }

    public BigDecimal getBaseWeeeTaxAppliedAmount() {
        return baseWeeeTaxAppliedAmount;
    }

    public void setBaseWeeeTaxAppliedAmount(BigDecimal baseWeeeTaxAppliedAmount) {
        this.baseWeeeTaxAppliedAmount = baseWeeeTaxAppliedAmount;
    }

    public BigDecimal getBaseWeeeTaxAppliedRowAmnt() {
        return baseWeeeTaxAppliedRowAmnt;
    }

    public void setBaseWeeeTaxAppliedRowAmnt(BigDecimal baseWeeeTaxAppliedRowAmnt) {
        this.baseWeeeTaxAppliedRowAmnt = baseWeeeTaxAppliedRowAmnt;
    }

    public BigDecimal getWeeeTaxAppliedAmount() {
        return weeeTaxAppliedAmount;
    }

    public void setWeeeTaxAppliedAmount(BigDecimal weeeTaxAppliedAmount) {
        this.weeeTaxAppliedAmount = weeeTaxAppliedAmount;
    }

    public BigDecimal getWeeeTaxAppliedRowAmount() {
        return weeeTaxAppliedRowAmount;
    }

    public void setWeeeTaxAppliedRowAmount(BigDecimal weeeTaxAppliedRowAmount) {
        this.weeeTaxAppliedRowAmount = weeeTaxAppliedRowAmount;
    }

    public String getWeeeTaxApplied() {
        return weeeTaxApplied;
    }

    public void setWeeeTaxApplied(String weeeTaxApplied) {
        this.weeeTaxApplied = weeeTaxApplied;
    }

    public BigDecimal getWeeeTaxDisposition() {
        return weeeTaxDisposition;
    }

    public void setWeeeTaxDisposition(BigDecimal weeeTaxDisposition) {
        this.weeeTaxDisposition = weeeTaxDisposition;
    }

    public BigDecimal getWeeeTaxRowDisposition() {
        return weeeTaxRowDisposition;
    }

    public void setWeeeTaxRowDisposition(BigDecimal weeeTaxRowDisposition) {
        this.weeeTaxRowDisposition = weeeTaxRowDisposition;
    }

    public BigDecimal getBaseWeeeTaxDisposition() {
        return baseWeeeTaxDisposition;
    }

    public void setBaseWeeeTaxDisposition(BigDecimal baseWeeeTaxDisposition) {
        this.baseWeeeTaxDisposition = baseWeeeTaxDisposition;
    }

    public BigDecimal getBaseWeeeTaxRowDisposition() {
        return baseWeeeTaxRowDisposition;
    }

    public void setBaseWeeeTaxRowDisposition(BigDecimal baseWeeeTaxRowDisposition) {
        this.baseWeeeTaxRowDisposition = baseWeeeTaxRowDisposition;
    }

    public SalesFlatOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(SalesFlatOrder orderId) {
        this.orderId = orderId;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesFlatOrderItem)) {
            return false;
        }
        SalesFlatOrderItem other = (SalesFlatOrderItem) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.obolon.ponovoy.entity.SalesFlatOrderItem[ itemId=" + itemId + " ]";
    }
    
}
