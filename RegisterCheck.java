import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterCheck extends HttpServlet {
  protected Connection conn = null;

  public void init() throws ServletException{
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "info";
    String password = "pro";

    try {
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

    HttpSession session = request.getSession(true);

    boolean check = authUser(user, pass);
    if (check){
      /* 認証済みにセット */
      session.setAttribute("status", user);

      /* トップ画面に戻す */
      response.sendRedirect("/keiziban/keizimann");
    }else{
      /* 登録に失敗したら、登録画面に戻す */
	session.setAttribute("status", null);
      session.setAttribute("register", "Not Auth");
      response.sendRedirect("/keiziban/keizimann");
    }
  }

  protected boolean authUser(String user, String pass){
    /* 取りあえずユーザー名とパスワードが入力されていれば認証する */
    if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
      return false;
    }

    try {
    	String sql = "insert into rv_User(user_id,user_name,user_pass,user_fdate,user_ldate) values (user_seq.nextval, ?, ?, current_timestamp, current_timestamp)";
      PreparedStatement pstmt = conn.prepareStatement(sql);
    	
      pstmt.setString(1, user);
      pstmt.setString(2, pass);
      int num = pstmt.executeUpdate();
    	
    	pstmt.close();
    	
        return true;
    	
    }catch (SQLException e){
      log("SQLException:" + e.getMessage());
      return false;
    }
  }
}