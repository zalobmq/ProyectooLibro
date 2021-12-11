package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML 
	private TextField EmailID;
	
	@FXML
	private PasswordField PasswordID;
	
	@FXML 
	private Button loginID;
	
	@FXML 
	private Button SignUpID;
	
	private String email,password;
}
