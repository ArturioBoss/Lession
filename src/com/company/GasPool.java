package com.company;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final float volumeGasTank = 200F;
    private float sizeResidue = 200F;

    public float request(float amount) {
        lock.writeLock().lock();
        try {
            if (amount > sizeResidue) {
                return 0F;
            }
            Thread.sleep(5000);
            sizeResidue -= amount;
            return amount;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return 0F;
    }

    @Override
    public String toString() {
        return "Объём заправки:" + volumeGasTank +
                ", Осталось топлива:" + sizeResidue;
    }
}
