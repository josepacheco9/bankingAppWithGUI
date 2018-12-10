package mp;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//import bank.controllers.LoginController;

import java.text.SimpleDateFormat;

// Java102 Machine Problem

public class TestApp {
	private static Scanner sc;
	private static Accounts accounts = null;
	
	public static void main(String[] args) throws IOException {
		
		new LoginController();
		
		sc = new Scanner(System.in);

		accounts = Accounts.getInstance();

		boolean lContinue = true;
		while (lContinue) {
			switch (getMenu()) {
			case '1':
				createNewAccount();
				break;
			case '2':
				findAcct();
				break;
			case '3':
				makeDeposit();
				break;
			case '4':
				makeWithdrawal();
				break;
			case '5':
				rolloverAccount();
				break;
			case '6':
				terminateAccount();
				break;
			case '7':
				updateAccount();
				break;
			case '8':
				displayDatabaseReport();
				break;
			case '9':
				logOperationSummary();
				break;	
			case 'X':
				lContinue = false;
				break;
			default:
				System.out.println("\nInvalid option...");
			}
		}
		System.out.println("End of program...");
	}
	
	private static char getMenu() {
		char option = 'X';
		System.out.println("\n\n ==========================================");
		System.out.println(" |       Banking App Menu Options         |");
		System.out.println(" ==========================================");
		System.out.println(" *  Create a New Account ----------- <1>  *");
		System.out.println(" *  Find Account ------------------- <2>  *");
		System.out.println(" *  Deposit (CA & SA) -------------- <3>  *");
		System.out.println(" *  Withdraw ----------------------- <4>  *");
		System.out.println(" *  Roll over TD Account ----------- <5>  *");
		System.out.println(" *  Terminate Account -------------- <6>  *");
		System.out.println(" *  Update Account ----------------- <7>  *");
		System.out.println(" *  Display Report of All Accounts - <8>  *");
		System.out.println(" *  Summarize the Day's Operations - <9>  *");
		System.out.println(" *  Exit --------------------------- <X>  *");
		System.out.println(" ==========================================");
		System.out.print("\n               Select Option: ");
		option = Character.toUpperCase(sc.nextLine().charAt(0));
		System.out.println("\n Option = " + option);
		return option;
	}
	private static void createNewAccount() {
		//System.out.print("\nAccount Number: ");
		//String acctNo = sc.nextLine();
		System.out.print("Account Name: ");
		String acctName = sc.nextLine();
		System.out.print("Account Type -- [S] for Savings, [T] for Time Deposit, [C] for Checking) : ");
		String acctType = sc.nextLine();

		System.out.print("Initial Balance: ");
		BankAccount acc = null;
		double bal = Double.parseDouble(sc.nextLine());

		if (Character.toUpperCase(acctType.charAt(0)) == 'S') {
			System.out.print("Interest Rate: ");
			double intRate = Double.parseDouble(sc.nextLine());
			acc = new SavingsAccount(acctName, bal, intRate, acctType);
			System.out.printf("Current Balance is now %10.2f\n", acc.getBalance());
			// save account
			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "INSERT INTO bkAcc (accountName, balance, "
						+ "interestRate, accountType) VALUES (\'" +  acctName + "\' , \'" + 
						bal + "\' , \'" + intRate + "\' , \'" +  acctType + "\');" ;
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
				}
			}
			System.out.println("Savings Account details successfully entered!");
		} 
		
		else if (Character.toUpperCase(acctType.charAt(0)) == 'T'){
			System.out.print("Term (in days) -- Select <30>, <60>, <90>, <180> or <360> : ");
			int ter =  Integer.parseInt(sc.nextLine());
			System.out.print("Maturity (yyyy-mm-dd) : ");
			String mat = sc.nextLine();
			System.out.print("Interest Rate: ");
			double intRate = Double.parseDouble(sc.nextLine());
			acc = new TimedepositAccount(acctName, bal, mat, ter, intRate, 
					acctType);
			System.out.printf("Current Balance is now %10.2f\n", acc.getBalance());
			// save account
			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "INSERT INTO bkAcc (accountName, balance, "
						+ "maturity, term, interestRate, accountType) VALUES (\'" +  acctName + "\' , \'" + 
						bal + "\' , \'" + mat + "\' , \'" + ter + "\' , \'" + intRate + "\' , \'" +  acctType + "\');" ;
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
				}
			}
			System.out.println("Time Deposit Account details successfully entered!");
		}
		
		else if (Character.toUpperCase(acctType.charAt(0)) == 'C'){
			System.out.print("Overdraft Protection: ");
			double overdraftProt = Double.parseDouble(sc.nextLine());
			acc = new CheckingAccount(acctName, bal, overdraftProt, acctType);
			System.out.printf("Current Balance is now %10.2f\n", acc.getBalance());
			// save account
			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "INSERT INTO bkAcc (accountName, balance, "
						+ "overdraftProtection, accountType) VALUES (\'" + acctName + "\' , \'" +
						bal + "\' , \'" + overdraftProt + "\' , \'" + acctType + "\');"; 
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
				}
			}
			System.out.println("Checking Account details successfully entered!");
		}

