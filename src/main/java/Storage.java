import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    private void writeFile(ArrayList<Task> taskList) {
        String s;
        try (FileWriter writer = new FileWriter(new File(this.filePath));
             BufferedWriter bw = new BufferedWriter(writer)) {

            for (Task t : taskList) {
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

    public void saveFile(ArrayList<Task> taskList) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + taskList.get(taskList.size() - 1));
        writeFile(taskList);
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }

    public ArrayList<Task> load() throws DukeException
    {
        String s;
        String[] string;
        ArrayList<Task> taskList = new ArrayList<>();
        FileReader file;
        try {
            file = new FileReader(new File(this.filePath));
        }
        catch (FileNotFoundException e) {
            throw new DukeException(this.filePath + " is not found");
        }
        BufferedReader br = new BufferedReader(file);
        try {
            while ((s = br.readLine()) != null) {
                string = s.split("\\|");
                if (string[0].equals("T")) {
                    taskList.add(new ToDo(string[2]));
                } else if (string[0].equals("E")) {
                    taskList.add(new Event(string[2], string[3]));
                } else {
                    taskList.add(new Deadline(string[2], string[3]));
                }
                if (string[1].equals("1")) {
                    taskList.get(taskList.size() - 1).markAsDone();
                }
            }
        }
        catch (IOException e) {
            throw new DukeException(e.getMessage());
        }
        return taskList;
    }
}
