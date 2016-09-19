/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.impl;

import java.util.Objects;
import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.interfaces.UserDetails;
import ua.obolon.ponovoy.interfaces.UserOrders;

/**
 * @version 1.0
 * @author Timur xaxaxa
 */
public class UserDetailsImpl implements UserDetails{
    
    private User user;
    private String address;
    private String city;
    private UserOrders userOrders;

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public UserOrders getUserOrders() {
        return userOrders;
    }

    @Override
    public void SetUserOrders(UserOrders userorders) {
        this.userOrders = userorders;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDetailsImpl other = (UserDetailsImpl) obj;
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    
    
    
}
