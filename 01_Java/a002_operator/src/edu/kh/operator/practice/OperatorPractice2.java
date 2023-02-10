package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String name;
		int grade;
		int ban;
		int number;
		String gender;
		double score;
		
		System.out.print("이름 : ");
		name = scan.next();
		
		System.out.print("학년(정수) : ");
		grade = scan.nextInt();
		
		System.out.print("반(정수) : ");
		ban = scan.nextInt();
		
		System.out.print("번호(정수) : ");
		number = scan.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		gender = scan.next();
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		score = scan.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.",
				grade, ban, number, name, gender, score);
		

		
		
		
	}
}
