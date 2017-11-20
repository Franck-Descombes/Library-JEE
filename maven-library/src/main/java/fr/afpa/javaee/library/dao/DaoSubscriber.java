package fr.afpa.javaee.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.afpa.javaee.library.daoconnect.Connect;
import fr.afpa.javaee.library.model.Subscriber;

public class DaoSubscriber implements IDaoSubscriber {
	private Connection con; // crée une variable vide prete à recevoir....
	private Statement st;
	private ResultSet rs;

	// méthode myConnect() qui appelle ma classe Connect et qui renvoie la
	// connection via la méthode getConnect()
	private void myConnect() {
		con = Connect.getConnect();
	}

	public void addSubscriber(String firstName, String lastName) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO _Subscriber (First_name_subscriber, Last_name_subscriber) VALUES (?,?)");

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Subscriber getOneSubscriber(int id) {
		Subscriber selectedSubscriber = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _Subscriber where Id_subscriber = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idSubscriber = rs.getInt("Id_subscriber");
				String firstNameSubscriber = rs.getString("First_name_subscriber");
				String lastNameSubscriber = rs.getString("Last_name_subscriber");
				selectedSubscriber = new Subscriber(idSubscriber, firstNameSubscriber, lastNameSubscriber);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedSubscriber;
	}

	public ArrayList<Subscriber> getAllSubscribers() {
		ArrayList<Subscriber> mySubscriberList = new ArrayList<Subscriber>();
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _subscriber");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idSubscriber = rs.getInt("Id_subscriber");
				String firstName = rs.getString("First_name_subscriber");
				String lastName = rs.getString("Last_name_subscriber");
				Subscriber s = new Subscriber(idSubscriber, lastName, firstName);
				mySubscriberList.add(s);
			}
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mySubscriberList;
	}

	public void updateSubscriber(int id, String newFirstName, String newLastName) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE _Subscriber SET Last_name_subscriber = ?, First_name_subscriber = ? WHERE Id_subscriber = ?");
			pstmt.setString(1, newLastName);
			pstmt.setString(2, newFirstName);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSubscriber(int id) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM _Subscriber  WHERE Id_subscriber = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
