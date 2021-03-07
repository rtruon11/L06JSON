package student;

import java.io.FileNotFoundException;
import org.json.simple.JSONObject;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Richard Truong
 */

public class Student {

    public static void main(String[] args) {
        objToJSON();
        //displayJSON();
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("Student.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);
             
            //Iterate over employee array
            employeeList.forEach( emp -> displayJSON( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
    public void setCurrentCredits(int currentCredits) { 
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
        Scanner scString = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);
        Scanner scInteger = new Scanner(System.in);
        Scanner scfName = new Scanner(System.in);
        
        System.out.println("Enter IName");
        String IName = scString.nextLine();
        
        System.out.println("Enter GPA");
        double GPA = scDouble.nextDouble();
        
        System.out.println("Enter currentCredits");
        int currentCredits = scInteger.nextInt();
        
        System.out.println("Enter totalCredits");
        int totalCredits = scInteger.nextInt();
        
        System.out.println("Enter fName");
        String fName = scfName.nextLine();
        
        Student students = new Student();
        students.setIName(IName);
        students.setGPA(GPA);
        students.setCurrentCredits(currentCredits);
        students.setTotalCredits(totalCredits);
        students.setIName(fName);
        
        ArrayList studentsList = new ArrayList(); 
        studentsList.add(IName);
        studentsList.add(GPA);
        studentsList.add(currentCredits);
        studentsList.add(totalCredits);
        studentsList.add(fName);
        
        JSONObject JSONdetails = new JSONObject();
        JSONdetails.put("IName", students.getIName());
        JSONdetails.put("GPA", students.getGPA());
        JSONdetails.put("currentCredits", students.getCurrentCredits());
        JSONdetails.put("totalCredits", students.getTotalCredits());
        JSONdetails.put("fName", students.getfName());
        //break;

        JSONObject JSONStudent = new JSONObject();
        JSONStudent.put("Student", JSONdetails);

        System.out.println(JSONStudent);

        JSONArray studentList = new JSONArray();
        studentList.add(JSONStudent);
        
        System.out.println(studentList);
        
        try (FileWriter file = new FileWriter("Student.json")) {
            file.write(studentList.toJSONString());
            file.flush();
            
        /*
        //Textbook Example
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder(); 
        
            //for (Student student : studentsList) { 
                jsonArrayBuilder.add( 
                  Json.createObjectBuilder() 
                  .add("IName", students.getIName()) 
                  .add("GPA", students.getGPA()) 
                  .add("CurrentCredits", students.getCurrentCredits()) 
                  .add("TotalCredits", students.getTotalCredits()) 
                  .add("fName", students.getfName())
                );
            //}

            JsonArray studentsArray = jsonArrayBuilder.build(); 
            OutputStream outputStream = new FileOutputStream ("Students.json"); 
            JsonWriter jsonWriter = Json.createWriter(outputStream); 
            jsonWriter.writeArray(studentsArray); 
            System.out.println(studentsArray);

            outputStream.close(); 
            jsonWriter.close(); 
        */
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
    
    public static void displayJSON(JSONObject Student) {
        /*
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
        */
        
        //Get employee object within list
        JSONObject studentObject = (JSONObject) Student.get("Student");
         
        //Get employee first name
        String IName = (String) studentObject.get("IName");    
        System.out.println(IName);
        
    }
}
