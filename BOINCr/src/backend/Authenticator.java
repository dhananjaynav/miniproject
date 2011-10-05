package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Authenticator {
	Connection con;
	public boolean getConnected(String username, String password, String server, String database)
	{
		//Class driverClass = null;
		try
		{
			String cString="jdbc:mysql://"+server+"/"+database;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(cString, username, password);
			System.err.println("Established Connection to "+ con.getMetaData().getURL());
			return true;
		}

		catch (ClassNotFoundException ae)
		{
			System.err.println("Class Not Found!!!");
			ae.printStackTrace();
			return false;
		}		
		catch (SQLException sqle)
		{
			System.err.println("SQLException!!");
			sqle.printStackTrace();
			return false;
		}
	}
	public void exit()
	{
		try {
			String str=con.getMetaData().getURL();
			con.close();
			System.err.println("Disconneted from "+str);
		} catch (SQLException e) {
			System.err.println("SQLException!!");
			e.printStackTrace();
		}
	}

}