package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Copy;

public interface IServiceCopy {

	public void addCopy(Copy copy, Book book);

	public ArrayList<Copy> getAllCopies();

	public Copy getOneCopy(int id);

	public void updateCopy(Copy copy);

	public void deleteCopy(int isbn);

}
