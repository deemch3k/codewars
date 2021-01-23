package ua.dima.challanges.other;

import java.util.*;

public class TestTask {

    public static void main(String[] args) {

        System.out.println(calcSum("9111000000000014"));

    }

    public static void task(String[] lines) {

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();
            Arrays.sort(chars);
            List<Integer> list;
            String s = Arrays.toString(chars);
            if (map.get(s) != null) {
                list = map.get(s);
            } else {
                list = new LinkedList<>();
                map.put(s, list);
            }
            list.add(i);
        }
        for (String s : map.keySet()) {
            List<Integer> value = map.get(s);
            String[] arr = s.split(", ");
            StringBuilder res = new StringBuilder();
            Arrays.stream(arr).forEach(res::append);
            if (value.size() > 1) {
                System.out.println(res + " = " + value);
            }
        }
    }

    public static int sqrt(int n) {

        for (int i = 0; i < n; i++) {
            if (i * i >= n) {
                return i * i > n ? i - 1 : i;
            }
        }
        return 0;
    }

    public static int logSqrt(int n) {
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid > n) {
                high = mid - 1;
            }
            if (mid * mid < n) {
                low = mid + 1;
            }
            if (mid * mid == n) {
                return mid;
            }
        }
        return low - 1;
    }

    static void task(String s) {
        String[] rows = s.split("\n");
        for (String str : rows) {
            String[] strings = str.split(" ");
            Arrays.stream(strings)
                    .map(string -> (string.length() >= 4) ? string.substring(2) : string)
                    .forEach(out -> System.out.print(out + " "));
            System.out.println();
        }
    }

    //12345
    static Integer calcSum(String str) {

        int num = Integer.parseInt(str);
        int acum = 0;


        while (num / 10 > 0) {
            acum += num % 10;
            num /= 10;
        }
        acum += num;

        return acum;
    }
}

