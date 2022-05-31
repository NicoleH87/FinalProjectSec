import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskManager {
    private ArrayList<TaskInfo> taskList;

    public void loadTasks() {
        try {
            taskList = new ArrayList<TaskInfo>();
            File f = new File("/Users/nicol/IdeaProjects/TaskPlanner/src/tasks.data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] playerInfo = data.split("\\|");
                Player p = new Player(playerInfo[0], Integer.parseInt(playerInfo[1]));
                players.add(p);
            }
            s.close();
        } catch (FileNotFoundException fnf) {
            taskList = new ArrayList<TaskInfo>();
        }
    }
    public TaskManager () {
        taskList = new ArrayList<TaskInfo> ();
    }

    public void addTask(TaskInfo task) {
        taskList.add(task);
    }

    public ArrayList<TaskInfo> getTask() {return taskList;}

    public void removeTask() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("(" + i + 1 + ")" + taskList.get(i));
        }
    }

    public ArrayList<TaskInfo> keyWordSearch (String search) {
        ArrayList<TaskInfo> result = new ArrayList<TaskInfo> ();
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTask().indexOf(search) != -1 || taskList.get(i).getNotes().indexOf(search) != -1) {
                result.add(taskList.get(i));
            }
        }
        return result;
    }

    public ArrayList<TaskInfo> typeSearch (String type) {
        ArrayList<TaskInfo> typesResult = new ArrayList<TaskInfo>();
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getType().equals(type)) {
                typesResult.add(taskList.get(i));
            }
        }
        return typesResult;
    }

    public void editTask(int num, TaskInfo task) {
        taskList.set(num-1, task);
    }

    public void save() {
        try {
            File f = new File("src/taskInfo.data");
            f.createNewFile();
            FileWriter fileWrite = new FileWriter("src/taskInfo.data");
            fileWrite.write(taskList.get(1).getTask());
            fileWrite.close();
        }
        catch (IOException e){
            System.out.println("Cannot create file.");
            e.printStackTrace();
        }
    }
    //Find a way to check past history to record which tasks are typically completed first (maybe based on category and simplicity?)
    //Program a method which would help the user create a task plan (search up hw efficiency harder first, or easier first)
    //Accommodate based on the user...maybe for future reference if it is not already too much.
}
