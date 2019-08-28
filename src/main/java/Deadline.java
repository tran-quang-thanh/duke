public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description, ProcessDateAndTime.formatDate(by));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}
