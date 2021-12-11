package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Book;
import model.Chapter;

public class MainScreenController {

	/* BUTTON */
	
	private Button NewBookID;
	private Button NewChapterID;
	private Button AddCoverID;
	/* TABLE VIEW */
	private TableView<Book> TableBookID;
	private TableView<Chapter> TableChapterID;

	/* COLUMN */
	private TableColumn <Chapter, String> ChapterNumberID;
	private TableColumn <Chapter, String> ChapterNameID;
	private TableColumn <Chapter, String> ChapterStatusID;
}
