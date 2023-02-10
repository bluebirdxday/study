package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForRun {

	public static void main(String[] args) {
		
		int executeMethod;
		
		ForPractice forPractice = new ForPractice();
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실행하고자 하는 메서드 (1~13): ");
		executeMethod = sc.nextInt();
		
		switch(executeMethod) {
		case 1 : 
			forPractice.practice1();
			break;
		case 2 : 
			forPractice.practice2();
			break;
		case 3 : 
			forPractice.practice3();
			break;
		case 4 : 
			forPractice.practice4();
			break;
		case 5 : 
			forPractice.practice5();
			break;
		case 6 : 
			forPractice.practice6();
			break;
		case 7 : 
			forPractice.practice7();
			break;
		case 8 : 
			forPractice.practice8();
			break;
		case 9 : 
			forPractice.practice9();
			break;
		case 10 : 
			forPractice.practice10();
			break;
		case 11 : 
			forPractice.practice11();
			break;
		case 12 : 
			forPractice.practice12();
			break;
		case 13 : 
			forPractice.practice13();
			break;
		default : 
			System.out.println("존재하지 않는 메서드");
		}
	}

}
