import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);
    public String line = "____________________________________________________________";
    private boolean isExit;

    public UI() {
        this.isExit = false;
    }

    public void showWelcome() {
        System.out.println(line);
        System.out.println("  Hello! I'm Duke\n  What can I do for you?");
        System.out.println(line);
    }

    public void showLine() {
        System.out.println(line);
    }

    public String readCommand() {
        return scanner.next();
    }

    public int readNumber() {
        return scanner.nextInt();
    }

    public String readFindItem() {
        return scanner.nextLine();
    }

    public String readTask() {
        return scanner.nextLine();
    }

    public void exit() {
        this.isExit = true;
    }

    public boolean isExit() {
        return this.isExit;
    }
}
