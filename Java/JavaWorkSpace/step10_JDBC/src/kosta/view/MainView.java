package kosta.view;

import kosta.dao.SqlQueryDAO;
import kosta.frame.MenuExam;

public class MainView {

	public static void main(String[] args) {
		System.out.println("1. ��ü ����̸� �˻��ϱ�");
		SqlQueryDAO dao = new SqlQueryDAO();
		dao.selectEname();
		
		System.out.println("2. �����ȣ, �̸�, job, hiredate �˻��ϱ�");
		dao.selectEname();
		new MenuExam();
		
		// 1. empno�� �μ��� �޾� empno�� �ش��ϴ� ��� �����ϱ�
		// 2. empno�� �ش��ϴ� ����� ename, job, sal �����ϱ�
		//		�μ� : empno, ename, job, sal �޴´�
		// 3. empno�� �ش��ϴ� ��� �˻��ϱ�
		// 4. emp ���̺� ���ڵ� �߰��ϱ�
		//		�߰����� : empno, enmae, job, sal, hiredate
		//		* hiredate�� ���糯¥ ��� 
		
	}

}
