package dba;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;

public class DBAccess{
	
	private Connection conn = null;
	
	public void init() throws ServletException{
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "info";
		String password = "pro";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e){
			System.out.println("ClassNotFoundException:" + e.getMessage());
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
		}catch (Exception e){
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
//	public void destory(){
//		try{
//			if (conn != null){
//				conn.close();
//			}
//		}catch (SQLException e){
//			System.out.println("SQLException:" + e.getMessage());
//		}
//	}
	public ArrayList<ThreadBean> ReadThread(){
		ArrayList<ThreadBean> threadList = new ArrayList<ThreadBean>();
		
		try{
			String sql = "select th_id, th_title, th_fdate, th_maker from thread order by th_id desc";
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				ThreadBean tb = new ThreadBean();
				
				tb.setId(Integer.parseInt(rs.getString(1)));
				tb.setTitle(rs.getString(2));
				tb.setFdate(rs.getString(3));
				tb.setMaker(rs.getString(4));
				threadList.add(tb);
			}
		}catch(SQLException e){
			System.out.println("OK");
		}
		
		return threadList;
	}
	
	public ArrayList<ResBean> ReadRes(){
		ArrayList<ResBean> resList = new ArrayList<ResBean>();
		
		try{
			String sql = "select res_id, res_User_name, res_response, res_date from thread order by res_id desc";
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				ResBean rb = new ResBean();
				
				rb.setId(Integer.parseInt(rs.getString(1)));
				rb.setUser_name(rs.getString(2));
				rb.setResponse(rs.getString(3));
				rb.setDate(rs.getString(4));
				resList.add(rb);
			}
		}catch(SQLException e){
			System.out.println("OK");
		}
		
		return resList;
	}
	
	public boolean RegisterUser(String user, String pass){
		/* 取りあえずユーザー名とパスワードが入力されていれば認証する */
		if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
			return false;
		}
		try{
			String sql = "insert into rv_User(user_id,user_name,user_pass,user_fdate,user_ldate) values (user_seq.nextval, ?, ?, current_timestamp, current_timestamp)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			int num = pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
			return false;
		}
	}
	
	public boolean LoginUser(String user, String pass){
		/* 取りあえずユーザー名とパスワードが入力されていれば認証できる*/
		if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
			return false;
		}
		try{
			String sql = "SELECT * FROM rv_User WHERE user_name = ? and user_pass = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				String sql2 = "UPDATE rv_User SET user_ldate=current_timestamp where user_name = ?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, user);
				int num = pstmt2.executeUpdate();
				return true;
			}else{
				return false;
			}
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
			return false;
		}
	}
	
	public boolean WriteRes(String thid, String res, String name){
		if (res == null || res.length() == 0){
			return false;
		}
		ResBean rb = new ResBean();
		try {
			String sql = "insert into Res(res_th_id,res_id, res_user_name, res_response, res_date) values ('"+rb.getTh_id()+"',res_seq.nextval, '"+res+"', '"+name+"',current_timestamp)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int num = pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
			return false;
		}
	}
	
	public boolean WriteThread(String title, String maker){
		if (title == null || title.length() == 0){
			return false;
		}
		if (maker == null || maker.length() == 0){
		maker = "Nameless";
		}
		
		try {
			String sql = "insert into Thread(th_id,th_title,th_fdate,th_maker) values (th_seq.nextval, ?,current_timestamp, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, maker);
			int num = pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}catch (SQLException e){
			System.out.println("SQLException:" + e.getMessage());
			return false;
		}
	}
}