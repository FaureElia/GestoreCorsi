/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	String input=this.txtPeriodo.getText();
    	int inputNumber=0;
    	
    	try {
    		inputNumber=Integer.parseInt(input);//metodo che verifica se è un intero;
    		
    		}catch(NumberFormatException e) {
    		txtRisultato.setText("il numero non è un intero");
    		return;
    			}
    	
    	if (inputNumber<1 || inputNumber>2) {
    		txtRisultato.setText("inserire 1 o 2");
    		return;
    	}
    	List<Corso> result =new ArrayList<>(model.getCorsiByPeriodo(inputNumber));    	
    	this.txtRisultato.clear();
    	txtRisultato.setText("Ho trovato "+ result.size()+" corsi.\n");
    	for(Corso c: result)
    		txtRisultato.appendText(""+c+"\n");
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	this.txtRisultato.clear();
    	String input= this.txtPeriodo.getText();
    	int inputNumber=0;
    	try {
    		inputNumber=Integer.parseInt(input);
    		
    	}catch(NumberFormatException e) {
    		this.txtRisultato.setText("inserire un numero intero");
    		e.printStackTrace();
    	}
    	if (inputNumber<1 || inputNumber>2) {
    		txtRisultato.setText("inserire 1 o 2");
    		return;
    	}
    	Map<Corso, Integer > resultNumber= new HashMap<>();
    	resultNumber=this.model.getCorsiIscritti(inputNumber);
    	for (Corso c:resultNumber.keySet()) {
			this.txtRisultato.appendText(c.getNome()+", numero iscritti: "+ resultNumber.get(c)+"\n");
			
			
		}
    	
    	
    	
    }

    @FXML
    void stampaDivisione(ActionEvent event) {
    	String codins=this.txtCorso.getText();
    	if (codins.isEmpty()) {
    		this.txtRisultato.setText("Inserire codice di un corso");
    		return;
    	}
    	List<Divisione> listaRisultato=new ArrayList<Divisione>(this.model.getDivisioneStudentiCorso(codins));
    	this.txtRisultato.clear();
    	for (Divisione d: listaRisultato) {
    		txtRisultato.appendText(d.getCds()+": "+ d.getnStudenti()+"\n");
    	}
    	
    	
    	
    	

    }

    @FXML
    void stampaStudenti(ActionEvent event) {
    	String codins=this.txtCorso.getText();
    	if (codins.isEmpty()) {
    		this.txtRisultato.setText("Inserire codice di un corso");
    		return;
    	}
    	List<Studente> listaRisultato=new ArrayList<Studente>(this.model.getStudentebyCorso(codins));
    	this.txtRisultato.clear();
    	for (Studente s: listaRisultato) {
    		txtRisultato.appendText(s+"\n");
    	}
    	
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}