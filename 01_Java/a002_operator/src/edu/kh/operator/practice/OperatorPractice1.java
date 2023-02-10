package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice1 {

	public static void main(String[] args) {
		
		int peopleCount; 
		int candyCount;
		int forEachCandy;
		int restCandy;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("인원 수 : ");
		peopleCount = scan.nextInt();
		
		System.out.print("사탕 개수 : ");
		candyCount = scan.nextInt();
		
		forEachCandy = candyCount / peopleCount;
		restCandy = candyCount % peopleCount;
		
		System.out.println("1인당 사탕 개수 : " + forEachCandy);
		System.out.println("남는 사탕 개수 : " + restCandy);
		
	}

}
