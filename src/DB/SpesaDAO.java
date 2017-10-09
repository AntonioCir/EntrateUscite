package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DB.DBConnect;
import model.Spesa;

public class SpesaDAO 
{
	
	
	public boolean insSpesa(Spesa s)
	{
		Connection conn = DBConnect.getConnection();
	
		/*
		 String in = "INSERT INTO `gestione`.`movimenti` (`titolo`, `data`, `descrizione`, `ammontare`, `tipo`) "
				+ "VALUES ('Bolletta enel', '2017-09-28', 'bolletta dell\\'elettricita', '12.36', 'U')";
		 */
		
		String in = "INSERT INTO `gestione`.`movimenti` (`titolo`, `data`, `descrizione`, `ammontare`, `tipo`) "
				+ "VALUES (?,?,?,?,?)";
		
		try 
		{
			PreparedStatement st = conn.prepareStatement(in);
			st.setString(1, s.getTitolo());
			
			LocalDate data = s.getData();
			
			//System.out.println("Sono in SpesaDAO 1");
			
			//Metodo 1 converto la data da LocalDate in String usando un formatter personalizzato
			/*
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dataStringa = data.format(formatter);
			*/
			
			// Metodo 2  converto la LocalDate a stringa in maniera semplice
			//String dataStringa1 = data.toString();
			//st.setString(2, dataStringa1);
			
			// Metodo corretto
			
			st.setDate(2, Date.valueOf(data));
			st.setString(3, s.getDescrizione());
			st.setDouble(4, s.getAmmontare());
			st.setString(5, s.getTipo());
			
			//System.out.println("Sono in SpesaDAO 2");
			//System.out.println(s.getTipo());
			
			int res = st.executeUpdate();
			//System.out.println("Sono in SpesaDAO 3");
			
			conn.close();
			
			if(res==1)
			{
				return true;
				
			}
			else
			{
				return false;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
	
	public List<Spesa> getEntrate()
	{
		Connection conn = DBConnect.getConnection();
		
		/*
		 String in = "SELECT * FROM movimenti WHERE tipo= "E"";
		 */
		
		String sql = "SELECT * FROM movimenti WHERE tipo= 'E'";
		
		try 
		{
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet elencoEntrate = st.executeQuery();
			
			List<Spesa> entrate = new ArrayList<>();
			
			while (elencoEntrate.next())
			{
				Spesa sp = new Spesa(
						elencoEntrate.getString("tipo"), 
						elencoEntrate.getString("titolo"), 
						elencoEntrate.getDate("data").toLocalDate(), 
						elencoEntrate.getString("descrizione"),
						elencoEntrate.getDouble("ammontare"));
				entrate.add(sp);
			}
			
			conn.close();
			return entrate;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Spesa> getUscite()
	{
		Connection conn = DBConnect.getConnection();
		
		/*
		 String in = "SELECT * FROM movimenti WHERE tipo= "U"";
		 */
		
		String sql = "SELECT * FROM movimenti WHERE tipo= 'U'";
		
		try 
		{
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet elencoEntrate = st.executeQuery();
			
			List<Spesa> entrate = new ArrayList<>();
			
			while (elencoEntrate.next())
			{
				Spesa sp = new Spesa(
						elencoEntrate.getString("tipo"), 
						elencoEntrate.getString("titolo"), 
						elencoEntrate.getDate("data").toLocalDate(), 
						elencoEntrate.getString("descrizione"),
						elencoEntrate.getDouble("ammontare"));
				entrate.add(sp);
			}
			
			conn.close();
			return entrate;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
}
