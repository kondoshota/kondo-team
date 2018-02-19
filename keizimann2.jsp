<%@ page import="java.util.Calendar,
	java.util.Date,
	java.text.SimpleDateFormat"
pageEncoding="Windows-31J"
contentType="text/html;charset=Windows-31J" %>

<html>
<head>

<%
	Calendar cal=Calendar.getInstance();
	Date date=cal.getTime();
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd H:m:s");
	String today=formatter.format(date);
%>
</head>



<body>
	<table width=700 border=1 cellspacing=0 cellpadding=5>
	<tr><td><b>名前</b></td><td><input type=text name=dbname size=50  maxlength=50></td></tr>
	<tr><td><b>メール</b></td><td><input type=text name=dbemail size=50  maxlength=50></td></tr>
	<tr><td><b>サイト</b></td><td><input type=text name=dbhomepage size=50  maxlength=50></td></tr>
	<tr><td><b>見出し</b></td><td><input type=text name=dbsubject size=50  maxlength=50></td></tr>
	<tr><td><b>内容</b></td><td><textarea name=dbmemo cols=50 rows=10></textarea></td></tr>
	</table>
	<table width=700 border=1 cellspacing=0 cellpadding=0>
	<tr><td><input type=button value="登録" OnClick="window.location='board_write_insert.jsp'"></td></tr>
	</table>

</body>
</html>