package ua.dima.challanges.kyu5;

/*Write a function, which takes a non-negative integer (seconds) as input and returns the time
in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
*/

public class HumanReadableTime {

    public static String makeReadable(int seconds) {

        int minutes;
        int hours;

        if (seconds > 0) {

            minutes = seconds / 60;

            if (minutes > 0) {
                seconds -= minutes*60;
                hours = minutes / 60;
                String m = minutes < 10 ? ":0" + minutes : ":" + minutes;
                String s = seconds < 10 ? ":0" + seconds : ":" + seconds;

                if (hours > 0) {
                    minutes -= hours*60;
                    m = minutes < 10 ? ":0" + minutes : ":" + minutes;
                    String h = hours < 10 ? "0" + hours : "" + hours;

                    return h + m + s;
                } else {
                    return "00"+m+s;
                }

            } else if (seconds >= 10) {

                return "00:00:" + seconds;
            } else {
                return "00:00:0" + seconds;
            }
        } else {
            return "00:00:00";
        }
    }

}