package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

	/* TEXT FIELD */
	@FXML 
	private TextField FirstNameID;
	@FXML 
	private TextField LastNameID;
	@FXML 
	private TextField EmailID;
	
	/* PASSWORD FIELD */
	@FXML
	private PasswordField PasswordID;
	
	/* BUTTON */
	@FXML
	private Button Login;
	
	/* VARIABLES */
	private String firstName,lastName,email,password;
}
