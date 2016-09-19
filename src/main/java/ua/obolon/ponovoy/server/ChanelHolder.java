/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server;

import java.nio.channels.SocketChannel;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua.obolon.ponovoy.magento.dao.UserDaoImpl;
import ua.obolon.ponovoy.impl.UserImpl;
import ua.obolon.ponovoy.interfaces.Order;
import ua.obolon.ponovoy.interfaces.User;
import ua.obolon.ponovoy.server.interfaces.DataTransfer;
import ua.obolon.ponovoy.local.dao.CallsJPA;

/**
 *
 * @author Alexander
 */
public class ChanelHolder {

    private Map chanels;
    DataTransfer transfer;

    public ChanelHolder() {
        this.chanels = new HashMap<String, SocketChannel>();
        this.transfer = new DataTransferImpl();
    }

    public void sendCall(String pass, String phone) {
        CallsJPA log_call = new CallsJPA();
        log_call.refresh();
        log_call.setNewCall(pass, phone, new GregorianCalendar().getTime());
        User user = new UserDaoImpl().getUserByTelephone(phone);

        if (user != null) {
            SocketChannel tm = (SocketChannel) chanels.get(pass);
            transfer.sendUserToClient(user, tm);
        } else {
            SocketChannel tm = (SocketChannel) chanels.get(pass);
            User guest = new UserImpl();
            guest.setId(0);
            guest.setTelephone(phone);
            guest.setFirstName("unknown");
            guest.setLastName("unknown");
            transfer.sendUserToClient(guest, tm);
        }
    }

    public boolean sendOrders(List<Order> list, String pass, SocketChannel channel) {
        if (list != null) {
            transfer.sendUserDetailsToClient(list, channel);
            return true;
        } else {
            return false;
        }
    }

    public void loginClient(String pass, SocketChannel s) {
        if (chanels.get(pass) != null) {
            chanels.put(pass, s);
        } else {
            chanels.remove(pass);
            chanels.put(pass, s);
        }
    }
}
