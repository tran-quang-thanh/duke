public class DukeException extends Exception {
    public DukeException(String message) {
        super(message);
    }

    public static void notTaskException(String task) throws DukeException {
        if(!task.equals("bye") && !task.equals("list") && !task.equals("done") &&
                !task.equals("todo") && !task.equals("deadline") && !task.equals("event") &&
                !task.equals("delete") && !task.equals("find")) {
            throw new DukeException("Sorry I don't understand this :'(");
        }
    }

    public static void notString(String s) throws Exception{
        if (s.length() == 0) {
            throw new Exception();
        }
    }

    public static void DeadlineAndEventLackInfo (String[] string) throws Exception{
        if (string.length < 2) {
            throw new Exception();
        }
    }
}
