package ua.dima.challanges.kyu7;

/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive.
Implement a function that determines whether a string that contains only letters is an isogram.
Assume the empty string is an isogram. Ignore letter case.
 */

public class Isogram {
    public static boolean isIsogram(String str) {

        char[] chars = str.toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if(chars[i] == chars[j] && i != j){
                    return false;
                }
            }
        }
    return true;
    }

}
