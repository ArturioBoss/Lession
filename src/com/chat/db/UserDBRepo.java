package com.chat.db;

import com.chat.entity.User;
import com.chat.io.Log;
import com.chat.server.ManagerDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBRepo implements ManagerDatabase {
    public UserDBRepo(){

    }

    public User findUserByEmailAndPassword(String email, String password) {
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("nickname"),
                        result.getString("email"),
                        result.getString("password")

                );
            }

            return null;
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW ошибка выборки пользователя", throwables);
        } finally {
            DBService.close(connection);
        }
    }

    @Override
    public void updateUsername(String email, String newName) {
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE users set Name = ? WHERE email = ?"
            );
            statement.setString(1, newName);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            DBService.rollback(connection);
            throw new RuntimeException("SWW не удалось изменить ник", e);
        } finally {
            DBService.close(connection);
        }
    }
}
