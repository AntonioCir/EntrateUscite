package application;

/**
 * Sample Skeleton for 'FinestraVisualizzazione.fxml' Controller Class
 */

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import model.Model;
import model.Spesa;

public class Visualizza 
{
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML // fx:id="txtTipo2"
    private ComboBox<String> txtTipo2; // Value injected by FXMLLoader

    @FXML // fx:id="btnVisualizza"
    private Button btnVisualizza; // Value injected by FXMLLoader

    @FXML // fx:id="txtVisualizzazioni"
    private TextArea txtVisualizzazioni; // Value injected by FXMLLoader

    @FXML
    void onVisualizza(ActionEvent event) 
    {
    	String tipo = txtTipo2.getValue();
    	txtVisualizzazioni.setText("");
    	Double totale=(double) 0;
    	Model mod = new Model();
    	if (tipo=="E")
    	{
    		List<Spesa> elenco = mod.elencoEntrate();
    	
    		for (Spesa s:elenco)
    		{
    			
    			txtVisualizzazioni.appendText(s.toString()+"\n");
    			totale= totale + s.getAmmontare();
    		}
    		String totaleInLettere= totale.toString();
    		txtVisualizzazioni.appendText("TOTALE ENTRATE = " + totaleInLettere);
    	}
    	else if (tipo=="U")
    	{
    		List<Spesa> elenco = mod.elencoUscite();
        	
    		for (Spesa s:elenco)
    		{
    			txtVisualizzazioni.appendText(s.toString()+"\n");
    			totale= totale + s.getAmmontare();
    		}
    		String totaleInLettere= totale.toString();
    		txtVisualizzazioni.appendText("TOTALE USCITE = " + totaleInLettere);
    	}
    	else
    	{
    		txtVisualizzazioni.setText("Devi specificare che tipo di elenco vuoi");
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
        assert btnVisualizza != null : "fx:id=\"btnVisualizza\" was not injected: check your FXML file 'FinestraVisualizzazione.fxml'.";
        assert txtTipo2 != null : "fx:id=\"txtTipo2\" was not injected: check your FXML file 'FinestraVisualizzazione.fxml'.";
        assert txtVisualizzazioni != null : "fx:id=\"txtVisualizzazioni\" was not injected: check your FXML file 'FinestraVisualizzazione.fxml'.";

        txtTipo2.getItems().add("E");
        txtTipo2.getItems().add("U");
    }
    

}

