package utils.database;



import java.io.PrintStream;
import java.sql.*;

public class DbUtils {
	private static final PrintStream ERR = System.err;

	public static final String URL="jdbc:mysql://mysqlserver66.mysql.database.azure.com:3306",
			USER="matteodinoia",
			PASSWORD="5Rb!GHz*";

	private static Connection con=null;
	
	//da settare
	private ResultSet resSet=null;
	private PreparedStatement prepStat=null;
	
	
	/**Carica le risorse adesso invece di aspettare il primo utilizzo*/
	public void prepareResourceNOW() {
		getConnection();
	}
	private static Connection getConnection() {
		if(con==null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				//con=DriverManager.getConnection(URL2);
				con=DriverManager.getConnection(URL, USER, PASSWORD);
			} 
			catch (SQLException e) {
				ERR.println("Errore mySql in getConnection:");
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) {
				ERR.println("Errore driver in getConnection:");
				e.printStackTrace();
			}
			
		}
		
		
		return con;
	}
	
	
	public PreparedStatement getPreparedStatement(String command) {
		getConnection();
		
		PreparedStatement ris=null;
		
		try {
			ris=con.prepareStatement(command);
		} catch (SQLException e) {
			ERR.println("Errore sql in getPreparedStatement:");
			e.printStackTrace();
		}
		
		prepStat=ris;
		return ris;
	}
	
	
	public ResultSet getResultSet() {
		if(prepStat==null) {
			ERR.println("Manca statement");
			return null;
		}
		
		ResultSet ris=null;
		try {
			ris = prepStat.executeQuery();
		} catch (SQLException e) {
			ERR.println("Errore in getResultSet:");
			e.printStackTrace();
		}
		
		resSet=ris;
		return ris;
	}
	public void executeUpdate() {
		if(prepStat==null) {
			ERR.println("Manca statement");
			return;
		}
		
		
		try {
			prepStat.executeUpdate();
		} catch (SQLException e) {
			ERR.println("Errore in excuteUpdate:");
			e.printStackTrace();
		}
	}

	
	public void closeConnectionsResurses() {
		
		try {
			if(resSet!=null) {
				resSet.close();
				resSet=null;
			}
			if(prepStat!=null){
				prepStat.close();
				prepStat=null;
			} 
		} 
		catch (SQLException e) {
			ERR.println("Errore mySql in closeConnection:");
			e.printStackTrace();
		} 
	}
	public static void terminateConnection(){
		try {
			if(con!=null){
				con.close();
				con=null;
			} 
			
		} 
		catch (SQLException e) {
			ERR.println("Errore mySql in terminatesConnection:");
			e.printStackTrace();
		} 
	}

	
}
