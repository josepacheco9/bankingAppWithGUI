package mp;

import javax.swing.SwingUtilities;



public class LoginController {
	private LoginView view;
	
	public LoginController() {
		this.view = new LoginView("Login");
		SwingUtilities.invokeLater(() -> {
			this.login();

		});
	}
	
	public void login() {
		this.view.getLoginBtn().addActionListener((e) -> {			
			String username = this.view.getUsernameField().getText();
			String password = String.valueOf(this.view.getPasswordField().getPassword());
			
			Boolean isValid = User.validateUsernamePassword(username, password);
			
			
			if(isValid) {
				this.view.getErrorMessageLabel().setVisible(false);
				this.view.dispose();
			} else {
				this.view.getErrorMessageLabel().setVisible(true);
			}
		});
		
	}
}
