package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static final String SERVER_ADDRESS = "127.0.0.1"; // The server's IP address
    public static final int PORT = 8100; // The server's port
    public static final String CLIENT_SHUTDOWN_MESSAGE = "exit";
    public static final String SERVER_SHUTDOWN_MESSAGE = "stop";
    private boolean running = true;

    public Client() {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner keyboard = new Scanner(System.in);
            String request, response;

            while (running) {
                // read request from user
                request = keyboard.nextLine();

                if (request.equals(CLIENT_SHUTDOWN_MESSAGE) || request.equals(SERVER_SHUTDOWN_MESSAGE))
                    running = false;

                // send request to server
                out.println(request);

                // Wait the response from the server
                try {
                    response = in.readLine();
                } catch (SocketException e) {
                    response = "Connection timed out";
                    running = false;
                }
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}