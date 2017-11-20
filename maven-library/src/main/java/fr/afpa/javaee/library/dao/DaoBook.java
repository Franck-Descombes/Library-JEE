package fr.afpa.javaee.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.javaee.library.daoconnect.Connect;
import fr.afpa.javaee.library.model.Author;
import fr.afpa.javaee.library.model.Book;
import fr.afpa.javaee.library.model.Catalog;

public class DaoBook implements IDaoBook {

	private Connection con; // crée une variable vide prete à recevoir....
	private Statement st;
	private ResultSet rs;

	// méthode myConnect() qui appelle ma classe Connect et qui renvoie la
	// connection via la méthode getConnect()
	private void myConnect() {
		con = Connect.getConnect();
	}

	public void addBook(long isbn, String title, String subtitle, boolean available, int nbCopy, int idAuthor,
			int idCatalog) {
		myConnect(); // ouverture flux
		try { // Loading new values in my prepared request
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO _book (Isbn_book, Title_book, Subtitle_book, Available, NbCopy, Id_author, Id_catalog) values (?,?,?,?,?,?,?)");
			pstmt.setLong(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, subtitle);
			pstmt.setBoolean(4, false);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, idAuthor);
			pstmt.setInt(7, idCatalog);
			pstmt.executeUpdate(); // Saves the data in the database
			pstmt.close();
			con.close(); // Close the stream

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book getOneBook(long isbn) {
		Book selectedBook = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM _Book join _Author on _Book.Id_author = _Author.Id_author join _Catalog"
							+ " on _Book.Id_catalog = _Catalog.Id_catalog where Isbn_book = ?");
			pstmt.setLong(1, isbn);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				long Isbn = rs.getLong("Isbn_book");
				String Title = rs.getString("Title_book");
				String Subtitle = rs.getString("Subtitle_book");

				boolean isAvailable = false;
				if (rs.getInt("Available") == 1) {
					isAvailable = true;
				}

				Author myAuthor = null;
				int idAuthor = rs.getInt("Id_author");
				String firstname = rs.getString("First_name_author");
				String lastname = rs.getString("Last_name_author");
				String dob = rs.getString("Dob_author");
				myAuthor = new Author(idAuthor, firstname, lastname, dob);

				Catalog myCatalog = null;
				int idCatalog = rs.getInt("Id_catalog");
				String nameCatalog = rs.getString("Name_catalog");
				myCatalog = new Catalog(idCatalog, nameCatalog);

				selectedBook = new Book(isbn, Title, Subtitle, isAvailable, myAuthor, myCatalog);

			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedBook;
	}

	public Book getOneBook(String title, Author author) {
		Book selectedBook = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM _Book join _Author on _Book.Id_author = _Author.Id_author join _Catalog"
							+ "on _Book.Id_catalog = _Catalog.Id_catalog where Title_book, Id_author = ?,? ");
			pstmt.setString(1, title);
			pstmt.setInt(2, author.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				long Isbn = rs.getLong("Isbn_book");
				String Subtitle = rs.getString("Subtitle_book");
				boolean isAvailable = false;
				if (rs.getInt("Available") == 1) {
					isAvailable = true;
				}
				Catalog myCatalog = null;
				int idCatalog = rs.getInt("Id_catalog");
				String nameCatalog = rs.getString("Name_catalog");
				myCatalog = new Catalog(idCatalog, nameCatalog);

				selectedBook = new Book(Isbn, title, Subtitle, isAvailable, author, myCatalog);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedBook;
	}

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> myBookList = new ArrayList<Book>();
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM _Book join _Author on _Book.Id_author = _Author.Id_author join _Catalog"
							+ " on _Book.Id_catalog = _Catalog.Id_catalog");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				long isbn = rs.getLong("Isbn_book");
				String bookTitle = rs.getString("Title_book");
				String bookSubtitle = rs.getString("Subtitle_book");
				boolean isAvailable = rs.getBoolean("Available");

				Catalog myCatalog = null;
				int idCatalog = rs.getInt("Id_catalog");
				String nameCatalog = rs.getString("Name_catalog");
				myCatalog = new Catalog(idCatalog, nameCatalog);

				Author myAuthor = null;
				int idAuthor = rs.getInt("Id_author");
				String firstname = rs.getString("First_name_author");
				String lastname = rs.getString("Last_name_author");
				String dob = rs.getString("Dob_author");
				myAuthor = new Author(idAuthor, firstname, lastname, dob);

				Book b = new Book(isbn, bookTitle, bookSubtitle, isAvailable, myAuthor, myCatalog);

				myBookList.add(b);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myBookList;
	}

	public void updateBook(long isbn, String title, String subtitle, boolean available, int idAuthor, int idCatalog) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE _Book SET Title_book, Subtitle_book, Available, Id_author, Id_catalog = ?,?,?,?,? WHERE Isbn_book = ?");
			pstmt.setString(1, title);
			pstmt.setString(2, subtitle);
			pstmt.setBoolean(3, available);
			pstmt.setInt(4, idAuthor);
			pstmt.setInt(5, idCatalog);
			pstmt.setLong(6, isbn);

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(long isbn) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE _Book WHERE Isbn_book =  ?");
			pstmt.setLong(1, isbn);

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(long isbn, String title, String subtitle, int available, Author author, Catalog catalog) {
		// TODO Auto-generated method stub

	}

}
