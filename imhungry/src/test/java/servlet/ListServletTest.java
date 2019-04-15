package servlet;

import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import info.History;
import info.Info;
import info.RestaurantInfo;

public class ListServletTest {
	
	
	@Test
	//doPost test
	public void doPostTest1() throws IOException, ServletException {
		HttpSession session = mock(HttpSession.class);
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		BufferedReader reader = mock(BufferedReader.class);
		Stream<String> stream = (Stream<String>)mock(Stream.class);
		when(reader.lines()).thenReturn(stream);
		when(request.getReader()).thenReturn(reader);
		when(stream.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Quick Access\\\",\\\"body\\\":\\\"\\\\\\\"burger\\\\\\\"\\\"}\"}");
		when(request.getSession()).thenReturn(session);
		
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        new ListServlet().doPost(request, response);
        assertTrue(stringWriter.toString().contains("quick access"));
	}
	
	@Test
	//doPost test
	public void doPostTest2() throws IOException, ServletException {
		HttpSession session = mock(HttpSession.class);
		when(session.getAttribute("Favorites")).thenReturn((List<Info>)new ArrayList<Info>());
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		BufferedReader reader = mock(BufferedReader.class);
		Stream<String> stream = (Stream<String>)mock(Stream.class);
		when(reader.lines()).thenReturn(stream);
		when(request.getReader()).thenReturn(reader);
		when(stream.collect(any())).thenReturn("{\"header\":\"addItem\",\"body\":\"{\\\"header\\\":\\\"Favorites\\\",\\\"body\\\":\\\"{\\\\\\\"placeID\\\\\\\":\\\\\\\"ChIJ7w9tDvPHwoAR1n-EuEdjF1Y\\\\\\\",\\\\\\\"address\\\\\\\":\\\\\\\"2511 S Vermont Ave, Los Angeles\\\\\\\",\\\\\\\"priceLevel\\\\\\\":\\\\\\\"$\\\\\\\",\\\\\\\"driveTimeText\\\\\\\":\\\\\\\"7 mins\\\\\\\",\\\\\\\"driveTimeValue\\\\\\\":443,\\\\\\\"phone\\\\\\\":\\\\\\\"(323) 730-1461\\\\\\\",\\\\\\\"url\\\\\\\":\\\\\\\"https://locations.jackinthebox.com/us/ca/los-angeles/2511-s-vermont-ave\\\\\\\",\\\\\\\"name\\\\\\\":\\\\\\\"Jack in the Box\\\\\\\",\\\\\\\"rating\\\\\\\":4}\\\"}\"}");
		when(request.getSession()).thenReturn(session);
		
		HttpServletResponse response = mock(HttpServletResponse.class);
		StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        new ListServlet().doPost(request, response);
        assertTrue(stringWriter.toString().contains("Added to list"));
	}
	
