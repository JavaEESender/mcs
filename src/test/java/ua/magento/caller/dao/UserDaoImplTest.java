/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.magento.caller.dao;

import ua.magento.caller.magento.dao.UserDaoImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.magento.caller.impl.UserImpl;
import ua.magento.caller.interfaces.User;

/**
 *
 * @author Alexander
 */
public class UserDaoImplTest {

    public UserDaoImplTest() {
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
     * Test of getUserByTelephone method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserByTelephone() {
        System.out.println("Test_getUserByTelephone");
        String telephone = "";
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.getUserByTelephone("+380671111111");
        User tst = new UserImpl();
        tst.setId(11);
        System.out.println(result.getFirstName() + "   " + result.getLastName() + "   " + result.getId());
//        assertEquals(tst, result);
    }

}
