import java.util.ArrayList;
import java.util.Arrays;

public class Organizer {
    private String[] months = new String[12];
    //months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    private ArrayList<TaskInfo> tasks = new ArrayList<TaskInfo> ();

    public Organizer() {}

    public void addTask (TaskInfo a) {
        tasks.add(a);
    }

    public void removeTask (int n) {
        tasks.remove(n);
    }

    public ArrayList<TaskInfo> returnTask() {
        return tasks;
    }

    public ArrayList<TaskInfo> dueLater () {
        ArrayList<TaskInfo> later = new ArrayList<TaskInfo>();
        for (TaskInfo t : tasks) {
            if (t.getYear() >= )
        }
    }
}
