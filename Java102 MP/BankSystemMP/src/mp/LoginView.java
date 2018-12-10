package mp;

import java.awt.Color;

import javax.swing.*;

public class LoginView extends MainView {
	
	private static final long serialVersionUID = 1L;
	
	JButton loginBtn;
	JTextField usernameField;
	JPasswordField passwordField;
	JLabel usernameLabel, passwordLabel, errorMessageLabel;
	
	public LoginView(String name) {
		super(name);
		loginBtn = new JButton("Login");
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		usernameLabel = new JLabel("username: ");
		passwordLabel = new JLabel("password: ");
		errorMessageLabel = new JLabel("Invalid username or password");
			
		usernameLabel.setBounds(10,10,120,20);
		passwordLabel.setBounds(10,30,120,20);
		
		usernameField.setBounds(140,10,300,20);
		passwordField.setBounds(140,30,300,20);
		
		loginBtn.setBounds(140,55,100,20);
	
		errorMessageLabel.setVisible(false);
		errorMessageLabel.setForeground(Color.RED);
		errorMessageLabel.setBounds(140,80,200,20);
		
		this.add(usernameLabel);
		this.add(passwordLabel);
		this.add(usernameField);
		this.add(passwordField);
		this.add(loginBtn);

		this.add(errorMessageLabel);
				
		this.setVisible(true);
	}
	
	public JLabel getErrorMessageLabel() {
		return this.errorMessageLabel;
	}
	
	public JTextField getUsernameField() {
		return this.usernameField;
	}
	
	public JPasswordField getPasswordField() {
		return this.passwordField;
	}
	
	public JButton getLoginBtn() {
		return this.loginBtn;
	}
	
}
