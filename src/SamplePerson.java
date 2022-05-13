import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SamplePerson {
    private String name;
    private String hobby;

    public SamplePerson(){
        name = "";
        hobby = "";
    }
    public SampleString name, String hobby) {
       this.name = name;
        this.hobby = hobby;
    }
    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String greet() {
        if (name.equals("") && hobby.equals("")) {
            return "Hello! Please introduce yourself!";
        }
        else {
            return "Name: " + name + "\n" + "Hobby: " + hobby;
        }
    }

    // This method is an example of how to take some information and write it into a file!
    public void save() {
        try {
            File f = new File("src/person.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/person.data");
            fw.write(name + "\n");
            fw.write(hobby);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
}

