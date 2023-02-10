package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPracticeRun {

	public static void main(String[] args) {
		
		int excuteMethod;
		ConditionPractice con = new ConditionPractice();
		
		System.out.println("실행할 메서드 (1~3): ");
		Scanner sc = new Scanner(System.in);
		
		excuteMethod = sc.nextInt();
		
		switch(excuteMethod) {
		case 1 :
			con.practice1();
			break;
		case 2 :
			con.practice2();
			break;
		case 3 :
			con.practice3();
			break;
		case 4 :
			con.practice4();
			break;
		case 5 :
			con.practice5();
			break;
		default :
			System.out.println("메서드가 존재하지 않음 범위 밖");
		}
		
	}

}

