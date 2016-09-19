/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.obolon.ponovoy.interfaces.Order;
import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.interfaces.UserDetails;
import ua.obolon.ponovoy.server.interfaces.DataTransfer;

/**
 *
 * @author Alexander
 */
public class DataTransferImpl implements DataTransfer {

    @Override
    public boolean sendUserToClient(User user, SocketChannel chanel) {
        if (chanel != null) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(chanel.socket().getOutputStream());

                oos.writeObject(user);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean sendUserDetailsToClient(List<Order> list, SocketChannel chanel) {
        if (chanel != null) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(chanel.socket().getOutputStream());

                oos.writeObject(list);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

}
