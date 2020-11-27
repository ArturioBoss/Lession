package com.chat.entity;

public class User {
    private String nickname;
    private String email;
    private String password;
    private int id;

    public User(int id, String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.id = id;
    }


    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }
}
