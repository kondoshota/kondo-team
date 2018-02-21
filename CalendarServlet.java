import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Calendar;

public class CalendarServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		int year;
		
		String param = req.getParameter("YEAR");
		if (param == null || param.length() == 0){
			year = -999;
		}else{
			try{
				year = Integer.parseInt(param);
			}catch (NumberFormatException e){
				year = -999;
			}
		}
		
		if (year == -999){
			Calendar calendar = Calendar.getInstance();
			year = calendar.get(Calendar.YEAR);
		}
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0.1//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
		
		sb.append("<html lang=\"ja\">");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" Content=\"text/html;charset=UTF-8\">");
		
		sb.append("<title>カレンダー機能</title>");
		
		sb.append("<style>");
		sb.append("table{border:1px solid #a9a9a9;width:90%;padding:0px;margin:0px;border-collapse:collapse;}");
		sb.append("td{width:12%;border-top:1px solid #a9a9a9;border-left:1px solid #a9a9a9;vertical-align:top;margin:0px;padding:2px;}");
		sb.append("td.month{background-color:#f5f5f5;text-align:right;font-size:0.75em;}");
		sb.append("td.sche{background-color:#fffffff;text-align:left;height:80px;}");
		sb.append("img{border:0px;}");
		sb.append("p{font-size:0.75em;}");
		sb.append("</style>");
		
		sb.append("</head>");
		sb.append("<body>");
		
		sb.append(createYearLink(year));
		
		sb.append("<table>");
		
		sb.append("<tr><td class=\"month\">1月</td><td class=\"month\">2月</td><td class=\"month\">3月</td><td class=\"month\">4月</td></tr>");
		sb.append(createScheduleStr());
		
		sb.append("<tr><td class=\"month\">5月</td><td class=\"month\">6月</td><td class=\"month\">7月</td><td class=\"month\">8月</td></tr>");
		sb.append(createScheduleStr());
		
		sb.append("<tr><td class=\"month\">9月</td><td class=\"month\">10月</td><td class=\"month\">11月</td><td class=\"month\">12月</td></tr>");
		sb.append(createScheduleStr());
		
		sb.append("</table>");
		
		sb.append("</body>");
		sb.append("</html>");
		
		out.println(new String(sb));
	}
	
	protected String createScheduleStr(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<tr>");
		for (int i = 0 ; i < 4 ; i++){
			sb.append("<td class=\"sche\"><img src=\"./img/memo.png\" width=\"14\" height=\"16\"></td>");
		}
		sb.append("</tr>");
		
		return (new String(sb));
		
	}
	
	protected String createYearLink(int year){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<p>");
		
		sb.append("<a href=\"/board/calendarservlet?YEAR=");
		sb.append(year - 1);
		sb.append("\"><span class=\"small\">前年</span></a>  ");
		
		sb.append(" "+year);
		sb.append("年 ");
		
		sb.append("<a href=\"/board/calendarservlet?YEAR=");
		sb.append(year + 1);
		sb.append("\"><span class=\"small\">翌年</span></a>");
		
		sb.append("</p>");
		
		return (new String(sb));
    }
}