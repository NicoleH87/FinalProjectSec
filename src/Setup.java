import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Setup {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat d = new SimpleDateFormat("MM/dd/yy");
        System.out.println("Current date: " + d);
        //String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayList<String> sections = new ArrayList<String> ();
        TaskManager organize = new TaskManager();
        CreateTask create = new CreateTask();
        ArrayList<String> categories = new ArrayList<String> ();
        try {
            File f = new File("myfile.txt");
            Scanner s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println(" -----Task Planner----- ");
            Scanner s = new Scanner(System.in);
            //Ask about categories and keep adding, prints the complete list each time a complete addition is added. There will also be an option later on the fix if necessary (delete / replace).
            System.out.println("Input individual categories (folder). Enter \"x\" when completed. Enter \" \" to continue and \"x\" upon completion.");
            System.out.println("Enter category name: ");
            String in = s.nextLine();
            while (!in.toLowerCase().equals("x")) {
                categories.add(in);
                System.out.println("Enter category name: ");
                in = s.nextLine();
            }
            System.out.println("Please add your tasks. Enter \"s\" to stop");
            while (! s.nextLine().toLowerCase().equals("s")) {
                create.action(categories);
            }
        }
    }
}
