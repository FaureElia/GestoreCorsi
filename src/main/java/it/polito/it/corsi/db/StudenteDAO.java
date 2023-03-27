package it.polito.it.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;

/**
 * NOTA: QUANDO ABBIAMO DIVERSE TABELLE E FUNZIONI CHE LEGGONO DA TABELLE DIFFERENTI E' MEGLIO INSERIRLE IN FUNZIONI DIVERSE
 * @param codice
 * @return
 */

public class StudenteDAO {
	
	public List<Studente> getStudentiByCorso(String codice){
		List<Studente> listaStudenti=new ArrayList<Studente>();
		String sql="SELECT s.matricola, s.cognome, s.nome, s.CDS "
				+ "FROM iscrizione i, studente s "
				+ "WHERE i.matricola=s.matricola AND i.codins=?";
		try {
		Connection conn=ConnectDB.getConnection();
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, codice);
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Studente s=new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("cognome"));
			listaStudenti.add(s);
		}
		conn.close();
		st.close();
		rs.close();
		
		}catch(SQLException e) {
			System.out.println("eccezione DAO inserimento codins");
			e.printStackTrace();
			// return null; in questo caso non è obbligatorio perche il valore di ritorno è listaStudenti, che nel caso in cui non siamo entrati nel try, sarà nulla!
		}
		return listaStudenti;
		
	}
	
	public  List<Divisione>   getDivisioneStudentiCorso(String codice){
		String sql="SELECT s.CDS, COUNT(*) AS n "
				+ "FROM iscrizione i, studente s "
				+ "WHERE i.matricola=s.matricola AND i.codins=? "
				+ "GROUP BY s.CDS ";
		
		List<Divisione> risultato=new ArrayList<Divisione>();
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, codice);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Divisione dv=new Divisione(rs.getString("CDS"),rs.getInt("n"));
				risultato.add(dv);
			}
			conn.close();
			rs.close();
			st.close();
			
			
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("Errore lettura DAO");
		}
		return risultato;
		
	}
			

}
