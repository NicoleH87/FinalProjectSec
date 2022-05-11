import java.util.Arrays;

public class TaskInfo {
    private String[] months = new String[12];
    private String task;
    private String notes;
    private int month;
    private int day;
    private int year;
    private boolean priority;
    private boolean simple;
    private String type;

    public TaskInfo(String task, String notes, int month, int day, int year, boolean priority, boolean simple, String type) {
        this.task = task;
        this.notes = notes;
        this.month = month;
        this.day = day;
        this.year = year;
        this.priority = priority;
        this.simple = simple;
        this.type = type;
    }

    public String monthNumConversion (int num) {
        return months[num - 1];
    }

    public int monthStringConversion (String mon){
        int find = -1;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals("mon")) {
                find = i + 1;
            }
        }
        return find;
    }


}
