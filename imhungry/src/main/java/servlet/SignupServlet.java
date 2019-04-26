package servlet;


import java.io.FileNotFoundException;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_manager.GroceryDataManager;
import database_manager.RecipeDataManager;
import database_manager.RestaurantDataManager;
import database_manager.HistoryDataManager;
import database_manager.UserDataManager;
import info.*;
import user.User;




/**
 * Servlet implementation class myFirstServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @throws FileNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() throws FileNotFoundException {
        super();
        
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String next = "";
    	  String username = request.getParameter("username");
    	  String pw = request.getParameter("pw");
    	  String pw2 = request.getParameter("pw2");
    	  username = username.trim();
    	  pw = pw.trim();
    	  pw2 = pw2.trim();
    	  if (username.equals("") || pw.equals("") || pw2.equals("")) {
    	  if (username.equals(""))
    	  {
    	   next = "/signup.jsp"; //NEW
    	   request.setAttribute("uerror", "No Username Entered");
    	   //System.out.println("U empty");
    	  }
    	  if (pw.equals(""))
    	  {
    	   next = "/signup.jsp";
    	   request.setAttribute("perror", "No Password Entered");
    	   //System.out.println("P empty");
    	  }
    	  if (pw2.equals(""))
    	  {
    	   next = "/signup.jsp";
    	   request.setAttribute("perror", "No Password Entered");
    	   //System.out.println("P empty");
    	  }
    	  }
    	  else
    	  {
    	   if (!pw.equals(pw2))
    	   {
    	    next = "/signup.jsp";
    	    request.setAttribute("ierror", "Password Didn't Match");
    	   }
    	   else
    	   {
   		UserDataManager userDB = new UserDataManager(username);	
   		int check = userDB.checkPassword(username,pw);
   		System.out.println(check);
    	    if (check == 2) {
	    	    	User u =new User(username,pw);
	    	    	userDB.addUser(u);
	    	    	next = "/login.jsp";
    	    } else // verification passed, add to database, go back to sign up
    	    {
    	     next = "/signup.jsp";
    	     request.setAttribute("uerror", "User Already Exists");
    	    }
    	   }
    	  }
    	  RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
    	  dispatch.forward(request, response);
    	 }
    	}