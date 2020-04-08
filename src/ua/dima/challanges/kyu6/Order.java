package ua.dima.challanges.kyu6;


/*
Your task is to sort a given string. Each word in the string will contain a single number.
This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string.
The words in the input String will only contain valid consecutive numbers.
 */

import java.util.HashMap;
import java.util.Map;

public class Order {

    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }

    public static String order(String words) {

        String[] arr = words.split(" ");
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (tryParse(chars[j])) {
                    map.put(Integer.parseInt(chars[j] + ""), arr[i]);
                }
            }
        }

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> map.put(x.getKey(), x.getValue()));

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < map.size() + 1; i++) {
            s.append(map.get(i) + " ");
        }
        return s.toString().trim();

    }

    private static boolean tryParse(char aChar) {

        try {
            Integer.parseInt(aChar + "");
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}