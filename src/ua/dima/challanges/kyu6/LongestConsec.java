package ua.dima.challanges.kyu6;

/*
You are given an array(list) strarr of strings and an integer k.
Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 */

public class LongestConsec {

    public static void main(String[] args) {

        String s = longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2);
        System.out.println(s);
        // abigailtheta
    }


    public static String longestConsec(String[] strarr, int k) {

        if (k <= 0) return "";
        if (strarr.length - k + 1 <= 0) return "";

        String[] strings = new String[strarr.length - k + 1];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = "";
            for (int j = i; j < i + k; j++) {
                strings[i] += strarr[j];
            }
        }

        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[index].length() < strings[i].length()) {
                index = i;
            }
        }
        return strings[index];
    }

}
