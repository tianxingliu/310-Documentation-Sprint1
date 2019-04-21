package database_manager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import info.GroceryInfo;
import info.Info;

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
