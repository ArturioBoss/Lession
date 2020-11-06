package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyWindow extends JFrame {
    JButton buttonSend = new JButton("Отправить");
    JTextArea textMessage = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(textMessage);
    JTextField textSendMessage = new JTextField();
    public MyWindow(){
        setTitle("Супер Аська");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel[] jPanels = new JPanel[2];
        for (int i = 0; i <2 ; i++) {
            jPanels[i] = new JPanel(new GridLayout());
        }

        jPanels[0].add(jScrollPane);
        jPanels[1].add(textSendMessage);
        jPanels[1].add(buttonSend);

        add(jPanels[0]);
        add("South", jPanels[1]);

        buttonSend.addActionListener(e -> {
            sendMessage();
        });
        textSendMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });


        setVisible(true);

    }

     private void sendMessage() {
        String out = textSendMessage.getText();
         textMessage.append("Сообщение: " + out + "\n");
         textSendMessage.setText("");
         textSendMessage.grabFocus();
    }
}
