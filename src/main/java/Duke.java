import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
//    private static ArrayList<Task> tasks;

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        Ui.displayWelcome();
        try {
            ArrayList<Task> currenttasks = Storage.readFile();
            tasks = new TaskList(currenttasks);
            if (!currenttasks.isEmpty()) {
                Ui.displayTasks(currenttasks);
            } else {
                Ui.display("No current list available. Start by adding a task!");
            }
        } catch (FileNotFoundException e) {
            tasks = new TaskList(new ArrayList<Task>());
        }
    }

    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (CustomException | IOException e) {
                Ui.display(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data/fileInfo.txt").run();
    }
}
