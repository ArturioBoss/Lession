package com.company;

import java.util.Map;

public class NumConverter {
    private static final Map<Integer, String> arabicNumbers;

    static {
        arabicNumbers = Map.of(
                1, "I",
                2, "V",
                3, "X"
        );
    }

    public String toRoman(int number) {
        StringBuilder sb = new StringBuilder();
        if (number <= 3){
            for (int i = 0; i < number ; i++) {
                sb.append(arabicNumbers.get(1));
            }
            return sb.toString();
        } else if (number <= 8){
            for (int i = 4; i <= number; i++) {
                if (number < 5){
                    sb.append(arabicNumbers.get(1));
                    sb.append(arabicNumbers.get(2));
                    return sb.toString();
                }else if (number > 5 ){
                    sb.append(arabicNumbers.get(2));
                    for (int j = 0; j < number - 5; j++) {
                        sb.append(arabicNumbers.get(1));
                    }
                    return sb.toString();
                }else {
                    sb.append(arabicNumbers.get(2));
                    return sb.toString();
                }
            }
            return sb.toString();
//            return sb.append(arabicNumbers.get(2));

        }else if (number <= 10){
            if (number == 10){
                sb.append(arabicNumbers.get(3));
                return sb.toString();
            }
            sb.append(arabicNumbers.get(1));
            sb.append(arabicNumbers.get(3));
            return sb.toString();
        }
        // 0 <= N <= 3 - I II III
        // 4 <= N <= 8 - IV V VI VII VIII

        return "";
    }
}
