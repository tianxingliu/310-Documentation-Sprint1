package database_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import info.GroceryInfo;
import info.Info;
import info.RecipeInfo;

public class GroceryDataManager extends DataManager {
	
	public void addToList(GroceryInfo ingredient) {
		Connection conn = null;
		PreparedStatement ps = null;
		Class.forName("com.mysql.jdbc.Driver"); // get driver for database
		conn = DriverManager.getConnection(JDBC_CONNECTION);
		ps = conn.prepareStatement("INSERT INTO GroceryList(GroceryItem) VALUES(?);");
		ps.setString(1, ingredient.item);
		ps.executeUpdate();
		System.out.println("Grocery added.");
		ps.close();
		conn.close();
	}
	
	public ArrayList<Info> loadGrocery() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Info> groceryList = new ArrayList<Info>();
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(JDBC_CONNECTION);
    	ps = conn.prepareStatement("SELECT * FROM GroceryList");
		rs = ps.executeQuery();
		System.out.println("Loading grocery list.");
		while(rs.next()) {				
			GroceryInfo groceryToAdd = new GroceryInfo(rs.getString("GroceryItem"));
			groceryList.add(groceryToAdd);
		}
		rs.close();
		ps.close();
		conn.close();
		return groceryList;
	}
	
}
