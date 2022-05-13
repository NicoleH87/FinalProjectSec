import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SamplePersonRunner {
    public static void main(String[] args) {
        try {
            File f = new File("src/person.data");
            Scanner s = new Scanner(f);
            int line = 1;
            String name = "";
            String hobby = "";
            // reading from the file line by line
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line == 1) {
                    name = data;
                }
                if (line == 2) {
                    hobby = data;
                }
                line++;
            }
            s.close();
            Person p =  new Person(name, hobby);
            System.out.println(p.greet());
            System.out.println("Would you like to update any information? Select an option");
            System.out.println("1: Change my name");
            System.out.println("2: Change my hobby");
            System.out.println("3: Change both hobby and name");
            System.out.println("4: Exit");
            s = new Scanner(System.in);
            System.out.print("Enter your option: ");
            String option = s.nextLine();
            if (option.equals("1") || option.equals("3")) {
                String n = "";
                System.out.print("Enter your new name: ");
                n = s.nextLine();
                p.setName(n);
            }
            if (option.equals("2") || option.equals("3")) {
                String h = "";
                System.out.print("Enter your new hobby: ");
                h = s.nextLine();
                p.setHobby(h);
            }
            p.save();
            System.out.println("Data saved! Good bye!");

        }
        // if the file doesn't exist, we will create a blank Person object and ask them for a name and hobby
        catch (FileNotFoundException e) {
            Person p = new Person();
            System.out.println(p.greet());
            System.out.print("What is your name? ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            System.out.print("What is your hobby? ");
            String hobby = in.nextLine();
            p.setName(name);
            p.setHobby(hobby);
            p.save();
        }
    }
}
