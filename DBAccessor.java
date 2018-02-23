import java.sql.*;

class JavaDataAccess01 {
	public static void main (String args[]) throws SQLException, ClassNotFoundException {
		//Oracle JDBC Driver�̃��[�h
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Oracle��info���[�U�[�Őڑ�
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
		// �X�e�[�g�����g�i����w��������́j���쐬
		Statement stmt = conn.createStatement();

		//�⍇�������s
		ResultSet rset = stmt.executeQuery(""); //������select��
		//�⍇�����ʂ�\��
		while ( rset.next() ) {
			// ��ԍ��Ŏw��
			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
		}

		//�N���[�Y
		rset.close();
		stmt.close();
		conn.close();
  }
} 
