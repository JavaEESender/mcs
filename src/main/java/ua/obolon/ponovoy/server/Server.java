/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author Alexander
 */
public final class Server implements Runnable {

    private final String serverIP;
    private final int port;
    private ServerSocketChannel serverSocket = null;
    private boolean isRun = true;
    private final Check c;

    public Server(String serverIP, int port) {
        this.serverIP = serverIP;
        this.port = port;
        this.c = new Check();
    }

    @Override
    public void run() {
        try {
            serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress("10.0.74.100", 7878));
            
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.port, e);
        }
        while (this.isRun) {
            SocketChannel clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if (!this.isRun) {
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            new Thread(
                    new Client(clientSocket, c)
            ).start();
        }
    }

    public void stopServer() {
        this.isRun = false;
    }

}
