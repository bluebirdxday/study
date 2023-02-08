package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		// Scanner 프로그램 실행 중 입력을 받는 객체
		
		Scanner scan = new Scanner(System.in); // System.in : 키보드로 부터 입력받음
		
		System.out.print("정수 입력 1 : ");
		int input1 = scan.nextInt();
		System.out.println(input1);
		
		System.out.print("정수 입력 2 : ");
		int input2 = scan.nextInt();
		 
		System.out.printf("%d + %d = %d", input1, input2, input1 + input2);
		
	}
}
