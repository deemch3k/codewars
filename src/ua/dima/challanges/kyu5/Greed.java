package ua.dima.challanges.kyu5;

/*
Greed is a dice game played with five six-sided dice.
Your mission, should you choose to accept it, is to score a throw according to these rules.
You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point
A single die can only be counted once in each roll.
For example, a "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points,
but not both in the same roll.

Example scoring

 Throw       Score
 ---------   ------------------
 5 1 3 4 1   50 + 2 * 100 = 250
 1 1 1 3 1   1000 + 100 = 1100
 2 4 4 5 4   400 + 50 = 450
In some languages, it is possible to mutate the input to the function.
This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.
 */


public class Greed {

    public static void main(String[] args) {
        System.out.println(greedy(new int[]{5, 1, 3, 4, 1}));
    }


    public static int greedy(int[] dice) {

        if(dice.length != 5) return 0;

        int[] temp = new int[7];
        int res = 0;

        for (int i = 0; i < dice.length; i++) {
            temp[dice[i]]++;
        }

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > 0) {
                if (temp[i] >= 3) {
                    if (i == 5) {
                        if (temp[i] == 3) {
                            res += 500;
                        } else {
                            res += 500 + ((temp[i] - 3) * 50);
                        }
                    } else if (i == 1) {
                        if (temp[i] == 3) {
                            res += 1000;
                        } else {
                            res += 1000 + ((temp[i] - 3) * 100);
                        }
                    } else {
                        res += i * 100;
                    }
                } else {
                    if (i == 1) {
                        res += 100 * temp[i];
                    } else if (i == 5) {
                        res += 50 * temp[i];
                    }
                }
            }
        }

        return res;
    }

}
