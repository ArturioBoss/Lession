package com.chat.server;

import com.chat.entity.User;

public interface ManagerDatabase {
        User findUserByEmailAndPassword(String email, String password);

        void updateUsername(String email, String newName);
}
