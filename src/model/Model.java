/**
 * 
 */
package model;

import java.util.List;

import DB.SpesaDAO;

/**
 * @author Antonio
 *
 */
public class Model 
{
	public boolean addSpesa(Spesa s)
	{
		System.out.println("Sono in model");
		SpesaDAO dao = new SpesaDAO();
		System.out.println("Sono in model 2");
		return dao.insSpesa(s);
		
	}
	
	public List<Spesa> elencoEntrate()
	{
		SpesaDAO dao = new SpesaDAO();
		return dao.getEntrate();
	}
	
	public List<Spesa> elencoUscite()
	{
		SpesaDAO dao = new SpesaDAO();
		return dao.getUscite();
	}
}
