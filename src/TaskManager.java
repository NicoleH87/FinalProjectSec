import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<TaskInfo> taskList;

    public void loadTasks() {
        try {
            taskList = new ArrayList<TaskInfo>();
            File f = new File("/Users/nicol/IdeaProjects/TaskPlanner/src/tasks.data");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] taskIn = data.split("\\|");
                TaskInfo task = new TaskInfo(taskIn[0], taskIn[1], Integer.parseInt(taskIn[2]), Integer.parseInt(taskIn[3]), Integer.parseInt(taskIn[4]), taskIn[5].toLowerCase().equals("true"), taskIn[6].toLowerCase().equals("true"), taskIn[7]);
                taskList.add(task);
            }
            s.close();
        } catch (FileNotFoundException fnf) {
            taskList = new ArrayList<TaskInfo>();
        }
    }
    public TaskManager () {
        loadTasks();
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
        save();
    }

    public void save() {
        try {
            File f = new File("/Users/nicol/IdeaProjects/TaskPlanner/src/tasks.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("/Users/nicol/IdeaProjects/TaskPlanner/src/tasks.data");
            String data = "";
            for (int i = 0; i < taskList.size(); i++) {
                data = taskList.get(i).getTask() + "|" + taskList.get(i).getNotes() + "|" + taskList.get(i).getMonth() + "|" + taskList.get(i).getDay()  + "|" + taskList.get(i).getYear() + "|" + taskList.get(i).isPriority()  + "|" + taskList.get(i).isSimple()  + "|" + taskList.get(i).getType();
                fw.write(data + "\n");
            }
            fw.close();
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
