import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class PrintingTasks {
    public static Scanner scanner = new Scanner(System.in);
    public static Queue<String> queue = new LinkedList<>();
    public static Map<String,Integer> data = new HashMap<>();

    public static float speed = 10;

    public static void display(){
        float currentTime = 0;
        if(queue.size() == 0){
            System.out.println("No tasks in queue");
        } else {
            System.out.println("Number of Print jobs: "+ queue.size());
            System.out.println("Printer Speed (pages per minute): "+speed);
            System.out.println("Print jobs (Job ID, Pages):");
            for(String job : queue){
                System.out.print(job + "\t" + data.get(job));
                System.out.println();
            }
            for(String job : queue){
                System.out.print(job + " -> ");
            }
            System.out.print("next");
            System.out.println();
            System.out.println("Job Execution Details: ");
            for(String job : queue){
                float jobDuration = data.get(job) / speed;
                float waitingTime = currentTime;
                float turnaroundTime = waitingTime + jobDuration;
                
                System.out.println(job + ": waiting time = " + waitingTime + "min, Turnaround time = " + turnaroundTime + "min");
                
                currentTime = turnaroundTime;
            }
        }
    }

    public static void addTask(){
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the number of pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();

        data.put(name,pages);
        queue.add(name);
    }
    public static void main(String[] args){
        while(true){
            System.out.println("==== welcome to printer interface ====");
            System.out.println("1.View Printer Tasks");
            System.out.println("2.Add Tasks");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            if(choice == 1){
                display();
            } else if(choice == 2){
                addTask();
            } else if(choice == 3){
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}
