import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import dba.*;
import beans.*;

public class ResponseCheck extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		request.setCharacterEncoding("Windows-31J");
		String res = request.getParameter("res");
		String toko = request.getParameter("toko");
		String id = request.getParameter("id");
		
		
		HttpSession session = request.getSession();
		
		
		DBAccess db = new DBAccess();
		
		db.init();
		
		
		boolean check = db.WriteRes(res,toko,id);
		if (check){
			ResBean rb = new ResBean();
			rb.setTh_id(Integer.parseInt(id));
			request.setAttribute("rb",rb);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}
		
	}
}