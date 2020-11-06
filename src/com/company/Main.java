package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        goOneStream(10000000);
        goTwoStream(10000000);

    }

    private static void goOneStream(int size) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(String.format("Прошло времени на одном потоке: %s ms",System.currentTimeMillis()-startTime));

    }
    /*
    Макс, привет! Добавил в метод с двумя потоками корректировку в виде значения correct в формуле.
    Просто посидел, покурил и подумал, что будет считать не верно по времени т.к.
    если взять к примеру массив[10] разьеденить его и потом склеить то индексы будут 0123401234,
    а не 0123456789 (следовательно будут расчёты не верны) как в начальном виде массива.
    Может и не верно я подумал, хотел бы чтоб ты завтра подробнее на этом остановился.
    */

    private static void goTwoStream(int size) {
        final int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Thread oneThread = new Thread(() -> {
            for (int i = 0; i <arr1.length ; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread twoThread = new Thread(() ->{
            int correct;
            for (int i = 0; i <arr2.length ; i++) {
                correct = i + h;
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + correct / 5) * Math.cos(0.2f + correct / 5) * Math.cos(0.4f + correct / 2));
            }
        });
        oneThread.start();
        twoThread.start();
        try {
            oneThread.join();
            twoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println(String.format("Прошло времени в два потока: %s ms",System.currentTimeMillis()-startTime));

    }
}
