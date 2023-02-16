package edu.kh.oop.method.service;

// 기능 제공용 객체를 만들기 위한 클래스
// -> 비즈니스 로직
public class MethodExService {
	
	
	// 2. 매개 변수 O, 반환 값 X
	// void : 반환 값 없음
	// 매개 변수 : 전달 받은 값을 저장할 변수
	public void threeNumbersSumAndAverage(int a, int b, int c) {
		// 세 숫자의 합과 평균
		
		// 전달 받은 세 정수의 합
		int sum = a + b + c;
		
		double avg = sum / 3.0;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
	
	
	// 3. 매개 변수 X, 반환 값 O
	// [1부터 10 사이의 난수 5개를 저장한 배열을 반환 받아 출력]
	
	public int[] fiveRandomNumbers() {
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}
		
		// 호출한 위치로 돌아감 -> return
		return arr;
	}
	
	
	// 4. 매개 변수 O, 반환 값 O
	// 정수 2개, 연산자를 입력 받아 계산 서비스 호출 후
	// 연산 결과를 반환 받아서 출력
	public String calculate(int num1, int num2, String op) {
		// 매개변수 명을 일치시켜 이해도 향상
		
		// +, -, * : 문제 없음
		// /, % : 0으로 나눌 경우 오류 발생
		
		// 정상 계산 : "5 + 10 = 15"
		// 오류 발생 : "0으로 나눌 수 없습니다"
		
		String result = null;
		// String은 참조형 == 주소를 저장
		// null : 참조하는 게 없다(== 주소를 저장하고 있지 않다)
		// null =/= 비어있다 
		
		
		// 만약에 두번째 숫자가 0이고
		// 연산 기호가 / 또는 %인 경우
		
		// ==, != : 비교 연산자
		// 참조형을 비교할 때 값이 아닌 주소를 비교함
		if(num2==0 && (op.equals("/") || op.equals("%"))) {
			result = "0으로 나눌 수 없습니다.";
			
			// ************************************
			// 코드 수행 중 return 구문을 만나면 
			// 그 즉시 메서드를 종료하고 호출한 곳으로 돌아감!
			// ************************************
			return result;
		}
		
		// String.format("패턴", 변수);
		//  -> 패턴 형태의 문자열 반환
		switch(op) {
		case "+": result = String.format("%d %s %d = %d", num1, op, num2, num1+num2); break;
		case "-": result = String.format("%d %s %d = %d", num1, op, num2, num1-num2); break;
		case "*": result = String.format("%d %s %d = %d", num1, op, num2, num1*num2);break;
		
		case "/": result = String.format("%d %s %d = %d", num1, op, num2, num1/num2);break;
		case "%": result = String.format("%d %s %d = %d", num1, op, num2, num1%num2);break;
		default : result = "연산 기호가 잘못 입력되었습니다.";
		}
		
		return result;
	}
}
