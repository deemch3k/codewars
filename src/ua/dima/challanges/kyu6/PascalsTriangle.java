package ua.dima.challanges.kyu6;

/*
In mathematics, Pascal's triangle is a triangular array of the binomial coefficients expressed with formula

Pascal's Triangle

You can read Wikipedia article on Pascal's Triangle for more information.

Task
Write a function that, given a depth n, returns n top rows of Pascal's Triangle flattened into a one-dimensional list/array.

Example:
n = 1: [1]
n = 2: [1,  1, 1]
n = 4: [1,  1, 1,  1, 2, 1,  1, 3, 3, 1]
Note
Beware of overflow. Requested terms of a triangle are guaranteed to fit into the returned type, but depending on seleced method of calculations, intermediate values can be larger.


 */

import java.util.Arrays;

public class PascalsTriangle {

    public static void main(String[] args) {

        long[] arr = generate(4);
        Arrays.stream(arr).forEach(System.out::print);


    }

    public static long[] generate(int level) {

        int resultArrayLength = 0;
        for (int i = 1; i <= level; i++) {
            resultArrayLength += i;
        }
        long[] resultArray = new long[resultArrayLength];
        int iter = 0;
        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == 0) {
                    resultArray[iter] = 1;
                } else {
                    resultArray[iter] = resultArray[iter - 1] * (i - j + 1) / j;
                }
                iter++;
            }
        }

        return resultArray;
    }

}
