package mp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Deposit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 667, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String username = "jojo";
		String password = "ako";
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log in");
		
		JLabel lblNewLabel = new JLabel("Username");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String usernameFieldValue = textField.getText();
				 System.out.println(textField.getText());
				 String user = usernameFieldValue;
				 System.out.println(textField_1.getText());
				 String passwordFieldValue = textField_1.getText();
				 String pass = passwordFieldValue;
				 
				 if (user.equals(username)){ 
					 System.out.println("It's me!");
				 } else {
					 System.out.println("It's not me!");
				 }
				 if (pass.equals(password)){ 
					 System.out.println("Password correct!");
				 } else {
					 System.out.println("Password not correct!");
				 }

				 
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		
			
				//String passwordFieldValue = textField_1.getText();
				 
			
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblAccountName = new JLabel("Account name");
		
		JLabel lblBalance = new JLabel("Balance");
		
		JLabel lblAccountType = new JLabel("Account Type");
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		
		JLabel lblMaturity = new JLabel("Maturity");
		
		JLabel lblTerm = new JLabel("Term");
		
		JLabel lblOverdraftProtection = new JLabel("Overdraft Protection");
		
	
		
		btnNewButton_1 = new JButton("enter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accountNameFieldValue = textField_2.getText();
				 System.out.println(textField_2.getText());
				 String balanceFieldValue = textField_3.getText();
				 System.out.println(textField_3.getText());
				 String accountTypeFieldValue = textField_4.getText();
				 System.out.println(textField_4.getText());
				 String interestRateFieldValue = textField_5.getText();
				 System.out.println(textField_5.getText());
				 String maturityFieldValue = textField_6.getText();
				 System.out.println(textField_6.getText());
				 String termFieldValue = textField_7.getText();
				 System.out.println(textField_7.getText());
				 String overdraftProtectionFieldValue = textField_8.getText();
				 System.out.println(textField_8.getText());		
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblInterestRate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblBalance, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAccountName, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAccountType, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblMaturity, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(lblOverdraftProtection, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(lblTerm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_2)
							.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addComponent(textField)
							.addComponent(btnNewButton)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
					.addGap(309))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBalance))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountType))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInterestRate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaturity, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTerm, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOverdraftProtection, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
