package student;

import java.io.FileInputStream;
import org.json.simple.JSONObject;
import java.util.Scanner;
import javax.json.Json; 
import javax.json.JsonArray; 
import javax.json.JsonArrayBuilder; 
import javax.json.JsonObject; 
import javax.json.JsonObjectBuilder; 
import javax.json.JsonWriter; 
import java.io.FileOutputStream; 
import java.io.InputStream;
import java.io.OutputStream; 
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonValue;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Richard Truong
 */

public class Student {

    public static void main(String[] args) {
        objToJSON();
        displayJSON();
    }
    
    private String IName;
    private double GPA;
    private int currentCredits;
    private int totalCredits;
    private String fName;
    
    public String getIName() { 
      return IName; 
    }
    public void setIName(String IName) { 
      this.IName = IName; 
    }
    
    public double getGPA() { 
      return GPA; 
    }
    public void setGPA(double GPA) { 
      this.GPA = GPA; 
    }
    
    public int getCurrentCredits() { 
      return currentCredits; 
    }
    public void setGPA(int currentCredits) { 
      this.currentCredits = currentCredits; 
    }
    
    public int getTotalCredits() { 
      return totalCredits; 
    }
    public void setTotalCredits(int totalCredits) { 
      this.totalCredits = totalCredits; 
    }
    
    public String getfName() { 
      return fName; 
    }
    public void setfName(String fName) { 
      this.fName = fName; 
    }
    
    public static void objToJSON() {
        
        //Video Lecture Example
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter IName");
        String IName = sc.nextLine();
        
        System.out.println("Enter GPA");
        double GPA = sc.nextDouble();
        
        System.out.println("Enter currentCredits");
        int currentCredits = sc.nextInt();
        
        System.out.println("Enter totalCredits");
        int totalCredits = sc.nextInt();
        
        System.out.println("Enter fName");
        String fName = sc.nextLine();
        
        List<Student> studentsList = new ArrayList(); 
        Student students = new Student();
        
        studentsList.add(students.setIName(IName));
        students.setIName(GPA, GPA);
        students.setIName(currentCredits);
        students.setIName(totalCredits);
        students.setIName(fName);
        
        for (Student student : students) {
        JSONObject obj = new JSONObject();
        obj.put("IName", student.getIName());
        obj.put("GPA", student.getGPA());
        obj.put("currentCredits", student.getCurrentCredits());
        obj.put("totalCredits", student.getTotalCredits());
        obj.put("fName", student.getfName());
        System.out.println(obj);
        }
        
        //Textbook Example
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder(); 
        
        List<Student> students = new ArrayList(); 
        
        try {
            for (Student student : students) { 
                jsonArrayBuilder.add( 
                  Json.createObjectBuilder() 
                  .add("IName", student.getIName()) 
                  .add("GPA", student.getGPA()) 
                  .add("CurrentCredits", student.getCurrentCredits()) 
                  .add("TotalCredits", student.getTotalCredits()) 
                  .add("fName", student.getfName()) 
                );
            }

            JsonArray studentsArray = jsonArrayBuilder.build(); 
            OutputStream outputStream = new FileOutputStream ("Students.json"); 
            JsonWriter jsonWriter = Json.createWriter(outputStream); 
            jsonWriter.writeArray(studentsArray); 
            System.out.println(studentsArray);

            outputStream.close(); 
            jsonWriter.close(); 
        }
        catch (Exception ex) {
        }
    }
    
    public static void displayJSON() {
        try {
        InputStream jsonInput = new FileInputStream("Student.json");
        String json = jsonInput.toString();
        
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(json);
        
        System.out.println("IName: " + obj.get("IName"));
        System.out.println("GPA: " + obj.get("GPA"));
        System.out.println("Current Credits: " + obj.get("CurrentCredits"));
        System.out.println("Total Credits: " + obj.get("TotalCredits"));
        System.out.println("fName: " + obj.get("fName"));
        }
        catch (Exception ex) {
            System.out.println("Parse Exception: " + ex);
        }
    }
}
