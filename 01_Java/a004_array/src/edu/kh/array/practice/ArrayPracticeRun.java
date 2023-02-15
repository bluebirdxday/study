package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPracticeRun {

	public static void main(String[] args) {
		
		ArrayPractice arrayPractice = new ArrayPractice();
		
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.print("실행하고자 하는 메서드 : ");
		input = sc.nextInt();
		
		switch(input) {
		case 1 :
			arrayPractice.practice1();
			break;
		case 2 :
			arrayPractice.practice2();
			break;
		case 3 :
			arrayPractice.practice3();
			break;
		case 4 :
			arrayPractice.practice4();
			break;
		case 5 :
			arrayPractice.practice5();
			break;
		case 6 :
			arrayPractice.practice6();
			break;
		case 7 :
			arrayPractice.practice7();
			break;
		case 8 :
			arrayPractice.practice8();
			break;
		case 9 :
			arrayPractice.practice9();
			break;
		case 10 :
			arrayPractice.practice10();
			break;
		case 11 :
			arrayPractice.practice11();
			break;
		case 12 :
			arrayPractice.practice12();
			break;
		case 13 :
			arrayPractice.practice13();
			break;
		case 14 :
			arrayPractice.practice14();
			break;
		case 15 :
			arrayPractice.practice15();
			break;
		case 16 :
			arrayPractice.practice16();
			break;
		case 17 :
			arrayPractice.practice17();
			break;
		case 18 :
			arrayPractice.practice18();
			break;
		case 19 :
			arrayPractice.practice19();
			break;
		case 20 :
			arrayPractice.practice20();
			break;
		case 21 :
			arrayPractice.practice21();
			break;
		case 22 :
			arrayPractice.practice22();
			break;
		default : 
				System.out.println("실행할 수 없는 메서드");
				return;
		}
	}

}
