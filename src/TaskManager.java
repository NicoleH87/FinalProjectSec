import java.util.ArrayList;
import java.util.Arrays;

public class TaskManager {
    private ArrayList<TaskInfo> taskList;

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

    public void editTask(int num, TaskInfo task) {
        taskList.set(num-1, task);
    }


}
