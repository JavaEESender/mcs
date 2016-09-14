/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server.interfaces;

import java.nio.channels.SocketChannel;
import ua.obolon.ponovoy.inerfaces.User;
import ua.obolon.ponovoy.inerfaces.UserDetails;

/**
 *
 * @author Alexander
 */
public interface DataTransfer {
    
   boolean sendUserToClient(User user, SocketChannel chanel);
   boolean sendUserDetailsToClient(UserDetails userDetails);
    
}
