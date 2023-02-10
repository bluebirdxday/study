package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice4 {

	public static void main(String[] args) {
		
		int korean;
		int english;
		int math;
		
		int sum;
		double average;
		
		String passOrNonPass;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 : ");
		korean = scan.nextInt();
		
		System.out.print("영어 : ");
		english = scan.nextInt();
		
		System.out.print("수학 : ");
		math = scan.nextInt();
		
		sum = korean + english + math;
		average = sum/3.0;
		
		passOrNonPass = average>=60 ? "합격" : "불합격";
		
		System.out.printf("합계 : %d \n평균 : %.1f \n%s", sum, average, passOrNonPass);
		
		
	}

}
