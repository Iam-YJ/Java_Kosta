//TwoDmArrayExam.java

class TwoDmArray{
	//String�� �����ϴ� twoDmArray �迭����
	String [][] twoDmArray = new String [10][];
	int [][] arr = new int [10][];
	
	//�޼ҵ� make2DmArray
	//twoDmArray �迭��  ���� �Ҵ�
	public void make2DmArray(){
		int count = 1;
		for(int i=0; i<10; i++){
			for(int k=1; k<=10-i; i++){
				twoDmArray[i] = new String[k];
				//twoDmArray[i][k] = (String)("��");
			}
			for(int l=1; l<=10-i; l++){
				twoDmArray[i][l] = ("��");
			}
			

		}

	}

/*	for (int i=1; i<=5; i++ ){
		for(int j=1; j<=i; j++){
			System.out.print("��");
		}
		for(int k=1; k<=6-i; k++){
			System.out.print("��");
		}
		System.out.println(); */
		
		
	//�޼ҵ� print2DmArray
	//	twoDmArray �迭�� ���� �־����������� ���
	public void print2DmArray(){
		System.out.println("�ǤǤ�");
		for(int i=0; i<twoDmArray.length; i++){
			for(int j=0; j<twoDmArray[i].length; j++){
				System.out.print(twoDmArray[i][j]+"\t");

			}System.out.println();
		}
	}
		
}

public class TwoDmArrayExam{
	//main�޼ҵ忡��
	public static void main(String [] args){
		//TwoDmArray��ü����
		TwoDmArray tda = new TwoDmArray();
		//TwoDmArray��ü�� make2DmArray�޼ҵ� ȣ��
		tda.make2DmArray();
		//TwoDmArray��ü�� print2DmArray�޼ҵ� ȣ��
		tda.print2DmArray();

	
	}
	
		
	
}
