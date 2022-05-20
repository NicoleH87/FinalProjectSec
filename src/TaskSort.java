import java.util.ArrayList;

public class TaskSort {
    private int thisYear = 0; // implement later
    private int thisMonth = 0; // implement later
    private int thisDay = 0; // implement later

    public TaskSort() {}

    public ArrayList<TaskInfo> dueSoon(ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> soon = new ArrayList<TaskInfo> ();
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).getYear() == thisYear)
            {
                if (task.get(i).getMonth() == thisMonth || (task.get(i).getDay() > 25 && task.get(i).getMonth() + 1 == thisMonth)) {
                    soon.add(task.get(i));
                }
            }
        }
        return soon;
    }

    public ArrayList<TaskInfo> dueLater(ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> later = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).getYear() > thisYear || (task.get(i).getDay() < 25 && task.get(i).getMonth() == thisMonth + 1)) {
                later.add(task.get(i));
            }
        }
        return later;
    }

    public ArrayList<TaskInfo> dueLate (ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> late = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).getYear() < thisYear || task.get(i).getMonth() < thisMonth || task.get(i).getDay() < thisDay){
                late.add(task.get(i));
            }
        }
        return late;
    }

    public ArrayList<TaskInfo> typeTasks (String type, ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> thisType = new ArrayList<TaskInfo>();
        for (TaskInfo t : task) {
            if (t.getType().equals(type)) {
                thisType.add(t);
            }
        }
        return thisType;
    }

    public ArrayList<TaskInfo> simpleTasks (ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> simpleTask = new ArrayList<TaskInfo>();
        for (TaskInfo t: task) {
            if (t.isSimple() == true) {
                simpleTask.add(t);
            }
        }
        return simpleTask;
    }

    public ArrayList<TaskInfo> difficultTasks (ArrayList<TaskInfo> task) {
        ArrayList<TaskInfo> hard = new ArrayList<TaskInfo>();
        for (TaskInfo t : task) {
            if (t.isSimple() == false) {
                hard.add(t);
            }
        }
        return hard;
    }

    public void keyWord (ArrayList<TaskInfo> task, String word) {
        for (TaskInfo t : task) {
            if (t.getNotes().indexOf(word) > -1 || t.getTask().indexOf(word) > -1) {
                t.print();
                System.out.println();
            }
        }
    }


}
















