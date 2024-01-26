/**
 * App
 */

import java.io.File;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("student.json"));

            String studentInfo = scanner.nextLine();
            System.out.println(studentInfo);

            JsonParser studentParser = new JsonParser();
            JsonElement studentElement = studentParser.parse(studentInfo);
            JsonObject studentObject = studentElement.getAsJsonObject();

            System.out.println(studentObject.get("name").getAsString());
            System.out.println(studentObject.get("GPA").getAsString());
            System.out.println(studentObject.get("major").getAsString());

            Scanner peopleScanner = new Scanner(new File("people.json"));
            String peopleInfo = peopleScanner.nextLine();
            
            JsonParser peopleParser = new JsonParser();
            JsonArray peopleArray = (JsonArray)peopleParser.parse(peopleInfo);

            for (JsonElement person: peopleArray) {
                System.out.println(person.getAsJsonObject().get("name").getAsString());
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}