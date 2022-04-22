package utils.database;

public abstract class DatabaseElement {
	
	//COSTRUCTOR
	//protected static String getTableName();
	
	
	//TABLE MANAGMENT
	//public abstract static String getSqlCreateTable();
	public static String getSqlDeleteTable() {
		
		return null;
	}
	
	
	//ELEMENT MANAGER
	public abstract String getSqlInsert();
	public abstract String getSqlUpdate();
	public String getSqlDelete() {
		
		return null;
	}
}
