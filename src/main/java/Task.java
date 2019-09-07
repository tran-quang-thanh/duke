/**
 * Represent tasks that user need to do
 * A Task can be Deadline, Event, Todo
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String time;

    /**
     * Create task with only a description
     * Use when user add a new task
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Create a task with description and time
     * Use when read data from duke.txt file or if the task is Deadline or Event
     * @param description
     * @param time
     */
    public Task(String description, String time) {
        this.description = description;
        this.isDone = false;
        this.time = time;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public String getTime() {
        return this.time;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Mark a task status to done
     * Call when user finish a specific task
     */
    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}