import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class ListWriter {
    public static void main(String[] args) throws ParseException {
        ArrayList<String> categories = new ArrayList<String> ();
        TaskManager manage = new TaskManager();
        String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            Scanner s = new Scanner(System.in);
            int input = 0;
            System.out.println("What action would you like to commit to? Enter 0 to end program.");
            System.out.println("(1) Add Task \n(2) Edit Task or Info \n(3) Complete task \n(4) Generate List");
            System.out.print("Enter action: ");
            String actionChoice = s.nextLine();
            input = Integer.parseInt(actionChoice);
            System.out.println();
            while (input != 0) {
                if (input > 0 && input < 5) {
                    if (input == 1) {
                        //copy and paste
                        Scanner y = new Scanner(System.in);
                        System.out.print("Enter a category for your task: ");
                        String type = y.nextLine();

                        System.out.print("Enter task you would like to add: ");
                        String task = y.nextLine();
                        System.out.println("Add any additional notes? (yes/no)");
                        String choice = y.nextLine();
                        String note = "";
                        if (choice.toLowerCase().equals("yes")) {
                            System.out.println("Note: ");
                            note = y.nextLine();
                        }
                        System.out.println();
                        System.out.println("Due date");
                        System.out.print("Enter a Year: ");
                        String tempYear = y.nextLine();
                        int year = Integer.parseInt(tempYear);
                        for (int i = 0; i < 12; i++) {
                            int num = i + 1;
                            System.out.println("(" + num + ") " + months[i]);
                        }
                        System.out.print("Select a Month: ");
                        String tempMonth = y.nextLine();
                        int month = Integer.parseInt(tempMonth);
                        System.out.print("Enter a date: ");
                        String temp = y.nextLine();
                        int date = Integer.parseInt(temp);
                        if (month == 2) {
                            if (year % 4 == 0) {
                                while (date < 0 && date > 29) {
                                    System.out.println("Your date is inaccurate. Please enter an accurate date.");
                                    System.out.print("Enter a date: ");
                                    temp = y.nextLine();
                                    date = Integer.parseInt(temp);
                                }
                            } else {
                                while (date < 0 && date > 28) {
                                    System.out.println("Your date is inaccurate. Please enter an accurate date.");
                                    System.out.println("Enter a date: ");
                                    temp = y.nextLine();
                                    date = Integer.parseInt(temp);
                                }
                            }
                        } else if ((month < 8 && month % 2 == 1) || (month > 7 && month % 2 == 0)) {
                            while (date < 0 && date > 31) {
                                System.out.println("Your date is inaccurate. Please enter an accurate date.");
                                System.out.println("Enter a date: ");
                                temp = y.nextLine();
                                date = Integer.parseInt(temp);
                            }
                        } else {
                            while (date < 0 && date > 30) {
                                System.out.println("Your date is inaccurate. Please enter an accurate date.");
                                System.out.println("Enter a date: ");
                                temp = y.nextLine();
                                date = Integer.parseInt(temp);
                            }
                        }
                        System.out.println("is Priority? (y/n)");
                        String pString = y.nextLine();
                        boolean priority = false;
                        if (pString.equals("y")) {
                            priority = true;
                        }
                        System.out.println("Simple task? (y/n)");
                        String sString = y.nextLine();
                        boolean simple = false;
                        if (sString.equals("y")) {
                            simple = true;
                        }
                        TaskInfo newTask = new TaskInfo(task, note, month, date, year, priority, simple, type);
                        manage.addTask(newTask);
                        manage.save();
                        System.out.println();
                    } else if (input == 2) {
                        int taskNumChoice = 0;
                        ArrayList<TaskInfo> task = manage.getTask();
                        while (taskNumChoice > task.size() || taskNumChoice < 0) {
                            System.out.println("Task List: ");
                            for (int i = 0; i < task.size(); i++) {
                                int taskNum = i + 1;
                                System.out.println("(" + taskNum + ") " + task.get(i).getTask());
                            }
                            System.out.print("Select task to edit: ");
                            String choice = s.nextLine();
                            taskNumChoice = Integer.parseInt(choice) - 1;
                            System.out.println();
                        }

                        int editOption = 0;
                        while (editOption > 5 || editOption <= 0) {
                            TaskInfo t = task.get(taskNumChoice);
                            System.out.println("What would you like to replace?");
                            System.out.println("(1) Section: " + t.getType());
                            System.out.println("(2) Task: " + t.getTask());
                            System.out.println("(3) Notes: " + t.getNotes());
                            System.out.println("(4) Priority: " + t.isPriority());
                            System.out.println("Enter your choice: ");
                            String replChoice = s.nextLine();
                            editOption = Integer.parseInt(replChoice);
                        }

                        if (editOption < 4) {
                            System.out.println("What would you like to change it into?");
                        }
                        else {
                            System.out.println("Change?");
                        }
                        if (editOption == 1) {
                            System.out.print("Enter a category for your task: ");
                            String category = s.nextLine();
                            task.get(taskNumChoice).setType(category);
                        }
                        if (editOption == 2) {
                            System.out.println("New Task: ");
                            String newTask = s.nextLine();
                            task.get(taskNumChoice).setTask(newTask);
                        }
                        if (editOption == 3) {
                            System.out.println("New Note: ");
                            String newNote = s.nextLine();
                            task.get(taskNumChoice).setNote(newNote);
                        }
                        if (editOption == 4) {
                            System.out.println("(1) yes \n(2) no");
                            String editPriority = s.nextLine();
                            int choice = Integer.parseInt(editPriority);
                            if (choice == 1) {
                                task.get(taskNumChoice).setPriority(true);
                            }
                            if (choice == 2) {
                                task.get(taskNumChoice).setPriority(false);
                            }
                        }
                        manage.save();
                        System.out.println("***Edit Complete***\n");
                    } else if (input == 3){
                        //List task, ask which task was completed
                        ArrayList<TaskInfo> task = manage.getTask();
                        System.out.println("Task List: ");
                        for (int i = 0; i < task.size(); i++) {
                            int taskNum = i + 1;
                            System.out.println("(" + taskNum + ") " + task.get(i).getTask());
                        }
                        System.out.print("Enter completed task: ");
                        String finChoice = s.nextLine();
                        int taskChoice = Integer.parseInt(finChoice);
                        manage.getTask().remove(taskChoice - 1);
                        manage.save();
                        System.out.println("***Task Removed***\n");
                    }
                    else {
                        System.out.println("List Options: ");
                        System.out.println("(1) Key Word \n(2) Due Soon \n(3) Due Later \n(4) Due Late \n(5) Simple/Difficult");
                        ArrayList<TaskInfo> currentList = manage.getTask();
                        SortTask sort = new SortTask(currentList);
                        System.out.print("Enter choice: ");
                        String listChoice = s.nextLine();
                        int listOption = Integer.parseInt(listChoice);
                        System.out.println();
                        if (listOption == 1) {
                            System.out.println("Enter key term.");
                            String keyTerm = s.nextLine();
                            sort.keyWord(keyTerm.toLowerCase());
                            System.out.println();
                        }
                        if (listOption == 2) {
                            ArrayList<TaskInfo> soon = sort.dueSoon();
                            int count = 1;
                            for (TaskInfo t : soon) {
                                System.out.println("(" + count + ") ");
                                t.print();
                                System.out.println();
                                count++;
                            }
                            if (soon.size() == 0) {
                                System.out.println("***No assignments due soon.***\n");
                            }
                        }
                        if (listOption == 3) {
                            ArrayList<TaskInfo> later = sort.dueLater();
                            int count = 1;
                            for (TaskInfo t : later) {
                                System.out.println("(" + count + ") ");
                                t.print();
                                System.out.println();
                                count++;
                            }
                            if (later.size() == 0) {
                                System.out.println("***No assignments due later.***");
                            }
                        }
                        if (listOption == 4) {
                            ArrayList<TaskInfo> late = sort.dueLate();
                            int count = 1;
                            for (TaskInfo t : late) {
                                System.out.println("(" + count + ") ");
                                t.print();
                                System.out.println();
                                count++;
                            }
                            if (late.size() == 0) {
                                System.out.println("***No assignments due soon.***");
                            }
                        }
                        if (listOption == 5) {
                            ArrayList<TaskInfo> simple = sort.simpleTasks();
                            ArrayList<TaskInfo> difficult = sort.difficultTasks();
                            System.out.println("Simple Tasks: ");
                            int count = 1;
                            for (TaskInfo sim : simple) {
                                System.out.println("(" + count + ") ");
                                sim.print();
                                System.out.println();
                                count++;
                            }
                            System.out.println();
                            System.out.println("Difficult Tasks: ");
                            count = 1;
                            for (TaskInfo diff : difficult) {
                                System.out.println("(" + count + ") ");
                                diff.print();
                                System.out.println();
                                count++;
                            }
                        }
                    }
                }
                else {
                    System.out.println("Input choice invalid.");
                    System.out.println("What action would you like to commit to? Enter 0 to end program.");
                    System.out.println("(1) Add Task \n(2) Edit Task or Info \n(3) Complete task \n(4) Generate List");
                    System.out.print("Enter action: ");
                    actionChoice = s.nextLine();
                    input = Integer.parseInt(actionChoice);
                    System.out.println();
                }
                /*for (int i = 0; i < manage.getTask().size(); i++) {
                    manage.getTask().get(i).print();
                }
                */
                System.out.println("What action would you like to commit to? Enter 0 to end program.");
                System.out.println("(1) Add Task \n(2) Edit Task or Info \n(3) Complete task \n(4) Generate List");
                System.out.print("Enter action: ");
                actionChoice = s.nextLine();
                input = Integer.parseInt(actionChoice);
                System.out.println();
            }
            manage.save();
            System.out.println("Program Terminated");
    }
}
