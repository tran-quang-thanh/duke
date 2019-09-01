import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String time;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

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

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}