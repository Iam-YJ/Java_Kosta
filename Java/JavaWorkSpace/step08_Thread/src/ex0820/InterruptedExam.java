package ex0820;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("*** ���� �����Դϴ� ***");

		// new Thread() {public void rub(){}}.start();

		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while (true) {
						if(Thread.interrupted()) {
							break;
						}
						System.out.println("Thread ����ִ�.");
						Thread.sleep(100); // 0.1��
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		
		th.start();
		
		try {
			Thread.sleep(5000);//5��
		}catch (Exception e) {
			e.printStackTrace();
		}
		//5�� ���� �� �����带 ������Ű��
		th.interrupt();
		
		System.out.println("*** ���� �� �Դϴ� ***");
	}

}