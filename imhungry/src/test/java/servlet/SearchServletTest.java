package servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import info.Info;
import info.RecipeInfo;
import info.RestaurantInfo;

public class SearchServletTest {
	
	@Test
	//doGet test 1
	public void testServlet1() throws Exception {
		HttpSession session = mock(HttpSession.class);
		when(session.isNew()).thenReturn(true);
		
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("search")).thenReturn("burger");
        when(request.getParameter("number")).thenReturn("1");
        when(request.getParameter("radius")).thenReturn("5000");
        when(request.getSession()).thenReturn(session);
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        new SearchServlet().doGet(request, response);
        assertTrue(stringWriter.toString().contains("Success"));
	}
	
	@Test
	//doPost test: add to grocery
	public void doPostTest4() throws IOException, ServletException {
		HttpSession session = mock(HttpSession.class);
		when(session.getAttribute("Grocery")).thenReturn((List<Info>)new ArrayList<Info>());
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		BufferedReader reader = mock(BufferedReader.class);
		Stream<String> stream = (Stream<String>)mock(Stream.class);
		when(reader.lines()).thenReturn(stream);
		when(request.getReader()).thenReturn(reader);
		when(stream.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Grocery\\\",\\\"body\\\":\\\"{\\\\\\\"recipeID\\\\\\\":449835,\\\\\\\"prepTime\\\\\\\":15,\\\\\\\"cookTime\\\\\\\":20,\\\\\\\"ingredients\\\\\\\":[\\\\\\\"barbeque sauce\\\\\\\",\\\\\\\"ground cayenne pepper\\\\\\\",\\\\\\\"ground turkey breast\\\\\\\",\\\\\\\"hamburger buns\\\\\\\",\\\\\\\"honey\\\\\\\",\\\\\\\"horseradish\\\\\\\",\\\\\\\"jalapeno pepper\\\\\\\",\\\\\\\"light mayonnaise\\\\\\\",\\\\\\\"liquid smoke\\\\\\\",\\\\\\\"mayo\\\\\\\",\\\\\\\"mustard\\\\\\\",\\\\\\\"olive oil\\\\\\\",\\\\\\\"onion\\\\\\\",\\\\\\\"pepper sauce\\\\\\\",\\\\\\\"seasoning mix\\\\\\\",\\\\\\\"steak seasoning\\\\\\\",\\\\\\\"turkey burgers\\\\\\\",\\\\\\\"worcestershire sauce\\\\\\\"],\\\\\\\"instructions\\\\\\\":[\\\\\\\"1. Combine mayonnaise, mustard, honey, horseradish, hot pepper sauce, and cayenne pepper in a bowl. Cover and refrigerate.\\\\\\\",\\\\\\\"2. Mix ground turkey, grated onion, jalapeno, barbeque sauce, Worcestershire sauce, liquid smoke, steak seasoning, and mesquite seasoning in a large bowl. Form into 5 patties.\\\\\\\",\\\\\\\"3. Heat the olive oil in a skillet over medium heat. Stir in the onion; cook and stir until the onion has softened and turned translucent, about 5 minutes. Reduce heat to medium-low, and continue cooking and stirring until the onion is very tender and dark brown, 15 to 20 minutes more.\\\\\\\",\\\\\\\"4. Cook the patties in a medium skillet over medium heat, turning once, to an internal temperature of 180 degrees F (85 degrees C), about 6 minutes per side.\\\\\\\",\\\\\\\"5. Serve on buns topped with spicy sweet mayo and caramelized onions.\\\\\\\"],\\\\\\\"imageURL\\\\\\\":\\\\\\\"https://spoonacular.com/recipeImages/449835-556x370.jpg\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Kickin' Turkey Burger with Caramelized Onions and Spicy Sweet Mayo\\\\\\\",\\\\\\\"rating\\\\\\\":4}\\\"}\"}");
		when(request.getSession()).thenReturn(session);
		
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        new ListServlet().doPost(request, response);
        assertTrue(stringWriter.toString().contains("Added to list"));
	}
	
	@Test
	//doGet test 2
	public void testServlet2() throws Exception {
		HttpSession session2 = mock(HttpSession.class);
		when(session2.getAttribute(any(String.class))).thenReturn((List<Info>)new ArrayList<Info>());
		
		ListServlet listServlet = new ListServlet();
		
		HttpServletResponse response2 = mock(HttpServletResponse.class);
		StringWriter stringWriter2 = new StringWriter();
        PrintWriter writer2 = new PrintWriter(stringWriter2);
        when(response2.getWriter()).thenReturn(writer2);
        
        //add restaurant to database
		HttpServletRequest request1 = mock(HttpServletRequest.class);
		BufferedReader reader1 = mock(BufferedReader.class);
		Stream<String> stream1 = (Stream<String>)mock(Stream.class);
		when(reader1.lines()).thenReturn(stream1);
		when(request1.getReader()).thenReturn(reader1);
		when(stream1.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Favorites\\\",\\\"body\\\":\\\"{\\\\\\\"placeID\\\\\\\":\\\\\\\"ChIJ7w9tDvPHwoAR1n-EuEdjF1Y\\\\\\\",\\\\\\\"address\\\\\\\":\\\\\\\"2511 S Vermont Ave, Los Angeles\\\\\\\",\\\\\\\"priceLevel\\\\\\\":\\\\\\\"$\\\\\\\",\\\\\\\"driveTimeText\\\\\\\":\\\\\\\"7 mins\\\\\\\",\\\\\\\"driveTimeValue\\\\\\\":443,\\\\\\\"phone\\\\\\\":\\\\\\\"(323) 730-1461\\\\\\\",\\\\\\\"url\\\\\\\":\\\\\\\"https://locations.jackinthebox.com/us/ca/los-angeles/2511-s-vermont-ave\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Jack in the Box\\\\\\\",\\\\\\\"rating\\\\\\\":4}\\\"}\"}");
		when(request1.getSession()).thenReturn(session2);
		listServlet.doPost(request1, response2);
		
		//add recipe to database
		HttpServletRequest request2 = mock(HttpServletRequest.class);
		BufferedReader reader2 = mock(BufferedReader.class);
		Stream<String> stream2 = (Stream<String>)mock(Stream.class);
		when(reader2.lines()).thenReturn(stream2);
		when(request2.getReader()).thenReturn(reader2);
		when(stream2.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Do Not Show\\\",\\\"body\\\":\\\"{\\\\\\\"recipeID\\\\\\\":669071,\\\\\\\"prepTime\\\\\\\":5,\\\\\\\"cookTime\\\\\\\":16,\\\\\\\"ingredients\\\\\\\":[\\\\\\\"blueberries\\\\\\\",\\\\\\\"bread\\\\\\\",\\\\\\\"chili powder\\\\\\\",\\\\\\\"ground pepper\\\\\\\",\\\\\\\"monterey jack cheese\\\\\\\",\\\\\\\"olive oil\\\\\\\",\\\\\\\"peaches\\\\\\\",\\\\\\\"salt\\\\\\\",\\\\\\\"turkey burgers\\\\\\\"],\\\\\\\"instructions\\\\\\\":[\\\\\\\"1. Preheat grill to medium heat. Lightly brush both sides of FROZENturkey burgers with olive oil and place on grill about 4-inch above heat. Grillburgers 8 minutes on one side. Turn and grill other side 7 minutes or untildone and a meat thermometer inserted in center of burger registers 165F.\\\\\\\",\\\\\\\"2. Add cheese; cover and cook 1 minute more.Meanwhile, in a large skillet combine peaches, blueberries, and chili powder. Cook, stirring occasionally, over medium heat for 5 to 6 minutes or until heated through and juices are beginning to form.Top each piece of garlic bread with one turkey burger and some of the peach mixture. If desired, top with mint and additional chili powder.\\\\\\\"],\\\\\\\"imageURL\\\\\\\":\\\\\\\"https://spoonacular.com/recipeImages/669071-556x370.jpg\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Grilled Monterey Jack Turkey Burger with Peaches and Blueberries\\\\\\\",\\\\\\\"rating\\\\\\\":2}\\\"}\"}");
		when(request2.getSession()).thenReturn(session2);
		listServlet.doPost(request2, response2);
		
		//add search history to database
		HttpServletRequest request4 = mock(HttpServletRequest.class);
		BufferedReader reader4 = mock(BufferedReader.class);
		Stream<String> stream4 = (Stream<String>)mock(Stream.class);
		when(reader4.lines()).thenReturn(stream4);
		when(request4.getReader()).thenReturn(reader4);
		when(stream4.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Quick Access\\\",\\\"body\\\":\\\"\\\\\\\"burger\\\\\\\"\\\"}\"}");
		when(request4.getSession()).thenReturn(session2);
		listServlet.doPost(request4, response2);
		
		HttpSession session = mock(HttpSession.class);
		when(session.isNew()).thenReturn(false);
		when(session.getAttribute(any(String.class))).thenReturn(new ArrayList<Info>());
		
		//perform search
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getParameter("search")).thenReturn("burger");
        when(request.getParameter("number")).thenReturn("1");
        when(request.getParameter("radius")).thenReturn("5000");
        when(request.getSession()).thenReturn(session);
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        new SearchServlet().doGet(request, response);
        assertTrue(stringWriter.toString().contains("Success"));
        
        //remove restaurant from database
        HttpServletRequest request1d = mock(HttpServletRequest.class);
		BufferedReader reader1d = mock(BufferedReader.class);
		Stream<String> stream1d = (Stream<String>)mock(Stream.class);
		when(reader1d.lines()).thenReturn(stream1d);
		when(request1d.getReader()).thenReturn(reader1d);
		when(stream1d.collect(any())).thenReturn("{\"header\":\"removeItem\",\"body\":\"{\\\"header\\\":\\\"Favorites\\\",\\\"body\\\":\\\"{\\\\\\\"placeID\\\\\\\":\\\\\\\"ChIJ7w9tDvPHwoAR1n-EuEdjF1Y\\\\\\\",\\\\\\\"address\\\\\\\":\\\\\\\"2511 S Vermont Ave, Los Angeles\\\\\\\",\\\\\\\"priceLevel\\\\\\\":\\\\\\\"$\\\\\\\",\\\\\\\"driveTimeText\\\\\\\":\\\\\\\"7 mins\\\\\\\",\\\\\\\"driveTimeValue\\\\\\\":443,\\\\\\\"phone\\\\\\\":\\\\\\\"(323) 730-1461\\\\\\\",\\\\\\\"url\\\\\\\":\\\\\\\"https://locations.jackinthebox.com/us/ca/los-angeles/2511-s-vermont-ave\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Jack in the Box\\\\\\\",\\\\\\\"rating\\\\\\\":4}\\\"}\"}");
		when(request1d.getSession()).thenReturn(session2);
		listServlet.doPost(request1d, response2);
		
		//remove recipe from database
		HttpServletRequest request2d = mock(HttpServletRequest.class);
		BufferedReader reader2d = mock(BufferedReader.class);
		Stream<String> stream2d = (Stream<String>)mock(Stream.class);
		when(reader2d.lines()).thenReturn(stream2d);
		when(request2d.getReader()).thenReturn(reader2d);
		when(stream2d.collect(any())).thenReturn("{\"header\":\"removeItem\",\"body\":\"{\\\"header\\\":\\\"Do Not Show\\\",\\\"body\\\":\\\"{\\\\\\\"recipeID\\\\\\\":669071,\\\\\\\"prepTime\\\\\\\":5,\\\\\\\"cookTime\\\\\\\":16,\\\\\\\"ingredients\\\\\\\":[\\\\\\\"blueberries\\\\\\\",\\\\\\\"bread\\\\\\\",\\\\\\\"chili powder\\\\\\\",\\\\\\\"ground pepper\\\\\\\",\\\\\\\"monterey jack cheese\\\\\\\",\\\\\\\"olive oil\\\\\\\",\\\\\\\"peaches\\\\\\\",\\\\\\\"salt\\\\\\\",\\\\\\\"turkey burgers\\\\\\\"],\\\\\\\"instructions\\\\\\\":[\\\\\\\"1. Preheat grill to medium heat. Lightly brush both sides of FROZENturkey burgers with olive oil and place on grill about 4-inch above heat. Grillburgers 8 minutes on one side. Turn and grill other side 7 minutes or untildone and a meat thermometer inserted in center of burger registers 165F.\\\\\\\",\\\\\\\"2. Add cheese; cover and cook 1 minute more.Meanwhile, in a large skillet combine peaches, blueberries, and chili powder. Cook, stirring occasionally, over medium heat for 5 to 6 minutes or until heated through and juices are beginning to form.Top each piece of garlic bread with one turkey burger and some of the peach mixture. If desired, top with mint and additional chili powder.\\\\\\\"],\\\\\\\"imageURL\\\\\\\":\\\\\\\"https://spoonacular.com/recipeImages/669071-556x370.jpg\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Grilled Monterey Jack Turkey Burger with Peaches and Blueberries\\\\\\\",\\\\\\\"rating\\\\\\\":2}\\\"}\"}");
		when(request2d.getSession()).thenReturn(session2);
		listServlet.doPost(request2d, response2);
		
		//remove grocery from database
		HttpServletRequest request3d = mock(HttpServletRequest.class);
		BufferedReader reader3d = mock(BufferedReader.class);
		Stream<String> stream3d = (Stream<String>)mock(Stream.class);
		when(reader3d.lines()).thenReturn(stream3d);
		when(request3d.getReader()).thenReturn(reader3d);
		when(stream3d.collect(any())).thenReturn("{\"header\":\"removeItem\",\"body\":\"{\\\"header\\\":\\\"Grocery\\\",\\\"body\\\":\\\"{\\\\\\\"recipeID\\\\\\\":449835,\\\\\\\"prepTime\\\\\\\":15,\\\\\\\"cookTime\\\\\\\":20,\\\\\\\"ingredients\\\\\\\":[\\\\\\\"barbeque sauce\\\\\\\",\\\\\\\"ground cayenne pepper\\\\\\\",\\\\\\\"ground turkey breast\\\\\\\",\\\\\\\"hamburger buns\\\\\\\",\\\\\\\"honey\\\\\\\",\\\\\\\"horseradish\\\\\\\",\\\\\\\"jalapeno pepper\\\\\\\",\\\\\\\"light mayonnaise\\\\\\\",\\\\\\\"liquid smoke\\\\\\\",\\\\\\\"mayo\\\\\\\",\\\\\\\"mustard\\\\\\\",\\\\\\\"olive oil\\\\\\\",\\\\\\\"onion\\\\\\\",\\\\\\\"pepper sauce\\\\\\\",\\\\\\\"seasoning mix\\\\\\\",\\\\\\\"steak seasoning\\\\\\\",\\\\\\\"turkey burgers\\\\\\\",\\\\\\\"worcestershire sauce\\\\\\\"],\\\\\\\"instructions\\\\\\\":[\\\\\\\"1. Combine mayonnaise, mustard, honey, horseradish, hot pepper sauce, and cayenne pepper in a bowl. Cover and refrigerate.\\\\\\\",\\\\\\\"2. Mix ground turkey, grated onion, jalapeno, barbeque sauce, Worcestershire sauce, liquid smoke, steak seasoning, and mesquite seasoning in a large bowl. Form into 5 patties.\\\\\\\",\\\\\\\"3. Heat the olive oil in a skillet over medium heat. Stir in the onion; cook and stir until the onion has softened and turned translucent, about 5 minutes. Reduce heat to medium-low, and continue cooking and stirring until the onion is very tender and dark brown, 15 to 20 minutes more.\\\\\\\",\\\\\\\"4. Cook the patties in a medium skillet over medium heat, turning once, to an internal temperature of 180 degrees F (85 degrees C), about 6 minutes per side.\\\\\\\",\\\\\\\"5. Serve on buns topped with spicy sweet mayo and caramelized onions.\\\\\\\"],\\\\\\\"imageURL\\\\\\\":\\\\\\\"https://spoonacular.com/recipeImages/449835-556x370.jpg\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Kickin' Turkey Burger with Caramelized Onions and Spicy Sweet Mayo\\\\\\\",\\\\\\\"rating\\\\\\\":4}\\\"}\"}");
		when(request3d.getSession()).thenReturn(session2);
		listServlet.doPost(request3d, response2);
		
		//remove search history from database
		HttpServletRequest request4d = mock(HttpServletRequest.class);
		BufferedReader reader4d = mock(BufferedReader.class);
		Stream<String> stream4d = (Stream<String>)mock(Stream.class);
		when(reader4d.lines()).thenReturn(stream4d);
		when(request4d.getReader()).thenReturn(reader4d);
		when(stream4d.collect(any())).thenReturn("{\"header\":\"removeItem\",\"body\":\"{\\\"header\\\":\\\"Quick Access\\\",\\\"body\\\":\\\"\\\\\\\"burger\\\\\\\"\\\"}\"}");
		when(request4d.getSession()).thenReturn(session2);
		listServlet.doPost(request4d, response2);
	}
	
	@Test
	//URL API value test 1
	public void getImageUrlTest1() {
		SearchServlet servlet = new SearchServlet();
		ArrayList<String> testConfirm = servlet.getImageURLs("Noodle");
		assertEquals(10,testConfirm.size());
	}
	
	@Test
	//URL API value test 2
	public void getImageUrlTest2() {
		SearchServlet servlet = new SearchServlet();
		ArrayList<String> testConfirm = servlet.getImageURLs("Dumpling");
		assertEquals(10,testConfirm.size());
	}
	
	@Test
	//getPhoneandURL test
	public void getPhoneURLTest1() {
		SearchServlet servlet = new SearchServlet();
		RestaurantInfo ri = new RestaurantInfo("Chipotle", 1, "ChIJXQa3SffHwoARbWWdPwK_Ums", "1", 1, "1", 1, "1", "1");
		ArrayList<RestaurantInfo> testConfirm = new ArrayList<RestaurantInfo>();
		testConfirm.add(ri);
		servlet.getPhoneAndURL(testConfirm);
		assertEquals(1,testConfirm.size());
		assertEquals("(323) 766-9775",testConfirm.get(0).phone);
		assertEquals("https://himalayanhouse.menufy.com/#/",testConfirm.get(0).url);
	}
	
	@Test
	//getDriveTimes test
	public void getDriveTimesTest1() {
		SearchServlet servlet = new SearchServlet();
		RestaurantInfo ri = new RestaurantInfo("Chipotle", 1, "ChIJXQa3SffHwoARbWWdPwK_Ums", "1", 1, "1", 1, "1", "1");
		ArrayList<RestaurantInfo> testConfirm = new ArrayList<RestaurantInfo>();
		testConfirm.add(ri);
		servlet.getDriveTimes(testConfirm);
		assertEquals(1,testConfirm.size());
		assert(testConfirm.get(0).driveTimeValue > 100 && testConfirm.get(0).driveTimeValue < 600);
	}
	@Test
	//getting the Restaurant arraylist API test with radius = 1000
	public void getResInfoTest1() {
		SearchServlet servlet = new SearchServlet();
		List<Info> empty1 = new ArrayList<Info>();
		List<Info> empty2 = new ArrayList<Info>();
		ArrayList<RestaurantInfo> rest = servlet.restaurantSearch("Chipotle", 10, 1000, empty1, empty2);
		assertEquals(1,rest.size());
	}
	
	@Test
	//getting the Restaurant arraylist API test with radius = 10000
	public void getResInfoTest2() {
		SearchServlet servlet = new SearchServlet();
		List<Info> empty1 = new ArrayList<Info>();
		List<Info> empty2 = new ArrayList<Info>();
		ArrayList<RestaurantInfo> rest = servlet.restaurantSearch("Chipotle", 10, 10000, empty1, empty2);
		assertEquals(10,rest.size());
	}
	
	@Test
	//getting the Recipe arraylist API test
	public void getReciInfoTest() {
		SearchServlet servlet = new SearchServlet();
		List<Info> empty1 = new ArrayList<Info>();
		List<Info> empty2 = new ArrayList<Info>();
		ArrayList<RecipeInfo> rest = servlet.recipeSearch("beef", 1, empty1, empty2);
		assertEquals(1,rest.size());
	}
	
}
