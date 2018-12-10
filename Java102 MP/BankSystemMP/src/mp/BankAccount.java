package mp;

public abstract class BankAccount {
	private int accountNo;
	private String accountName;
	protected double balance;
	
	public BankAccount( String accountName, double initBalance) {
		this.accountName = accountName;
		this.balance = initBalance;
	}	
	
	public BankAccount( int accountNo, String accountName, double initBalance) {
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = initBalance;
	}
	
/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//if (getClass() != obj.getClass())
		//	return false;
		if(!(obj instanceof BankAccount)) {
			return false;
		}
		
		BankAccount other = (BankAccount) obj;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNo == 0) {
			if (other.accountNo != 0)
				return false;
		} else if (!(accountNo == (other.accountNo)))
			return false;
		return true;
	}

	public BankAccount(int accountNo, String accountName) {
		this.accountNo = accountNo;
		this.accountName = accountName;
	}
	
	public boolean withdraw(double amount) {
		if(balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public boolean deposit(double amount) {
		balance += amount;
		return true;
	}
	
	public double getBalance() {
		return balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}
}
