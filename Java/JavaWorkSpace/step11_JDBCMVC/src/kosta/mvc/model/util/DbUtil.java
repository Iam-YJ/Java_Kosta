package kosta.mvc.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB ������ �ʿ��� �ε�, ����, �ݱ� ��� ����
 */

public class DbUtil {

	private static Properties proFile = new Properties();
	
	
	public static Properties getProFile() {
		return proFile;
	}
	
	

	/**
	 * �ε�
	 */
	static {
		try {
			// 2���� properties ���� �ε��ؼ� properties ��ü�� �����Ѵ�

			proFile.load(new FileInputStream("resources/board.properties"));
			proFile.load(new FileInputStream("resources/dbInfo.properties"));

			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	// static �� �ٿ��� �ٸ������� �ٷ� ȣ���� �� �ֵ���.
	public static Connection getConnection() throws SQLException {
		// ������ �̰Ÿ� ����ϴ� DAO class���� ����ó���� �ϰ� �ϱ� ���ؼ�
		return DriverManager.getConnection(proFile.getProperty("url"),proFile.getProperty("userName"),proFile.getProperty("userPass"));
	}
	
	

	/**
	 * �ݱ�(select�� ���)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) // null�� �ƴ� -> ���𰡸� ���� -> �״ϱ� �ݾƶ�
				rs.close(); // ���� �������� ������ �� ���� �ݱ�
			/*
			 * if (st != null) st.close(); if (con != null) con.close();
			 */ // ���� �ڵ� ������ �Ʒ� �޼ҵ� ��
			dbClose(con, st);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * �ݱ�(insert, update, delete�� ��� )
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
