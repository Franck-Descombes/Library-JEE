package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.IDaoBook;
import fr.afpa.javaee.library.model.Author;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Catalog;

public class ServiceBook implements IServiceBook {

	private IDaoBook iDaoBook;
	private ArrayList<Book> myBookList = new ArrayList<Book>(); // book list

	// CONSTRUCTOR
	public ServiceBook(IDaoBook myDaoBook) {
		this.iDaoBook = myDaoBook;
	}

	// METHODS
	public void addBook(long isbn, String title, String subtitle, boolean available, int nbCopy, int idAuthor,
			int idCatalog) {
		iDaoBook.addBook(isbn, title, subtitle, available, idAuthor, nbCopy, idCatalog);
	}

	public Book getOneBook(long isbn) {
		return iDaoBook.getOneBook(isbn);
	}

	public ArrayList<Book> getAllBooks() {
		return iDaoBook.getAllBooks();
	}

	public void updateBook(long isbn, String title, String subtitle, int available, Author author, Catalog catalog) {
		iDaoBook.updateBook(isbn, title, subtitle, available, author, catalog);
	}

	public void deleteBook(long isbn) {
		iDaoBook.deleteBook(isbn);
	}

}
