package com.company;

public class Main {
    public static void main(String[] args) {
        PrintText printText = new PrintText();
        Thread t1 = new Thread(() -> {
            printText.print("A",5);
        });
        Thread t2 = new Thread(() -> {
            printText.print("B",5);
        });
        Thread t3 = new Thread(() -> {
            printText.print("C",5);
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
