package mp;

public class TimedepositAccount extends BankAccount {
	private String maturity;
	private int term;
	private double interestRate;
	private String accountType;

	public TimedepositAccount(int accountNo, String accountName) {
		super(accountNo, accountName);
	}
	public TimedepositAccount(String accountName, 
			double balance, String maturity, int term, double interestRate, 
			String accountType) {
		super(accountName, balance);
		this.maturity = maturity;
		this.term = term;
		this.interestRate = interestRate;
		this.accountType = accountType;
	}
	public TimedepositAccount(int accountNo, String accountName , 
			double balance, String maturity, int term, double interestRate, 
			String accountType) {
		super(accountNo, accountName, balance);
		this.maturity = maturity;
		this.term = term;
		this.interestRate = interestRate;
		this.accountType = accountType;
	}
	public String getMaturity() {
		return maturity;
	}
	public int getTerm() {
		return term;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public String getAccountType() {
		return accountType;
	}
	public void rolloverAccount() {
		
	}
	public void preterminateAccount() {
		
	}
	
	
	
	

}
