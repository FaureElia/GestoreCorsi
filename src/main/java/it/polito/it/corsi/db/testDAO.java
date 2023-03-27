package it.polito.it.corsi.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class testDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorsoDAO dao=new CorsoDAO();
		List<Corso> result =new ArrayList<>();
		result=dao.getCorsiByPeriodo(2);
		for (Corso c: result) {
			System.out.println(c);
		}
		Map<Corso, Integer> mappaResult=new HashMap<>(dao.getCorsiIscritti(1));
		for (Corso c:mappaResult.keySet()) {
			System.out.println(c+" "+ mappaResult.get(c));
			
		}
		
	}

}
