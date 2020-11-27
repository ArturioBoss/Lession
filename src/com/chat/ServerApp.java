package com.chat;

import com.chat.db.UserDBRepo;
import com.chat.server.ChatServer;

public class ServerApp {
    public static void main(String[] args) {
        new ChatServer(new UserDBRepo());
    }
}
