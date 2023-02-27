package com.kimyoji.study.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

// 배열에 여러 문자열이 있을 때 그중 길이가 가장 긴 문자열을 찾는 예제

class CompareString implements BinaryOperator<String>{  // BinaryOperator를 구현한 클래스 정의

	@Override
	public String apply(String s1, String s2) {
		if(s1.getBytes().length >= s2.getBytes().length)  // reduce() 메서드가 호출될 때 불리는 메서드
			return s1;
		else 
			return s2;
	}
	
}

public class ReduceTest {
	public static void main(String[] args) {
		
		String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다"};
		
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2)->{ 
			if(s1.getBytes().length >= s2.getBytes().length) return s1;
			else return s2;
		}));
		
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();  // BinaryOperator를 구현한 클래스 사용
		System.out.println(str);
		
		
	}
	
}
