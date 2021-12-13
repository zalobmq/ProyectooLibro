package controller;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Author;
import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;
import model.MariaDBDAO.ChapterImpMariaDB;


public class MainScreenController {

	
	private static  Author author;
	
	/* BUTTON */
	@FXML
	private Button NewBookID;
	@FXML
	private Button NewChapterID;
	@FXML
	private Button AddCoverID;
	/* TABLE VIEW */
	@FXML
	private TableView<Book> TableBookID;
	@FXML
	private TableView<Chapter> TableChapterID;

	 private ObservableList<Chapter> listaCapitulos;
	/* COLUMN */
	@FXML
	private TableColumn <Book, String> BookTitleID;
	@FXML
	private TableColumn <Chapter, String> ChapterNumberID;
	@FXML
	private TableColumn <Chapter, String> ChapterNameID;
	@FXML
	private TableColumn <Chapter, String> ChapterStatusID;
	
	private Book b;
	private Chapter c;
	/* LABEL */
	@FXML
	private Label NameAuthorID;
	
	@FXML
	protected void initialize() {
		comprobaconAutor(author);
		welcomeAuthor(author);
		showBooks();
		
		
	}
	
	public static void setAuthor (Author a) {
		
    	author = a;	
    }
	public void comprobaconAutor(Author a) {
		System.out.println("El author es: "+a.toString());
	}
	/* METODOS */
	
	public void welcomeAuthor(Author a) {
		NameAuthorID.setText(a.getName());
	}
	
	/*METODOS BOTONES*/
	
	public void newBook() {
		
		try {
			App.loadScene(new Stage(), "NewBook", "Add new book");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void newChapter() {
		
		try {
			NewChapterController.setBook(b = TableBookID.getSelectionModel().getSelectedItem());
			App.loadScene(new Stage(), "NewChapter", "Add new chapter");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editChapter() {
		
		try {
			EditScreenController.setChapter(c = TableChapterID.getSelectionModel().getSelectedItem());
			EditScreenController.setBook(b = TableBookID.getSelectionModel().getSelectedItem());
			System.out.println(c.toString());
			App.loadScene(new Stage(), "EditScreen", "Edit chapter");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addCover() {
		try {
			AddCoverController.setBook(b = TableBookID.getSelectionModel().getSelectedItem());
			App.loadScene(new Stage(), "AddCover", "Add Cover");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void infoBook() {
		
		try {
			InfoBookController.setBook(b = TableBookID.getSelectionModel().getSelectedItem());
			App.loadScene(new Stage(), "InfoBook", "Info");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	/*CONFIGURAR TABLA*/
	
	private void configurarTablaBooks() {
		BookTitleID.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadalista.getValue().getTitle());
            return v;
        });
		    
    }
	@FXML
	private void configurarTablaChapter() {
		if(TableBookID.getSelectionModel().getSelectedItem() != null) {
			b = TableBookID.getSelectionModel().getSelectedItem();
			try {
				listaCapitulos = FXCollections.observableArrayList(ChapterImpMariaDB.getChapterByBook(b));
				TableChapterID.setItems(listaCapitulos);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ChapterNumberID.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(""+cadalista.getValue().getChapterNumber());
            return v;
        });
		ChapterNameID.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadalista.getValue().getName());
            return v;
        });
		ChapterStatusID.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            if (cadalista.getValue().isFinish()) {
            v.setValue("Terminado");
            }else {
            	v.setValue("No terminado");
            }
            return v;
        });
		    
    }
	}
	
	
	@FXML
	private void showBooks() {
		configurarTablaBooks();
		try {
			List<Book> booksDB = BookImpMariaDB.getBookByAuthor(author);
			System.out.println(booksDB.toString());
			ObservableList<Book>lista = FXCollections.observableArrayList(booksDB);
			TableBookID.setItems(lista);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		configurarTablaBooks();
		try {
			List<Book> booksDB = BookImpMariaDB.getBookByAuthor(author);
			System.out.println(booksDB.toString());
			ObservableList<Book>lista = FXCollections.observableArrayList(booksDB);
			TableBookID.setItems(lista);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configurarTablaChapter();
	}
	
	
	
	
	
}
