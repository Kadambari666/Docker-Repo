package CoreJava;

import java.util.Scanner;

public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Enter a number: ");
            int num1 = sc.nextInt();
            
            System.out.println("Enter another number: ");
            int num2 = sc.nextInt();
            
            int result = num1/num2;
            System.out.println("Result: " +result);
    
        }catch(ArithmeticException e) {
        	System.out.println("Chukla re tu , tak ata dusra number");
        	
        }catch(Exception e) {
        	System.out.println("An error occured: "+e.getMessage());
        }
	}

}
