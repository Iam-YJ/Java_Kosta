package ch07;

public class SnowTireExample {
	public static void main(String [] args) {
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		// tire -> snowtire 
		tire.run();
		//tire
		
		//�� �� �����ε� ������ ����..?
	}

}

//8-2
