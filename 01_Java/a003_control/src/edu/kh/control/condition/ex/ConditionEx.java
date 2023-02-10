package edu.kh.control.condition.ex;

import java.util.Scanner;

public class ConditionEx {
	
	Scanner scan = new Scanner(System.in);
	int input;

	public void test1() {
		System.out.println("test1 수행");
	}
	
	public void test2() {
		System.out.println("test2 수행");
	}
	
	public void test3() {
		System.out.println("test3 수행");
	}

	
	public void ex1() {
		
		System.out.print("정수 입력 : ");
		input = scan.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다.");
			System.out.println("ex1() 종료");
		}
		
		if(input < 0) {
			System.out.println("음수 입니다.");
			System.out.println("ex1() 끝!");
		}
	}
	
	public void ex2() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		input = scan.nextInt();
		
		if(input>0) {
			System.out.println("양수입니다.");
		}else {
			
			if(input==0) {
				System.out.println("0입니다.");
			}else {
				System.out.println("음수입니다.");
			}
			
		}
	}
	
	public void ex3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("[홀짝 판별기]");
		System.out.print("정수 입력 : ");
		input = scan.nextInt();
		
		if(input==0) {
			System.out.println("0은 홀/짝수를 구분할 수 없음");
		}else if(Math.abs(input)%2==1) {
			System.out.println("홀수입니다.");
		}else {
			System.out.println("짝수입니다.");
		}
	}
	
	public void ex4() {
		Scanner scan = new Scanner(System.in);
		System.out.println("계절을 알고 싶은 월(달)을 입력해주세요 : ");
		input = scan.nextInt();
		
		String result;
		
		if(3<=input && input<=5) {
			result = "봄";
		}else if(6<=input && input<=8){
			result = "여름";
		}else if(9<=input && input<=11) {
			result = "가을";
		}else if(input==12 || input==1 || input==2){
			result = "겨울";
		}else {
			result = "범위 밖입니다.";
		}
		
		System.out.println(result);

	}
	
	public void ex5() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
		input = scan.nextInt();
		
		String result2;
		
		if(input<=13) {
			result2 = "어린이";
		}else if(input<=19) {
			result2 = "청소년";
		}else{
			result2 = "성인";
		}
		
		System.out.println(result2 + "입니다.");
	}	
	
	
	public void ex6() {
		//놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상일 경우에만 탑승 가능
		// 나이가 12세 미만 : "적정 연령이 아닙니다."
		// 키 140.0cm 미만 : "적정 키가 아닙니다."
		// 나이를 0세 미만 또는 100세 초과 입력 시 : "잘못 입력하셨습니다."
		
		Scanner scan = new Scanner(System.in);
		int age; 
		double height;
		
		System.out.printf("나이 입력 : ");
		age = scan.nextInt();
		
		System.out.printf("키 입력 : ");
		height = scan.nextDouble();
		
		String result = "";
		
		if(age<0 || age>100) {
			result = "잘못 입력하셨습니다.";
		}else if(height<140) {
			result = "적정 키가 아닙니다.";
		}else if(age<12) {
			result = "적정 연령이 아닙니다.";
		}else {
			result = "탑승 가능";
		}
		
		System.out.println(result);
		
	
	}
	
	public void ex7() {

		Scanner scan = new Scanner(System.in);
		String result3 = "";
				
		System.out.println("나이 입력 : ");
		int age = scan.nextInt();
		
		if(age<0 || age>100) {
			result3 = "잘못 입력하셨습니다.";
		}else if(age<12) {
			result3 = "적정 연령이 아닙니다.";
			
		}else {
			
			System.out.println("키 입력 : ");
			double height = scan.nextDouble();
			
			if(height < 100 || height > 220) {
				result3 = "잘못 입력하셨습니다.";
			}else if(height < 140) {
				result3 = "적정 키가 아닙니다.";
			}else {
				result3 = "탑승 가능";
			}
		}
		
		System.out.println(result3);
		
	}
	
	
	
}
