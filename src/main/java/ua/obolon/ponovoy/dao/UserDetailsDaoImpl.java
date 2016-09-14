/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.dao;

import ua.obolon.ponovoy.impl.UserDetailsImpl;
import ua.obolon.ponovoy.inerfaces.User;
import ua.obolon.ponovoy.inerfaces.UserDetails;
import ua.obolon.ponovoy.inerfaces.dao.UserDetailsDao;

/**
 *
 * @author Alexander
 * @version 1.0
 */
public class UserDetailsDaoImpl implements UserDetailsDao{

    @Override
    public UserDetails getUserDetailsByUser(User user) {
        
        //Тут нужно вытягивать 
        //customer_address_entity {id} --> customer_address_entity_varchar {telephone, postCode, Fax, Region, Country, City, Company, DeliveryFirstName, DeliveryLastName, DeliveryMiddleName} --> 
        //--> customer_address_entity_text {Street} --> customer_address_entity_int(Region_id)
        // address = Country + City + Street   Пока что так!
        
        UserDetails result = new UserDetailsImpl();
        result.setUser(user);
        result.setAddress("Address");
        result.setCity("City");
        
        return result;
    }
    
}
