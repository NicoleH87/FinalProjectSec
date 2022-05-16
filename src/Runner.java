import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        String[] months = new String[];
        months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        try {
            File f = new File("myfile.txt");
            Scanner s = new Scanner(f);
            int inChoice = 0;
            while (inChoice > 0 && inChoice < 5) {
                System.out.println("What action would you like to commit to?");
                System.out.println("(1) Add Task \n(2) Edit Task or Info \n(3) Complete task \n(4)Edit Category List");
                inChoice = s.nextInt();
            }
            if (inChoice == 1) {
                //copy and paste
            }
            else if (inChoice == 2) {
                //List tasks and their info (in a particular print format), choices on which to edit, confirmation of editing, confirmation and restating initial
            }
            else if (inChoice == 3) {
                //List task, which task was completed
            }
            else {
                //list category, change/delete/add option
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(" -----Task Planner----- ");

            //Ask about categories and keep adding, prints the complete list each time a complete addition is added. There will also be an option later on the fix if necessary (delete / replace).
            System.out.println("Categories");

            System.out.println("What task would you like to add?");
            Scanner s = new Scanner(System.in);
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
            System.out.println("Simple task? (y/n)");
            String simple = s.nextLine();
        }

    }
}
