package ua.dima.challanges.kyu4;

/*
A format for expressing an ordered list of integers is to use a comma separated list of either

individual integers
or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
 The range includes all integers in the interval including both endpoints.
 It is not considered a range unless it spans at least 3 numbers. For example ("12, 13, 15-17")
Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string
in the range format.
 */

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {

        String res = "";
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 != arr.length) {
                if (arr[i + 1] == arr[i] + 1) {
                    counter++;
                } else if (counter > 1) {
                    res += arr[i - counter] + "-" + arr[i] + ",";
                    counter = 0;
                } else if (counter == 1) {
                    res += arr[i - counter] + "," + arr[i] + ",";
                    counter = 0;
                } else {
                    res += arr[i] + ",";
                }
            } else if (counter > 1) {
                res += arr[i - counter] + "-" + arr[i];
            } else if (counter == 1) {
                res += arr[i - counter] + "," + arr[i];
            } else {
                res += arr[i];
            }
        }
        return res;
    }


}
