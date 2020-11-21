package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private ArrayList arrayList = new ArrayList();
    public static void main(String[] args) {

        Object[] arrays = {1, 2, 3, 4, 5, 6, "Собака", "Кот"};


//        replaceValues(arrays,2,7);

        System.out.println(convertArray(arrays));




    }

    public static void replaceValues(Object[] arr, int key1, int key2 ) {
        Object temp = arr[key1];
        arr[key1] = arr[key2];
        arr[key2] = temp;
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }

    public static <T> ArrayList<T> convertArray(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }


}
