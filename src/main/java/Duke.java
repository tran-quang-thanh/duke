import java.util.*;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String s, task;
        String[] string;
        ArrayList<Task> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            s = scanner.next();
            if (s.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (s.equals("list")) {
                System.out.println("Here are the tasks in the list:");
                for (int i = 1; i <= arr.size(); ++i) {
                    System.out.println(i + "." + arr.get(i-1));
                }
            }
            else if (s.equals("done")){
                int i = scanner.nextInt();
                arr.get(i-1).markAsDone();
                System.out.println("Nice! I've marked this task as done:\n  " + arr.get(i-1));
            }
            else {
                task = scanner.nextLine();
                System.out.println("Got it. I've added this task:");
                if (s.equals("todo")) {
                    arr.add(new ToDo(task));
                }
                else if (s.equals("deadline")) {
                    string = task.split("/");
                    arr.add(new Deadline(string[0], string[1].substring(3)));
                }
                else {
                    string = task.split("/");
                    arr.add(new Event(string[0], string[1].substring(3)));
                }
                System.out.println("  " + arr.get(arr.size() - 1));
                System.out.println("Now you have " + arr.size() + " tasks in the list.");
            }
        }
    }
}