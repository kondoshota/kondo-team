import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import dba.*;

public class ThreadCheck extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		request.setCharacterEncoding("Windows-31J");
		
		String title = request.getParameter("title");
		String maker = request.getParameter("maker");
		
		UserBean ub = new UserBean();
		DBAccess db = new DBAccess();
		
		db.init();
		
		boolean check = db.WriteThread(title, maker);
		if (check){
			ThreadBean tb = new ThreadBean();
			tb.setTitle(title);
			request.setAttribute("tb",tb);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}
	}
}