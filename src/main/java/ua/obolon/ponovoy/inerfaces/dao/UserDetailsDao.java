/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.inerfaces.dao;

import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.interfaces.UserDetails;

/**
 *
 * @author Alexander
 */
public interface UserDetailsDao {
    UserDetails getUserDetailsByUser(User user);
}
