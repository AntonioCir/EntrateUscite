/**
 * Sample Skeleton for 'EntrateUscite.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Model;
import model.Spesa;

public class EntrateUsciteController 
{
	
	Model model;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtData"
    private DatePicker txtData; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtTipo"
    private ComboBox<String> txtTipo; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnGestione"
    private Button btnGestione; // Value injected by FXMLLoader

    @FXML // fx:id="txtAmmontare"
    private TextField txtAmmontare; // Value injected by FXMLLoader

    @FXML // fx:id="txtDescrizione"
    private TextField txtDescrizione; // Value injected by FXMLLoader

    @FXML
    void onInserisci(ActionEvent event) 
    {
            	
    	String tipo = txtTipo.getValue();
    	String titolo = txtTitolo.getText();
    	LocalDate data = txtData.getValue();
    	String ammon = txtAmmontare.getText();
    	String descrizione = txtDescrizione.getText();
    	
    	
    	double ammontare = Double.parseDouble(ammon);
    	
    	Spesa s = new Spesa(tipo, titolo, data, descrizione, ammontare);
    	
    	System.out.println("Sono nel controller");
    	boolean result = model.addSpesa(s);
    	
    	if (result)
    	{
    		txtRisultato.appendText("Item aggiunto con successo");
    	}
    	else
    	{
    		txtRisultato.appendText("Item non aggiunto");
    	}
    }

    @FXML
    void onVisualizza(ActionEvent event) 
    {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert txtTipo != null : "fx:id=\"txtTipo\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert btnGestione != null : "fx:id=\"btnGestione\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert txtAmmontare != null : "fx:id=\"txtAmmontare\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        assert txtDescrizione != null : "fx:id=\"txtDescrizione\" was not injected: check your FXML file 'EntrateUscite.fxml'.";
        
        txtTipo.getItems().add("E");
        txtTipo.getItems().add("U");
    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) 
	{
		this.model = model;
	}
}
