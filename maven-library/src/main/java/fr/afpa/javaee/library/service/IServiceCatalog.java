package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Catalog;

public interface IServiceCatalog {

	public void addCatalog(String name);

	public Catalog getOneCatalog(String name);

	public ArrayList<Catalog> getAllCatalogs();

	public void updateCatalog(int Id, String newNameCatalog);

	public void deleteCatalog(int id);

}
