/**
 * Convert a String of numbers to a date format
 */
public class ProcessDateAndTime {
    public static String formatDate(String s) {
        try {
            String[] arr = s.split(" ", 2);
            String s1 = day(arr[0]) + " " + time(arr[1]);
            s = s1;
        }
        catch (Exception e) {}
        return s;
    }

    /**
     * Convert day in form dd/mm/yyyy to d"th" m yyyy
     * @param date day in form dd/mm/yyyy
     * @return day in form d"th" m yyyy
     */
    public static String day(String date) {
        try {
            String[] arr = date.split("/");
            String idx;
            int i = Integer.parseInt(arr[0]);
            if (i % 10 == 1 && i != 11) {
                idx = "st";
            }
            else if (i % 10 == 2 && i != 12) {
                idx = "nd";
            }
            else if (i % 10 == 3 && i != 13) {
                idx = "rd";
            }
            else {
                idx = "th";
            }
            int j = Integer.parseInt(arr[1]);
            String month = "";
            switch (j) {
                case 1:
                    month = "Jan";
                    break;
                case 2:
                    month = "Feb";
                    break;
                case 3:
                    month = "Mar";
                    break;
                case 4:
                    month = "Apr";
                    break;
                case 5:
                    month = "May";
                    break;
                case 6:
                    month = "Jun";
                    break;
                case 7:
                    month = "Jul";
                    break;
                case 8:
                    month = "Aug";
                    break;
                case 9:
                    month = "Sep";
                    break;
                case 10:
                    month = "Oct";
                    break;
                case 11:
                    month = "Nov";
                    break;
                case 12:
                    month = "Dec";
                    break;
            }
            date = i + idx + " " + month + " " + arr[2];
        }
        catch (Exception e) {}
        return date;
    }

    /**
     * Convert String from hhmm format to hh:mm am/pm
     * @param time time in form hhmm
     * @return time in form hh:mm am/pm
     */
    public static String time(String time) {
        try {
            int i = Integer.parseInt(time);
            int hr = i % 100;
            int min = i / 100;
            time = hr + ":" + min + (hr >= 12 ? "pm" : "am");
        }
        catch (Exception e) {}
        return time;
    }
}
