/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.inerfaces.dao;

import java.util.List;
import ua.obolon.ponovoy.interfaces.Order;

/**
 *
 * @author Alexander
 */
public interface SalesDao {
    List<Order> getOrdersByTelephone(String telephone);
 
}
