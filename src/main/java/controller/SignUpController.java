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
	@FXML
	protected void initialize() {

	}
	/* METODOS */
	
	//Crear un Autor
	public Author newAuthor() {
		Author result = new Author(FirstNameID.getText(), LastNameID.getText(), PasswordID.getText(), EmailID.getText());
		return result;
	}
	//Id del autor buscado
	public Long idAuthorSeacht(Author a) {
		Long result = 0L;
		try {
			Author aSeacht = AuthorImpMariaDB.getByEmail(EmailID.getText());
			result = aSeacht.getId();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//Comprobar si existe un autor con ese correo,comparando sus id
	public boolean AuthorExists() {
		boolean result = false;
		
			if(idAuthorSeacht(newAuthor()) == -1) {
				result = true;
			}
		return result;
	}
	
	
	public void signUpAuthor() {
		
		//Se deben rellenar todos los campos
		//comprobacion
		if(FirstNameID.getText().length() > 0 &&
			LastNameID.getText().length() > 0 &&
			EmailID.getText().length() > 0 &&
			PasswordID.getText().length() > 0 ) {
			
			//Si existe el autor muestra error y vacia los campos
				if(AuthorExists()) {
					mostrarAlertErrorEmail();
					EmailID.clear();
					PasswordID.clear();
				}else {
					//Si no existe el autor muestra OK y guarfa en la BD	
					try {
						AuthorImpMariaDB.save(newAuthor());	//Guarga en MariaDB
						//Guarda en h2
						mostrarAlertInfo();
						try {
							Stage stage = (Stage) this.Login.getScene().getWindow();
				            stage.close();
							App.loadScene(new Stage(), "Login", "Login");
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (DAOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}else {
			mostrarAlertErrorEmptyFields();
		}
	}
	/*ALERTAS*/
	@FXML
	private void mostrarAlertErrorEmail() {
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setHeaderText(null);
	    alert.setTitle("Error");
	    alert.setContentText("EXISTE UN AUTOR CON ESE CORREO");
	    alert.showAndWait();
	   
	}
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
	private void mostrarAlertWarning() {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setHeaderText(null);
	    alert.setTitle("Info");
	    alert.setContentText("Warning en la aplica");
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
