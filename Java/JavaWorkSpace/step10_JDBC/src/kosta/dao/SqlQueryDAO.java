package kosta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kosta.frame.MenuExam;
import kosta.util.DbUtil;

public class SqlQueryDAO {
	MenuExam me;
	
	/**
	 * emp ���̺��� ��� ����� ename ���� ��������
	 */

	public void selectEname() {
		Connection con = null; //���������� �ؼ� ���� �������� ���� �������� �ݺ� 
		// �ε� -> static �� ��
		Statement st = null;
		ResultSet rs = null;
		
		try { //connectino�� ������ , ���ʿ��� ó���� ����
			// ����
			con = DbUtil.getConnection();
			// ����
			st = con.createStatement();
			rs = st.executeQuery("select empno, ename, job, hiredate from emp");
			while(rs.next()) {
				String empno = rs.getString(1);
				System.out.print(empno + " : ");
				
				String ename = rs.getString(2);
				System.out.print(ename + " : ");
				
				String job = rs.getString(3);
				System.out.print(job + " : ");
				
				String hiredate = rs.getString(4);
				System.out.println(hiredate);
				
				me.textArea.append(empno + " : "+ename + " : "+job + " : "+hiredate+"\n");
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ݱ� -- ������ �����ؾ� �ϱ� ������ .. finally�� 
					// + try - catch �ϰ���°� ���� 
			DbUtil.dbClose(con, st, rs); //select ����̿��� �Լ����� 3��
		}
	}

}
