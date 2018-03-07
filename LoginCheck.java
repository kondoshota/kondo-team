import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginCheck extends HttpServlet {
	protected Connection conn = null;
	
	public void init() throws ServletException{
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "info";
		String password = "pro";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e){
			log("ClassNotFoundException:" + e.getMessage());
		}catch (SQLException e){
			log("SQLException:" + e.getMessage());
		}catch (Exception e){
			log("Exception:" + e.getMessage());
		}
	}
	
	public void destory(){
		try{
			if (conn != null){
				conn.close();
			}
		}catch (SQLException e){
			log("SQLException:" + e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		response.setContentType("text/html; charset=Shift_JIS");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		boolean check = authUser(user, pass);
		if (check){
			/* 認証済みにセット */
			session.setAttribute("status", user);
			response.sendRedirect("/keiziban/keizimann");
		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("status", null);
			session.setAttribute("login", "Not Auth");
			response.sendRedirect("/keiziban/keizimann");
		}
	}
	
	protected boolean authUser(String user, String pass){
		/* 取りあえずユーザー名とパスワードが入力されていれば認証できる*/
		if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
			return false;
		}
		
		try {
			String sql = "SELECT * FROM rv_User WHERE user_name = ? and user_pass = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				String sql2 = "UPDATE rv_User SET user_ldate=current_timestamp where user_name = ?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, user);
				int num = pstmt2.executeUpdate();
				return true;
			}else{
				return false;
			}
		}catch (SQLException e){
			log("SQLException:" + e.getMessage());
			return false;
		}
	}
}