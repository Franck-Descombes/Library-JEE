package test;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.DaoAuthor;
import fr.afpa.javaee.library.dao.DaoBook;
import fr.afpa.javaee.library.dao.DaoCatalog;
import fr.afpa.javaee.library.dao.DaoSubscriber;
import fr.afpa.javaee.library.model.Author;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Catalog;
import fr.afpa.javaee.library.model.Subscriber;

public class main {

	public static void main(String[] args) {

		// CATALOGUE NICKEL
		// DaoCatalog daoCat = new DaoCatalog();
		// ArrayList<Catalog> listCat = daoCat.getAllCatalogs();
		// for (Catalog catalog : listCat) {
		// System.out.println("Le nom du catalogue est : " + catalog.getCatalogName());
		// }
		// Catalog c = daoCat.getOneCatalog(5);
		// System.out.println("le catalogue demandé est : " + c.getCatalogName());
		//
		// Catalog c2 = daoCat.getOneCatalog("Fantastic");
		// System.out.println(("le nom du catalogue demandé est : " + c2.getId()));
		//
		// daoCat.addCatalog("Ludo");
		//
		// daoCat.updateCatalog(13, "Sigrid");
		//
		// daoCat.deleteCatalog(13);

		// AUTHOR NICKEL
		// DaoAuthor daoAuthor = new DaoAuthor();
		// ArrayList<Author> listAuthor = daoAuthor.getAllAuthors();
		// for (Author author : listAuthor) {
		// System.out.println("Voici la liste de tous les auteurs : " +
		// author.getFirstName() +" " + author.getLastName() + " "
		// +" né le : " + author.getDateOfBirth());
		// }
		// Author a = daoAuthor.getOneAuthor(16);
		// System.out.println("L'auteur demandé est : " + a.getFirstName() + " " +
		// a.getLastName());
		//
		// Author a2 = daoAuthor.getOneAuthor("Maurice", "G.DANTEC", "1959-06-13");
		// System.out.println("L'auteur demandé est : " + a2.getId());

		// daoAuthor.addAuthor("Sigrid", "Deramond", "1988-03-03");

		// daoAuthor.updateAuthor(19, "Raynad", "Titeca", "2002-02-28");

		// daoAuthor.deleteAuthor(19);

		// SUBSCRIBER NICKEL
		// DaoSubscriber daoSubscriber = new DaoSubscriber();
		// ArrayList<Subscriber> listSubscriber = daoSubscriber.getAllSubscribers();
		// for (Subscriber subscriber : listSubscriber) {
		// System.out.println("Voici la liste de tous les emprunteurs : " +
		// subscriber.getFirstName() +" " + subscriber.getLastName());
		// }
		//
		// Subscriber s = daoSubscriber.getOneSubscriber(7);
		// System.out.println("l'emprunteur demandé est : " + s.getFirstName() + " " +
		// s.getLastName());
		//
		// daoSubscriber.addSubscriber("Sigrid", "Deramond");
		//
		// daoSubscriber.updateSubscriber(5, "bla", "bli");
		//
		// daoSubscriber.deleteSubscriber(11);

		// BOOK
		DaoBook daoBook = new DaoBook();
		ArrayList<Book> listBook = daoBook.getAllBooks();
		for (Book book : listBook) {
			// System.out.println("Voici la liste de tous les livres : " + book.getTitle() +
			// " " + " écrit par " + book.getAuthor());
		}

//		Book b = daoBook.getOneBook(9780241107711L);
//		System.out.println("Le livre demandé est : " + b.getTitle() + " " + b.getAuthor());

//		 daoBook.addBook(9780241107002L, "The Git", null, 17, 3);
		
		 daoBook.updateBook(5, "bla", "bli", true, 6, 3);
		
		// daoBook.deleteBook(11);

	}

}
