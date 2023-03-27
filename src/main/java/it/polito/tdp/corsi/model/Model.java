package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.it.corsi.db.CorsoDAO;
import it.polito.it.corsi.db.StudenteDAO;

public class Model {
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	
	
	
	
	
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO=new StudenteDAO();
	}


	public List <Corso >getCorsiByPeriodo(int periodo) {
		return this.corsoDAO.getCorsiByPeriodo(periodo);
	}
	
	public Map<Corso, Integer> getCorsiIscritti(int periodo){	
		return corsoDAO.getCorsiIscritti(periodo);
	}
	
	public List<Studente> getStudentebyCorso(String codice){
		return this.studenteDAO.getStudentiByCorso(codice);
	}
	

	public List<Divisione> getDivisioneStudentiCorso(String codice){
		return this.studenteDAO.getDivisioneStudentiCorso(codice);
	}
	
	
	
}
