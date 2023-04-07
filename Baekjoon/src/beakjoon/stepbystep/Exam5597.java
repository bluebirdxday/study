package beakjoon.stepbystep;

import java.util.Scanner;

public class Exam5597 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] student = new int[30];
		
		for(int i=0; i<28; i++) {
			student[scan.nextInt()-1] = 1;
		}
		
		
		for(int i=0; i<30; i++) {
			if(student[i]==0)
				System.out.println(i+1);
		}
		
		scan.close();
	
	}
}
