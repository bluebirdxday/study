package com.kimyoji.study.innerclass;

class OuterClass {

	private int num = 10;
	private static int sNum = 20;
	
	static class InStaticClass{
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println("정적 내부 클래스 inNum(의 인스턴스 변수) : " + inNum);
			System.out.println("정적 내부 클래스 sInNum(의 정적 변수) : " + sInNum);
			System.out.println("외부 클래스 num(의 정적 변수) : " + sNum);
		}
		
		static void sInTest() {
			
			System.out.println("외부 클래스의 정적 변수 sNum : " + sNum);
			System.out.println("내부 클래스의 정적 변수 sInNum : " + sInNum);
		}
	}
}

public class InnerTest{
	public static void main(String[] args) {
		
		OuterClass.InStaticClass inclass = new OuterClass.InStaticClass();
		
		System.out.println("정적 내부 클래스 일반 메서드 호출");
		inclass.inTest();
		
		System.out.println("정적 내부 클래스 정적 메서드 호출");
		OuterClass.InStaticClass.sInTest();
		
		
	}
}
