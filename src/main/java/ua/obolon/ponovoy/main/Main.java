/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.obolon.ponovoy.main;

import ua.obolon.ponovoy.server.Server;

/**
 *
 * @author Alexander
 */
public class Main {

    private static String serverIP;
    private static int port;

    public static void main(String[] args) {

//        serverIP = args[0];
//        port = Integer.parseInt(args[1]);

        Server srv = new Server("10.0.74.100", 7878);
        new Thread(srv).start();
    }
}
