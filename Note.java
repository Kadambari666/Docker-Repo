package CoreJava;

import java.util.ArrayList;
import java.util.Scanner;

class NoteApp {
	private String title;
	private String content;
	
	public NoteApp(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
        return "Title: " + title + "\nContent: " + content;

	}
}

public class Note{
	private static ArrayList<NoteApp> notes = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) {
		while(true) {
			System.out.println("\nNote-taking Application");
			System.out.println("1. create note");
			System.out.println("2. View Notes");
			System.out.println("3. Delete Note");
			System.out.println("4. Exit");
			
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				createNote();
				break;
			case 2:
				viewNotes();
				break;
			case 3:
				deleteNote();
				break;
			case 4:
				System.out.println("Exiting Note-Taking Application. Goodbye!");
				System.exit(0);
				break;	
			default:
				System.out.println("Invalid choice.Please enter a valid option.");
				
			}
		}
		
	}
	
	private static void createNote()
	{
		System.out.print("Enter note title: ");
		String title = scanner.nextLine();
		System.out.print("Enter note content: ");
		String content = scanner.nextLine();
		
		NoteApp note = new NoteApp(title, content);
		notes.add(note);
		System.out.println("Note created successfully!");
		
		
		
	}
	
	private static void viewNotes() {
		System.out.println("\nNotes:");
		
		if(notes.isEmpty()) {
			System.out.println("No notes available. ");
			
		}else{
			for(NoteApp note:notes)
			{
				System.out.println(note);
				System.out.println("--------------------");
			}
		}
	}
	
	private static void deleteNote() {
		viewNotes();
		if(!notes.isEmpty()) {
			System.out.print("Enter the title of the note to delete: ");
			String titleToDelete = scanner.nextLine();
			
			for (NoteApp note : notes) {
                if (note.getTitle().equalsIgnoreCase(titleToDelete)) {
                    notes.remove(note);
                    System.out.println("Note deleted successfully!");
                    return;
                }
            }
			
            System.out.println("Note with the given title not found.");

		}
	}
}
