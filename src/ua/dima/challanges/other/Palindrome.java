package ua.dima.challanges.other;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {
        List<String> a1 = new ArrayList<>();
        a1.add("a");
        a1.add("b");
        a1.add("c");
        List<String> a2 = new ArrayList<>();
        a2.add("a");
        a2.add("b");
        a2.add("b");


    }

    public static boolean isPalindrome(String inputText) {

        char first;
        char last;

        for (int i = 0; i < inputText.length(); i++) {
            first = inputText.charAt(i);
            last = inputText.charAt(inputText.length() - i - 1);
            if (first != last) {
                return false;

            }
        }
        return true;

    }

    public static boolean isPalindrome2(String inputText) {

        for (int i = 0; i < inputText.length() / 2; i++) {
            if (inputText.charAt(i) != inputText.charAt(inputText.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }


    public static boolean isPalindrome3(String inputText) {

        char[] chars = inputText.toCharArray();

        for (int i = 0; i < inputText.length() / 2; i++) {
            if (chars[i] != chars[inputText.length() - i - 1]) {
                return false;
            }
        }
        return true;
    }

    static List<String> collect(List<String> strings1, List<String> strings2) {

        strings1.addAll(strings2);
        List<String> result = new ArrayList<>();

        strings1.forEach(s -> {
            if(!result.contains(s)) result.add(s);
        });

        return result;
    }


}
