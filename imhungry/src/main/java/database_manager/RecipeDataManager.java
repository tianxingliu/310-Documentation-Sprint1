package database_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import info.RecipeInfo;

public class RecipeDataManager extends DataManager {
	
	//TODO
	public void addToList(RecipeInfo recipe, String listName) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // get driver for database
			conn = DriverManager.getConnection(JDBC_CONNECTION);
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				System.out.println("sqle closing conn: " + sqle.getMessage());
			}
		}
	}
	
	//TODO
	public void removeFromList(int recipeID, String listName) {}
	
	//TODO
	public ArrayList<RecipeInfo> loadRecipes(){
		return null;
	} 
}
