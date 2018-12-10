package mp;

import java.util.Hashtable;
import java.util.Map;


public class Accounts {
	private Map<String,BankAccount> data;
	private static Accounts accounts;
	
	public static Accounts getInstance() {
		return (accounts!=null ? accounts : new Accounts());
	}
	
	private Accounts() {
		data = new Hashtable<>();
	}
	
/*	public boolean addAccount(BankAccount acc) {
		boolean result = data.(acc.getAccountNo(), acc) == null ? false: true;
		return result;
	}*/
	
	public boolean closeAccount(BankAccount acc) {
		return false;
	}
	
	public boolean withdraw(String accNo, double amount) {
		BankAccount acc = findAccount(accNo);
		if( acc != null ) {
			acc.withdraw(amount);
			return true;
		}
		return false;
	}
	
	public boolean deposit(String accNo, double amount) {
		BankAccount acc = findAccount(accNo);
		if( acc != null ) {
			acc.deposit(amount);
			return true;
		}
		return false;
	}

	public BankAccount findAccount(String accNo)  {
		BankAccount acc = null;
		if(data.containsKey(accNo)) {
			acc = data.get(accNo);
		}
		return acc;
	}
	
	public Map<String, BankAccount> getAllAccounts() {
		return data;
	}
	
	
}
