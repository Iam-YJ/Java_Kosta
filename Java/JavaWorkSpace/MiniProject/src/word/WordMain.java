package word;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class WordMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ReadFile file = new ReadFile("words.txt");
		file.readFile();
		Set<Word> wordlist = file.getWords();
		String sql = "select * from word";
		DBConnection db = new DBConnection();
		db.Run();
		wordlist = db.getWordlist();
		MyFrame frame = new MyFrame("������ �ܾ���");
		while (true) {
			try {
				switch (scan.nextInt()) {
	
					
				case 1:
					ShortAnswer shortanswer = new ShortAnswer(wordlist);
					shortanswer.shortAnswer();
					break;
				case 2:
					LongAnswer longanswer = new LongAnswer(wordlist);
					longanswer.longAnswer();
					break;
					
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
			} catch (InputMismatchException e) {// ���ڰ� �ƴѰ��� �Է�������
				// Scanner ���׸� ������� �ڵ�. Scanner instance �ʱ�ȭ
				// �ʱ�ȭ���� ������ ���ѷ��� �߻�
				scan = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. ���ڷ� �Է����ּ���.");
			}
		}

	}

}
