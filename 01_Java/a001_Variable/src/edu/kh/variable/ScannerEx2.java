package edu.kh.variable;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scan.next();
		// scan.next() : 다음 입력되는 한 단어를 얻어옴 (띄어쓰기 나오기 전까지)
		
		System.out.print("나이 : ");
		int age = scan.nextInt();
		
		System.out.print("키 : ");
		double height = scan.nextDouble();
		
		System.out.printf("%s님은 %d세, 키 %.1fcm 입니다.", name, age, height);
		
	}
}
