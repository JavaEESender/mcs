/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server.interfaces;

import java.nio.channels.SocketChannel;
import java.util.List;
import ua.obolon.ponovoy.inerfaces.Order;
import ua.obolon.ponovoy.inerfaces.User;

/**
 *
 * @author Alexander
 */
public interface DataTransfer {
    
   boolean sendUserToClient(User user, SocketChannel chanel);
   boolean sendUserDetailsToClient(List<Order> list, SocketChannel chanel);
    
}
