/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.inerfaces.dao;

import ua.obolon.ponovoy.inerfaces.User;

/**
 *
 * @author Alexander
 */
public interface UserDao {
 
    User getUserByTelephone(String telephone);
    
}
