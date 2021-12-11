package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import model.Landscape;
import model.Note;

public class EditScreenController {

	/* BUTTON */
	@FXML
	private Button NewNote;
	@FXML
	private Button NewCharacter;
	@FXML
	private Button NewPlace;
	@FXML
	private Button Update;
	@FXML
	private Button SaveInTheCloud;
	
	/* TEXT AREA */
	@FXML
	private TextArea TextAreaID;
	
	/* LABEL */
	//--------------------------------
	
	/*
	 * Puede ser el nombre de personaje o del lugar.
	 * */
	@FXML
	private Label Value1TitleID;	
	@FXML
	private Label Value1ContentID;
	
	/*
	 * Puede ser el la edad del personaje o la localizacion del lugar.
	 * */
	@FXML
	private Label Value2TitleID;
	@FXML
	private Label Value2ContentID;
	
	/*
	 * Puede la descripcion del peronaje o de el lugar.
	 * */
	@FXML
	private Label Value3TitleID;
	@FXML
	private Label Value3ContentID;
	
	/* LIST VIEW */
	@FXML
	private ListView<?> ListCharactersID;	//RELLENAR LUEGO 
	@FXML
	private ListView<Landscape> ListPlacesID;
	@FXML
	private ListView<Note> ListNotesID;
	
	
	
	
	
}
