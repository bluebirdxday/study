package edu.kh.variable;

public class Practice {

	public static void main(String[] args) {

		/* 강제 형변환 (<->자동 형변환)
		 * 특정 자료형으로 강제 형변환 
		 * 데이터 손실 발생*/
		
		
		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum2 * dNum); // int형 > double형으로 자동 형변환 : 10.0
		
		System.out.println((double)iNum1 / iNum2);
		System.out.println((int)fNum);
		System.out.println((int)(iNum1 / fNum)); // ((강제형변환)(자동형변환))
		
		//정확도 차이를 보여주기 위한 예시
		System.out.println(iNum1 / fNum); // 3.3333333
		System.out.println(iNum1 / (double)fNum); // 3.333333333333333
		
		System.out.println((int)ch);  // 65
		
		System.out.println(iNum1 + ch); // 자동 형변환 int + char = 10 + 65
		
		System.out.println((char)(ch+10));
		
	}

}
