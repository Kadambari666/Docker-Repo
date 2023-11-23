package CoreJava;
import java.util.Scanner;

public class BankAcc {
	
	private String accountNo;
	private double balance;
	
	public BankAcc(String accountNumber, double initialBalance) {
		this.accountNo = accountNo;
		this.balance = initialBalance;
	}
	
	public void deposit(double amount){
		balance += amount;
		System.out.println("Deposit successful. New balance: "+balance);
		
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful.New balance: " +balance);
		}else {
			System.out.println("Insufficient funds");
		}
	}
    
	public void displayBalance() {
		System.out.println("Account Number: "+ accountNo);
		System.out.println("Balance: "+ balance);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter Account number: ");
     String accNumber = sc.nextLine();
     
     System.out.print("Enter initial balance: ");
     double initialBalance = sc.nextDouble();
     
     BankAcc account = new BankAcc(accNumber, initialBalance);
     
     account.displayBalance();
     
     System.out.print("Enter deposit amount: ");
     double depositAmount = sc.nextDouble();
     account.deposit(depositAmount);
     
     System.out.print("Enter withdraw amount: ");
     double withdrawAmount = sc.nextDouble();
     account.withdraw(withdrawAmount);
     
     account.displayBalance();
    
     
	}

}
