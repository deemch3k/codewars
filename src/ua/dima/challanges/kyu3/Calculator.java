package ua.dima.challanges.kyu3;

/*
Create a simple calculator that given a string of operators
(), +, -, *, / and numbers separated by spaces returns the value of that expression
 */

public class Calculator {


    public static Double evaluate(String expression) {
        final String WALL = "WALL";

        String[] arr = expression.split(" ");
        if (arr.length == 1) return Double.parseDouble(arr[0]);

        int counter = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*") || arr[i].equals("/")) {
                if (arr[i - counter].equals(WALL)) {
                    while (arr[i - counter].equals(WALL)) {
                        ++counter;
                    }
                }
                double a = Double.parseDouble(arr[i - counter]);
                arr[i - counter] = WALL;
                counter = 1;
                if (arr[i + counter].equals(WALL)) {
                    while (arr[i + counter].equals(WALL)) {
                        counter++;
                    }
                }
                double b = Double.parseDouble(arr[i + counter]);
                arr[i] = calc(a, b, arr[i]) + "";
                arr[i + counter] = WALL;
                counter = 1;
            }
        }

        counter = 1;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+") || arr[i].equals("-")) {
                if (arr[i - counter].equals(WALL)) {
                    while (arr[i - counter].equals(WALL)) {
                        ++counter;
                    }
                }
                double a = Double.parseDouble(arr[i - counter]);
                arr[i - counter] = WALL;
                counter = 1;
                if (arr[i + counter].equals(WALL)) {
                    while (arr[i + counter].equals(WALL)) {
                        counter++;
                    }
                }
                double b = Double.parseDouble(arr[i + counter]);
                arr[i] = calc(a, b, arr[i]) + "";
                arr[i + counter] = WALL;
                counter = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(WALL)) return Double.parseDouble(arr[i]);
        }
        return -1.0;
    }

    public static double calc(double a, double b, String operator) {
        switch (operator) {
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return -1;
        }
    }

}