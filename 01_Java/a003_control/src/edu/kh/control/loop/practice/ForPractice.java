package edu.kh.control.loop.practice;

import java.util.Scanner;

public class ForPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		num= sc.nextInt();
		
		if(num<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}else {
			for(int i=1; i<=num; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		num= sc.nextInt();
		
		if(num<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}else {
			for(int i=num; i>0; i--) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		int sum = 0;
		
		System.out.print("정수를 하나 입력하세요 : ");
		num = sc.nextInt();
		
		
		for(int i=1; i<=num; i++) {
			sum += i;
			System.out.print(i);
			
			if(i==num) {
				System.out.print(" = ");
			}else {
				System.out.print(" + ");
			}
			
			System.out.println(sum);
		}

		// [또 다른 방식]
		
//		for(int i=1; i<=num-1; i++) {
//			sum += i;
//			System.out.print(i + " + ");
//		}
//		
//		sum += num;
//		System.out.println(num + " = " + sum);

		
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		
		
		System.out.print("첫 번째 숫자 : ");
		num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		num2 = sc.nextInt();
		
		if(num1<1 || num2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		
		if(num1 > num2) {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i + " ");
			}
		}else {
			for(int i=num2; i<=num1; i++) {
				System.out.print(i + " ");
			}
		}
	}
		
	
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("숫자 : ");
		num = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n", num);
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n", num, i, num*i);
		}
	}
	
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("숫자 : ");
		num = sc.nextInt();
		
		if(num<2 || num>9) {
			System.out.println("2~9 사이 숫자만 입력해주세요");
			return;
		}
		
		for(int dan=num; dan<=9; dan++) {
			System.out.printf("===== %d단 =====\n", dan);
			for(int x=1; x<=9; x++) {
				System.out.printf("%d * %d = %d\n", dan, x, dan*x);
			}
		}
	}
	
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		for(int i=num; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		// 공백 - 3개 , 별 - 1개
		// 공백 - 2개 , 별 - 2개
		int empty;
		int star;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		empty = num-1; 
		star = num-empty; 
		
		for(int i=0; i<num; i++, empty--, star++) {
			
			for(int j=0; j<empty; j++) {
				System.out.print(" ");
			} // 공백 출력
			
			for(int h=0; h<star; h++) {
				System.out.print("*");
			} // 별 출력
			
			System.out.println();
		}
		
	}
	
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.printf("정수 입력 : ");
		num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=num-1; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		int star;
		int empty;
		
		System.out.printf("정수 입력 : ");
		num = sc.nextInt();
		
		empty = num-1;
		star = 1;
			
		for(int i=0; i<num; i++, empty--, star+=2) {
			
			for(int j=0; j<empty; j++) {
				System.out.print(" ");
			}
			
			for(int h=0; h<star; h++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		// 공백3 별1 
		// 공백2 별3 
		// 공백1 별5 
		// 공백0 별7
		
	}
	
	
	public void practice12() {
		
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int empty;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		empty = num-2;
		
		for(int i=0; i<num; i++) {
			
			if(i==0 || i==num-1) {
				for(int j=0; j<num; j++) {
					System.out.print("*");
				}
			}else {
				System.out.print("*");
				
				for(int h=0; h<empty; h++) {
					System.out.print(" ");
				}
				
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int count = 0;
		
		System.out.print("자연수 하나를 입력하세요 : ");
		num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			
			if(i%2==0 || i%3==0) {
				System.out.print(i + " ");
			}
			
			if(i%2==0 && i%3==0) {
				count++;
			}
		}
		
		System.out.printf("\ncount : %d ",count);
	}
	
	
	
}
