/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.obolon.ponovoy.dao.UserDaoImpl;
import ua.obolon.ponovoy.inerfaces.User;
import ua.obolon.ponovoy.local.dao.CallsJPA;

/**
 *
 * @author Alexander
 */
public class Check {

    private Map m;

    public Check() {
        this.m = new HashMap<String, SocketChannel>();
    }

    public void callPhone(String pass, String phone) {
        CallsJPA call = new CallsJPA();
        call.refresh();
        call.setNewCall(pass, phone);
        User user = new UserDaoImpl().getUserByTelephone(phone);

        if (user != null) {

            SocketChannel tm = (SocketChannel) m.get(pass);
            if (tm != null) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(tm.socket().getOutputStream());

                    oos.writeObject(user);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            SocketChannel tm = (SocketChannel) m.get(pass);
            if (tm != null) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(tm.socket().getOutputStream());
                    user.setTelephone(phone);
                    user.setFirstName("?");
                    user.setLastName("?");
                    oos.writeObject(user);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void addClient(String pass, SocketChannel s) {
        if (m.get(pass) != null) {
            m.put(pass, s);
        } else {
            m.remove(pass);
            m.put(pass, s);
        }
    }

}
