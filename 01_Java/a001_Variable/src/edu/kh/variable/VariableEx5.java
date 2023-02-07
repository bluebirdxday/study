package edu.kh.variable;

public class VariableEx5 {
	public static void main(String[] args) {
		// 형변환 : 값의 자료형을 변환하는 것
		
		// 형변환은 왜 필요할까?
		// 컴퓨터의 값 처리 원칙을 위배하는 경우를 해결하기 위해
		
		
		/* 자동 형변환 
		 * 
		 * 값의 범위가 서로 다른 두 값의 연산 시
		 * 컴파일러가 자동으로 형변환을 함 */
		
		
		int num1 = 10;
		long num2 = 100L;
		
		System.out.println("num1 + num2 = " + (num1+num2));
	
	
		int num3 = 300;
		double num4 = 12.3;
		double result = num3 + num4;
		
		System.out.println(num3 + " + " + num4 + " = " + result);
		
		char ch5 = '9';
		
		int num5 = ch5;
		
		System.out.println("-----------------------------------");
		/*강제 형변환
		 *   값의 범위가 큰 자료형을 작은 자료형으로 강제 변환 *
		 */
		
		int test1 = 290;
		byte test2 = (byte) test1;
		
		System.out.println("test1 : " + test1);
		System.out.println("test2 : " + test2);
		
		System.out.println("-----------------------------------");
		// 변수에만 강제 형변환이 가능한 것은 아니다
		System.out.println((double)65);
		System.out.println((char)65);
		System.out.println((int)'B');
		
		
		//데이터 오버플로우
		byte bNum = 126;
		System.out.println(bNum);
		bNum = (byte)(bNum + 1);  // (byte)((int)127)
		System.out.println(bNum);
		bNum = (byte)(bNum + 1);  // (byte)((int)128)
		System.out.println(bNum);
		
		int iNum1 = 1000000000;
		int iNum2 = 2000000000;
		
		long iNum3 = (long)iNum1 + iNum2;
		
		System.out.println(iNum3);
		// 값의 범위를 잘못 예측한 경우 오버플로우가 발생함
						
	}
	
}
