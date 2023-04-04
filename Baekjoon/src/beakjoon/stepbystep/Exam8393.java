package beakjoon.stepbystep;

import java.util.Scanner;

/**
 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 */
public class Exam8393 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int sum=0;
		int n = scan.nextInt();
		
		for(int i=1; i<n+1; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}