	@Test
	//doPost test
	public void doPostTest3() throws IOException, ServletException {
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
	//doGet test if given input is not one of the predefined lists
	public void doGetTest1() throws ServletException, IOException { 
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<Info> list = new ArrayList<Info>();
		when(request.getParameter("list")).thenReturn("wrongList");
		when(request.getSession().getAttribute("Favorites")).thenReturn(list);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(list);
		when(request.getSession().getAttribute("To Explore")).thenReturn(list);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		servlet.doGet(request, response);
		String written = sw.toString();
		JsonObject json = new Gson().fromJson(written, JsonObject.class);
		String result = json.get("header").getAsString();
		assertEquals("invalid list mistake","Invalid List!",result);
	}
	
	@Test
	//doGet test if given input is empty string
	public void doGetTest2() throws ServletException, IOException {
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<Info> list = new ArrayList<Info>();
		when(request.getParameter("list")).thenReturn("");
		when(request.getSession().getAttribute("Favorites")).thenReturn(list);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(list);
		when(request.getSession().getAttribute("To Explore")).thenReturn(list);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		servlet.doGet(request, response);
		String written = sw.toString();
		JsonObject json = new Gson().fromJson(written, JsonObject.class);
		String result = json.get("header").getAsString();
		assertEquals("invalid list mistake", "Invalid List!",result);
	}
	
	@Test
	//doGet test the fetching of favorite list
	public void doGetTest3() throws ServletException, IOException {
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<Info> listAc = new ArrayList<Info>();
		List<Info> list = new ArrayList<Info>();
		RestaurantInfo ri = new RestaurantInfo("string", 767812, "string", "string", 0, "string", 0, "string", "string");
		listAc.add(ri);
		when(request.getParameter("list")).thenReturn("Favorites");
		when(request.getSession().getAttribute("Favorites")).thenReturn(listAc);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(list);
		when(request.getSession().getAttribute("To Explore")).thenReturn(list);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		servlet.doGet(request, response);
		String written = sw.toString();
		JsonObject json = new Gson().fromJson(written, JsonObject.class);
		String result = json.get("header").getAsString();
		JsonElement jsonelement = json.get("body");
		JsonArray jsonarray = jsonelement.getAsJsonArray();
		JsonObject json2 = jsonarray.get(0).getAsJsonObject();
		String subresult = json2.get("rating").getAsString();
		assertEquals("invalid list name mistake","Favorites",result);
		assertEquals("invalid list content mistake","767812",subresult);
	}
	
	@Test
	//doGet test the fetching of the Do Not Show list test
	public void doGetTest4() throws ServletException, IOException {
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<Info> listAc = new ArrayList<Info>();
		List<Info> list = new ArrayList<Info>();
		RestaurantInfo ri = new RestaurantInfo("string", 244, "string", "string", 0, "string", 0, "string", "github.com");
		listAc.add(ri);
		when(request.getParameter("list")).thenReturn("Do Not Show");
		when(request.getSession().getAttribute("Favorites")).thenReturn(list);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(listAc);
		when(request.getSession().getAttribute("To Explore")).thenReturn(list);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		servlet.doGet(request, response);
		String written = sw.toString();
		JsonObject json = new Gson().fromJson(written, JsonObject.class);
		String result = json.get("header").getAsString();
		JsonElement jsonelement = json.get("body");
		JsonArray jsonarray = jsonelement.getAsJsonArray();
		JsonObject json2 = jsonarray.get(0).getAsJsonObject();
		String subresult = json2.get("url").getAsString();
		String subresult2 = json2.get("rating").getAsString();
		assertEquals("invalid list name mistake","Do Not Show",result);
		assertEquals("invalid list url mistake", "github.com",subresult);
		assertEquals("invalid list content mistake","244",subresult2);
	}
	
	@Test
	//doGet test the fetching of the To Explore list test
	public void doGetTest5() throws ServletException, IOException {
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<Info> listAc = new ArrayList<Info>();
		List<Info> list = new ArrayList<Info>();
		RestaurantInfo ri = new RestaurantInfo("string", 20, "string", "string", 0, "string", 0, "string", "google.com");
		listAc.add(ri);
		when(request.getParameter("list")).thenReturn("To Explore");
		when(request.getSession().getAttribute("Favorites")).thenReturn(list);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(list);
		when(request.getSession().getAttribute("To Explore")).thenReturn(listAc);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		servlet.doGet(request, response);
		String written = sw.toString();
		JsonObject json = new Gson().fromJson(written, JsonObject.class);
		String result = json.get("header").getAsString();
		JsonElement jsonelement = json.get("body");
		JsonArray jsonarray = jsonelement.getAsJsonArray();
		JsonObject json2 = jsonarray.get(0).getAsJsonObject();
		String subresult = json2.get("url").getAsString();
		String subresult2 = json2.get("rating").getAsString();
		assertEquals("invalid list name mistake","To Explore",result);
		assertEquals("invalid list url mistake", "google.com",subresult);
		assertEquals("invalid list content mistake","20",subresult2);
	}

	@Test
	//doGet test the fetching of the Quick Access list test
	public void doGetTest6() throws ServletException, IOException {
		ListServlet servlet = new ListServlet();
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		when(request.getSession()).thenReturn(session);
		List<History> listAc = new ArrayList<History>();
		List<Info> list = new ArrayList<Info>();
		listAc.add(new History("chicken", 1, 2000));
		when(request.getParameter("list")).thenReturn("Quick Access");
		when(request.getSession().getAttribute("Favorites")).thenReturn(list);
		when(request.getSession().getAttribute("Do Not Show")).thenReturn(list);
		when(request.getSession().getAttribute("To Explore")).thenReturn(list);
		when(request.getSession().getAttribute("Quick Access")).thenReturn(listAc);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		when(response.getWriter()).thenReturn(pw);
		
		servlet.doGet(request, response);
		assertTrue(sw.toString().contains("chicken"));
	}
	
}
