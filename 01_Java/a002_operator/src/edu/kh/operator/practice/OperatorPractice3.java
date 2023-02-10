package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {

	public static void main(String[] args) {
		
		int num;
		String result;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		num = scan.nextInt();
		
		result = num==0 ? "0 입니다." : (num>0 ? "양수 입니다." : "음수 입니다.");
		
		System.out.println(result);
	}

}
