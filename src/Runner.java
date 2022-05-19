import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayList<String> sections = new ArrayList<String> ();
        Organizer organize = new Organizer();
        ArrayList<String> categories = new ArrayList<String> ();
        try {
            File f = new File("myfile.txt");
            Scanner s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println(" -----Task Planner----- ");
            Scanner s = new Scanner(System.in);
            //Ask about categories and keep adding, prints the complete list each time a complete addition is added. There will also be an option later on the fix if necessary (delete / replace).
            System.out.println("Input individual categories (folder). Enter \"x\" when completed");
            String in = s.nextLine();
            while (!in.toLowerCase().equals("x")) {
                System.out.println("Enter category name: ");
                categories.add(s.nextLine());
                System.out.println("Enter \" \" to continue or \"x\" to stop.");
            }

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
    }
}
