package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {

	/*
	 * for문
	 * 반복 횟수가 지정되어 있는 경우 사용
	 * 
	 * for(초기식[1]; 조건식[2]; 증감식[4]){ 
	 * 		[3] 조건식이 true일때 반복 수행할 코드
	 * } 
	 *
	 */

	
	public void ex1() {
		
		for(int i=1; i<11; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		for(int i=5; i<13; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void ex3() {
		for(int i=3; i<=20; i+=2) {
			System.out.println(i + " ");
		}
	}
	
	public void ex4() {
		// 1부터 100까지의 모든 정수의 합 == 5050
		
		int sum=0;
		
		for(int i=1; i<=100; i++) {
			sum += i;
		}
	}
	
	public void ex5() {
		// 두 정수를 입력 받아 두 정수 사이의 모든 정수의 합 출력
		// 단, 첫번째 입력 받은 정수가 무조건 작다고 가정
		
		// 정수 1 입력 : 2
		// 정수 2 입력 : 5
		// 2부터 5까지 모든 정수의 합 : 14
		
		 Scanner sc = new Scanner(System.in);
		 int num1;
		 int num2;
		 int sum = 0;
		 
		 System.out.print("정수 1 입력 : ");
		 num1 = sc.nextInt();
		 
		 System.out.print("정수 2 입력 : ");
		 num2 = sc.nextInt();
		 
		 for(int i=num1; i<=num2; i++) {
			 sum += i;
		 }
		 
		 System.out.printf("%d부터 %d까지 모든 정수의 합 : %d", num1, num2, sum);
		
	}
	
	public void ex6() {
		// 다른 자료형으로 for문 사용하기
		
		// 10부터 20까지 0.5씩 증가하며 출력
		
		for(double i=0; i<=20; i+=0.5) {
			// 초기식을 int형으로 지정하게 되는 경우 무한루프에 빠짐
			// 왜? i += 0.5 수행 시 10.5가 아닌
			// 10으로(int형으로) 형변환되어 i에 대입되기 때문에
			// i가 계속 10을 유지
			// 해결 방법 : 초기식을 double 자료형으로 변경
			
			System.out.println(i);
		}
		
		System.out.println("--------------------------------------------");
		
		// A-Z까지 모든 알파벳 출력하기
		
		// 1) A(65), Z(90)의 유니코드 번호 이용하기
		for(int i=65; i<=90; i++) {
			System.out.print((char)i);
		}
		
		// 2) 유니코드 번호를 모를 때
		System.out.println();
 		for(int i='A'; i<='Z'; i++) {   // char->int 자동형변환
			System.out.print((char)i);
		}
 		
 		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장한다!
 		System.out.println();
 		for(char i='A'; i<='Z'; i++) {
 			System.out.print(i);
 		}
	}
	
	public void ex7() {
		// 감소하기
		// 10부터 1까지 1씩 감소하며 출력
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
		}
	}
	
	public void ex8() {
		// 입력, 합계, for
		// 정수 5개를 입력받아 합계 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			System.out.printf("정수 입력 : %d", i);
			sum += sc.nextInt();
		}
		
		System.out.println("합계 : " + sum);
		
	}
	
	public void ex9() {
		// 정수를 몇 번 입력 받을지 먼저 입력하고
		// 입력된 정수의 합계를 출력
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int howManyNum;
		int num;
		
		System.out.print("입력 받을 정수의 개수 : ");
		howManyNum = sc.nextInt();
		
		for(int i=1; i<howManyNum+1; i++) {
			System.out.printf("입력 %d : " , i);
			num = sc.nextInt();
			sum += num;
		}
		
		System.out.println("합계 : " + sum);
	}
	
	public void ex10() {
		// for + if 동시 사용
		// 1부터 10까지 반복하며 출력
		// 단, 짝수일 경우 ()로 숫자를 감싸서 출력
		
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.printf("(%d) ", i);
			}else {
				System.out.print(i + " " );
			}
		}
		
	}
	
	public void ex11() {
		// 1부터 10까지 1씩 증가하며 출력
		// 단, 3의 배수인 경우 숫자를 []로 감싸서 출력
		// 단, 5의 배수인 경우 숫자 대신 '@' 출력
		
		for(int i=1; i<=10; i++) {
			if(i%3==0) {
				System.out.printf("[%d] ", i);
			}else if(i%5==0) {
				System.out.print("@ ");
			}else {
				System.out.print(i + " ");
			}
		}
	}
	
	public void ex12() {
		// 구구단 2단 출력하기, for printf
		
		int dan = 2;
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
	}
	
	public void ex13() {
		//원하는 단을 입력받아서 역순으로 출력
		// 단 입력 : 3
		// 3 x 9 = 27 ~
		
		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.print("단 입력 : ");
		dan = sc.nextInt();
		
		for(int i=9; i>0; i--) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan*i);
		}
	}
	
	public void ex14() {
		// 입력 받은 단의 구구단 출력하기
		// 단, 입력 받은 단이 2~9 사이가 아니라면 "잘못입력하셨습니다." 출력
		
		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.print("단 입력 : ");
		dan = sc.nextInt();
		
		if(dan<2 || dan>9) {
			System.out.println("잘못 입력하셨습니다.");
		}else {
			for(int i=1; i<=9; i++) {
				System.out.printf("%d x %d = %2d\n", dan, i, i*dan);
			}
			
		}
	
	}
	
	public void ex16() {
		// 중첩 반복문 
	
		// 1 2 3 4 5
		// 2 4 6 8 10
		// 3 6 9 12 15
		// 4 8 12 16 20
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.printf(i*j +  " ");
			}
			System.out.println();
		}
	}
	
	
	public void ex17() {
		// 중첩 반복문 응용
		// 구구단을 2단부터 9단까지 모두 출력하기
		
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %2d ", i, j, i*j);
			}
			System.out.println();
		}
	}
	
	public void ex18() {
		// 2중 for문을 이용하여 다음 모양을 출력하세요 
		
		// 1
		// 12
		// 123
		// 1234
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public void ex19() {
		for(int i=1; i<=4; i++) {
			for(int j=4; j>=1; j--) {
				System.out.print(j);
			}
			
			System.out.println();
		}
	}
	
	
	public void ex20() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("입력된 정수 : ");
		int input = sc.nextInt();
		
		for(int i=input; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public void ex21() {
		// 1부터 20 사이의 3의 배수의 합과 개수를 출력
		// sum : 63
		// count : 6
		
		int count=0;
		int sum = 0;
		
		for(int i=1; i<=20; i++) {
			if(i%3==0) {
				sum += i;
				count++;
			}
		}
		
		System.out.println("sum : " + sum);
		System.out.println("count : " + count);
		
	}

	public void ex22() {
		// 1 2 3 4
		// 5 6 7 8
		// 9 10 11 12
		
		
	   int count = 0;
		
		for(int i=1; i<=12; i++, count++) {
			
			if(count!=0 && count%4==0) {
				System.out.println();
			}
			
			System.out.print(i + " ");
		}
		
		/*
		int count = 1;
		
		for(int row=1; row<=3; row++) {
			for(int col=1; col<=4; col++) {
				System.out.printf("%3d", count++);
			}
			System.out.println();
		}
		*/
	}
	
}
