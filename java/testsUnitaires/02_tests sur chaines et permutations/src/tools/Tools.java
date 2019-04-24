package tools;

import static java.lang.Integer.valueOf;
import static java.lang.String.valueOf;
import static java.util.Arrays.sort;

public class Tools {

        public Tools() {
                // Eviter une instanciation directe.
        }

        /* @return an array of numbers order in ascending. */
        public static String[] explodeAndOrderInAscending(String s) {
                String[] arr = new String[s.length()];
                for (int i = 0; i < s.length(); i++) {
                        arr[i] = valueOf(s.charAt(i));
                }
                sort(arr);
                return arr;
        }

        /* @return {@code true} if the hour is valid */
        public static boolean checkIfHourIsValid(String hour) {
                Integer value = valueOf(hour);
                return (value >= 0 && value <= 23);
        }

        /* @return {@code true} if the minute or the second is valid */
        public static boolean checkIfMinuteOrSecondIsValid(String time) {
                Integer value = valueOf(time);
                return (value >= 0 && value <= 59);
        }

}
