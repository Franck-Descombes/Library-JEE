package fr.afpa.javaee.library.model;

public class Book {

	private long isbn;
	private String title;
	private String subtitle;
	private boolean available;
	private Author author;
	private Catalog catalog;


	// CONSTRUCTOR USING ALL FIELDS
	public Book(long isbn, String title, String subtitle, boolean available, Author author, Catalog catalog) {
		this.isbn = isbn;
		this.title = title;
		this.subtitle = subtitle;
		this.available = available;
		this.author = author;
		this.catalog = catalog;
	}

	// GETTERS & SETTERS
	public long getIsbn() {
		return this.isbn;
	}

	public void setIsbn(long value) {
		this.isbn = value;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String value) {
		this.subtitle = value;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		if (catalog != null) {
			return "ISBN : " + isbn + "Title : " + title + "Subtitle : " + subtitle + "Author : " + author.getLastName()
					+ author.getFirstName() + " | Availability : " + available + "Catalog : "
					+ catalog.getCatalogName();
		} else {
			return "ISBN : " + isbn + "Title : " + title + "Subtitle : " + subtitle + "Author : " + author.getLastName()
					+ author.getFirstName() + " | Availability : " + available;
		}
	}


}
