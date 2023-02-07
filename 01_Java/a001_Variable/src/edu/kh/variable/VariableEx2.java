package edu.kh.variable;

public class VariableEx2 {
	
	public static void main(String[] args) {
		
		// 변수 선언 : 메모리에 값을 저장할 공간을 생성함
		
		/* 논리형 boolean (1byte)
		 * 정수형 : byte (1byte)
		 *          short (2byte)
		 *          int (4byte, 정수 기본형)
		 *          long (8byte)
		 * 실수형 : float (4byte)
		 *          double (8byte, 실수 기본형)
		 * 문자형 : char (2byte, 유니코드(UTF-16))
		 */
		
		boolean booleanData; 
		// 1byte를 메모리에 할당하고
		// 그 공간을 booleanData라고 부르겠다
		
		int number1;
		
		double number2;
		
		char ch;
		
		booleanData = true;
		
		number1 = 123456789;
		number2 = 9.87654321;
		
		ch = 'A';
		
		System.out.println(booleanData);
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(ch);
		
		ch = '하';
		System.out.println(ch);
		
		// int : 10, -50, 0 (기본 정수 표기법)
		// long : 214723426L, 0L, -10L
		
		// double : 3.14, -123.456, 0.0 (기본 실수 표기법)
		// float : 3.14f, -123.456f, 0.0f
		
		// char : '가', 'z' 또는 0~65535 사이 정수
		
		// byte, short : 10, 0, -312 (int와 동일)
		// -> byte, short는 옛날 코드와의 호환을 위해 만들어진 자료형
		// --> 사용 빈도가 낮아서 별도의 리터럴 표기법을 제작 X
		
		char test1 = 'A';
		char test2 = 65;
		
		System.out.println(test1);
		System.out.println(test2);
	
		
		final int UP = 5;
		final int DOWN = -5;
		final int INIT = 0;
		
		int result2 = INIT;
		System.out.println(result2);
		
		result2 += UP;
		System.out.println(result2);
		 
		result2 += DOWN + DOWN;
		System.out.println(result2);
		
		//변수 명명 규칙
		// 3. 숫자로 시작 금지
		// 4. 특수문자는 $와 _만 사용가능
		
	}

}
