/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.interfaces;

import java.util.List;

/**
 *
 * @author Alexander
 */
public interface UserOrders {

    List<Order> getActiveOrders(User user);

    List<Order> getAllOrders(User user);

    void setOrders(List<Order> list);
}