/*		if (acc != null) {
			accounts.addAccount(acc);
		}*/
	}	
	
	public static BankAccount findAcct() {
		System.out.print("Enter account number: ");
		String acctNo = sc.nextLine();
		System.out.println("Account Type (<S> for Savings, <T> for Time Deposit, <C> for Checking): ");
		String accType = sc.nextLine();
		
		BankAccount acct = null;
		Connection conn = null;
		try {
			Class.forName(Connect.DRIVER);
			conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
					Connect.USERNAME, Connect.PASSWORD);
			
			if (Character.toUpperCase(accType.charAt(0)) == 'S') {
				Statement stmt = conn.createStatement();
				String query = "SELECT accountNo, accountName, balance, interestRate, accountType from bkAcc "
						+ "WHERE accountNo = " + acctNo;
				ResultSet rs = stmt.executeQuery(query);
				if(rs.first()) {
					acct = new SavingsAccount(rs.getInt("accountNo"), 
							rs.getString("accountName"), rs.getDouble("balance"), rs.getDouble("interestRate"),
							rs.getString("accountType"));
					System.out.println("Account No.: " + rs.getString("accountNo") + " Account Name: " + rs.getString("accountName")
							+ " Account Balance: " + rs.getDouble("balance") + " Interest Rate: " + rs.getDouble("interestRate")
							+ " Account Type: "	+ rs.getString("accountType"));
				}
				
			} else if (Character.toUpperCase(accType.charAt(0)) == 'T') {
				Statement stmt = conn.createStatement();
				String query = "SELECT accountNo, accountName, balance, maturity, term, interestRate, accountType from bkAcc "
					+ "WHERE accountNo = " + acctNo;
				ResultSet rs = stmt.executeQuery(query);
				if(rs.first()) {
					acct = new TimedepositAccount(rs.getInt("accountNo"), 
							rs.getString("accountName"), rs.getDouble("balance"), rs.getString("maturity"),
							rs.getInt("term"), rs.getDouble("interestRate"), rs.getString("accountType"));
					System.out.println("Account No.: " + rs.getString("accountNo") + " Account Name: " + rs.getString("accountName")
							+ " Account balance: " + rs.getDouble("balance") + " Maturity: " + rs.getString("maturity") 
							+ " Term: " + rs.getInt("term") +  " Interest Rate: " + rs.getDouble("interestRate")
							+ " Account Type: " + rs.getString("accountType"));
				}
			} else if (Character.toUpperCase(accType.charAt(0)) == 'C') {
				Statement stmt = conn.createStatement();
				String query = "SELECT accountNo, accountName, balance, overdraftProtection, accountType from bkAcc "
					+ "WHERE accountNo = " + acctNo;
				ResultSet rs = stmt.executeQuery(query);
				if(rs.first()) {
					acct = new CheckingAccount(rs.getInt("accountNo"), 
							rs.getString("accountName"), rs.getDouble("balance"),
							rs.getDouble("overdraftProtection"), rs.getString("accountType"));
					System.out.println("Account No.: " + rs.getString("accountNo") + " Account Name: " + rs.getString("accountName")
							+ " Account balance: " + rs.getDouble("balance") +  " Overdraft Protection: "
							+ rs.getDouble("overdraftProtection")	+ " Account Type: " + rs.getString("accountType"));
				}
			}
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());			
		} finally {
			try {
				conn.close();
			} catch(Exception ex) {	
			}
		}
		return acct;
	}

		
	private static void makeDeposit() {
	
		BankAccount acct;
		acct = findAcct();
		if (acct != null) {
			boolean result = false;
			double amount;	
			System.out.print("Amount to deposit: ");
			amount = Double.parseDouble(sc.nextLine());
			result = acct.deposit(amount);
			// save account
			displayTransactionResult(acct, 'D', result);
			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "UPDATE bkAcc SET balance = " + acct.getBalance() + 
					" WHERE accountNo = " + acct.getAccountNo(); 
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
				System.out.println("The new balance is " + acct.getBalance());
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
					}
			}
		} else {
			System.out.println("\nAccount not found!");
		}
		
	}
	public static void displayTransactionResult(BankAccount acc, char tranType, boolean result) {
		System.out.println("\n" + (tranType == 'D' ? "Deposit" : "Withdrawal") + " for account [" + acc.getAccountName()
				+ "] " + (result ? "successful" : "failed"));
		System.out.printf("Current Balance is now %10.2f\n", acc.getBalance());
	}
	
	private static void makeWithdrawal() {

		BankAccount acct;
		acct = findAcct();

		if (acct != null) {
			double amount = 0;
			boolean result = false;

			System.out.print("Amount to withdraw: ");
			amount = Double.parseDouble(sc.nextLine());
			result = acct.withdraw(amount);
			System.out.printf("Current Balance is now %10.2f\n", acct.getBalance());
			// save account
			displayTransactionResult(acct, 'W', result);
			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "UPDATE bkAcc SET balance = " + acct.getBalance() + 
						" WHERE accountNo = " + acct.getAccountNo(); 
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
				}
			}
		} else {
			System.out.println("\nAccount not found!");
		}

	}
	private static void updateAccount() {
		System.out.print("Enter Account Number: ");
		String accNo = sc.nextLine();
		System.out.println("Account Type ([S] for Savings, [T] for Time Deposit, [C] for Checking): ");
		String accType = sc.nextLine();


			Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				if (Character.toUpperCase(accType.charAt(0)) == 'S') {
					System.out.println("Field to update (Account Name[N], Balance[B], Interest Rate[I],"
							+ "Account Type[T] : ");
					String sav = sc.nextLine();
					if (Character.toUpperCase(sav.charAt(0)) == 'N') {
						System.out.println("New Account Name: ");
						String newName = sc.nextLine();
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountName = " + "\'" +  newName + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;"; 
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(sav.charAt(0)) == 'B') {
						System.out.println("New Account Balance: ");
						double newBal = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET balance = " + newBal + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(sav.charAt(0)) == 'I') {
						System.out.println("New Interest Rate: ");
						double newInt = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET interestRate = " + newInt + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(sav.charAt(0)) == 'T') {
						System.out.println("New Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
						String newType = sc.nextLine();
						// fixing
						if ((Character.toUpperCase(newType.charAt(0)) != 'S') && (Character.toUpperCase(newType.charAt(0)) != 'T') && (Character.toUpperCase(newType.charAt(0)) != 'C')) {
							System.out.println("Re-enter Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
							newType = sc.nextLine();
							Statement stmt = conn.createStatement();
							String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
								" WHERE accountNo = " + "\'" + accNo +  "\' ;";
							System.out.println(insertQuery);		
							records = stmt.executeUpdate(insertQuery);
						} else {
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
						}
					}
				} else if (Character.toUpperCase(accType.charAt(0)) == 'T') {
					System.out.println("Field to update (Account Name[N], Balance[B], Maturity[M],"
							+ "Term[R], Interest Rate[I], Account Type[P]) : ");
					String tdp = sc.nextLine();		
					if (Character.toUpperCase(tdp.charAt(0)) == 'N') {
						System.out.println("New Account Name: ");
						String newName = sc.nextLine();
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountName = " + "\'" +  newName + "\'" +
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(tdp.charAt(0)) == 'B') {
						System.out.println("New Account Balance: ");
						double newBal = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET balance = " + newBal + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(tdp.charAt(0)) == 'M') {
						System.out.println("New Maturity Date (yyyy-mm-dd) : ");
						String newMat = sc.nextLine();
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET maturity = " + "\'" + newMat + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(tdp.charAt(0)) == 'R') {
						System.out.println("New Term ( <30>, <60>, <90>, <180> or <360> )  : ");
						double newTerm = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET term = " + newTerm + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(tdp.charAt(0)) == 'I') {
						System.out.println("New Interest Rate: ");
						double newInt = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET interestRate = " + newInt + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(tdp.charAt(0)) == 'P') {
						System.out.println("New Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
						String newType = sc.nextLine();
						// fixing
						if ((Character.toUpperCase(newType.charAt(0)) != 'S') && (Character.toUpperCase(newType.charAt(0)) != 'T') && (Character.toUpperCase(newType.charAt(0)) != 'C')) {
							System.out.println("Re-enter Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
							newType = sc.nextLine();
							Statement stmt = conn.createStatement();
							String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
								" WHERE accountNo = " + "\'" + accNo +  "\' ;";
							System.out.println(insertQuery);		
							records = stmt.executeUpdate(insertQuery);
						} else {
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
						}
					}
				} else if (Character.toUpperCase(accType.charAt(0)) == 'C') {
					System.out.println("Field to update (Account Name[N], Balance[B],"
							+ "OverdraftProtection[O], Account Type[P]");
					String chk = sc.nextLine();
					if (Character.toUpperCase(chk.charAt(0)) == 'N') {
						System.out.println("New Account Name: ");
						String newName = sc.nextLine();
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountName = " + "\'" + newName + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(chk.charAt(0)) == 'B') {
						System.out.println("New Account Balance: ");
						double newBal = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET balance = " + newBal + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(chk.charAt(0)) == 'O') {
						System.out.println("New OverdraftProtection: ");
						double newOverDP = Double.parseDouble(sc.nextLine());
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET overdraftProtection = " + newOverDP + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
					} else if (Character.toUpperCase(chk.charAt(0)) == 'P') {
						System.out.println("New Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
						String newType = sc.nextLine();
						// fixing
						if ((Character.toUpperCase(newType.charAt(0)) != 'S') && (Character.toUpperCase(newType.charAt(0)) != 'T') && (Character.toUpperCase(newType.charAt(0)) != 'C')) {
							System.out.println("Re-enter Account Type -- [S] for Savings, [T] for Time Deposit or [C] for Checking : ");
							newType = sc.nextLine();
							Statement stmt = conn.createStatement();
							String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
								" WHERE accountNo = " + "\'" + accNo +  "\' ;";
							System.out.println(insertQuery);		
							records = stmt.executeUpdate(insertQuery);
						} else {
						Statement stmt = conn.createStatement();
						String insertQuery = "UPDATE bkAcc SET accountType = " + "\'" + newType + "\'" + 
							" WHERE accountNo = " + "\'" + accNo +  "\' ;";
						System.out.println(insertQuery);		
						records = stmt.executeUpdate(insertQuery);
						}
					}
				}
			} catch(Exception ex) { 
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
					}
					System.out.println("Account number " + accNo + " successfully updated!");
			}

	}
	
	private static void terminateAccount() {
		System.out.println("Account Number to terminate: ");
		String accNo = sc.nextLine();
		
		Connection conn = null;
			int records = 0;
			try {
				Class.forName(Connect.DRIVER);
				conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
						Connect.USERNAME, Connect.PASSWORD);
				
				Statement stmt = conn.createStatement();
				String insertQuery = "DELETE FROM bkAcc WHERE accountNo = " + "\'" + accNo + "\'"; 
				System.out.println(insertQuery);		
				records = stmt.executeUpdate(insertQuery);
			} catch(Exception ex) {
				System.out.println("Error: " + ex.getMessage());			
			} finally {
				try {
					conn.close();
				} catch(Exception ex) {	
					}
			System.out.println("Account Number [" + accNo + "] successfully terminated!");
			
			} 
	}
	
	private static void rolloverAccount() {

		System.out.println("Enter Account Number to Rollover: ");
		String accNo = sc.nextLine();
		System.out.println("Enter new Maturity Date <yyyy-mm-dd> : ");
		String mat = sc.nextLine();
		
		Connection conn = null;
		int records = 0;
		try {
			Class.forName(Connect.DRIVER);
			conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
					Connect.USERNAME, Connect.PASSWORD);
			
			Statement stmt = conn.createStatement();
			String insertQuery = "UPDATE bkAcc SET maturity = " + "\'" + mat + "\'"  +
					" WHERE accountNo = " + "\'" +  accNo + "\'"; 
			System.out.println(insertQuery);		
			records = stmt.executeUpdate(insertQuery);
			
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());			
		} finally {
			try {
				conn.close();
			} catch(Exception ex) {	
			}
			System.out.println("Account Number: " + accNo + " successfully rolled over!");
			System.out.println("New Maturity Date: " + mat);
		}
	}
	
	public static void logOperationSummary() throws IOException {
		// This method will write to the log.txt file with a 
		// current date and time.

		System.out.println("Enter the operation to be logged: ");
		Scanner sc = new Scanner (System.in);
		while (sc.hasNext()) {
			String op = sc.nextLine();
		
			 String timeStamp = new SimpleDateFormat("( yyyy.MM.dd.HH.mm.ss ) ").format(new java.util.Date());
			 StringBuffer name = new StringBuffer(timeStamp);
			 StringBuffer name1 = name;
			 name1.append(op);			 
			 System.out.println(name1);
			 System.out.print("Enter file name: ");
			 Scanner logger = new Scanner (System.in);
			 String log = logger.nextLine();
			 String fileName = log;
			 FileWriter file = null;
			 try {
				 file = new FileWriter(fileName);            
	            PrintWriter pw = new PrintWriter(file);
	            pw.println(name1);               
	            pw.flush();
	            System.out.println("Summary Report successfully logged to " + log +" file!");
	            pw.close();
	        } catch(FileNotFoundException ex) {
	            System.out.println("File not found....");
	        } finally {
	            file.close();
	            
	        }
			return;
		}
		
	}
	
	

	
	private static void displayDatabaseReport() {
		Connection conn = null;
		int records = 0;
		Statement stmt = null;
	    String query =
	        "SELECT accountNo, accountName, balance, maturity, term, interestRate, accountType " +
	        "FROM  bkacc ORDER BY accountNo;";
		
		try {
			Class.forName(Connect.DRIVER);
			conn = DriverManager.getConnection(Connect.CONNECTION_STRING,
					Connect.USERNAME, Connect.PASSWORD);
			
 					stmt = conn.createStatement();
 					ResultSet rs = stmt.executeQuery(query);
 					while (rs.next()) {
 						String acctnum = rs.getString("accountNo");
 						String acctname = rs.getString("accountName");
 						double balan = rs.getDouble("balance");
 						String accttype = rs.getString("accountType");
 						System.out.println("A/C Number: " + acctnum + "\t" + "A/C Name: " + acctname +
 								"\t" + "Balance: " + balan + "\t"  +
 								 "A/C Type: " + accttype);
 					}
					
		} catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());			
		} finally {
			try {
				conn.close();
			} catch(Exception ex) {	
			}
		}
	}
}
