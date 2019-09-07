import java.util.ArrayList;

/**
 * Create an arrayList to store all tasks
 */
public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void add(Task t) {
        this.taskList.add(t);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t);
        System.out.println("Now you have " + this.taskList.size() + " tasks in the list.");
    }

    public void delete(int i) {
        System.out.println("Noted. I've removed this task:\n " + this.taskList.get(i - 1));
        this.taskList.remove(i - 1);
        System.out.println("Now you have: " + this.taskList.size() + " in the list");
    }

    /**
     * Find in all tasks some particular tasks containing keyword
     * @param keyword
     * @return an arrayList of task that contains a specific keyword
     */
    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> arrayList = new ArrayList<>();
        for (Task t : this.taskList) {
            if (t.getDescription().contains(keyword)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
