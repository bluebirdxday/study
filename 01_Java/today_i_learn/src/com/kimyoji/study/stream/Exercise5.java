package com.kimyoji.study.stream;

import java.util.Scanner;

interface Calc{
	public int add(int num1, int num2);
}


public class Exercise5 {
	
	public static void main(String[] args) {
		
		int a;
		int b;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 : ");
		a = sc.nextInt();
		
		System.out.print("두번째 정수 입력 : ");
		b = sc.nextInt();
		
		Calc c = (num1, num2) -> num1+num2;
		
		System.out.print("합 : " + c.add(a, b));
	}
}
