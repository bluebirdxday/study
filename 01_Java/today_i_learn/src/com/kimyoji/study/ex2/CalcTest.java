package com.kimyoji.study.ex2;

public class CalcTest {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 30;	
		
		CompleteCalc calc = new CompleteCalc();
		System.out.println(calc.add(num1, num2));
		calc.showInfo();
		
		System.out.println(Calc.PI);
		
		int[] arr = {3, 4, 5, 6, 7};
		System.out.println(Calc.total(arr));
		
	}

}
