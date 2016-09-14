/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.interfaces.server;

import ua.obolon.ponovoy.inerfaces.User;
import ua.obolon.ponovoy.inerfaces.UserDetails;

/**
 *
 * @author Alexander
 */
public interface DataTransfer {
    
   boolean sendUserToClient(User user);
   boolean sendUserDetailsToClient(UserDetails userDetails);
    
}
