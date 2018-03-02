import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DatabaseTest2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{

        response.setContentType("text/html; charset=Shift_JIS");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>データベーステスト</title>");
        out.println("</head>");
        out.println("<body>");

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "info";
        String password = "pro";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM emp";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                out.println("<p>");
                out.println("コード:" + empno + " 名前:" + ename);
                out.println("</p>");
            }

            rs.close();
            stmt.close();

        }catch (ClassNotFoundException e){
            out.println("ClassNotFoundException:" + e.getMessage());
        }catch (SQLException e){
            out.println("SQLException:" + e.getMessage());
        }catch (Exception e){
            out.println("Exception:" + e.getMessage());
        }finally{
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                out.println("SQLException:" + e.getMessage());
            }
        }

        out.println("</body>");
        out.println("</html>");
    }
}