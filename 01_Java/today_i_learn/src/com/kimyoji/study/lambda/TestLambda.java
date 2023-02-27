package com.kimyoji.study.lambda;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		
		PrintString ps = returnString();
		ps.showString("hello");
	}
	
	private static void showString(PrintString p) {
		p.showString("hello lambda2");
	}

	public static PrintString returnString() {
		return s -> System.out.println(s + "world");
	}
	
}
