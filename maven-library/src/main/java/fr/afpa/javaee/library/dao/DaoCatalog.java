package fr.afpa.javaee.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.afpa.javaee.library.daoconnect.Connect;
import fr.afpa.javaee.library.model.Catalog;

public class DaoCatalog implements IDaoCatalog {

	private Connection con; // crée une variable vide prete à recevoir....
	private ResultSet rs;

	// méthode myConnect() qui appelle ma classe Connect et qui renvoie la
	// connection via la méthode getConnect()
	private Connection myConnect() {
		return con = Connect.getConnect();
	}

	public void addCatalog(String nameCatalog) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO _Catalog (Name_catalog) VALUES (?)");

			pstmt.setString(1, nameCatalog);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Catalog getOneCatalog(int id) {
		Catalog selectedCatalog = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _Catalog where Id_catalog = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String nameCatalog = rs.getString("Name_catalog");
				selectedCatalog = new Catalog(id, nameCatalog);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedCatalog;
	}

	public Catalog getOneCatalog(String nameCatalog) {
		Catalog selectedCatalog = null;
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _Catalog where name_catalog = ?");
			pstmt.setString(1, nameCatalog);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int idCatalog = rs.getInt("Id_catalog");
				selectedCatalog = new Catalog(idCatalog, nameCatalog);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedCatalog;
	}

	public ArrayList<Catalog> getAllCatalogs() {
		ArrayList<Catalog> selectedCatalogs = new ArrayList<Catalog>();
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM _Catalog");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String nameCatalog = rs.getString("Name_catalog");
				int idCatalog = rs.getInt("Id_catalog");
				Catalog c = new Catalog(idCatalog, nameCatalog);

				selectedCatalogs.add(c);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return selectedCatalogs;
	}

	public void updateCatalog(int Id, String newNameCatalog) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmtUpdate = con
					.prepareStatement("UPDATE _Catalog SET Name_catalog = ? WHERE Id_catalog = ?");
			pstmtUpdate.setString(1, newNameCatalog);
			pstmtUpdate.setInt(2, Id);

			pstmtUpdate.executeUpdate();
			pstmtUpdate.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCatalog(int id) {
		myConnect(); // ouverture flux
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM _Catalog where Id_catalog =  ?");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
