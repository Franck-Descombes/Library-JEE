package fr.afpa.javaee.library.dao;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Catalog;

public interface IDaoCatalog {
	
	public void  addCatalog(String nameCatalog);
	public Catalog getOneCatalog(int id);
	public Catalog getOneCatalog(String nameCatalog);
	public ArrayList<Catalog> getAllCatalogs();
	public void updateCatalog(int Id, String newNameCatalog);
	public void deleteCatalog(int Id);
	

}
