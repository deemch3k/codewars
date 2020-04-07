package ua.dima.challanges.kyu5;

/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word.
 Leave punctuation marks untouched.
 */

public class PigLatin {

    public static void main(String[] args) {
        System.out.println(pigIt("This is my string"));
    }

    public static String pigIt(String str) {
        String[] arr = str.split(" ");
        char first;

        for (int i = 0; i < arr.length; i++) {
            first = arr[i].charAt(0);
            arr[i] = arr[i].substring(1)+ first + "ay";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]).append(" ");
        }
        return res.toString();
    }


}
