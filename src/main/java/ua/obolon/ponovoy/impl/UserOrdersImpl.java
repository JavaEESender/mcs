/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.impl;

import java.util.List;
import ua.obolon.ponovoy.interfaces.Order;
import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.interfaces.UserOrders;

/**
 *
 * @author Alexander
 */
public class UserOrdersImpl implements UserOrders{

    @Override
    public List<Order> getActiveOrders(User user) {
        //TODO .....
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrders(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOrders(List<Order> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
