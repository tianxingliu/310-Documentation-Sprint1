package database_manager;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import info.Info;
import info.RestaurantInfo;
import user.User;

public class UserDataManagerTest {

	@Ignore
	@Test
	public void addUserAndCheckTest() throws SQLException {
		UserDataManager manager = new UserDataManager("nero");
		manager.addUser(new User("nero", "domusaurea"));
		assertEquals(manager.checkPassword("nero", "domusaurea"), 1);
	}
}
