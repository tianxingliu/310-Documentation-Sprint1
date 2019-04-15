package database_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import info.Info;
import info.RestaurantInfo;
import info.History;

public class HistoryDataManager  extends DataManager {

	
	public void addToList(History history) {
		
		String query = history.query;
		int number = history.number;
		int radius = history.radius;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver"); // get driver for database
		conn = DriverManager.getConnection(JDBC_CONNECTION);
		ps = conn.prepareStatement("INSERT INTO History (hName,hNumber,Radius) VALUES (?,?,?);");

		ps.setString(1, query); // set first variable in prepared statement
		ps.setLong(2, number);
		ps.setLong(3, radius);	
		ps.execute();
		System.out.println("Restaurant added to database.");
					
		rs.close();
		ps.close();
		conn.close();
	}
	
	public void removeHistory(int key) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Class.forName("com.mysql.jdbc.Driver"); // get driver for database
		conn = DriverManager.getConnection(JDBC_CONNECTION);
		PreparedStatement delete = conn.prepareStatement("DELETE FROM History WHERE ID = " + key );
		delete.execute();
		delete.close();
		System.out.println("Restaurant removed.");
		
		rs.close();
		ps.close();
		conn.close();
				
	}
	
	public ArrayList<History> loadHistory(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<History> historyList = new ArrayList<History>();
		Class.forName("com.mysql.jdbc.Driver"); // get driver for database
		conn = DriverManager.getConnection(JDBC_CONNECTION);
		
		ps = conn.prepareStatement("SELECT * FROM History");
		rs = ps.executeQuery();
		while(rs.next()) {
			History his = new History(
				rs.getInt("ID"),
				rs.getString("hName"), 
				rs.getInt("hNumber"),
				rs.getInt("Radius"));
			historyList.add(his);
		}
		rs.close();
		ps.close();
		conn.close();
		return historyList;
	} 
	
}
