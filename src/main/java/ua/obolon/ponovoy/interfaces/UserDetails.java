/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.interfaces;

/**
 *
 * @author Alexander
 * @param <User> 
 */
public interface UserDetails {
    
    String getAddress();
    String getCity();
    void setUser(User user);
    User getUser();
    void setCity(String city);
    void setAddress(String address);
    UserOrders getUserOrders();
    void SetUserOrders(UserOrders userorders);
    
    
}
