package ua.dima.challanges.kyu4;

/*
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
This image will illustrate things more clearly:


NOTE: The idea is not sort the elements from the lowest value to the highest;
the idea is to traverse the 2-d array in a clockwise snailshell pattern.

NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
 */

public class Snail {

    public static int[] snail(int[][] array) {

        if (array[0].length <= 0) {
            return new int[0];
        }

        int length = array.length * array.length;
        int[] res = new int[length];
        int x = 0;
        int y = 0;
        int stepX = 1;
        int stepY = 0;

        for (int i = 0; i < length; ++i) {
            res[i] = array[y][x];
            array[y][x] = -1;

            x += stepX;
            y += stepY;

            if(stepX != 0 && (x < 0 || x >= array.length || array[y][x] == -1)) {
                x += -stepX; y += stepX;
                stepY = stepX; stepX = 0;
            } else if (stepY != 0 && (y < 0 || y >= array.length || array[y][x] == -1)) {
                x += -stepY;
                y += -stepY;
                stepX = -stepY;
                stepY = 0;
            }
        }

        return res;

    }
}
