package com.chat.users;

import com.chat.entity.User;
import com.chat.server.ManagerDatabase;

public class UserService implements UserManager {
    private ManagerDatabase managerDatabase;

    public UserService(ManagerDatabase managerDatabase) {
        this.managerDatabase = managerDatabase;
    }

    @Override
    public void changeName(User user, String newName) {
        System.out.println(user.getEmail()+" l "+ newName);
        managerDatabase.updateUsername(user.getEmail(), newName);
    }
}