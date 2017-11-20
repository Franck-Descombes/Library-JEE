package fr.afpa.javaee.library.dao;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Copy;
import fr.afpa.javaee.library.model.Subscriber;

public interface IDaoCopy {
	public void addCopy(Book book);

	public Copy getOneCopy(int id);

	public ArrayList<Copy> getAllCopies();

	public void updateCopy(int idCopy, boolean available, String borrowingDate, String returnDate, boolean fix,
			Subscriber subscriber);

	public void deleteCopy(int idCopy);
}
