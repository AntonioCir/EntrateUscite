/**
 * 
 */
package model;

import java.time.LocalDate;

/**
 * @author Antonio
 *
 */
public class Spesa 
{
	private String tipo;
	private String titolo;
	private LocalDate data;
	private String descrizione;
	private double ammontare;
	
	
	/**
	 * @param tipo
	 * @param titolo
	 * @param data
	 * @param descrizione
	 * @param ammontare
	 */
	public Spesa(String tipo, String titolo, LocalDate data, String descrizione, double ammontare) {
		super();
		this.tipo = tipo;
		this.titolo = titolo;
		this.data = data;
		this.descrizione = descrizione;
		this.ammontare = ammontare;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}


	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}


	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}


	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	/**
	 * @return the ammontare
	 */
	public double getAmmontare() {
		return ammontare;
	}


	/**
	 * @param ammontare the ammontare to set
	 */
	public void setAmmontare(double ammontare) {
		this.ammontare = ammontare;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Spesa [tipo=" + tipo + ", titolo=" + titolo + ", data=" + data + ", descrizione=" + descrizione
				+ ", ammontare=" + ammontare + "]";
	}

	

	
}
