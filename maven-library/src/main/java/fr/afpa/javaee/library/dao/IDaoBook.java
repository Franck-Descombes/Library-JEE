package fr.afpa.javaee.library.dao;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Author;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Catalog;

public interface IDaoBook {
	public void addBook(long isbn, String title, String subtitle, boolean available, int nbCopy, int idAuthor,
			int idCatalog);

	public Book getOneBook(long id);

	public Book getOneBook(String title, Author author);

	public ArrayList<Book> getAllBooks();

	public void updateBook(long isbn, String title, String subtitle, int available, Author author, Catalog catalog);

	public void deleteBook(long Isbn);
}
