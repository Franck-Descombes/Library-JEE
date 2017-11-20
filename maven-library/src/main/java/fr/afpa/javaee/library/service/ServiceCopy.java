package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.IDaoCopy;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Copy;

public class ServiceCopy implements IServiceCopy {

	private IDaoCopy iDaoCopy;
	private ArrayList<Copy> myCopyList = new ArrayList<Copy>();// list of copies

	// CONSTRUCTOR
	public ServiceCopy(IDaoCopy myDaoCopy) {
		this.iDaoCopy = myDaoCopy;
	}
	
	// METHODS
	public void addCopy(Copy copy, Book book) {
		iDaoCopy.addCopy(copy, book);
	}

	public ArrayList<Copy> getAllCopies() {
		return iDaoCopy.getAllCopies();
	}

	public Copy getOneCopy(int isbn) {
		return iDaoCopy.getOneCopy(isbn);
	}

	public void updateCopy(Copy copy) {
		iDaoCopy.updateCopy(copy);
	}

	public void deleteCopy(int isbn) {
		iDaoCopy.deleteCopy(isbn);
	}

	
	
}
