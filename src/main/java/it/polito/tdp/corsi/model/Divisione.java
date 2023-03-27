package it.polito.tdp.corsi.model;

public class Divisione {
	String cds;
	Integer nStudenti;
	
	public Divisione(String cds, Integer nStudenti) {
		this.cds = cds;
		this.nStudenti = nStudenti;
	}

	public String getCds() {
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	public Integer getnStudenti() {
		return nStudenti;
	}

	public void setnStudenti(Integer nStudenti) {
		this.nStudenti = nStudenti;
	}
	
	
	
	

}
