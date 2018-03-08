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
	<link rel = "stylesheet" type = "text/css" href = "css/KeizimannCSS.css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<td><label for="id">NAME</label></td>
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
						<td><label for="id">NAME</label></td>
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

		
			
			
		</nav>
		
		
		<section>
		
		<% if(session.getAttribute("status") != null){ %>
<form method="POST" action="/keiziban/ThreadCheck">
	<table width=720 border=1 cellspacing=0 cellpadding=5>
	<tr><td><b>タイトル：</b></td><td><input type="text" size=80  maxlength=50 name="title">
	<tr><td><b>作成者名：</b></td><td><input type="text" size=20  maxlength=50 name="maker">
	<input type="submit" value="作成" colspan="2" align="right"></td></tr>
	</table>
</form>
<% } %>
								<!-- スレッド -->
			
			<table cellspacing=1 width=720 border=1>
				<tr>
					<td width=50><p align=center>ID</p></td>
					<td width=100><p align=center>作成者名</p></td>
					<td width=320><p align=center>スレッドタイトル</p></td>
					<td width=100><p align=center>作成月日</p></td>
				</tr>
				<% if(request.getAttribute("al") == null){
				response.sendRedirect("ThreadList");}%>
				<c:forEach var="al" items="${al}">
				<tr>
					<td width=50><p align=center>${al.getId()}</p></td>
					<td width=100><p align=center>${al.getMaker()}</p></td>
					<td width=320><p align=center></p><a href="ResponseList?id=${al.id}&title=${al.title}"method = 'GET'>${al.getTitle()}</a></td>
					<td width=100><p align=center></p>${al.getFdate()}</td>
				</tr>
				</c:forEach>
			</table>
				
		</section>
		

				
		<footer>
		</footer>

			
			
			
			
		</div>

</body>
</html>