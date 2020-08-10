package ch06;

import java.util.Scanner;

public class BankApplication {
	private static AccountNew[] accountArray = new AccountNew[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.���»��� | 2.���¸��|3.����|4.���|5.����");
			System.out.println("-------------------------------------");
			System.out.println("����>");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("���α׷�����");
	}

	private static void createAccount() {
		System.out.println("-------");
		System.out.println("���»���");
		System.out.println("-------");
		System.out.print("���¹�ȣ : ");
		String ano = scanner.next();
		System.out.print("������ : ");
		String owner = scanner.next();
		System.out.print("�ʱ��Աݾ� : ");
		int balance = scanner.nextInt();

		AccountNew account = new AccountNew(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("���°� �����Ǿ����ϴ�.");
				break;
			}
		}
	}

	private static void accountList() {
		System.out.println("-------");
		System.out.println("���¸��");
		System.out.println("-------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null)
				break;
			System.out.println(
					accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());

		}

	}

	private static void deposit() {
		System.out.println("-------");
		System.out.println("����");
		System.out.println("-------");
		System.out.print("���¹�ȣ");
		String ano = scanner.next();
		System.out.print("���ݾ�");
		int balance = scanner.nextInt();
		AccountNew account = findAccount(ano);
		if (account == null) {
			System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
		} else {
			account.setBalance(account.getBalance() + balance);
			System.out.println("������ �����Ǿ����ϴ�.");
		}

	}

	private static void withdraw() {
		System.out.println("-------");
		System.out.println("���");
		System.out.println("-------");
		System.out.print("���¹�ȣ");
		String ano = scanner.next();
		System.out.print("��ݾ�");
		int balance = scanner.nextInt();

		AccountNew account = findAccount(ano);
		if (account == null) {
			System.out.println("���¹�ȣ�� �������� �ʽ��ϴ�.");
		} else {
			account.setBalance(account.getBalance() - balance);
			System.out.println("����� �����Ǿ����ϴ�.");
		}
	}

	// Account�迭���� ano�� ������ Account��ü ã��
	private static AccountNew findAccount(String ano) {
			AccountNew account=null;
			for(int i=0;i<accountArray.length;i++) {
				if(accountArray!=null) {
				if(ano.equals(accountArray[i].getAno())) {
					account=accountArray[i];
				break;
				}
			}
			
		}
			return account;
	}
}