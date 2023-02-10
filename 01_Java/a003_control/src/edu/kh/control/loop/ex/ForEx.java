package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {

	/*
	 * for문
	 * 반복 횟수가 지정되어 있는 경우 사용
	 * 
	 * for(초기식[1]; 조건식[2]; 증감식[4]){ 
	 * 		[3] 조건식이 true일때 반복 수행할 코드
	 * } 
	 *
	 */

	
	public void ex1() {
		
		for(int i=1; i<11; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		for(int i=5; i<13; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void ex3() {
		for(int i=3; i<=20; i+=2) {
			System.out.println(i + " ");
		}
	}
	
	public void ex4() {
		// 1부터 100까지의 모든 정수의 합 == 5050
		
		int sum=0;
		
		for(int i=1; i<=100; i++) {
			sum += i;
		}
	}
	
	public void ex5() {
		// 두 정수를 입력 받아 두 정수 사이의 모든 정수의 합 출력
		// 단, 첫번째 입력 받은 정수가 무조건 작다고 가정
		
		// 정수 1 입력 : 2
		// 정수 2 입력 : 5
		// 2부터 5까지 모든 정수의 합 : 14
		
		 Scanner sc = new Scanner(System.in);
		 int num1;
		 int num2;
		 int sum = 0;
		 
		 System.out.print("정수 1 입력 : ");
		 num1 = sc.nextInt();
		 
		 System.out.print("정수 2 입력 : ");
		 num2 = sc.nextInt();
		 
		 for(int i=num1; i<=num2; i++) {
			 sum += i;
		 }
		 
		 System.out.printf("%d부터 %d가지 모든 정수의 합 : %d", num1, num2, sum);
		
	}
	
}
