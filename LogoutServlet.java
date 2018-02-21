package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
		dispatcher.forward(req, res);
	}
}