/**
 * 
 */
package model;

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
}
