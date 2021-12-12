package controller;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Author;
import model.Book;
import model.Chapter;
import model.IDAO.DAOException;
import model.MariaDBDAO.AuthorImpMariaDB;
import model.MariaDBDAO.BookImpMariaDB;
import model.MariaDBDAO.BookcoverImpMariaDB;


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

	/* COLUMN */
	@FXML
	private TableColumn <Book, String> BookTitleID;
	@FXML
	private TableColumn <Chapter, String> ChapterNumberID;
	@FXML
	private TableColumn <Chapter, String> ChapterNameID;
	@FXML
	private TableColumn <Chapter, String> ChapterStatusID;
	
	/* LABEL */
	@FXML
	private Label NameAuthorID;
	
	@FXML
	protected void initialize() {
		comprobaconAutor(author);
		welcomeAuthor(author);
		//showBooks();
		
		try {
			List<Book> lista = BookImpMariaDB.getBookByAuthor(author);
			lista.toString();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
	
	/*CONFIGURAR TABLA*/
	/*
	private void configurarTablaBooks() {
		BookTitleID.setCellValueFactory(cadalista -> {
            SimpleStringProperty v = new SimpleStringProperty();
            v.setValue(cadalista.getValue().getTitle());
            return v;
        });
		    
    }
	/*
	private void showBooks() {
		configurarTablaBooks();
		try {
			ObservableList<Book>lista = FXCollections.observableArrayList(BookImpMariaDB.getBookByAuthor(author));
			TableBookID.setItems(lista);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	
	
}
