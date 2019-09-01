import java.io.*;
import java.util.*;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner scanner = new Scanner(System.in);
        String s, task;
        String[] string;
        ArrayList<Task> arr = new ArrayList<>();
        try {
            FileReader file = new FileReader(new File("D:\\nus\\MODULES\\sem3\\cs2113\\duke\\src\\main\\data\\duke.txt"));
            BufferedReader br = new BufferedReader(file);
            while ((s = br.readLine()) != null) {
                string = s.split("\\|");
                if (string[0].equals("T")) {
                    arr.add(new ToDo(string[2]));
                }
                else if (string[0].equals("E")){
                    arr.add(new Event(string[2], string[3]));
                }
                else {
                    arr.add(new Deadline(string[2], string[3]));
                }
                if (string[1].equals("1")) {
                    arr.get(arr.size() - 1).markAsDone();
                }
            }
        }
        catch (Exception e) {
            System.out.println("No file found");
            writeFile(arr);
        }
        while (scanner.hasNextLine()) {
            s = scanner.next();
            try {
                DukeException.checkTask(s);
                if (s.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (s.equals("list")) {
                    System.out.println("Here are the tasks in the list:");
                    for (int i = 1; i <= arr.size(); ++i) {
                        System.out.println(i + "." + arr.get(i - 1));
                    }
                } else if (s.equals("done")) {
                    try {
                        int i = scanner.nextInt();
                        arr.get(i - 1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n  " + arr.get(i - 1));
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("Check your list again to know the work you have");
                        for (int j = 1; j <= arr.size(); ++j) {
                            System.out.println(j + "." + arr.get(j - 1));
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("This should be the index number of your task");
                    }
                }
                else if (s.equals("delete")) {
                    try {
                        int i = scanner.nextInt();
                        System.out.println("Noted. I've removed this task:\n " + arr.get(i - 1));
                        arr.remove(i - 1);
                        System.out.println("Now you have: " + arr.size() + " in the list");
                        writeFile(arr);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Check your list again to know the work you have");
                        for (int j = 1; j <= arr.size(); ++j) {
                            System.out.println(j + "." + arr.get(j - 1));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("This should be the index number of your task");
                    }
                }
                else if (s.equals("find")) {
                    task = scanner.nextLine();
                    ArrayList<Task> temp = find(arr, task.substring(1));
                    System.out.println("Here are the matching tasks in your list:");
                    for (int j = 1; j <= temp.size(); ++j) {
                        System.out.println(j + "." + temp.get(j - 1));
                    }
                }
                else {
                    task = scanner.nextLine();
                    task = task.substring(1);
                    if (s.equals("todo")) {
                        try {
                            DukeException.notString(task);
                            arr.add(new ToDo(task));
                            printAddedTask(arr);
                        }
                        catch (Exception e) {
                            System.out.println("OOPS!!! The description of a todo cannot be empty.");
                        }
                    } else if (s.equals("deadline")) {
                        string = task.split("/", 2);
                        try {
                            DukeException.DeadlineAndEventLackInfo(string);
                            arr.add(new Deadline(string[0].substring(0, string[0].length()-1), string[1].substring(3)));
                            printAddedTask(arr);
                        }
                        catch (Exception e) {
                            System.out.println("OOPS!!! Your deadline note is not completed");
                        }
                    } else {
                        string = task.split("/", 2);
                        try {
                            DukeException.DeadlineAndEventLackInfo(string);
                            arr.add(new Event(string[0].substring(0, string[0].length()-1), string[1].substring(3)));
                            printAddedTask(arr);
                        }
                        catch (Exception e) {
                            System.out.println("OOPS!!! Your event note is not completed");
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }

    private static void printAddedTask(ArrayList<Task> arr) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + arr.get(arr.size() - 1));
        writeFile(arr);
        System.out.println("Now you have " + arr.size() + " tasks in the list.");
    }

    private static void writeFile(ArrayList<Task> arr) {
        String s;
        try (FileWriter writer = new FileWriter(new File("D:\\nus\\MODULES\\sem3\\cs2113\\duke\\src\\main\\data\\duke.txt"));
             BufferedWriter bw = new BufferedWriter(writer)) {

            for (Task t : arr) {
                char c = t.toString().charAt(1);
                s = c + "|" + (t.getIsDone() ? 1 : 0) + "|" + t.getDescription();
                if (c != 'T') {
                    s += "|" + t.getTime();
                }
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Task> find(ArrayList<Task> arr, String keyword) {
        ArrayList<Task> arrayList = new ArrayList<>();
        for (Task t : arr) {
            if (t.getDescription().contains(keyword)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}