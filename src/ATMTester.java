import java.util.*;
import java.io.*;


public class ATMTester {
	public static void main (String [] args) {
		Scanner in = new Scanner(System.in);
		
		ATM atm = new ATM();
		int isOn = 1;
		
		
		while (isOn==1) {
			for (int i = 0; i < 10; i++) {
				System.out.println("\n");
			}
			System.out.println("Please choose service:");
			System.out.println("1) Create Account        2) Close Account"
						   + "\n3) Withdraw			     4) Deposit"
						   + "\n5) Check Balance");
			int answer = in.nextInt();
			
			if (answer==1) {//OPEN ACCOUNT
				System.out.println("Do you also want to deposit an amount? (y/n)");
				String response = in.next();
				if (response.equalsIgnoreCase("y")) {
					System.out.println("Enter ID:");
					int id = in.nextInt();
					System.out.println("Enter amount:");
					double amount = in.nextDouble();
					atm.openAccount(id,amount);
				}
				else {
					System.out.println("Enter ID:");
					int id = in.nextInt();
					atm.openAccount(id);
				}
				System.out.println("You have successfully openned an account.");
			}
			
			else if (answer==2) {//close account
				System.out.println("Enter ID:");
				int id = in.nextInt();
				atm.closeAccount(id);
				System.out.println("You have successfully closed this account.");
			}
			
			else if (answer==3) {//withdraw
				System.out.println("Enter ID:");
				int id = in.nextInt();
				System.out.println("Enter amount:");
				double amount = in.nextDouble();
				if(atm.withdrawMoney(id, amount)) {//if successful
					System.out.println("You have successfully withdrawn $" + amount + ".");
				}
				else {
					System.out.println("An error has occurred.");
				}
			}
			
			
			else if (answer==4) {//deposit 
				System.out.println("Enter ID:");
				int id = in.nextInt();
				System.out.println("Enter amount:");
				double amount = in.nextDouble();
				if(atm.depositMoney(id, amount)) {//if successful
					System.out.println("You have successfully deposited $" + amount + ".");
				}
				else {
					System.out.println("An error has occurred.");
				}
			}
			
			else if (answer==5) {//check balance
				System.out.println("Enter ID:");
				int id = in.nextInt();
				System.out.println("You have $" + atm.checkBalance(id) + " remaining in this account");
			}
			
			System.out.println("\nWould you like to continue? (y/n)");
			String response = in.next();
			if (response.equalsIgnoreCase("n")) {
				isOn=0;
			}
			
		}
		System.out.println("Thank you for using our service");
		
	}
}
