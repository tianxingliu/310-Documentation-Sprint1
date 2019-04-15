package servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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
	//doGet test 2
	public void testServlet2() throws Exception {
		HttpSession session = mock(HttpSession.class);
		when(session.isNew()).thenReturn(false);
		when(session.getAttribute(any(String.class))).thenReturn(new ArrayList<Info>());
		
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
