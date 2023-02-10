package edu.kh.operator.ex;

public class OperatorEx2 {

	//main method 자동 완성 : main + ctrl + spacebar + enter

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 10;
		
		System.out.printf("[연산 전] num1 : %d \n num2 : %d \n", num1, num2);
		
		num1++;
		num2--;
		
		System.out.printf("[연산 후] num1 : %d \n num2 : %d \n", num1, num2);
		
		System.out.println("----------------------------------------------------");
		
		int num3 = 5;
		System.out.println(" ++num3 : " + (++num3));   // 6
		System.out.println(" --num3 : " + (--num3 + 10));  //15
		
		int num4 = 1;
		System.out.println("num4-- : " + (num4--));  // 0
		 
		System.out.println("num4++ - 3" + (num4++ - 3));  // -3
		System.out.println("연산 후 num4 : " + num4); // 1
		
		
		System.out.println("===================================");
		int a = 3;
		int b = 5;
		int c = a++ + --b; // 3+4 = 7 =c , a=4, b=4
		
		System.out.println("c : " + c);
		
		System.out.println("===================================");
		
		int num5 = 100;
		int num6 = 200;
		
		System.out.println(num5 == num6); // false
		System.out.println(num5 != num6); // true
		
		System.out.println(num5 >= num6-num5); // true
		System.out.println(num6 <= num5 + num5 + num5); // true
		
		// 짝수 검사 ==  2의 배수인지
		System.out.println(4%2==0); // true
		System.out.println(5%2==0); // false
		
		// 홀수 검사
		System.out.println(4%2==1); // false
		System.out.println(5%2==1); // true
		
		System.out.println("463984는 3의 배수인가? " + (463984%3==0));
 	} 

}
