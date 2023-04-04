package beakjoon.stepbystep;

import java.util.Scanner;

public class Exam25314 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		String output = "int";
		
		if(n>=4) {
			for(int i=0; i<n/4; i++)
				System.out.print("long ");
			System.out.print(output);
		}
	}
}
