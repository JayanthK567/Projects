import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class StudentEnrollment {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String,String> register = new HashMap<>();
    public static Map<String,List<String>> courseStudents = new HashMap<>();
    
    static{
        //data of courseStudents hashmap
        courseStudents.put("Java", new ArrayList<>());
        courseStudents.put("DataStuctures", new ArrayList<>());
        courseStudents.put("DBMS", new ArrayList<>());
    }
    private static void register(){
        System.out.print("Enter student ID: ");
        String ID = scanner.nextLine();
        if(register.containsKey(ID)){
            System.out.println("ID already exists");
        } else {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            register.put(ID,name);
            System.out.println("Successfully registered!");
        }
    }
    private static void enroll(){
        System.out.print("Enter student ID: ");
        String ID = scanner.nextLine();
        if(!register.containsKey(ID)){
            System.out.println("ID does not exist");
            return;
        }
        System.out.println("Available courses: "+courseStudents.keySet());
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        if(courseStudents.containsKey(courseName)){
            List<String> enrolledList = courseStudents.get(courseName);
            
            if(!enrolledList.contains(ID)) {
                enrolledList.add(ID);
                System.out.println("Enrollment successful!");
            } else {
                System.out.println("Student already enrolled in this course.");
            }
        } else {
            System.out.println("Course does not exist");
        }
    }
    private static void display(){
        for(String course : courseStudents.keySet()){
            System.out.println(course + " -> " + (courseStudents.get(course)).size());
        }
    }
    public static void main(String[] args){
        while(true){
            System.out.println();
            System.out.println("==== Welcome to Course Registration System ====");
            System.out.println("1.Register Student");
            System.out.println("2.Enroll in Course");
            System.out.println("3.Display Course Enrollment");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                register();
            } else if(choice == 2){
                enroll();
            } else if(choice == 3){
                display();
            } else if(choice == 4){
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}
