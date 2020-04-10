package ua.dima.challanges.kyu4;

/*
Write a function called sumIntervals/sum_intervals() that accepts an array of intervals,
and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.

Intervals
Intervals are represented by a pair of integers in the form of an array.
The first value of the interval will always be less than the second value.
Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

Overlapping Intervals
List containing overlapping intervals:

[
   [1,4],
   [7, 10],
   [3, 5]
]
The sum of the lengths of these intervals is 7.
Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
 */

import java.util.Arrays;

public class Interval {


    public static int sumIntervals(int[][] intervals) {

        int res = 0;

        if (null == intervals || intervals.length == 0) {
            return 0;
        }

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length; j++) {

                if (intervals[i][1] >= intervals[j][0]
                        && intervals[i][1] <= intervals[j][1]
                        && intervals[i][0] != Integer.MAX_VALUE
                        && intervals[j][0] != Integer.MAX_VALUE
                        && j != i
                ) {

                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = Integer.MAX_VALUE;
                    j = 0;
                } else if (intervals[j][0] <= intervals[i][0]
                        && intervals[j][1] >= intervals[i][0]
                        && intervals[i][0] != Integer.MAX_VALUE
                        && intervals[j][0] != Integer.MAX_VALUE
                        && i != j) {
                    intervals[i][0] = intervals[j][0];
                    intervals[j][0] = Integer.MAX_VALUE;
                    j = 0;
                }
            }
            if(intervals[i][0] != Integer.MAX_VALUE) {
                for (int k = 0; k < intervals.length; k++) {
                    if(intervals[k][0] >= intervals[i][0] && intervals[k][1] <= intervals[i][1] && k != i){
                        intervals[k][0] = Integer.MAX_VALUE;
                    }
                }
                res += intervals[i][1] - intervals[i][0];
            }
        }

        return res;
    }

}
