/**********************************************
 Workshop #
 Course: JAC444
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 12-9-2021
 **********************************************/

package task1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>(); // Store multiple clients
    private Socket socket; // get socket passed from server
    private BufferedReader bufferedReader; // read data
    private BufferedWriter bufferedWriter; // send data
    private String clientUserName;

    public ClientHandler(Socket socket) {
       try {
           this.socket = socket; // get socket from server
           this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           this.clientUserName = bufferedReader.readLine(); // read username
           clientHandlers.add(this); // add client into array
           broadcastMessage("SERVER: " + clientUserName + " has entered the chat");
       } catch (IOException e) {
           closeEverything(socket, bufferedReader, bufferedWriter);
       }
    }

    public void broadcastMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.clientUserName.equals(clientUserName)) {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUserName + " left the chat.");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
}
