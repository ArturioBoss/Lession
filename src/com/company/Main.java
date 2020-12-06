package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <4 ; i++) {
            executorService.submit(new Car("CC "+namber()+"_99RUS", fuelStation));
            executorService.submit(new Truck("TT "+namber()+"_99RUS", fuelStation));
            executorService.submit(new Bus("BB "+namber()+"_99RUS", fuelStation));
        }

        executorService.shutdown();
    }

    private static int namber(){
        int i = (int) (Math.floor(Math.random() * (999 - 1)) + 1);
        return i;
    }

}
