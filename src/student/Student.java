package student;

import java.io.FileNotFoundException;
import org.json.simple.JSONObject;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Richard Truong
 * 
 * Reference: https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
 *
 */

public class Student {

    public static void main(String[] args) {
        objToJSON();
        //displayJSON();
        System.out.println("");
        System.out.println("Output: ");
        JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("Student.json"))
        {
            Object obj = jsonParser.parse(reader);
 
            JSONArray studentList = (JSONArray) obj;
            System.out.println("Student.json: " + studentList);
             
            studentList.forEach( emp -> displayJSON( (JSONObject) emp ) );
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (ParseException e) {
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
        
        JSONObject JSONdetails = new JSONObject();
        JSONdetails.put("IName", students.getIName());
        JSONdetails.put("GPA", students.getGPA());
        JSONdetails.put("currentCredits", students.getCurrentCredits());
        JSONdetails.put("totalCredits", students.getTotalCredits());
        JSONdetails.put("fName", students.getfName());
        
        JSONObject JSONStudent = new JSONObject();
        JSONStudent.put("Student", JSONdetails);
        
        JSONArray studentList = new JSONArray();
        studentList.add(JSONStudent);
        
        System.out.println("JSON: " + studentList);
        
        try (FileWriter file = new FileWriter("Student.json")) {
            file.write(studentList.toJSONString());
            file.flush();
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static void displayJSON(JSONObject Student) {
        try {
        JSONObject studentObject = (JSONObject) Student.get("Student");
        
        String IName = (String) studentObject.get("IName");
        System.out.println("IName: " + IName);
        
        double GPA = (double) studentObject.get("GPA");
        System.out.println("GPA: " + GPA);
        
        long currentCredits = (long) studentObject.get("currentCredits");
        System.out.println("Current Credits: " + currentCredits);
        
        long totalCredits = (long) studentObject.get("totalCredits");
        System.out.println("Total Credits: " + totalCredits);
        
        String fName = (String) studentObject.get("fName");
        System.out.println("fName: " + fName);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }
}