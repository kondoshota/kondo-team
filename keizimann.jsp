<%@ page import="java.util.Calendar,
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
	
		<header><h1 align=center>�R���h�f����</h1></header>
	
		
		<nav>
									<!-- ���O�C�� -->
			<form id="login">
				<fieldset style=width:290;>
				<legend>login</legend>
				<table>	
				<tr>
						<td><label for="id">ID</label></td>
						<td><input type="text" id="id"></td>
					</tr>
					<tr>
						<td><label for="id">PASSWORD</label></td>
						<td><input type="password" id="pwd"></td>
					</tr>
						<tr>
					<td colspan="2" align="right">
						<input type="submit" value="login">
						</td>
					</tr>
				</table>
				</fieldset>
			</form>
			
			
															<!-- �V�K�X���b�h�쐬�̃{�^�� -->
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
			  " target="_blank">�V�K�̃X���b�h�쐬</a>
			 </div>
			  
			  
			<form>
				<h1>�J�e�S���[</h1>
			    <p align=center>
			    	�j���[�X : <input type="checkbox" name="kategorie" value="news">  <br>
			    	���� : <input type="checkbox" name="kategorie" value="action"> <br>
			    	�l�g���� : <input type="checkbox" name="kategorie" value="sad">
			    </p>
			    <button type="submit">�T���ɍs����</button>
			</form>

		
			
			
		</nav>
		
		
		<section>
								<!-- �X���b�h -->
			<table cellspacing=1 width=600 border=1>
				<tr>
					<td width=50><p align=center>�ԍ�</p></td>
					<td width=100><p align=center>���O</p></td>
					<td width=320><p align=center>���o��</p></td>
					<td width=100><p align=center>�o�^����</p></td>
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