package servlet;

import java.io.FileNotFoundException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_manager.UserDataManager;
import info.*;



/**
 * Servlet implementation class myFirstServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws FileNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() throws FileNotFoundException {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String logoutformSIGNAL = "";
		logoutformSIGNAL = request.getParameter("logoutformSIGNAL");
		if (logoutformSIGNAL.equals("logoutformSIGNAL"))
		{
			String next = "/searchPage.jsp";
			HttpSession session=request.getSession(true);
	        session.setAttribute("log","logout");
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
			dispatch.forward(request, response);
			return;
		}
		String next = "";
		String username = request.getParameter("username");
		String pw = request.getParameter("pw");
		username = username.trim();
		pw = pw.trim();
		if (username.equals("") || pw.equals("")) {
			if (username.equals("")) {
				next = "/login.jsp";
				request.setAttribute("uerror", "No Username Entered");
			}
			if (pw.equals("")) {
				next = "/login.jsp";
				request.setAttribute("perror", "No Password Entered");
			}
		} else {
			UserDataManager userDB = new UserDataManager(username);
			
			int check = userDB.checkPassword(username,pw);
			if (check != 1) {
				next = "/login.jsp";
				request.setAttribute("uerror", "Username or Password wrong");
				request.setAttribute("perror", "Username or Password wrong");
			} else {
				next = "/searchPage.jsp"; //successfully login
				response.setContentType("text/html"); // what's this for?
				HttpSession session=request.getSession(true);
		        session.setAttribute("log","login");
			}
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		dispatch.forward(request, response);
	}
}