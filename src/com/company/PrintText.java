package com.company;

public class PrintText {
    private final Object objectThread = new Object();
    private String currentText = "A";

    public void print(String text, int count){
        synchronized (objectThread){
            try {
                for (int i = 0; i < count; i++) {
                    while (!text.equals(currentText)) {
                        objectThread.wait(1000);
                    }
                    System.out.print(text);
                    currentText = replacecurrentText(text);
                    objectThread.notify();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private String replacecurrentText(String text){
        switch (text) {
            case "A":
                return currentText = "B";
            case "B":
                return currentText = "C";
            case "C":
                return currentText = "A";
        }
        return null;
    }
}
