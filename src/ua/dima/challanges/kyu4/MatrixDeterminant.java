package ua.dima.challanges.kyu4;
/*
Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.

How to take the determinant of a matrix -- it is simplest to start with the smallest cases:
 */

public class MatrixDeterminant {

    public static void main(String[] args) {
        int[][] a = {
                {1,5,7},
                {3,7,9},
                {6,1,1}
        };
        determinant(a);
        System.out.println(Math.pow(-1, 3));
    }

    public static int determinant(int[][] matrix) {
        int res = 0;
        if(matrix.length == 1) return matrix[0][0];
        if(matrix.length == 2){
           return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        if(matrix.length >= 3){
            for (int i = 0; i < matrix[0].length; i++) {

                int[][] arr = new int[matrix.length-1][matrix[0].length-1];

                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix[0].length; k++) {

                        if (k < i) {
                            arr[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            arr[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }
                res += Math.pow (-1, i+1)* matrix[0][i] * determinant (arr);
            }

        }
        return res;
    }

}
