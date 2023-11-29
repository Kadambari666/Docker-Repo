package CoreJava;

import java.util.ArrayList;
import java.util.Scanner;

class Question{
	private String questionText;
	private ArrayList<String> options;
	private char correctOption;
	
	public Question(String questionText, ArrayList<String> options, char correctOption) {	
	this.questionText = questionText;
	this.options = options;
	this.correctOption = correctOption;
	}
	
	public String getQuestionText() {
		return questionText;
	}
		public ArrayList<String> getOptions() {
	        return options;
	    }

	    public char getCorrectOption() {
	        return correctOption;
	    }
	
}

public class QuizGameApp {
 
	private static ArrayList<Question> questions = new ArrayList<>();
	private static int score = 0;
	private static Scanner scanner = new Scanner(System.in);

	public static void main()
	{
		initializeQuestions();
		
		System.out.println("Welcome to the Quiz Game");
		System.out.println("There are " + questions.size()+" questions.Let's get started!");
		
		for(Question question : questions) {
			askQuestion(question);
		
		}
		
		System.out.println("Quiz completed! Your final score: "+score+ "/" + questions.size());
	
	
	}
	
	private static void initializeQuestions() {
		ArrayList<String> options1 = new ArrayList<>();
		options1.add("A. Java");
		options1.add("B. Python");
		options1.add("C. Javascript");
		options1.add("D. C++");
		questions.add(new Question("What programming language is this quiz written in?", options1, 'A'));
		
		ArrayList<String> options2 = new ArrayList<>();
		options2.add("A. Mercury");
		options2.add("B. Venus");
		options2.add("C. Earth");
		options2.add("D. Mars");
		questions.add(new Question("Which planet is known as the 'Red Planet'?",options2, 'D'));


		
	}
	
	private static void askQuestion(Question question) {
		System.out.println("\n" + question.getQuestionText());
		for(String option : question.getOptions()) {
			System.out.println(option);
		}
		
		System.out.print("Your answer (A,B,C or D): ");
		char userAnswer = Character.toUpperCase(scanner.next().charAt(0));
		
		if(userAnswer == question.getCorrectOption()) {
			System.out.println("Correct! +! point");
			score++;
		}else {
			System.out.println("Incorrect.The correct answer is " + question.getCorrectOption());
			
		}
	}
}

