package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.IDaoCatalog;
import fr.afpa.javaee.library.model.Catalog;

public class ServiceCatalog implements IServiceCatalog {

	private IDaoCatalog iDaoCatalog;

	// CONSTRUCTOR
	public ServiceCatalog(IDaoCatalog myDaoCatalog) {
		this.iDaoCatalog = myDaoCatalog;
	}

	// METHODS
	public void addCatalog(String name) {
		iDaoCatalog.addCatalog(name);
	}

	public Catalog getOneCatalog(String name) {
		return iDaoCatalog.getOneCatalog(name);
	}

	public ArrayList<Catalog> getAllCatalogs() {
		return iDaoCatalog.getAllCatalogs();
	}

	public void updateCatalog(int Id, String newNameCatalog) {
		iDaoCatalog.updateCatalog(Id, newNameCatalog);
	}

	public void deleteCatalog(int id) {
		iDaoCatalog.deleteCatalog(id);
	}

}
