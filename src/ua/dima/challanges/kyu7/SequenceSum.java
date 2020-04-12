package ua.dima.challanges.kyu7;

/*
We want to generate a function that computes the series starting from 0 and ending until the given number.
 */

public class SequenceSum {

    public static String showSequence(int value) {
        if(value == 0) return "0=0";
        if(value < 0) return value+"<0";
        int res = 0;
        String rez = "";
        for (int i = 0; i <= value; i++) {
            res += i;
            rez += i + "+";
        }
        return rez.substring(0,rez.length()-1) + " = " + res;
    }
}
