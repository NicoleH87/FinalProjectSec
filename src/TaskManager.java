import java.util.ArrayList;
public class TaskManager {
    private ArrayList<TaskInfo> taskList = new ArrayList<TaskInfo> ();

    public TaskManager (ArrayList<TaskInfo> taskList) {
        this.taskList = taskList;
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

}
