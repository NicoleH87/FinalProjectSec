import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;

public class TaskSort {
    private Date date;

    public TaskSort() {
        Date date = new Date();
        this.date = date;
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
    }

    public ArrayList<TaskInfo> dueSoon(ArrayList<TaskInfo> task) throws ParseException {
        ArrayList<TaskInfo> soon = new ArrayList<TaskInfo> ();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date compDate = new SimpleDateFormat("MM/dd/yy").parse(dueDate);
            DateFormat form = new SimpleDateFormat("MM/dd/yy");
            int currDate = Integer.parseInt(form.format(date));
            if (date.compareTo(compDate) == 0 || (date.compareTo(compDate) > 0 && task.get(i).getDay() < currDate + 5))
            {
                soon.add(task.get(i));
            }
        }
        return soon;
    }

    public ArrayList<TaskInfo> dueLater(ArrayList<TaskInfo> task) throws ParseException {
        ArrayList<TaskInfo> later = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date compDate = new SimpleDateFormat("MM/dd/yy").parse(dueDate);
            DateFormat form = new SimpleDateFormat("MM/dd/yy");
            int currDate = Integer.parseInt(form.format(date));
            if (date.compareTo(compDate) > 0 && task.get(i).getDay() > currDate + 5)
            {
                later.add(task.get(i));
            }
        }
        return later;
    }

    public ArrayList<TaskInfo> dueLate (ArrayList<TaskInfo> task) throws ParseException {
        ArrayList<TaskInfo> late = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date compDate = new SimpleDateFormat("MM/dd/yy").parse(dueDate);
            DateFormat form = new SimpleDateFormat("MM/dd/yy");
            int currDate = Integer.parseInt(form.format(date));
            if (date.compareTo(compDate) < 0)
            {
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
















