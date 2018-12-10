package mp;

public class SavingsAccount extends BankAccount{
	private double interestRate;
	private String accountType; 
	
	public SavingsAccount(int accountNo, String accountName, double  balance, double interestRate) {
		super(accountNo, accountName, balance);
		this.interestRate = interestRate;
	}
	
	public SavingsAccount(String accountName ,double initBalance, double interestRate, String accountType) {
		super(accountName, initBalance);
		this.interestRate = interestRate;
		this.accountType = accountType;
	}

	public SavingsAccount(int accountNo, String accountName , double balance, double interestRate, String accountType) {
		super(accountNo, accountName, balance);
		this.interestRate = interestRate;
		this.accountType = accountType;
	}
	
	
	public double getInterestRate() {
		return interestRate;
	}
	public String accountType() {
		return accountType;
	}

}
