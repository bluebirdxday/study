package beakjoon.stepbystep;

import java.util.*;

public class Exam1008 {  
	// 백준에서는 반드시 Main으로 클래스명 변경해서 제출하기 -> 아니면 컴파일에러남
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		
		scan.close();
		
		System.out.println(a/b);
	}
}
