package ua.dima.challanges.kyu4;

/*
You have to create a function that takes a positive integer number
and returns the next bigger number formed by the same digits:

12 ==> 21
513 ==> 531
2017 ==> 2071
If no bigger number can be composed using those digits, return -1:

9 ==> -1
111 ==> -1
531 ==> -1
 */

import java.util.Arrays;

public class NextBiggerNumber {

    public static long nextBiggerNumber(long n) {

        char[] ar = Long.toString(n).toCharArray();

        int length = ar.length;
        int i;

        for (i = length - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            return -1;
        } else {
            int x = ar[i - 1], min = i;

            for (int j = i + 1; j < length; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            swap(ar, i - 1, min);

            Arrays.sort(ar, i, length);
        }
        long res = Long.parseLong(new String(ar));
        if (res == length) return -1;
        return res;
    }

    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
