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
		allAccounts.remove(accountID);
	}
	
	public double checkBalance (int accountID) {
		if (!isAccount(accountID)) return 0.0;
		return allAccounts.get(accountID).getBalance();
	} 
	
	private boolean isAccount (int id) {
		return allAccounts.containsKey(id);
	}
	
	public boolean depositMoney (int id, double amount) {
		if (!isAccount(id)) return false;
		account acc = allAccounts.get(id);
		acc.setBalance(acc.getBalance()+amount);
		return true;
	}
	
	public boolean withdrawMoney (int accountID, double amount) {
		if (!isAccount(accountID)) return false;
		account acc = allAccounts.get(accountID);
		if (acc.getBalance()<amount) return false;
		else {
			acc.setBalance(acc.getBalance()-amount);
			return true;
		}
	}
	
	
}
