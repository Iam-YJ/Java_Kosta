 import java.util.ArrayList;
class ArrayListExam extends ArrayList{

	//전역 Variable
	//Object 타입1개, int 타입 1개;
	

	//Constractor
	public ArrayListExam(){
			//초기 용량 5개 생성
		
			
	}

	//method
	//method이름			리턴타입		인수						
	
	/*addInt				없음			정수(int)1개				
	하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.*/
		
		
	
	
	/*addFloat				없음			실수(float)1개			
		하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.*/
		
	
	
	/*addString			없음			String 문자열1개		
		하는일 : 인수로 받은 String 을 list에 추가.*/
		
	
	
	
	/*printList		없음			없음			
		정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
		List에 저장된 각 객체를 맴버변수에 저장한후 출력*/
		
		

	public static void main(String args[]){
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");		 
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

/*실행결과

list에 들어있는 객체의 총 개수는=3
5
5.5
newString

Normal Termination
출력 완료 (0초 경과).
*/