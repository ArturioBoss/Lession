package com.company;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
    private final Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }
    @Override
    public int compare(String o1, String o2) {
        return map.get(o1) - map.get(o2);
    }
}
