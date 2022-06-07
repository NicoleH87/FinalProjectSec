import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;

import java.util.Date;
import java.util.Calendar;

public class SortTask {
    private Date date;
    private ArrayList<TaskInfo> task;

    public SortTask(ArrayList<TaskInfo> tasks) {
        Date date = new Date();
        this.date = date;
        task = tasks;
        Calendar cal = Calendar.getInstance();
    }

    public ArrayList<TaskInfo> dueSoon() throws ParseException {
        ArrayList<TaskInfo> soon = new ArrayList<TaskInfo> ();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = formatter.format(date);
            int monthIndex = strDate.indexOf("/");
            int currMonth = Integer.parseInt(strDate.substring(0, monthIndex));
            strDate = strDate.substring(monthIndex + 1);
            int dateIndex = strDate.indexOf("/");
            int currDate = Integer.parseInt(strDate.substring(0, dateIndex));
            strDate = strDate.substring(dateIndex + 1);
            int currYear = Integer.parseInt(strDate);
            if (currYear == task.get(i).getYear()) {
                if (currMonth == task.get(i).getMonth()) {
                    int dateDiff = task.get(i).getDay() - currDate;
                    if (dateDiff == 0 || dateDiff <= 7 && dateDiff > 0) {
                        soon.add(task.get(i));
                    }
                }
            }
        }
        return soon;
    }

    public ArrayList<TaskInfo> dueLater() throws ParseException {
        ArrayList<TaskInfo> later = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = formatter.format(date);
            int monthIndex = strDate.indexOf("/");
            int currMonth = Integer.parseInt(strDate.substring(0, monthIndex));
            strDate = strDate.substring(monthIndex + 1);
            int dateIndex = strDate.indexOf("/");
            int currDate = Integer.parseInt(strDate.substring(0, dateIndex));
            strDate = strDate.substring(dateIndex + 1);
            int currYear = Integer.parseInt(strDate);
            if (currYear == task.get(i).getYear()) {
                if (currMonth == task.get(i).getMonth()) {
                    int dateDiff = task.get(i).getDay() - currDate;
                    if (dateDiff > 5) {
                        later.add(task.get(i));
                    }
                }
                if (currMonth < task.get(i).getMonth()) {
                    later.add(task.get(i));
                }
            }
            if (currYear < task.get(i).getYear()) {
                later.add(task.get(i));
            }
        }
        return later;
    }

    public ArrayList<TaskInfo> dueLate () throws ParseException {
        ArrayList<TaskInfo> late = new ArrayList<TaskInfo>();
        for (int i = 0; i < task.size(); i++) {
            String dueDate = "" + task.get(i).getMonth() + task.get(i).getDay() + task.get(i).getYear();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = formatter.format(date);
            int monthIndex = strDate.indexOf("/");
            int currMonth = Integer.parseInt(strDate.substring(0, monthIndex));
            strDate = strDate.substring(monthIndex + 1);
            int dateIndex = strDate.indexOf("/");
            int currDate = Integer.parseInt(strDate.substring(0, dateIndex));
            strDate = strDate.substring(dateIndex + 1);
            int currYear = Integer.parseInt(strDate);
            if (currYear == task.get(i).getYear()) {
                if (currMonth == task.get(i).getMonth()) {
                    if (currDate > task.get(i).getDay()) {
                        late.add(task.get(i));
                    }
                }
                if (currMonth > task.get(i).getMonth()) {
                    late.add(task.get(i));
                }
            }
            if (currYear > task.get(i).getYear()) {
                late.add(task.get(i));
            }
        }
        return late;
    }

    public ArrayList<TaskInfo> typeTasks (String type) {
        ArrayList<TaskInfo> thisType = new ArrayList<TaskInfo>();
        for (TaskInfo t : task) {
            if (t.getType().equals(type)) {
                thisType.add(t);
            }
        }
        return thisType;
    }

    public ArrayList<TaskInfo> simpleTasks () {
        ArrayList<TaskInfo> simpleTask = new ArrayList<TaskInfo>();
        for (TaskInfo t: task) {
            if (t.isSimple() == true) {
                simpleTask.add(t);
            }
        }
        return simpleTask;
    }

    public ArrayList<TaskInfo> difficultTasks () {
        ArrayList<TaskInfo> hard = new ArrayList<TaskInfo>();
        for (TaskInfo t : task) {
            if (t.isSimple() == false) {
                hard.add(t);
            }
        }
        return hard;
    }

    public void keyWord (String word) {
        for (TaskInfo t : task) {
            if (t.getNotes().indexOf(word) > -1 || t.getTask().indexOf(word) > -1) {
                t.print();
            }
        }
    }
}
















