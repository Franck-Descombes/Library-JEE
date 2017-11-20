package fr.afpa.javaee.library.daoconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static Connection getConnect() {
		String url = "jdbc:mysql://localhost:3306/library?serverTimezone=UTC"; // nom de la base à connecter
		String user = "root";
		String password = "Zarathustra";
		Connection myConnect = null; // créer connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // chargement du driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			myConnect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myConnect;
	}

}
