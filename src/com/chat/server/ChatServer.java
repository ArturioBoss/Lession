package com.chat.server;

import com.chat.auth.AuthenticationService;
import com.chat.auth.BasicAuthenticationService;
import com.chat.users.UserService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private Set<ClientHandler> clients;
    private BasicAuthenticationService authenticationService;
    private UserService userService;

    public ChatServer(ManagerDatabase databaseService) {
        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(8990);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService(databaseService);
            userService = new UserService(databaseService);
            System.out.println("Server is started up...");

            while (true) {
                System.out.println("Server is listening for clients...");
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public synchronized void broadcastMessage(String message) {
        clients.forEach(client -> client.sendMessage(message));
    }


    public void broadcastPrivateMessage(ClientHandler sender, String recipientNickname, String message) {
        for ( ClientHandler client : clients){
            if (client.getName().equals(recipientNickname)){
                client.sendMessage("От "+sender.getName()+": "+message);
                sender.sendMessage("Вы отправили "+recipientNickname+ " сообщение:"+message);
                return;
            }
        }
        sender.sendMessage(recipientNickname+ "не в сети.");

    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        return clients.stream()
                .anyMatch(clientHandler -> clientHandler.getName().equals(nickname));
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
    @Override
    public UserService getUserService() {
        return userService;
    }
}
