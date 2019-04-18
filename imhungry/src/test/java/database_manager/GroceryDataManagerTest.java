package database_manager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import info.GroceryInfo;
import info.Info;
import servlet.ListServlet;

public class GroceryDataManagerTest {

	@Test
	public void addToListAndLoadGroceryTest() throws SQLException {
		GroceryInfo ingredient = new GroceryInfo("tomato");
		GroceryDataManager gd = new GroceryDataManager();
		gd.addToList(ingredient);
		ArrayList<Info> list = gd.loadGrocery();
		assert(list.size() >= 0);
	}
	
}
