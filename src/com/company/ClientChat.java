package com.company;

import java.io.IOException;
import java.net.Socket;

public class ClientChat {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 4546;

    public ClientChat() {
        try {
            Socket sock = new Socket(SERVER_ADDR, SERVER_PORT);
            if (sock.isConnected()) System.out.println("Успешное подключение к серверу");
            new Client(sock, "Сообщение от клиента");
            while(true){
                if(sock.isClosed()){
                    break;
                }
            }
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Ошибка подключения к серверу");
        }
    }

    public static void main(String[] args) {
        new ClientChat();
    }
}
