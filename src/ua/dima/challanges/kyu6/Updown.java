package ua.dima.challanges.kyu6;

public class Updown {

    public static void main(String[] args) {

    }

    public static String arrange(String strng) {

        String[] splited = strng.split(" ");

        for (int i = 0; i < splited.length; i++) {

            if (splited[i].length() >= splited[i + 1].length()) {
                String temp = splited[i + 1];
                splited[i + 1] = splited[i];
                splited[i] = splited[i + 1];
            }
        }

        return "";
    }

}
