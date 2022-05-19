import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class TaskCreator {
    private ArrayList<String> categories = new ArrayList<String> ();
    private String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public TaskCreator() {};

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
        }
        else if (inChoice == 2) {
            //List tasks and their info (in a particular print format), choices on which to edit, confirmation of editing, confirmation and restating initial
            ArrayList<TaskInfo> task = organize.returnTask();
            for (int i = 0; i < task.size(); i++) {
                System.out.println("(" + i + 1 + ") " + task.get(i));
            }
            System.out.println("Select task to edit: ");
            int num = s.nextInt();
            //Check between range of options
            System.out.println("What would you like to replace?");
            System.out.println("(1) Section: " + task.get(num).getType());
            System.out.println("(2) Task: " + task.get(num).getTask());
            System.out.println("(3) Notes: " + task.get(num).getNotes());
            System.out.println("(4) Due Date: " + task.get(num).getMonth() + "/" + task.get(num).getDay() + task.get(num).getYear());
            System.out.println("(5) Priority: " + task.get(num).isPriority());
            //Check response between range
            int num2 = s.nextInt();
            System.out.println("What would you like to change it into?");
            if (num2 == 5) {
                System.out.println("(1) yes \n(2) no");
                int choice = s.nextInt();
                if (choice == 1) {
                    task.get(num).setPriority(true);
                }
                else if (choice == 2) {
                    task.get(num).setPriority(false);
                }
                else {

                }
            }
        }
        else if (inChoice == 3) {
            //List task, which task was completed

        }
        else {
            //list category, change/delete/add option
        }
    }
}