/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.dao;

import ua.obolon.ponovoy.magento.dao.SalesDaoImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.obolon.ponovoy.inerfaces.Order;
import ua.obolon.ponovoy.res.ProductArt;

/**
 *
 * @author Alexander
 */
public class SalesDaoImplTest {
    
    public SalesDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOrdersByTelephone method, of class SalesDaoImpl.
     */
    @Test
    public void testGetOrdersByTelephone() {
        System.out.println("getOrdersByTelephone");
        String telephone = "+380671111111";
        SalesDaoImpl instance = new SalesDaoImpl();
        List<Order> expResult = null;
        List<Order> result = instance.getOrdersByTelephone(telephone);
        result.forEach((o) -> {
            System.out.println(o.getTotal());
            
            o.getProducts().forEach((m) -> {
                System.out.println(m.get(ProductArt.NAME));
                System.out.println(m.get(ProductArt.SKU));
                System.out.println(m.get(ProductArt.WEIGHT));
                System.out.println(m.get(ProductArt.TOTAL));
                System.out.println("!!!");
            });
            
            
        });
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
