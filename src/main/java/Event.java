public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description, ProcessDateAndTime.formatDate(at));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (by: " + at + ")";
    }
}
