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
      /* �F�؍ς݂ɃZ�b�g */
      session.setAttribute("status", user);

      /* �g�b�v��ʂɖ߂� */
      response.sendRedirect("/keiziban/keizimann");
    }else{
      /* �o�^�Ɏ��s������A�o�^��ʂɖ߂� */
	session.setAttribute("status", null);
      session.setAttribute("register", "Not Auth");
      response.sendRedirect("/keiziban/keizimann");
    }
  }

  protected boolean authUser(String user, String pass){
    /* ��肠�������[�U�[���ƃp�X���[�h�����͂���Ă���ΔF�؂��� */
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