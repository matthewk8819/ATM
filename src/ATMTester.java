import java.util.*;
import java.text.*;
import java.io.*;
import java.math.*;

public class ATMTester {
@SuppressWarnings("removal")
public static void main(String[] args) {
ATM chase = new ATM();
// Open accounts
chase.openAccount(00001);
chase.openAccount(00002, 2500.0);
// Test Basic Functionality
chase.depositMoney(00001, 433.45);
chase.depositMoney(00001, 434.77);
chase.depositMoney(00001, 424.91);
chase.depositMoney(00001, 474.10);
chase.depositMoney(00002, 154.30);
System.out.println(chase.checkBalance(00001)); // Should be 1767.23
System.out.println(chase.checkBalance(00002)); // Should be 2654.30
chase.withdrawMoney(00001, 100.00);
chase.withdrawMoney(00001, 1000.00);
System.out.println(chase.checkBalance(00001)); // Should be 667.23
// Test Invalid Deposits
chase.depositMoney(00003, -433.45);
chase.depositMoney(00004, 32434.77);
chase.depositMoney(01337, 128537424.91);
chase.depositMoney(21504, 2343474.10);
System.out.println(chase.checkBalance(00003)); // Should be 0.0
System.out.println(chase.checkBalance(00004)); // Should be 0.0
System.out.println(chase.checkBalance(01337)); // Should be 0.0
System.out.println(chase.checkBalance(21504)); // Should be 0.0
// Test Invalid Withdrawals
chase.withdrawMoney(00001, -433.45);
chase.withdrawMoney(00001, 32434.77);
chase.withdrawMoney(01337, 128537424.91);
chase.withdrawMoney(21504, -2343474.10);
System.out.println(chase.checkBalance(00001)); // Should be 667.23
System.out.println(chase.checkBalance(00001)); // Should be 667.23
System.out.println(chase.checkBalance(01337)); // Should be 0.0
System.out.println(chase.checkBalance(21504)); // Should be 0.0
// Test other issues
chase.withdrawMoney(00002, 2020.2);
System.out.println(chase.checkBalance(00002)); // Should be 634.1 and 
//not a fraction more!
double d1 = 2500.0;
double d2 = 2020.2;
double d3 = 154.30;
System.out.println(d1 + d3 - d2);
double floorD = Math.floor((d1+d3-d2) *100) /100;
System.out.println(floorD);
System.out.println(Math.floor((d1+d3-d2) * 100) / 100.00);

//test for two decimal places: 
System.out.println(Math.floor((d1+d3)*100)/100);
BigDecimal d = new BigDecimal(Math.floor((d1+d3)*100)/100);
MathContext m = new MathContext(6);
System.out.println(d.setScale(2,RoundingMode.DOWN));
BigDecimal newd = d.setScale(2,RoundingMode.DOWN);
Double d11 = new Double(d1+d3);
System.out.println(Double.sum(d3, d1));
DecimalFormat df = new DecimalFormat("0.00");

}
}
/*
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
				System.out.println("You have closed this account(if it existed).");
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
*/
