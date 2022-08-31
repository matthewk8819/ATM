
public class account {
	private int id;
	
	private double balance; 
	
	public account(int id) {
		this.id = id;
		balance = 0;
	}
	
	public account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getID () {
		return id;
	}
	
	public double getBalance () {
		return balance;
	}
}
