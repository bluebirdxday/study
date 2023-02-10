package edu.kh.operator.ex;

import java.util.Scanner;

public class OperatorEx4 {

	public static void main(String[] args) {
		
		// 홀짝 검사기
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" [홀짝 검사기] 정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		// Math.abs(숫자) -> 절대값
		String result = num%2==0 ? "짝수입니다." : (num==0 ? "0입니다." : "홀수입니다.");
		System.out.println(result);
		
		
	}

}
