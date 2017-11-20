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
import fr.afpa.javaee.library.model.Copy;
import fr.afpa.javaee.library.model.Subscriber;

public class DaoCopy implements IDaoCopy {

	private Connection con;
	private Statement st;
	private ResultSet rs;

	// méthode myConnect() qui appelle ma classe Connect et qui renvoie la
	// connection via la méthode getConnect()
	private void myConnect() {
		con = Connect.getConnect();
	}

	public void addCopy(Book book) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con
					.prepareStatement("INSERT INTO _Copy (Copy_available, isFixing, Isbn_book) VALUES (?,?,?)");
			pstmt.setBoolean(1, true);
			pstmt.setBoolean(2, false);
			pstmt.setLong(3, book.getIsbn());

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Copy getOneCopy(int id) {
		Copy selectedCopy = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con
					.prepareStatement("  SELECT * FROM _copy JOIN _book ON _copy.Isbn_book = _book.Isbn_book"
							+ "    JOIN _subscriber ON _copy.Id_subscriber = _subscriber.Id_subscriber"
							+ " JOIN _Author on _Book.Id_author =_Author.Id_author JOIN__Catalog on _Book.Id_catalog = _Catalog.Id_catalog"
							+ "    where Id_copy = ?");

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

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

				Book myBook = null;
				int Isbn = rs.getInt("Isbn_book");
				String Title = rs.getString("Title_book");
				String Subtitle = rs.getString("Subtitle_book");
				boolean isAvailable = false;
				if (rs.getInt("Available") == 1) {
					isAvailable = true;
				}
				myBook = new Book(Isbn, Title, Subtitle, isAvailable, myAuthor, myCatalog);

				Subscriber mySubscriber = null;
				int idSubscriber = rs.getInt("Id_subscriber");
				String firstNameSubscriber = rs.getString("First_name_subscriber");
				String lastNameSubscriber = rs.getString("Last_name_subscriber");
				mySubscriber = new Subscriber(idSubscriber, firstNameSubscriber, lastNameSubscriber);

				boolean available = rs.getBoolean("Copy_available");
				String bDate = rs.getString("Borrowing_date");
				String rDate = rs.getString("Return_date");

				boolean fix = rs.getBoolean("isFixing");

				selectedCopy = new Copy(id, available, bDate, rDate, fix, mySubscriber, myBook);

			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedCopy;
	}

	public ArrayList<Copy> getAllCopies() {
		ArrayList<Copy> myCopiesList = new ArrayList<Copy>();
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con
					.prepareStatement("  SELECT * FROM _copy JOIN _book ON _copy.Isbn_book = _book.Isbn_book"
							+ "    JOIN _subscriber ON _copy.Id_subscriber = _subscriber.Id_subscriber"
							+ " JOIN _Author on _Book.Id_author =_Author.Id_author JOIN__Catalog on _Book.Id_catalog = _Catalog.Id_catalog");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idCopy = rs.getInt("Id_copy");
				boolean available = rs.getBoolean("Copy_available");
				String borrowingDate = rs.getString("Borrowing_date");
				String returnDate = rs.getString("Return_date");
				boolean isFixing = rs.getBoolean("isFixing");
				int idSubscriber = rs.getInt("Id_subscriber");
				int isbnBook = rs.getInt("Isbn_book");

				Catalog myCatalog = null;
				int idCatalog = rs.getInt("id_catalog");
				String nameCatalog = rs.getString("Name_catalog");
				myCatalog = new Catalog(idCatalog, nameCatalog);

				Author myAuthor = null;
				int idAuthor = rs.getInt("Id_author");
				String firstNameAuthor = rs.getString("First_name_author");
				String lastNameAuthor = rs.getString("Last_name_author");
				String dobAuthor = rs.getString("Dob_author");
				myAuthor = new Author(idAuthor, firstNameAuthor, lastNameAuthor, dobAuthor);

				Book myBook = null;
				String title = rs.getString("Title_book");
				String subtitle = rs.getString("Subtitle_book");
				boolean availableBook = rs.getBoolean("Available");
				myBook = new Book(isbnBook, title, subtitle, availableBook, myAuthor, myCatalog);

				Subscriber mySubscriber = null;
				String firstNameSubscriber = rs.getString("First_name_subscriber");
				String lastNameSubscriber = rs.getString("Last_name_subscriber");
				mySubscriber = new Subscriber(idSubscriber, firstNameSubscriber, lastNameSubscriber);

				Copy c = new Copy(idCopy, available, borrowingDate, returnDate, isFixing, mySubscriber, myBook);

				myCopiesList.add(c);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myCopiesList;
	}

	public void updateCopy(int idCopy, boolean available, String borrowingDate, String returnDate, boolean fix,
			Subscriber subscriber) {
		try {
			myConnect(); // ouverture flux
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE _Copy SET Copy_available, Borrowing_date, return_date, isFixing, Id_subscriber, Isbn_book = ?,?,?,?,?,? WHERE Id_copy = ?");
			pstmt.setBoolean(1, available);
			pstmt.setString(2, borrowingDate);
			pstmt.setString(3, returnDate);
			pstmt.setBoolean(4, fix);
			pstmt.setInt(5, subscriber.getId());
			pstmt.setInt(6, idCopy);

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCopy(int idCopy) {
		try {
			myConnect(); // ouverture flux
			PreparedStatement pstmt = con.prepareStatement("DELETE _Copy WHERE Id_copy = ?");
			pstmt.setInt(1, idCopy);

			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
