package ua.dima.challanges.kyu4;

/*
Given two numbers: 'left' and 'right' (1 <= 'left' <= 'right' <= 200000000000000)
return sum of all '1' occurencies in binary representations of numbers between 'left' and 'right' (including both)

Example:
countOnes 4 7 should return 8, because:
4(dec) = 100(bin), which adds 1 to the result.
5(dec) = 101(bin), which adds 2 to the result.
6(dec) = 110(bin), which adds 2 to the result.
7(dec) = 111(bin), which adds 3 to the result.
So finally result equals 8.
WARNING: Segment may contain billion elements, to pass this kata, your solution cannot iterate through all numbers
in the segment!
 */

import java.math.BigInteger;

public class BitCount {

    public static void main(String[] args) {
        BigInteger bigInteger = countOnes(12, 29);
        System.out.println(bigInteger.toString());
    }

    public static BigInteger countOnes(long left, long right) {
        long res = 0;
        for (int i = 0; i <= right - left; i++) {
            res += countOnesInBin(left + i);
        }
        return BigInteger.valueOf(res);
    }

    public static long countOnesInBin(long n){
        int pow = 1;
        int counter = -1;
        while(n>=pow){
            pow *=2;
            counter++;
        }
        int res = 0;
        for (int i = counter; i >= 0; i--) {
            if(n>=Math.pow(2,i)){
                n -= Math.pow(2, i);
                res++;
            }
        }
        return res;
    }
}
