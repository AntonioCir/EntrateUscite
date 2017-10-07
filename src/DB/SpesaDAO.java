package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
			// st.setString(2, s.getData());
			st.setString(3, s.getDescrizione());
			LocalDate data = s.getData();
			System.out.println("Sono in SpesaDAO 1");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		    String dataStringa = data.format(formatter);
		        
			st.setString(2, dataStringa);
			st.setDouble(4, s.getAmmontare());
			st.setString(5, s.getTipo());
			System.out.println("Sono in SpesaDAO 2");
			System.out.println(s.getTipo());
			int res = st.executeUpdate();
			System.out.println("Sono in SpesaDAO 3");
			
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
	
	
	
	
	
	
	
}
