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
            date = i + idx + " " + arr[1] + " " + arr[2];
        }
        catch (Exception e) {}
        return date;
    }

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
