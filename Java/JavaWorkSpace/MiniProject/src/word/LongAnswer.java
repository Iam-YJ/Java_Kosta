package word;

import java.util.Random;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LongAnswer {

	Set<Word> arraylist;

	public LongAnswer(Set<Word> words) {
		this.arraylist = words;
	}

	public void longAnswer() {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.println("������ ������ �����ϰڽ��ϴ�.");

		int a, r;
		int rand[] = new int[5]; // ���� �ߺ��� �˻��ϱ� ���� �迭
		int num[] = new int[4]; // ���⿡ ���� ������ 4������ �����ϴ� �迭
		boolean check1[] = new boolean[arraylist.size()]; // ���� �迭�� ���ڰ� �ߺ����� ������ Ȯ���ϴ� �迭
		boolean check2[] = new boolean[arraylist.size()]; // ���� �迭�� ���ڰ� �ߺ����� ������ Ȯ���ϴ� �迭

		int count = 0; // ���� ���� �����ϴ� ����

		for (int i = 0; i < arraylist.size(); i++) // �迭 �ʱ�ȭ
			check1[i] = false;

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < arraylist.size(); j++) // �迭 �ʱ�ȭ
				check2[j] = false;

			while (true) // ���� ���� �ߺ� �� �ǰ� �̱�
			{
				r = random.nextInt(arraylist.size());
				if (!check1[r]) // ���࿡ ������ ������, �� ���� ����.
				{
					rand[i] = r;
					check1[r] = true;
					break;
				}
				else
					continue;
			}

			Iterator<Word> it = arraylist.iterator();
			for(int j=0; j<rand[i]; j++) {
				it.next();
			}
			Word testword = (Word) it.next();
			testword.setCount(testword.getCount()+1);
			System.out.println("������ Ƚ��"+testword.getCount());
			System.out.println(testword.getWord() + "�� ���� �����ΰ���?");

			
			
			check2[rand[i]] = true;

			int k = 0;
			while (k < 4) // ���� ä���
			{
				r = random.nextInt(arraylist.size());
				if (!check2[r]) {
					num[k] = r;
					check2[r] = true;
					k++;
				} 
				else
					continue;
			}

			a = random.nextInt(4); // ���⿡ ���� �־��ֱ�
			num[a] = rand[i];

			// ���� ����
			for (int j = 0; j < 4; j++) 
			{
				System.out.print((j + 1) + ". ");
				it = arraylist.iterator();
				for(int m = 0; m<num[j]; m++) {
					it.next();
				}
				Word example = (Word) it.next();
				for (String mean : example.getMean())
					System.out.print(mean +"/ ");
				System.out.println();
				
			}
				System.out.print("����: ");
				int answer = scan.nextInt();

				
				// ������ ������� �Ǻ��ϴ� ����
				boolean isCorrect = false;
				if (answer == a + 1) {
					System.out.println("�����Դϴ�.");
					count++;
					isCorrect = true;
				}
				if (!isCorrect)
					System.out.println("�����Դϴ�.");
			}
			System.out.println("���� ���� : " + count + " / ����� : " + (count * 100 / 5) + "%");
		}
}
