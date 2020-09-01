
package word;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTextArea;

public class ShortAnswer {

	Set<Word> arraylist;
	String sql = "select * from word";
	boolean waitForAnswer = true;

//	MyFrame mf;
	
	JTextArea textOutputArea;

	public ShortAnswer(Set<Word> wordslist, MyFrame mf) {
		this.arraylist = wordslist;
		//this.mf = mf;
	}

	public void shortAnswer() {
		Scanner scan = new Scanner(System.in);
		Random randomGenerator = new Random();
		// ���� �ߺ��� �˻��ϱ� ���� �迭
		int rand[] = new int[5];
		// ���� ���� �����ϴ� ����
		int count = 0;
		for (int i = 0; i < 5; i++) {
			int r = randomGenerator.nextInt(arraylist.size());
			rand[i] = r;
			// ���� �ߺ� �˻�
			int j = 0;
			while (j < i) {
				if (rand[i] == rand[j]) {
					j = 0;
					rand[i] = randomGenerator.nextInt(arraylist.size());
					continue;
				}
				j++;
			}

			Iterator<Word> it = arraylist.iterator();
			for (int k = 0; k < rand[i]; k++) {
				it.next();
			}
			Word testword = (Word) it.next();
//			mf.textOutputArea.setText("hi");
			//mf.textOutputArea.append(testword.getWord() + "�� ���� �����ΰ���? : ");

			// System.out.print(testword.getWord() + "�� ���� �����ΰ���? : ");

			String answer = scan.nextLine();
//			// �������� �Ǻ��ϴ� ����

			boolean isCorrect = false;
			for (String mean : testword.getMean()) {
				if (answer.equals(mean)) {
					System.out.println("�����Դϴ�.");
					count++;
					isCorrect = true;
					break;
				}
			}
			if (!isCorrect) {
				System.out.println("�����Դϴ�.");

			}
			waitForAnswer = true;
		}
		System.out.println("���� ���� : " + count + " / ����� : " + (count * 100 / 5) + "%");

	}

}
