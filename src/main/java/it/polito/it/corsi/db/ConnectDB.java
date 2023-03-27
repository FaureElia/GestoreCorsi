package it.polito.it.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	//classe che gestisce la connessione al database

	public static Connection getConnection() {
		String url ="jdbc:mysql://localhost/iscritticorsi?user=root&password=eliaMaria23";
		
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("ERrore nella connessione");
			e.printStackTrace();
			return null;
		}
	}

}
