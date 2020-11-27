package com.chat.auth;

import com.chat.entity.User;
import com.chat.server.ManagerDatabase;

import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {
    private ManagerDatabase managerDatabase;

    public BasicAuthenticationService(ManagerDatabase managerDatabase) {
        this.managerDatabase = managerDatabase;
    }

    @Override
    public Optional<User> doAuth(String email, String password) {
        User user = managerDatabase.findUserByEmailAndPassword(email, password);
        if (user != null) {
            if (user.getPassword().equals(password)) return Optional.of(user);
        }
        return Optional.empty();
    }
}
