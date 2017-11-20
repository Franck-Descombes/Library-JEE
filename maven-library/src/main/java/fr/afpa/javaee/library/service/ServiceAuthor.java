package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.IDaoAuthor;
import fr.afpa.javaee.library.model.Author;

public class ServiceAuthor implements IServiceAuthor {

	private IDaoAuthor iDaoAuthor;

	// CONSTRUCTOR
	public ServiceAuthor(IDaoAuthor myDaoAuthor) {
		this.iDaoAuthor = myDaoAuthor;
	}

	// METHODS
	public void addAuthor(String firstName, String lastName, String dateOfBirth) {
		iDaoAuthor.addAuthor(firstName, lastName, dateOfBirth);
	}

	public Author getOneAuthor(int id) {
		return iDaoAuthor.getOneAuthor(id);
	}

	public Author getOneAuthor(String firstName, String lastName, String dateOfBirth) {
		return iDaoAuthor.getOneAuthor(firstName, lastName, dateOfBirth);
	}

	public ArrayList<Author> getAllAuthors() {
		return iDaoAuthor.getAllAuthors();
	}

	public void updateAuthor(int id, String newFirstName, String newLastName, String newDateOfBirth) {
		iDaoAuthor.updateAuthor(id, newFirstName, newLastName, newDateOfBirth);
	}

	public void deleteAuthor(int id) {
		iDaoAuthor.deleteAuthor(id);

	}

}
