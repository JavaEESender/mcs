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
import ua.obolon.ponovoy.magento.dao.UserDaoImpl;
import ua.obolon.ponovoy.impl.UserImpl;
import ua.obolon.ponovoy.inerfaces.User;
import ua.obolon.ponovoy.server.interfaces.DataTransfer;
import ua.obolon.ponovoy.local.dao.CallsJPA;

/**
 *
 * @author Alexander
 */
public class Check {

    private Map m;
    DataTransfer transfer;

    public Check() {
        this.m = new HashMap<String, SocketChannel>();
        this.transfer = new DataTransferImpl();
    }

    public void callPhone(String pass, String phone) {
        CallsJPA call = new CallsJPA();
        call.refresh();
        call.setNewCall(pass, phone);
        User user = new UserDaoImpl().getUserByTelephone(phone);

        if (user != null) {
            SocketChannel tm = (SocketChannel) m.get(pass);
            transfer.sendUserToClient(user, tm);
        } else {
            SocketChannel tm = (SocketChannel) m.get(pass);
            User guest = new UserImpl();
            guest.setId(0);
            guest.setTelephone(phone);
            guest.setFirstName("unknown");
            guest.setLastName("unknown");
            transfer.sendUserToClient(guest, tm);
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
