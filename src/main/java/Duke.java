public class Duke {
    private Storage storage;
    private TaskList taskList;
    private UI ui;

    public Duke(String filePath) {
        ui = new UI();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            System.out.println(e.getMessage());
            taskList = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        while (!ui.isExit()) {
            String command = ui.readCommand();
            Parser.parse(ui, taskList, storage, command);
        }
    }

    public static void main(String[] args) {
        new Duke("src\\main\\data\\duke.txt").run();
    }
}