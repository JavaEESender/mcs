/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.magento.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import ua.obolon.ponovoy.magento.entity.SalesFlatOrderAddress;
import ua.obolon.ponovoy.magento.entity.SalesFlatOrderItem;
import ua.obolon.ponovoy.magento.entity.SalesFlatOrderPayment;
import ua.obolon.ponovoy.impl.OrderImpl;
import ua.obolon.ponovoy.interfaces.Order;
import ua.obolon.ponovoy.inerfaces.dao.SalesDao;
import ua.obolon.ponovoy.res.ProductArt;

/**
 * @version 1.0
 * @author Alexander
 */
public class SalesDaoImpl extends JPA implements SalesDao {

    
    
    /**
    *@param telephone telephone number who is calling
    * 
    * @author Alexander
    */
    @Override
    public List<Order> getOrdersByTelephone(String telephone) {
       
        EntityManager manager = getManager();
        List<Order> list = new ArrayList<>();
        try {
            List<SalesFlatOrderAddress> salesFlatOrderAddress = (List) manager.createQuery("SELECT s FROM SalesFlatOrderAddress s WHERE s.telephone = :telephone AND s.addressType = :addressType")
                    .setParameter("telephone", telephone).setParameter("addressType", "shipping").getResultList();
            salesFlatOrderAddress.forEach((s) -> {
                Order tmp = new OrderImpl();
                tmp.setFirstName(s.getFirstname()).setLastName(s.getLastname()).setEmail(s.getEmail()).
                        setAddress(s.getPostcode() + ", " + s.getCity() + ", " + s.getStreet()).setTelephone(telephone).
                        setTotal(s.getParentId().getGrandTotal().doubleValue()).setStatus(s.getParentId().getStatus()).
                        setShipPrice(s.getParentId().getBaseShippingAmount().doubleValue());
                SalesFlatOrderPayment salesFlatOrderPayment = (SalesFlatOrderPayment) manager.createQuery("SELECT s FROM SalesFlatOrderPayment s WHERE s.parentId = :parentId")
                    .setParameter("parentId", s.getParentId()).getSingleResult();
                tmp.setPaymentType(salesFlatOrderPayment.getMethod()).setOrderDate(s.getParentId().getCreatedAt()).setId(s.getParentId().getEntityId()).
                        setShipMethod(s.getParentId().getShippingDescription()).setOrderID(s.getParentId().getIncrementId());
                
                List<SalesFlatOrderItem> items = (List<SalesFlatOrderItem>) manager.createQuery("SELECT s FROM SalesFlatOrderItem s WHERE s.orderId = :order_id")
                    .setParameter("order_id", s.getParentId()).getResultList();

                List<Map<ProductArt,String>> listItem = new ArrayList();
                items.forEach((i) -> {
                    Map<ProductArt,String> map = new HashMap<>();
                    map.put(ProductArt.NAME, i.getName());
                    map.put(ProductArt.SKU, i.getSku());
                    map.put(ProductArt.WEIGHT, i.getWeight().toString());
                    map.put(ProductArt.TOTAL, i.getPrice().toString());
                    listItem.add(map);
                });
                
                tmp.setProducts(listItem);
                
                list.add(tmp);
            });
            return list;
        } catch (Exception ex) {
            return null;
        } finally {
            manager.close();
        }
    }

}
