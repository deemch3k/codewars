package ua.dima.challanges.other;

/*
Count the number of divisors of a positive integer n.

Random tests go up to n = 500000.
 */
public class FindDivisor {

    public static void main(String[] args) {
        System.out.println(numberOfDivisors(30));
    }

    public static long numberOfDivisors(int n) {

        if( n == 0) return 0;

        long result = 0;

        for (int i = 1; i <= 500000; i++) {
            if(n%i==0) result++;
        }

        return result;
    }

}
