import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import dba.*;

public class LoginCheck extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		request.setCharacterEncoding("Windows-31J");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		
		UserBean ub = new UserBean();
		DBAccess db = new DBAccess();
		ub.setName(user);
		request.setAttribute("ub", ub);
		
		db.init();
		//db.destory();
		boolean check = db.LoginUser(user, pass);
		if (check){
			/* 認証済みにセット */
			session.setAttribute("status", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("status", null);
			session.setAttribute("login", "Not Auth");
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}
	}
}