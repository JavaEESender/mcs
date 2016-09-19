/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.obolon.ponovoy.inerfaces.Call;
import ua.obolon.ponovoy.inerfaces.Order;
import ua.obolon.ponovoy.inerfaces.dao.SalesDao;
import ua.obolon.ponovoy.local.dao.CallsJPA;
import ua.obolon.ponovoy.local.dao.ManagersJPA;
import ua.obolon.ponovoy.magento.dao.SalesDaoImpl;
import ua.obolon.ponovoy.res.RequestKey;
import ua.obolon.ponovoy.server.interfaces.DataTransfer;

/**
 *
 * @author Alexander
 */
public class Client implements Runnable {

    private SocketChannel clientSocket;
    private DataTransfer transfer;
    private ChanelHolder holder;

    public Client(SocketChannel s, ChanelHolder c) {
        this.clientSocket = s;
        this.holder = c;
        this.transfer = new DataTransferImpl();
    }

    @Override
    public void run() {

        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.socket().getInputStream());

            RequestKey sw = (RequestKey) ois.readObject();
            switch (sw) {
                case CALL_ANDROID: {
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();
                    String telephone = (String) ois.readObject();
                    clientSocket.close();
                    ManagersJPA mjpa = new ManagersJPA();
                    if (mjpa.getLogin(username, password)) {
                        holder.sendCall(username + "@" + password, telephone);
                    } else {
                    }
                    break;
                }
                case MISSED_CALLS: {
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();
                    List<Call> list = (List<Call>) ois.readObject();
                    clientSocket.close();
                    CallsJPA log_call = new CallsJPA();
                    log_call.refresh();
                    list.forEach((Call c) -> {
                        log_call.setNewCall(username + "@" + password, c.getNumber(), new Date(c.getDate()));
                        System.out.println(c.getNumber());
                    });
                    break;
                }
                case NEW_LOGIN: {
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();
                    ManagersJPA mjpa = new ManagersJPA();
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.socket().getOutputStream());
                    if (mjpa.getLogin(username, password)) {
                        oos.writeObject("true");
                        holder.loginClient(username + "@" + password, clientSocket);
                    } else {
                        oos.writeObject("false");
                    }
                    break;
                }
                case GET_ORDERS: {
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();
                    String telephone = (String) ois.readObject();
                    SalesDao salesDao = new SalesDaoImpl();
                    List<Order> orders = salesDao.getOrdersByTelephone(telephone);

                    if (orders != null) {
                        transfer.sendUserDetailsToClient(orders, clientSocket);
                        clientSocket.close();
                    } else {
                        //TODO empty
                        clientSocket.close();
                    }

                    break;
                }
                default: {
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
