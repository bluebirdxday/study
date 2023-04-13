package beakjoon.stepbystep;

import java.util.Scanner;

public class Exam2588 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		int first = a*(b%10);
		int second = a*((b%100)/10);
		int third = a*(b/100);
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		
		System.out.println(first + second*10 + third*100);
		
		scan.close();
	}
}
