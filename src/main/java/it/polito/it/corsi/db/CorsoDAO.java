package it.polito.it.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Studente;

// classe che implementa il pattern DAO, scrivo tutti i metodi che hanno l'obiettivo di accedere alla tabella corso

public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo (int periodo){
		
		String sql= " SELECT * "
				+ "FROM corso "
				+ "WHERE pd= ?";
		
		List<Corso> resultCorso=new ArrayList<>();
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) { // dobbiamo richiamare il nome presente nella tabella del database
				Corso c=new Corso (rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				resultCorso.add(c);
			}
			st.close();
			rs.close();
			conn.close();
			return resultCorso;
		
			
		} catch (SQLException e) {
			System.out.println("Error in corso DAO");
			e.printStackTrace();
			return null;
		}
		
	}
	public Map <Corso,Integer >getCorsiIscritti(int periodo) {
		String sql="SELECT c.codins, c.crediti, c.nome,c.pd, COUNT(*) AS n "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins AND c.pd=? "
				+ "GROUP BY c.codins, c.crediti, c.nome,c.pd";
		try {
			Map<Corso, Integer> result=new HashMap<Corso, Integer>();
			Connection conn =ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs= st.executeQuery();
			while(rs.next()) {
				Corso c=new Corso (rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.put(c, rs.getInt("n"));
			}
			 conn.close();
			 st.close();
			 rs.close();
			 return result;
			
			
		}catch(SQLException e) {
			System.out.println("eccezione DAO");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
		
	

}
