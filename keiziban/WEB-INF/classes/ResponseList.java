import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import dba.*;

public class ResponseList extends HttpServlet { 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("Windows-31J");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		
		DBAccess db = new DBAccess();
		
		db.init();
		
		ArrayList al = new ArrayList();
		al = db.ReadRes();
		
		request.setAttribute("al", al);
		request.setAttribute("id", id);
		request.setAttribute("title", title);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("thread");
		dispatcher.forward(request, response);
		
	}
}