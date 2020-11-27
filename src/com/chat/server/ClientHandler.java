package com.chat.server;

import com.chat.entity.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private User user;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            doListen();
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public String getName() {
        return name;
    }


    private void doListen() {
        new Thread(() -> {
            try {
                doAuth();
                receiveMessage();
            } catch (Exception e) {
                throw new RuntimeException("SWW", e);
            } finally {
                server.unsubscribe(this);
            }
        }).start();

    }

    private void doAuth() {
        try {
            while (true) {
                String credentials = in.readUTF();
                /**
                 * Input credentials sample
                 * "-auth n1@mail.com 1"
                 */
                if (credentials.startsWith("-auth")) {
                    /**
                     * After splitting sample
                     * array of ["-auth", "n1@mail.com", "1"] -auth n1@mail.com 1
                     */
                    String[] credentialValues = credentials.split("\\s");
                    server.getAuthenticationService()

                            .doAuth(credentialValues[1], credentialValues[2])
                            .ifPresentOrElse(
                                    user -> {
                                        if (!server.isLoggedIn(user.getNickname())) {
                                            sendMessage("cmd auth: Status OK");
                                            name = user.getNickname();
                                            server.broadcastMessage(name + " is logged in.");
                                            server.subscribe(this);
                                        } else {
                                            sendMessage("Текущий пользователь уже вошёл в систему..");
                                        }
                                    },
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            sendMessage("No a such user by email and password.");
                                        }
                                    }
                            );

                }

                if (credentials.startsWith("-setNik ")) {
                    String[] credentialValues = credentials.split("\\s");
                    server.getUserService()
                        .changeName(user,credentialValues[1]);
//                        .user.setNickname(credentialValues[1]);


                    
                }
                
                if (credentials.startsWith("/w ")) {
                    String[] credentialValues = credentials.split(" ",3);
                    server.broadcastPrivateMessage(this, credentialValues[1],credentialValues[2]);
                    continue;

                }
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    /**
     * Receives input data from {@link ClientHandler#in} and then broadcast via {@link Server#broadcastMessage(String)}
     */
    private void receiveMessage() {
        try {
            while (true) {
                String message = in.readUTF();
                if (message.equals("-exit")) {
                    return;
                }
                server.broadcastMessage(message);
            }
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(server, that.server) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, name);
    }

    public void exitTimer(){
        TimerTask task = new TimerTask() {
            public void run() {
                //TODO: stop the thread here

            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(task, 1000, 1000);

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
