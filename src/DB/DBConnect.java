/**
 * 
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Antonio
 *
 */
public class DBConnect 
{
private final static String jdbcURL="jdbc:mysql://localhost/gestione?user=root&password=root";
	
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Driver JDBC non trovato", e);
		}
		Connection conn;
		try 
		{
			conn = DriverManager.getConnection(jdbcURL);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Impossibile connettersi al database", e);
		}
		return conn;
		
	}
}
