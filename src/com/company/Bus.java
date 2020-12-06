package com.company;

public class Bus implements Runnable{

    private final float volumeTank = 40F;
    private float tankResidue = 60F;
    private float rate = 7.5F;
    private String number;
    private FuelStation fuelStation;

    public Bus(String number, FuelStation fuelStation) {
        this.number = number;
        this.fuelStation = fuelStation;
    }

    public void go(){
        System.out.println(String.format("Автобус с гос.номером:[%s] выехал в рейс...", number));
        try {
            int mileage = 0;
            while (tankResidue > rate) {
                mileage++;
                Thread.sleep(3000);
                tankResidue -= rate;
                System.out.println(String.format("Автобус с гос.номером:[%s] проехал %sкм. остаток топлива %sл.", number, mileage, tankResidue));
            }

            System.out.println(String.format("Автобус с гос.номером:[%s] заехал на заправку с %sл. бензина", number, tankResidue));
            float refuel = fuelStation.refuel(volumeTank - tankResidue);
            if (refuel == 0F) {
                System.out.println(String.format("Автобус с гос.номером:[%s] заглох", number));
                return;
            }

            tankResidue += refuel;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        go();
    }


}
