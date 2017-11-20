package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Author;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Catalog;

public interface IServiceBook {

	public void addBook(long isbn, String title, String subtitle, boolean available, int nbCopy, int idAuthor,
			int idCatalog);

	public ArrayList<Book> getAllBooks();

	public Book getOneBook(long isbn);

	public void updateBook(long isbn, String title, String subtitle, int available, Author author,
			Catalog catalog);

	public void deleteBook(long isbn);

}
