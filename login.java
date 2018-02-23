import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.sql.ResultSet;

class login extends Executer {
	
	public void execute(ServletRequest req) throws Exception{
		
		HttpSession session = req.getRequest().getSession();
		
		String userid = req.getUsername();
		String userpw = req.getUserpass();
		String sql = "select user_name from rv_user where user_id='"+ user_id +"' and user_pass='"+user_pass+"'";
		String _id = dba.getString(sql);
		if (userid.equals(_id)) {
			session.setAttribute("s_id",userid);
		}else{
			session.setAttribute("message","存在しないＩＤか、パスワードが違います");
		}
		
	}
}
