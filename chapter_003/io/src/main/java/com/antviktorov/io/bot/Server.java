package com.antviktorov.io.bot;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Server socket.
 * @author antonviktorov
 * @since 1.0.
 */
public class Server {
    /**
     * Port number.
     */
    int port;
    /**
     * Dictionary.
     */
    Dictionary dictionary;

    /**
     * Server constructor.
     */
    public Server() {
        this.port = 8080;
        this.dictionary = new Dictionary();
    }

    /**
     * Starting server.
     */
    public void start() {
        try {
            Socket socket =  new ServerSocket(this.port).accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask = "";
            this.dictionary.init();
            do {
                System.out.println("Wait command ...");
                ask = in.readLine();
                System.out.println(ask);

                String response = this.dictionary.getResponse(ask);

                if (response != null) {
                    out.println(response);
                }
            } while (!"exit".equals(ask));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Console function.
     * @param params - console params
     */
    public static void main(String[] params) {
        Server server = new Server();
        server.start();
    }
}
