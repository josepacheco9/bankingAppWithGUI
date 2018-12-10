package mp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class CreateNewAccount {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount window = new CreateNewAccount();
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
	public CreateNewAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(40, 105, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(214, 93, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setBounds(40, 145, 119, 16);
		frame.getContentPane().add(lblCurrentBalance);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 133, 134, 28);
		frame.getContentPane().add(textField_1);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setBounds(40, 194, 103, 16);
		frame.getContentPane().add(lblAccountType);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 182, 134, 28);
		frame.getContentPane().add(textField_2);
		
		JLabel lblTerm = new JLabel("Term:");
		lblTerm.setBounds(40, 246, 61, 16);
		frame.getContentPane().add(lblTerm);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 234, 134, 28);
		frame.getContentPane().add(textField_3);
		
		JLabel lblMaturity = new JLabel("Maturity:");
		lblMaturity.setBounds(40, 297, 61, 16);
		frame.getContentPane().add(lblMaturity);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(214, 285, 134, 28);
		frame.getContentPane().add(textField_4);
		
		JLabel lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setBounds(40, 352, 103, 16);
		frame.getContentPane().add(lblInterestRate);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(214, 340, 134, 28);
		frame.getContentPane().add(textField_5);
		
		JLabel lblOverdraftProtection = new JLabel("Overdraft Protection:");
		lblOverdraftProtection.setBounds(40, 408, 134, 16);
		frame.getContentPane().add(lblOverdraftProtection);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(214, 396, 134, 28);
		frame.getContentPane().add(textField_6);
		
		lblNewLabel_1 = new JLabel("Create New Account");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(167, 44, 276, 28);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
