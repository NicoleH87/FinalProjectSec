import java.util.ArrayList;
import java.util.Scanner;

public class CreateTask {
    private ArrayList<String> categories = new ArrayList<String> ();
    private TaskManager manage = new TaskManager();
    private String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public CreateTask() {};

    public void action () {
        Scanner s = new Scanner(System.in);
        int inChoice = 0;
        while (inChoice > 0 && inChoice < 5) {
            System.out.println("What action would you like to commit to?");
            System.out.println("(1) Add Task \n(2) Edit Task or Info \n(3) Complete task \n(4)Edit Category List");
            inChoice = s.nextInt();
        }
        if (inChoice == 1) {
            //copy and paste
            System.out.println("Select a category for your task");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println("(" + i + 1 + ") " + categories.get(i));
            }
            int category = s.nextInt();
            String type = categories.get(category);

            System.out.println("What task would you like to add?");

            String task = s.nextLine();
            System.out.println("Would you like to add any notes");
            String choice = s.nextLine();
            String note = "";
            if (choice.toLowerCase().equals("yes")) {
                System.out.println("Note: ");
                note = s.nextLine();
            }
            System.out.println();
            System.out.println("Due date");
            System.out.println("Enter a Year");
            int year = s.nextInt();
            System.out.println("Select a Month:");
            for (int i = 0; i < months.length; i++) {
                System.out.println(i + 1 + months[i]);
            }
            int month = s.nextInt();
            System.out.println("Enter a date");
            int date = s.nextInt();
            if (month == 2) {
                if (year%4 == 0) {
                    while (date < 0 && date > 29) {
                        System.out.println("Your date is inaccurate. Please enter an accurate date.");
                        System.out.println("Enter a date: ");
                        date = s.nextInt();
                    }
                }
                else {
                    while (date < 0 && date > 28) {
                        System.out.println("Your date is inaccurate. Please enter an accurate date.");
                        System.out.println("Enter a date: ");
                        date = s.nextInt();
                    }
                }
            }
            else if ((month < 8 && month%2 == 1) || (month > 7 && month%2 == 0)) {
                while (date < 0 && date > 31) {
                    System.out.println("Your date is inaccurate. Please enter an accurate date.");
                    System.out.println("Enter a date: ");
                    date = s.nextInt();
                }
            }
            else
            {
                while (date < 0 && date > 30) {
                    System.out.println("Your date is inaccurate. Please enter an accurate date.");
                    System.out.println("Enter a date: ");
                    date = s.nextInt();
                }
            }
            System.out.println("is Priority? (y/n)");
            String pString = s.nextLine();
            boolean priority = false;
            if (pString.equals("y")) {
                priority = true;
            }
            System.out.println("Simple task? (y/n)");
            String sString = s.nextLine();
            boolean simple = false;
            if (sString.equals("y")) {
                simple = true;
            }
            TaskInfo newTask = new TaskInfo (task, note, month, date, year, priority, simple, type);
            manage.addTask(newTask);
        }
        else if (inChoice == 2) {
            //List tasks and their info (in a particular print format), choices on which to edit, confirmation of editing, confirmation and restating initial
            int taskNumChoice = 0;
            ArrayList<TaskInfo> task = manage.getTask();
            while (taskNumChoice <= task.size() && taskNumChoice > 0) {
                for (int i = 0; i < task.size(); i++) {
                    System.out.println("(" + i + 1 + ") " + task.get(i));
                }
                System.out.println("Select task to edit: ");
                taskNumChoice = s.nextInt();
            }

            //Check between range of options
            int choice2 = 0;
            while (choice2 <= 5 && choice2 > 0) {
                TaskInfo t = task.get(taskNumChoice);
                System.out.println("What would you like to replace?");
                System.out.println("(1) Section: " + t.getType());
                System.out.println("(2) Task: " + t.getTask());
                System.out.println("(3) Notes: " + t.getNotes());
                System.out.println("(4) Due Date: " + t.getMonth() + "/" + t.getDay() + t.getYear());
                System.out.println("(5) Priority: " + t.isPriority());
                System.out.println("Enter your choice: ");
                choice2 = s.nextInt();
            }

            System.out.println("What would you like to change it into?");
            if (choice2 == 1) {
                System.out.println("Select a category for your task");
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println("(" + i + 1 + ") " + categories.get(i));
                }
                int category = s.nextInt();
                task.get(taskNumChoice).setType(categories.get(category));
            }
            if (choice2 == 2) {
                System.out.println("New Task: ");
                String newTask = s.nextLine();
                task.get(taskNumChoice).setTask(newTask);
            }
            if (choice2 == 3) {
                System.out.println("New Note: ");
                String newNote = s.nextLine();
                task.get(taskNumChoice).setNote(newNote);
            }
            if (choice2 == 5) {
                System.out.println("(1) yes \n(2) no");
                int choice = s.nextInt();
                if (choice == 1) {
                    task.get(choice2).setPriority(true);
                }
                if (choice == 2) {
                    task.get(choice2).setPriority(false);
                }
            }
        }
        else {
            //List task, ask which task was completed
            for (int i = 0; i < manage.getTask().size(); i++) {
                System.out.println("(" + i + 1 + ") " + manage.getTask().get(i));
            }
            System.out.println("Completed Task: ");
            int taskChoice = s.nextInt();
            manage.getTask().remove(taskChoice - 1);
        }

    }
}