package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> storage;

    public Box(T... fr) {
        this.storage = new ArrayList<>(Arrays.asList(fr));
    }

    public float getWeight() {

        if (storage.size() ==0){
            return 0.0f;
        }
        float startWeight = 0.0f;
        for (int i = 0; i <storage.size() ; i++) {
            startWeight += storage.get(i).getWeight();
        }
        return startWeight;
    }

    public boolean compare(Box<?> a){
        return (this.getWeight() - a.getWeight()) < 0.001f;
    }

    public void pourOver(Box<? super T> a){
        a.storage.addAll(this.storage);
        a.storage.clear();

    }

    public void addFruit(T fruit){
        storage.add(fruit);
    }
}
