package com.kimyoji.study.lambda;

public interface MyNumber {

	int getMax(int num1, int num2); // 추상 메서드 선언
}


class TestMyNumber{
	public static void main(String[] args) {
		
		MyNumber max = (x, y) -> (x >= y)? x : y;  // 람다식을 인터페이스형 max 변수에 대입
		System.out.println(max.getMax(10, 20));    // 인터페이스형 변수로 메서드 호출
	}
}
