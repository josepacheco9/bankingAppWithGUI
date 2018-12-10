package mp;

public class CheckingAccount extends BankAccount{
	private double overdraftProtection;
	private String accountType;
	
	public CheckingAccount(int accountNo, String accountName){
		super(accountNo, accountName);
	}
	public CheckingAccount(String accountName, double initBalance, 
			double overdraftProtection, String accountType){
		super(accountName,initBalance);
		this.overdraftProtection = overdraftProtection;
		this.accountType = accountType;
	}
	
	public CheckingAccount(int accountNo, String accountName, double balance, 
			double overdraftProtection, String accountType){
	super(accountNo, accountName, balance);
	this.overdraftProtection = overdraftProtection;
	this.accountType = accountType;
}
	
	public boolean withdraw(double amount) {
		if(balance <= 0) {
			return false;
		}
		
		if(balance >= amount) {
			balance -= amount;
			return true;
		}else if ((overdraftProtection+balance) >= amount) {
			balance -= amount;
			return true;
		} 
		return false;
	}
	
	
	public double getOverdraftProtection() {
		return overdraftProtection;
	}
	public String getAccountType() {
		return accountType;
	}
}
