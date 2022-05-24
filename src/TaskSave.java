import java.util.ArrayList;
import java.io.File;

/* public class TaskSave {
    private ArrayList<TaskInfo> tasks = new ArrayList<TaskInfo>();

    public Task () {}

    public void saveData() {
        try {
            File f = new File(.txt);
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


