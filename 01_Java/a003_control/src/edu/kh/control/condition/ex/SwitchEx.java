package edu.kh.control.condition.ex;

import java.util.Scanner;

public class SwitchEx {

	/* switch문
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 * -> 식의 결과에 맞는 case문이 실행됨
	 * 
	 * [작성법]
	 * switch(식) { //식 수행 결과는 정수나 문자열}
	 * 
	 * case 결과값1 : 수행코드1; break;
	 * case 결과값2 : 수행코드2; break;
	 * case 결과값3 : 수행코드3; break;
	 * default : 모든 case가 만족하지 않을 경우 수행하는 코드;
	*/
	
	// 스캐너 자동완성 : sc -> ctrl + spacebar
	
	public void ex1() {
		//키보드로 정수 입력 받아
		// 1이면 "RED" 2면 "ORANGE" 3이면 "YELLOW" 4이면 "GREEN"
		// 모두 아니면 "BLUE"
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = scan.nextInt();
		
		String result;
		
		// if-else if- else 버전
//		if(input==1) {
//			result = "RED";
//		}else if(input==2) {
//			result = "ORANGE";
//		}else if(input==3) {
//			result = "YELLOW";
//		}else if(input==4){
//			result = "GREEN";
//		}else {
//			result = "BLUE";
//		}
		
		
		// switch 버전
		switch(input) {
		case 1 : 
			result = "RED"; 
			break;
		case 2 :
			result = "ORANGE";
			break;
		case 3 :
			result = "YELLOW";
			break;
		case 4 : 
			result = "GREEN";
			break;	
		default :
			result = "BLUE";
		}
		
		System.out.println(result);
		
	}
	
	public void ex2() {
		// 랜덤 팀배정 프로그램
		// (백팀, 청팀, 홍팀)
		
		int randomTeamNumber = (int)(Math.random()*3);
		String teamName = "";
		
		switch(randomTeamNumber) {
		case 1 : teamName = "백팀"; break;
		case 2 : teamName = "청팀"; break;
		default : teamName = "홍팀";
		}
		
		System.out.println(teamName + "입니다.");
	}
	
	public void ex3() {
		// 식의 결과가 문자열 (String)
		Scanner sc = new Scanner(System.in);
		
		// 메뉴를 입력받아서 가격이 얼마인지 출력
		
		System.out.print("메뉴를 입력하세요 (김밥/라면/샌드위치/떡볶이) : ");
		
		String inputMenu =  sc.next();
		int price;
		
		switch(inputMenu) {
		case "김밥" : price = 1000; break;
		case "라면" : price = 2000; break;
		case "샌드위치" : price = 3000; break;
		case "떡볶이" : price = 1500; break;
		default : price = -1;
		}
		
		if(price != -1) {
			System.out.printf("%s는(은) %d원 입니다.", inputMenu, price);
		}else {
			System.out.println("메뉴가 존재하지 않습니다.");
		}
		
		
	}
	
	
    // 산술 연산 계산기 만들기
    // 두 정수(int)와 1개의 연산자( + - * / % (String) )를 입력 받아서 
    // 연산 결과를 출력
    // 단, 나누기(/) 연산 시 0으로는 나눌 수 없도록 한다.
	
	// switch 예시4
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		String operator;

		
		
		System.out.printf("정수1 입력 : ");
		num1 = sc.nextInt();
		
		System.out.printf("연산자 입력 : ");
		operator = sc.next();
		
		System.out.printf("정수 2 입력 : ");
		num2 = sc.nextInt();
		
		
		switch(operator) {
		case "+" : System.out.printf("%d %s %d = %d", num1, operator, num2, num1 + num2); break;
		case "-" : System.out.printf("%d %s %d = %d", num1, operator, num2, num1 - num2); break;
		case "*" : System.out.printf("%d %s %d = %d", num1, operator, num2, num1 * num2); break;
		case "/" : 
			if(num2==0) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}else {
				System.out.printf("%d %s %d = %.2f", num1, operator, num2, (double)num1 / num2);
			}
			break;
		default : System.out.println("존재하지 않는 연산자입니다.");
		}
		
	}
	
	// switch 예시 5 : break의 역할
	// 계절 판별 (switch version)
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달(월) 입력 : ");
		int month = sc.nextInt();
		String result;
		
		switch(month) {
		case 3: 
		case 4: 
		case 5: result = "봄"; break;
		case 6: 
		case 7: 
		case 8: result = "여름"; break;
		case 9: 
		case 10:
		case 11: result = "가을"; break;
		case 12: 
		case 1:
		case 2: result = "겨울"; break;
		default : 
			result = "잘못 입력하셨습니다.";
		}
		
		System.out.println(result);
		
	}
}
