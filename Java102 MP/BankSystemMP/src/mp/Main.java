package mp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 490, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(52, 113, 149, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFindAccount = new JButton("Find Account");
		btnFindAccount.setBounds(52, 178, 149, 53);
		frame.getContentPane().add(btnFindAccount);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(52, 243, 149, 53);
		frame.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(52, 308, 149, 53);
		frame.getContentPane().add(btnWithdraw);
		
		JButton btnRolloverTdAccount = new JButton("Rollover TD Account");
		btnRolloverTdAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRolloverTdAccount.setBounds(52, 373, 149, 53);
		frame.getContentPane().add(btnRolloverTdAccount);
		
		JButton btnTerminateAccount = new JButton("Terminate Account");
		btnTerminateAccount.setBounds(279, 113, 149, 53);
		frame.getContentPane().add(btnTerminateAccount);
		
		JButton btnUpdateAccount = new JButton("Update Account");
		btnUpdateAccount.setBounds(279, 178, 149, 53);
		frame.getContentPane().add(btnUpdateAccount);
		
		JButton btnPrintToFile = new JButton("Print to File Summary");
		btnPrintToFile.setBounds(279, 243, 149, 53);
		frame.getContentPane().add(btnPrintToFile);
		
		JButton btnDisplayAllAccounts = new JButton("Display All Accounts");
		btnDisplayAllAccounts.setBounds(279, 308, 149, 53);
		frame.getContentPane().add(btnDisplayAllAccounts);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(279, 373, 149, 53);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("Menu Options");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 44, 174, 57);
		frame.getContentPane().add(lblNewLabel);
	}

}
