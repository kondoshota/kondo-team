import java.sql.*;

class JavaDataAccess01 {
	public static void main (String args[]) throws SQLException, ClassNotFoundException {
		//Oracle JDBC Driverのロード
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Oracleにinfoユーザーで接続
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
		// ステートメント（動作指示するもの）を作成
		Statement stmt = conn.createStatement();

		//問合せを実行
		ResultSet rset = stmt.executeQuery(""); //ここにselect文
		//問合せ結果を表示
		while ( rset.next() ) {
			// 列番号で指定
			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
		}

		//クローズ
		rset.close();
		stmt.close();
		conn.close();
  }
} 
