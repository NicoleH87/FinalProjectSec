import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Task {
    private ArrayList<TaskInfo> tasks = new ArrayList<TaskInfo>();

    public Task () {}

    public void saveData() {
        try {
            File f = new File("\Users\BT_1E10_06\IdeaProjects\Nicole Huang\FinalProject\src\task.data");
            f.createNewFile();

        }
    }

    /*
        public void saveData() {
        try {
            File f = new File("/Users/dasru/IdeaProjects/SlotMachine/src/players.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("/Users/dasru/IdeaProjects/SlotMachine/src/players.data");
            String data = "";
            for (int i = 0; i < players.size(); i++) {
                data = players.get(i).getUserName() + "|" + players.get(i).getWinnings();
                fw.write(data + "\n");
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

     */
}
