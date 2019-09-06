import java.util.ArrayList;

public class Parser {
    private static String[] s;
    private static String task;
    public static void parse(UI ui, TaskList taskList, Storage storage, String string) {
        try {
            DukeException.notTaskException(string);
            ui.showLine();
            if (string.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                ui.exit();
            } else if (string.equals("list")) {
                System.out.println("Here are the tasks in the list:");
                for (int i = 1; i <= taskList.getTaskList().size(); ++i) {
                    System.out.println(i + "." + taskList.getTaskList().get(i - 1));
                }
            } else if (string.equals("done")) {
                try {
                    int i = ui.readNumber();
                    taskList.getTaskList().get(i - 1).markAsDone();
                    System.out.println("Nice! I've marked this task as done:\n  " + taskList.getTaskList().get(i - 1));
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Check your list again to know the work you have");
                    for (int j = 1; j <= taskList.getTaskList().size(); ++j) {
                        System.out.println(j + "." + taskList.getTaskList().get(j - 1));
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("This should be the index number of your task");
                }
            }
            else if (string.equals("delete")) {
                try {
                    int i = ui.readNumber();
                    taskList.delete(i);
                    storage.saveFile(taskList.getTaskList());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Check your list again to know the work you have");
                    for (int j = 1; j <= taskList.getTaskList().size(); ++j) {
                        System.out.println(j + "." + taskList.getTaskList().get(j - 1));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This should be the index number of your task");
                }
            }
            else if (string.equals("find")) {
                task = ui.readFindItem();
                ArrayList<Task> temp = taskList.find(task.substring(1));
                System.out.println("Here are the matching tasks in your list:");
                for (int j = 1; j <= temp.size(); ++j) {
                    System.out.println(j + "." + temp.get(j - 1));
                }
            }
            else {
                task = ui.readTask();
                task = task.substring(1);
                if (string.equals("todo")) {
                    try {
                        DukeException.notString(task);
                        taskList.add(new ToDo(task));
                        storage.saveFile(taskList.getTaskList());
                    } catch (Exception e) {
                        System.out.println("OOPS!!! The description of a todo cannot be empty.");
                    }
                } else if (string.equals("deadline")) {
                    s = task.split("/", 2);
                    try {
                        DukeException.DeadlineAndEventLackInfo(s);
                        taskList.getTaskList().add(new Deadline(s[0].substring(0, s[0].length() - 1), s[1].substring(3)));
                        storage.saveFile(taskList.getTaskList());
                    } catch (Exception e) {
                        System.out.println("OOPS!!! Your deadline note is not completed");
                    }
                } else {
                    s = task.split("/", 2);
                    try {
                        DukeException.DeadlineAndEventLackInfo(s);
                        taskList.getTaskList().add(new Event(s[0].substring(0, s[0].length() - 1), s[1].substring(3)));
                        storage.saveFile(taskList.getTaskList());
                    } catch (Exception e) {
                        System.out.println("OOPS!!! Your event note is not completed");
                    }
                }
            }
        }
        catch (DukeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            ui.showLine();
        }
    }
}
