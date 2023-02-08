package edu.kh.variable;

public class PrintEx {
	public static void main(String[] args) {
		
		//출력 메서드
		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		
		// System.out.printf("패턴이 포함된 문자열", 변수 또는 값);
		// "패턴이 포함된 문자열" 출력 시
		// 패턴 자리에 뒤에 작성된 변수 또는 값을 순서대로 대입
		
		String name = "홍길동";
		int age = 30;
		char gender = '남';
		double height = 185.5;
		
		// 홍길동 님은 나이 30세 키 185.5cm의 남성입니다.
		System.out.printf("%s 님은 나이 %d세 키 %.1fcm의 %c성입니다.", 
				name, age, height, gender);
		// %d : 10진 정수,  %o : 8진수,  %x : 16진수
		// %s : 문자열,  %c : 문자
		// %f : 실수(소수점 아래 6자리)
		// %b : 논리형
		
	}
}
