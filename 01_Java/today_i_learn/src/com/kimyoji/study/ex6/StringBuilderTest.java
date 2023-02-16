package com.kimyoji.study.ex6;

public class StringBuilderTest {

	public static void main(String[] args) {
		
		String str1 = new String("java");
		System.out.println("str1 문자열 주소 : " + System.identityHashCode(str1));

		StringBuffer buffer = new StringBuffer(str1);
		System.out.println("연산 전 buffer의 메모리 주소 : " + System.identityHashCode(buffer));

	
		buffer.append(" and");
		buffer.append(" android");
		buffer.append(" programming");
		System.out.println("연산 후 buffer의 메모리 주소 : " + System.identityHashCode(buffer));
		
		str1 = buffer.toString();
		System.out.println(str1);
		System.out.println("새로 만들어진 str1 문자열 주소 : " + System.identityHashCode(str1));
	
	
	
		String str2 = "안녕하세요";
		
		StringBuilder builder = new StringBuilder(str2);
		builder.append("저는");
		builder.append("홍길동");
		
		str2 = builder.toString();
		System.out.println(str2);
	
	}
}
