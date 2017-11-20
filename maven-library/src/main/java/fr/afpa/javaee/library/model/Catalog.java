package fr.afpa.javaee.library.model;

public class Catalog {

	private int id;
	private String catalogName;

	// MAIN CONSTRUCTOR
	public Catalog(int id, String catalogName) {
		this.id = id;
		this.catalogName = catalogName;
	}

	// GETTERS & SETTERS
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " " +catalogName;
	}
}
