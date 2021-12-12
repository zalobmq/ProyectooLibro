package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Author;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;

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
	
	@FXML
	protected void initialize() {

	}
	
	/* METODOS */
	//Crear un Autor con el que me he registrado
		public Author newAuthor() {
			Author result=new Author();
			try {
				Author a = AuthorImpMariaDB.getByEmail(EmailID.getText());
				result.setId(a.getId());
				result.setName(a.getName());
				result.setSurname(a.getSurname());
				result.setEmail(a.getEmail());
				result.setPassword(a.getPassword());
				result.setbooks_author(a.getbooks_author());
				
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	//Comprobar que el usuario introducido esta registrado
	
	public void Login() {
		
		if(EmailID.getText().length() > 0 && PasswordID.getText().length() > 0) {
		try {
			Author a = AuthorImpMariaDB.getByEmail(EmailID.getText());
		if(a.getId() != -1) {
				if (EmailID.getText().equals(a.getEmail()) &&
					PasswordID.getText().equals(a.getPassword())) {
					
					try {
						MainScreenController.setAuthor(a);
						App.loadScene(new Stage(), "MainScreen", "MAIN");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else if(EmailID.getText().equals(a.getEmail()) &&
						!PasswordID.getText().equals(a.getEmail())) {
					mostrarAlertWarningPassw();
					PasswordID.clear();
				}
		
			}else {
				mostrarAlertWarning();
			}
			
			
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
			
			mostrarAlertErrorEmptyFields();
		}
		
	}
	
	//Cargar ventana Sign-up
	public void signUp() {
		try {
			App.loadScene(new Stage(), "SignUp", "Sign Up");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*ALERTAS*/
	
	@FXML
	private void mostrarAlertErrorEmptyFields() {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setHeaderText(null);
	    alert.setTitle("Error");
	    alert.setContentText("DEBES RELLENAR TODOS LOS CAMPOS");
	    alert.showAndWait();
	}
	 
	@FXML
	private void mostrarAlertInfo() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("AUTOR CREADO CORRECTAMENTE");
	    alert.showAndWait();
	    
	}
	 
	@FXML
	private void mostrarAlertWarningPassw() {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("Contraseña no valida");
	    alert.showAndWait();
	}
	@FXML
	private void mostrarAlertWarning() {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("Error usuario no encontrado, compruebe el correo o registrese");
	    alert.showAndWait();
	}
	 
	@FXML
	private void mostrarAlertConfirmation() {
	    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Confirmacion");
	    alert.setContentText("¿Deseas realmente confirmar?");
	    alert.showAndWait();
	}
	 
	@FXML
	private void mostrarAlertCabecera() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText("Cabecera");
	    alert.setTitle("Info");
	    alert.setContentText("Informacion sobre la aplicación");
	    alert.showAndWait();
	}
}
