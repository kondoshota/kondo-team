import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createThreadServlet extends HttpServlet{
	
	final String LOGFILE ="/WEB-INF/thread.txt";
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//作成者、スレッドタイトル、カテゴリーを取得
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String category = req.getParameter("category");
		
		//空文字チェック
		
		//ログファイルに書き込めるように整形
		comment = comment.replaceAll("\n","<br>");
		comment = comment.replaceAll("\r","");
		comment = comment.replaceAll("\t","");
		name = name.replaceAll("\t","");
		
		//日時の取得
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd"+" ("+"E"+") "+"HH:mm:ss");
		String dateStr=parser.format(date);
		
		writeThread wt=new writeThread();
		
		wt.writeFile("thread.txt",title,category);
		
		res.setContentType("text/html;charset=Windows-31J");
		
		RequestDispatcher dispatcher = req.getRequestDsipatcher("");
		dispatcher.forward(req,res);
	}
}