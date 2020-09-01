
package word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
//java.sql.��¼���� ����Ʈ �ؾ��Ѵ�
import java.util.Set;

public class DB {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	Set<Word> Wordlist;

	public void readWord() {
		Wordlist = new HashSet<>();
		String sql = "select * from word";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String eng = rs.getString(1);
					String kor = rs.getString(2);
				//	Wordlist.add(new Word(eng, kor));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the wordlist
	 */
	public Set<Word> getWordlist() {
		return Wordlist;
	}

	public void connectDB() {
		try {
			String user = "jin";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			// �ּ� �̸� ��й�ȣ ��ġ�ϰ�
			if (conn != null) {
				System.out.println("DB ���� ���� ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ���� ");
			e.printStackTrace();
		}
	} // ���� �׽�Ʈ

	public void registerWord(String eng, String kor) { // db�� �־��ִ� ����
//		Scanner scan = new Scanner(System.in);
//		System.out.print("������ �ܾ �Է��� �ּ���: ");
//		String eng = scan.next();
//		System.out.print("�ܾ��� ���� �Է��� �ּ���(���� ���� ��� /�� �����ϼ���): ");
//		String kor = scan.next();
		String sql = "insert into word (eng,kor) values(?,?)";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, eng);
				pstmt.setString(2, kor);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// ������ ���� > �Ŀ� heidi ���� ���� �����Ͱ� �߰��Ǿ� �ִ�.

	public void printDB() {
		String sql = "select * from word";
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String eng = rs.getString(1);
					String kor = rs.getString(2);
					System.out.println(eng + "," + kor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// ������ ����Ʈ ȹ��

	public String select(String searchWord) {
		connectDB();
		String ret = "";
		Scanner scan = new Scanner(System.in);
		String sql = "select * from word where eng = ?";
		String sql2 = "select * from word where kor = ?";
		if (conn != null) {
			try {
				String a = searchWord;
				char c = a.charAt(0);
				if (c >= 'a' && c <= 'z') {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, a);
					System.out.println(searchWord);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String eng = rs.getString(1);
						String kor = rs.getString(2);
						ret += (eng + "," + kor) + '\n';
					}
				} else {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, a);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String eng = rs.getString(1);
						String kor = rs.getString(2);
						ret += (eng + "," + kor) + '\n';
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // FIND
		closeDB();
		return ret;
	}

	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // DB ���� ����

	public void Run() {
		ReadFile rf = new ReadFile("words.txt");
		// TODO Auto-generated method stub
//		ReadFile readFile = new ReadFile("words.txt");
//		readFile.readFile();
		connectDB();
//		test.readWordAndRegister(readFile.getWords());
		// �ѹ� ���� �� �ּ�ó�� �ؾ��Ѵ�.
//		test.registerWord();
		// �̰��ϰ� heidi���� ���� �����Ϳ� �߰��Ǿ��ִ�.
 
		//20 08 31 ����.. iterator�� false�� 
		rf.readFile();
		Set<Word> words = rf.getWords();
		//System.out.println(words);
		Iterator iter = words.iterator(); // Iterator ���
		//System.out.println(iter.hasNext());
		
		while (iter.hasNext()) {// ���� ������ true ������ false
			Word word = (Word) iter.next();
			registerWord(word.getWord(), word.returnString(word.getMean()));
		}

		readWord();
		printDB();

		closeDB();
	}

}
