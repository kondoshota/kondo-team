<%@ page import="java.util.Calendar,
	java.io.*,
	javax.servlet.*,
	javax.servlet.http.*,
	java.util.Date,
	java.text.SimpleDateFormat"
	pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" 
%>

<html>
<head>
	<link rel = "stylesheet" type = "text/css" href = "KeizimannCSS.css">
	
	<%
		int index=1;
		String nomber=request.getParameter("no");
		String cal=request.getParameter("dateStr");
		String note=request.getParameter("note");
		String name=request.getParameter("name");
		String title=request.getParameter("title");
		int count=9;
	%>
</head>
<body>
	<div id="wrap">
		<header>
			<h1 align=center>コンド掲示板</h1>
		</header>
<form method="GET" action="/keiziban/ThreadCheck">
	<table width=700 border=1 cellspacing=0 cellpadding=5>
	<tr><td><b>スレッドタイトル：</b></td><td><input type="text" size=50  maxlength=50 name="title">
	<input type=submit value="register" colspan="2" align="right"></td></tr>
	</table>
</form>
<!-- ログインor登録 -->
	<nav>
		
		<% if(session.getAttribute("status") == null){ %>
		<form method="POST" action="/keiziban/LoginCheck">
			<fieldset style=width:290;>
				<legend>login</legend>
				<% if(session.getAttribute("login") == "Not Auth"){ %>
					<p>ログインに失敗しました</p>
					<p>再度ユーザー名とパスワードを</br>入力して下さい</p>
				<% } %>
				<table>
					<tr>
						<td><label for="id">ID</label></td>
						<td><input type="text" name="user"></td>
					</tr>
					<tr>
						<td><label for="id">PASSWORD</label></td>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="login">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
		<form method="POST" action="/keiziban/RegisterCheck">
			<fieldset style=width:290;>
				<legend>New Account</legend>
				<% if(session.getAttribute("register") == "Not Auth"){ %>
					<p>登録に失敗しました</p>
					<p>再度ユーザー名とパスワードを<br>入力して下さい</p>
				<% } %>
				<table>	
					<tr>
						<td><label for="id">ID</label></td>
						<td><input type="text" name="user"></td>
					</tr>
					<tr>
						<td><label for="id">PASSWORD</label></td>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="register">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
		<% }else{ %>
		<form method="GET" action="Logout">
			<fieldset style=width:290;>
				<legend>Wellcome</legend>
				<table>
					<tr>
						<td><h3>ようこそ「${sessionScope.status}」さん</h3></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="logout">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
		<% } %>
	</div>
<!-- 新規スレッド作成のボタン -->
			<div style="margin: 0 auto;
				padding: 0; 
				max-width: 760px;
				clear: both;
				line-height: 1.8;">
				
			<a href="BBSFrontServlet"style="background: #e26343;border: 1px solid #e26343;
				color: #fff;
				cursor: pointer;
				text-decoration: none;
				border-radius: 100px;
			 	font-size: 16px;
				padding: 8px 16px;
			 	font-weight: 600;
			  " target="_blank">新規のスレッド作成</a>
			 </div>
			  
			  
			<form>
				<h1>カテゴリー</h1>
			    <p align=center>
			    	ニュース : <input type="checkbox" name="kategorie" value="news">  <br>
			    	活動 : <input type="checkbox" name="kategorie" value="action"> <br>
			    	人身事故 : <input type="checkbox" name="kategorie" value="sad">
			    </p>
			    <button type="submit">探しに行こう</button>
			</form>

		
			
			
		</nav>
		
		
		<section>
								<!-- スレッド -->
			<table cellspacing=1 width=600 border=1>
				<tr>
					<td width=50><p align=center>番号</p></td>
					<td width=100><p align=center>名前</p></td>
					<td width=320><p align=center>見出し</p></td>
					<td width=100><p align=center>登録月日</p></td>
				</tr>
					
				<tr>
					<%
					
					out.println("<table cellspacing=1 width=600 border=1>");
					out.println("<tr><td width=50><p align=center>"+nomber+"</p></td>");
					out.println("<td width=100><p align=center>"+name+"</p></td>");
					out.println("<td width=320><p align=center>"+note+"</p></td>");
					out.println("<td width=320><p align=center>"+cal+"</p></td>");
					
					out.println("</table>");
					
					
					
					%>
				</tr>
			</table>
				
		</section>
		

				
		<footer>
		</footer>

			
			
			
			
		</div>

</body>
</html>