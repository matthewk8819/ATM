import java.util.*;


public class ATM {
	
	private HashMap<Integer,account> allAccounts = new HashMap<Integer,account>();
	
	public ATM () {
		
	}
	
	public void openAccount(int id) {
		account newaccount = new account(id);
		allAccounts.put(id, newaccount);
	}
	
	public void openAccount(int accountID, double ammount) {
		account newaccount = new account(accountID, ammount);
		allAccounts.put(accountID, newaccount);
	}
	
	public void closeAccount (int accountID) {
		if (!isAccount(accountID)) {
			System.out.println("This account does not exist");
			return;
		}
		if ((checkBalance(accountID)==0)) {
			allAccounts.remove(accountID);
		}
		else {
			System.out.println("This account still has money in it!");
		}
	}
	
	public double checkBalance (int accountID) {
		if (!isAccount(accountID)) return 0.0;
		return allAccounts.get(accountID).getBalance();
	} 
	
	private boolean isAccount (int id) {
		return allAccounts.containsKey(id);
	}
	
	public boolean depositMoney (int id, double amount) {
		if (!isAccount(id)||amount<0) return false;
		account acc = allAccounts.get(id);
		acc.setBalance(acc.getBalance()+amount);
		return true;
	}
	
	public boolean withdrawMoney (int accountID, double amount) {
		@SuppressWarnings("removal")
		Double d = new Double(20.0101001);
		
		
		if (!isAccount(accountID)) return false;
		account acc = allAccounts.get(accountID);
		if (acc.getBalance()<amount||amount<0) return false;
		else {
			acc.setBalance(acc.getBalance()-amount);
			return true;
		}
	}
	
	
	
}
