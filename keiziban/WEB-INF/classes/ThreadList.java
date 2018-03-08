import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import dba.*;

public class ThreadList extends HttpServlet { 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		request.setCharacterEncoding("Windows-31J");
		
		DBAccess db = new DBAccess();
		
		db.init();
		
		ArrayList al = new ArrayList();
		al = db.ReadThread();
		
		request.setAttribute("al", al);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
		dispatcher.forward(request, response);
		
	}
}