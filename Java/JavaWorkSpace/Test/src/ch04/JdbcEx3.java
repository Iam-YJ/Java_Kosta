package ch04;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

public class JdbcEx3 {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		String user = "jin", pw = "1234";

		Connection con = DriverManager.getConnection(url, user, pw);

		System.out.println("���� ����!!!");

		Statement st = con.createStatement();

		// statement ��ü�� ��� �´�

		String sql = "select * from word";

		// order by no : noĮ������ �������� ����

		ResultSet rs = st.executeQuery(sql); // select�� �ϰ�쿡�� executeQuery ���

		// insert�� ��� executeUpdate ���

		// ���� rs���� Į���� 1~**���� ����ִ�

		while (rs.next()) { //

			// rs.next() �ش� ������ ������� �ϳ��� �����ü� �ִ� ��ü



			String kor = rs.getString("kor");

			String eng = rs.getString("eng");

			System.out.println(eng + " : " + kor);

		}

		if (rs != null)
			rs.close();

		if (st != null)
			st.close();

		if (con != null)
			con.close();

	}

}