import java.util.*;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String s;
        ArrayList<String> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            if (s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (s.equals("list")) {
                for (int i = 1; i <= arr.size(); ++i) {
                    System.out.println(i + ". " + arr.get(i-1));
                }
            }
            else {
                System.out.println("added: " + s);
                arr.add(s);
            }
        }
    }
}