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
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.obolon.ponovoy.local.dao.ManagersJPA;
import ua.obolon.ponovoy.res.RequestKey;

/**
 *
 * @author Alexander
 */
public class Client implements Runnable {

    private SocketChannel clientSocket;
    private Check c;

    public Client(SocketChannel s, Check c) {
        this.clientSocket = s;
        this.c = c;
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
                        c.callPhone(username + "@" + password, telephone);
                    } else {
                    }
                    break;
                }
                case NEW_LOGIN: {
                    String username = (String) ois.readObject();
                    String password = (String) ois.readObject();
                    ManagersJPA mjpa = new ManagersJPA();
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.socket().getOutputStream());
                    if (mjpa.getLogin(username, password)) {
                        oos.writeObject("true");
                        c.addClient(username + "@" + password, clientSocket);
                    } else {
                        oos.writeObject("false");
                    }
                    break;
                }
                case GET_ORDERS: {
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
