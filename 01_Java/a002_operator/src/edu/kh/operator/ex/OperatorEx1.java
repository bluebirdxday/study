package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 나머지 연산자 % : modulom (=mod)
		
		System.out.println("두 정수를 입력 받아 산술 연산 결과 출력하기");
		
		System.out.print("정수 입력 1 : ");
		int input1 = scan.nextInt();
		
		System.out.print("정수 입력 2 : ");
		int input2 = scan.nextInt();
		
		System.out.printf("%d + %d = %d \n", input1, input2, input1+input2);
		
		System.out.printf("%d %% %d = %d \n", input1, input2, input1%input2);
		// printf에서 '%' 연산자를 출력하고 싶으면 "%%" 이렇게 작성
	}

}
