package beakjoon.stepbystep;

import java.util.Scanner;

// 중앙 이동 알고리즘
public class Exam2903 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int ans = 0;
		
		int dot = 4;
		// 1 -> 4 -> 16  ==> 4^n
		// 3개->(2)->5개->(4)->9개
		
		for(int i=0; i<=n; i++) {
			ans = (int) (Math.pow(dot, n) + Math.pow(2, i+1) + 1);
		}
		
		scan.close();
		System.out.println(ans);
	}
}
