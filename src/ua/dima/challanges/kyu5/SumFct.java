package ua.dima.challanges.kyu5;

/*
The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.
It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80

Could you give the sum of the perimeters of all the squares in a rectangle
when there are n + 1 squares disposed in the same manner as in the drawing:

alternative text

#Hint: See Fibonacci sequence #Ref: http://oeis.org/A000045

The function perimeter has for parameter n where n + 1 is the number of squares (they are numbered from 0 to n)
and returns the total perimeter of all the squares.
 */

import java.math.BigInteger;

public class SumFct {

    public static BigInteger perimeter(BigInteger n) {
        BigInteger n1 = new BigInteger("0");
        BigInteger n2 = new BigInteger("1");
        BigInteger temp;
        BigInteger res = new BigInteger("1");

        for (long i = 0; i < n.intValue(); i++) {
            temp = n1.add(n2);
            res = res.add(temp);
            n1=n2;
            n2=temp;
        }
        return res.multiply(new BigInteger("4"));
    }

}
