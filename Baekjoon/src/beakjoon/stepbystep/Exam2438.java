package beakjoon.stepbystep;

import java.util.Scanner;

public class Exam2438 {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		
		for(int i=1; i<count+1; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		scan.close();
	}
}
