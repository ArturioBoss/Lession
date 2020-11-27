package com.chat.server;

import com.chat.auth.AuthenticationService;
import com.chat.users.UserService;

public interface Server {
    void broadcastMessage(String message);
    void broadcastPrivateMessage(ClientHandler client, String s, String message);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    AuthenticationService getAuthenticationService();
    UserService getUserService();

}
