import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import beans.*;
import dba.*;

public class RegisterCheck extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		request.setCharacterEncoding("Windows-31J");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(true);
		
		UserBean ub = new UserBean();
		DBAccess db = new DBAccess();
		ub.setName(user);
		request.setAttribute("ub",ub);
		
		db.init();
		//db.destory();
		boolean check = db.RegisterUser(user, pass);
		if (check){
			/* �F�؍ς݂ɃZ�b�g */
			session.setAttribute("status", user);
			
			/* �g�b�v��ʂɖ߂� */
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}else{
			/* �o�^�Ɏ��s������A�o�^��ʂɖ߂� */
			session.setAttribute("status", null);
			session.setAttribute("register", "Not Auth");
			RequestDispatcher dispatcher = request.getRequestDispatcher("keizimann");
			dispatcher.forward(request, response);
		}
	}
}