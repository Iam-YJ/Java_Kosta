class RandomQuiz3{
	public static void main(String args[]){
	//본인 이름 저장할 String 선언
	String name = "김다정";
	//int 국어 ,영어, 수학 변수 선언
	int kor, math, eng=0;
	//int 총점, double평균 , 학점 char저장 변수 선언
	int total = 0;
	double avg = 0;
	char grade;

	//난수 발생 지점 최대값과 최소값 지정
	int max = 100;
	int min = 45;
	//국어, 영어, 수학변수에 45~100사이 난수 발생 점수 저장
	//**이렇게 하면 45~99까지의 임의 숫자만 지정이 가능한것 같은데 어떻게 난수 발생 점수 지정을 해야하는지 모르겠습니다.
	kor = (int)(Math.random()*(max-min))+min;
	math = (int)(Math.random()*(max-min))+min;
	eng = (int)(Math.random()*(max-min))+min;

	//국어,영어,수학 점수 총점을 더해 총점 변수에 넣기
	total = kor+ math+ eng;
	
	//총점을 가지고 평균을 구해 평균 변수에 저장
	avg = total/3.0;
	
	//평균이 90점 이상이면 A 이하 9점 단위로 B,C,D,F
	if(avg >=90){
		grade = 'A';
	}else if(avg >=80){
		grade = 'B';
	}else if(avg >=70){
		grade = 'C';
	}else if(avg >=60){
		grade = 'D';
	}else {
		grade = 'F';
	}

	//이름 , 국어점수, 영어점수, 수학점수, 총점,평균, 학점을 출력해본다.
	//학점은 소수점 한자리까지만 출력
		System.out.println("이름:"+name);
		System.out.println("국어점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균"+"%.1f\n",avg);
		System.out.println("학점:"+grade);

	}
}