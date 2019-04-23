package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Message.Message;
import Message.SearchResult;
import database_manager.GroceryDataManager;
import database_manager.RecipeDataManager;
import database_manager.RestaurantDataManager;
import database_manager.HistoryDataManager;
import database_manager.UserDataManager;
import info.*;

import java.net.*;
import java.io.Reader.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


 @WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {	
	        HttpSession session = request.getSession();
	        String username = request.getParameter("username"); //See what list was requested
	        String password = request.getParameter("password"); 
    			UserDataManager userdata = new UserDataManager(username);
    			Boolean check = userdata.checkPassword(username, password);
	        PrintWriter respWriter = response.getWriter();
	        Gson gson = new Gson();
			if(check) {
	            respWriter.println(gson.toJson(new Message("success")));
			}else {
				respWriter.println(gson.toJson(new Message("Fail")));
			}
            respWriter.close();
		}
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {	
	        HttpSession session = request.getSession();
	        String username = request.getParameter("username"); //See what list was requested
	        String password = request.getParameter("password"); 
	        User newUser = new User(username,password);
 			UserDataManager userdata = new UserDataManager(username);
 			userdata.addUser(newUser);
	        PrintWriter respWriter = response.getWriter();
	        Gson gson = new Gson();
	        respWriter.close();
		}
	 
	 
	 
}
