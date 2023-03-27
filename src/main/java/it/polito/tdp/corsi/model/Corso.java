package it.polito.tdp.corsi.model;

import java.util.Objects;

public class Corso {
	
	private String codins;
	private int credeiti;
	private String nome;
	private int pd;
	
	
	public Corso(String codins, int credeiti, String nome, int pd) {
		this.codins = codins;
		this.credeiti = credeiti;
		this.nome = nome;
		this.pd = pd;
	}


	public String getCodins() {
		return codins;
	}


	public void setCodins(String codins) {
		this.codins = codins;
	}


	public int getCredeiti() {
		return credeiti;
	}


	public void setCredeiti(int credeiti) {
		this.credeiti = credeiti;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPd() {
		return pd;
	}


	public void setPd(int pd) {
		this.pd = pd;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codins);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codins, other.codins);
	}


	@Override
	public String toString() {
		return "Corso [codins=" + codins + ", credeiti=" + credeiti + ", nome=" + nome + ", pd=" + pd + "]";
	}


	
	
	
	
	
	

}
