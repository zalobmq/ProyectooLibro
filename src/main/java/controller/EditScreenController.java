package controller;


import java.util.List;
import java.util.Observable;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import model.Book;
import model.Chapter;
import model.Character;
import model.Landscape;
import model.Note;
import model.IDAO.DAOException;
import model.MariaDBDAO.ChapterImpMariaDB;
import model.MariaDBDAO.CharacterImpMariaDB;
import model.MariaDBDAO.LandscapeImpMariaDB;
import model.MariaDBDAO.NoteImpMariaDB;

public class EditScreenController {

	
	private static  Chapter chapter;
	private static  Book book;
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
	@FXML
	private Label NameChapter;
	@FXML
	private Label NameBook;
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
	
	/* TABLE VIEW */
	@FXML
	private TableView<Character> TableCharacterID;
	@FXML
	private TableView<Landscape> TableLandspaceID;
	@FXML
	private TableView<Note> TableNotesID;
	
	/* TABLE COLUMN */
	@FXML
	private TableColumn<Character, String> 	NameCharacterID;
	@FXML
	private TableColumn<Landscape, String> 	NameLandspaceID;
	@FXML
	private TableColumn<Note, String> 	NameNoteID;
	
	private ObservableList<Character> listaCharacters;
	private ObservableList<Landscape> listaLandspace;
	private ObservableList<Note> listaNotes;

	private Character character;
	private Landscape landSpace;
	private Note note;
	
	
	
	public static void setChapter(Chapter c) {
		
		chapter = c;	
    }
	
	public static void setBook(Book b) {
		
		book = b;	
    }
	
	@FXML
	protected void initialize() {

		NameChapter(chapter);
		NameBook(book);
		mostrarCharacters();
		
		mostrarLandspace();
		mostrarNotes();
		/*
		List<Character> listabdc;
		try {
			System.out.println(book.toString());
			listabdc = CharacterImpMariaDB.getCharacterByBook(book);
			System.out.println(listabdc.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
	@FXML
	public void NameChapter(Chapter c) {
		
		NameChapter.setText(c.getName());
	}
	@FXML
	public void NameBook(Book b) {
		
		NameBook.setText(b.getTitle());
	}
	@FXML
	private void configurarTablaCharacters() {
		
		NameCharacterID.setCellValueFactory(cadaCharacter -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaCharacter.getValue().getName());
            return v;
        });    
    }
	
	@FXML
	private void configurarTablaLandscape() {
		
		NameLandspaceID.setCellValueFactory(cadacoche -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadacoche.getValue().getName());
            return v;
        });    
    }
    
	@FXML
	private void configurarTablaNotes() {
		
		NameNoteID.setCellValueFactory(cadaNote -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadaNote.getValue().getTitle());
            return v;
        });    
    }
	
	public void mostrarCharacters() {
		
		configurarTablaCharacters();
		try {
			List<Character> listabdc = CharacterImpMariaDB.getCharacterByBook(book);
			System.out.println(listabdc.toString());
			listaCharacters = FXCollections.observableArrayList(listabdc);
			TableCharacterID.setItems(listaCharacters);
			System.out.println(listaCharacters.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void mostrarLandspace() {
		
		configurarTablaLandscape();
		try {
			List<Landscape> listbdL = LandscapeImpMariaDB.getLandscapeByBook(book);
			System.out.println(listbdL.toString());
			listaLandspace = FXCollections.observableArrayList(listbdL);
			TableLandspaceID.setItems(listaLandspace);
			System.out.println(listaLandspace.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void mostrarNotes() {
		
		configurarTablaNotes();
		try {
			List<Note> listbdN = NoteImpMariaDB.getNoteByBook(book);
			System.out.println(listbdN.toString());
			listaNotes = FXCollections.observableArrayList(listbdN);
			TableNotesID.setItems(listaNotes);
			System.out.println(listaNotes.toString());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 public void writeLabelCharacter() {
		
	}
	 */
	
	private void newCharacter() {
		
		
	}
	
	
	
	
	
	
	
	
}
