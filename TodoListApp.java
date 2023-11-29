package CoreJava;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

	private static ArrayList<String> tasks = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     while(true) {
    	 System.out.println("\nTodo List Application");
    	 System.out.println("\n1.Add Task");
    	 System.out.println("\n2.View Tasks");
    	 System.out.println("\n3.Mark Task as Completed");
    	 System.out.println("\n4.Exit");
    	 
    	 System.out.println("Enter your choice: ");
    	 int choice = scanner.nextInt();
    	 scanner.nextLine();
    	 
    	 switch(choice) {
    	 case 1:
    		 addTask();
    		 break;
    	 case 2:
    		 viewTasks();
    		 break;
    	 case 3:
    		 markTaskAsCompleted();
    		 break;
    	 case 4:
    		 System.out.println("Exiting Todo List Application. Goodbye!");
    		 break;
    	 default:
             System.out.println("Invalid choice. Please enter a valid option.");

    		  
    	 }

     }
	}
	
	private static void addTask() {
		System.out.print("Enter the task: ");
		String task = scanner.nextLine();
		tasks.add(task);
		System.out.println("Task added successfully");
	}
	
	private static void viewTasks() {
		System.out.println("\nTasks:");
		
		if(tasks.isEmpty()) {
			System.out.println("No tasks available");
		}else {
			for(int i=0;i<tasks.size();i++) {
				System.out.println((i+1)+". "+ tasks.get(i));
				
			}
		}
	}
	
	private static void markTaskAsCompleted()
	{
		viewTasks();
		System.out.print("Enter the task number to mark as completed: ");
		int taskNumber = scanner.nextInt();
		
		if(taskNumber > 0 && taskNumber <= tasks.size()) {
			String completedTask = tasks.remove(taskNumber - 1);
			System.out.println("Task marked as completed: "+ completedTask);
		
		}else {
			System.out.println("Invalid task number. Please enter a valid task number.");
		}
	}
  

}
