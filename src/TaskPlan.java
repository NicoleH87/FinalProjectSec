import java.util.ArrayList;

public class TaskPlan {
    private ArrayList<TaskInfo> task;

    public TaskPlan(ArrayList<TaskInfo> task) {
        this.task = task;
    }

    public ArrayList<TaskInfo> dueSoon() {
        int thisYear; //find a way to implement current date onto the program
        ArrayList<TaskInfo> soon = new ArrayList<TaskInfo> ();
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).getYear() > )
        }
    }
}
