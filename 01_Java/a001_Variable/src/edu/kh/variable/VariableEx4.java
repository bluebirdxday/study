package edu.kh.variable;

public class VariableEx4 {
	public static void main(String[] args) {
		
		//String(문자열)
		
		String str1 = "hello";
		System.out.println(str1);
		
		//출력하고 하는 값의 리터럴 표기법을 작성
		System.out.println("안녕하세요?");
		
		System.out.println("--------------------------------");
		
		String name = "홍길동";
		int age = 20;
		char gender = '여';
		
		System.out.println(age + 1); // 정수 + 정수 = 두 수의 합
		System.out.println(name + "입니다.");
		
		System.out.println(name + age);
		System.out.println(name + age + gender);
		
		System.out.println(name + "님은 " + age + "세 " + gender + "성 입니다.");
		
		System.out.println(100 + age + name);
		
	}
}
