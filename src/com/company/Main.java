package com.company;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        MyWindow myWindow = new MyWindow();

//        doValue();
//        doConvertArabic();


    }

    private static void doConvertArabic() {
        NumConverter converter = new NumConverter();
        String romanFour = converter.toRoman(3);
        System.out.println(romanFour);
        String thrity = converter.toRoman(9);
        System.out.println(thrity);
    }

    static void doValue() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("1", 1);
        map.put("2", 10);
        map.put("3", 34);
        map.put("4", -1);
        map.put("5", 5678);

        Comparator comparator = (Comparator) new ValueComparator(map);
        Map<String, Integer> valueSortedMap = new TreeMap<>(comparator);
        valueSortedMap.putAll(map);
        System.out.println(valueSortedMap);
    }
}
