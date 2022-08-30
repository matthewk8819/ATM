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
		return allAccounts.get(accountID).getBalance();
	} 
	
	private boolean isAccount (int id) {
		return allAccounts.containsKey(id);
	}
	
	public boolean withdrawMoney (int accountID, double amount) {
		account acc = allAccounts.get(accountID);
		if (acc.getBalance()<amount) return false;
		else {
			acc.setBalance(acc.getBalance()-amount);
			return true;
		}
	}
	
	
}
