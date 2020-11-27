package com.chat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private DBService() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.54:3306/Chat?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8",
                    "test",
                    "01041984"
            );
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW не удалось подключиться к БД", throwables);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW не удалось разорвать соединение", throwables);
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException("SWW в процессе отката", e);
        }
    }

}
