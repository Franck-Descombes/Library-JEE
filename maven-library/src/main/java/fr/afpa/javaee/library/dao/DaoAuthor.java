package fr.afpa.javaee.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.javaee.library.daoconnect.Connect;
import fr.afpa.javaee.library.model.Author;

public class DaoAuthor implements IDaoAuthor {
	private Connection con; // crée une variable vide prete à recevoir....
	private Statement st;
	private ResultSet rs;

	// méthode myConnect() qui appelle ma classe Connect et qui renvoie la
	// connection via la méthode getConnect()
	private void myConnect() {
		con = Connect.getConnect();
	}

	public void addAuthor(String firstName, String lastName, String dateOfBirth) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO _Author (First_name_author, Last_name_author, Dob_author) VALUES (?,?,?)");

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, dateOfBirth);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Author getOneAuthor(int id) {
		Author selectedAuthor = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _Author where Id_author = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idAuthor = rs.getInt("Id_author");
				String firstNameAuthor = rs.getString("First_name_author");
				String lastNameAuthor = rs.getString("Last_name_author");
				String dateOfBirthAuthor = rs.getString("Dob_author");
				selectedAuthor = new Author(idAuthor, firstNameAuthor, lastNameAuthor, dateOfBirthAuthor);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedAuthor;
	}

	public Author getOneAuthor(String firstName, String lastName, String dateOfBirth) {
		Author selectedAuthor = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"SELECT * FROM _Author WHERE First_name_author = ? AND Last_name_author = ? AND Dob_author  = ?");
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, dateOfBirth);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idAuthor = rs.getInt("Id_author");
				String firstNameAuthor = rs.getString("First_name_author");
				String lastNameAuthor = rs.getString("Last_name_author");
				String dateOfBirthAuthor = rs.getString("Dob_author");
				selectedAuthor = new Author(idAuthor, firstNameAuthor, lastNameAuthor, dateOfBirthAuthor);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedAuthor;
	}

	public ArrayList<Author> getAllAuthors() {
		ArrayList<Author> myAuthorList = new ArrayList<Author>();
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _author");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				int idAuthor = rs.getInt("Id_author");
				String firstNameAuthor = rs.getString("First_name_author");
				String lastNameAuthor = rs.getString("Last_name_author");
				String dateOfBirthAuthor = rs.getString("Dob_author");
				Author a = new Author(idAuthor, firstNameAuthor, lastNameAuthor, dateOfBirthAuthor);
				myAuthorList.add(a);
			}
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myAuthorList;
	}

	public void updateAuthor(int id, String newFirstName, String newLastName, String newDateOfBirth) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE _Author SET First_name_author = ?, Last_name_author = ?, Dob_author = ? WHERE Id_author =?");
			pstmt.setString(1, newFirstName);
			pstmt.setString(2, newLastName);
			pstmt.setString(3, newDateOfBirth);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAuthor(int id) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM _Author WHERE Id_author =?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
