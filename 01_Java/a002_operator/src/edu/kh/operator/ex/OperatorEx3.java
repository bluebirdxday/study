package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx3 {

	public static void main(String[] args) {
		
		// 논리 연산자 : &&(AND), ||(OR)
		
		// [AND 연산자]
		// 입력받은 정수가 100 이상이면서 짝수인가?
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 1 : ");
		int num1 = scan.nextInt();
		
		System.out.println((num1>=100) && (num1%2==0));
		
		// 입력받은 정수가 50 이하이고 3의 배수인가?
		
		int num2 = 42;
		boolean result2 = (num2<=50) && (num2%3==0);
		System.out.println("50 이하이고 3의 배수? " + result2);
		
		// 입력받은 정수가 1과 100 사이의 숫자인가?
		System.out.println("정수 입력 2 : ");
		int num3 = scan.nextInt();
		System.out.println((1<=num3) && (num3<=100));
		
		// [OR 연산자]
		// 정수가 10을 초과하거나 홀수인가?
		int num4 = 5;
		boolean result4 = num4>10 || num4%2==1;
		System.out.println("10을 초과하거나 홀수? " + result4);
		
		// 정수는 0부터 50사이 숫자 또는 음수인가?
		int num5 = -1;
		boolean result5 = num5<=50;
		System.out.println("0부터 50사이 숫자 또는 음수인가? " + result5);
		
		// [! 논리 부정 연산자]
		
		// 11은 짝수가 아니다
		System.out.println("11은 짝수가 아니다 : " + !(11%2==0));
		System.out.println(true || false && !false);
	}
	
	

}
