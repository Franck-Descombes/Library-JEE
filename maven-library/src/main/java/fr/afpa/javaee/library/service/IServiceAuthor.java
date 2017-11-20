package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Author;

public interface IServiceAuthor {

	public void addAuthor(String firstName, String lastName, String dateOfBirth);

	public Author getOneAuthor(int id);

	public Author getOneAuthor(String firstName, String lastName, String dateOfBirth);

	public ArrayList<Author> getAllAuthors();

	public void updateAuthor(int id, String newFirstName, String newLastName, String newDateOfBirth);

	public void deleteAuthor(int id);
}
