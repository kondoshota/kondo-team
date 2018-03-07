import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ThreadCheck extends HttpServlet {
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		response.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		
		HttpSession session = request.getSession(true);
		
		boolean check = authThread(title);
		if (check){
			response.sendRedirect("/keiziban/keizimann");
		}else{
			response.sendRedirect("/keiziban/keizimann");
		}
	}
	
	protected boolean authThread(String title){
		if (title == null || title.length() == 0){
			return false;
		}
		
		try {
			String sql = "insert into Thread(th_id,th_title,th_fdate,th_ldate) values (th_seq.nextval, ?,current_timestamp, current_timestamp)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			int num = pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}catch (SQLException e){
			log("SQLException:" + e.getMessage());
			return false;
		}
	}
}