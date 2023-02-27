package com.kimyoji.study.lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "def";
		
		StringConcat sc = (x, y) -> System.out.println(x + y);

//		StringConcat concat = new StringConcat() {
//			@Override
//			public void makeString(String s1, String s2) {
//				System.out.println(s1 + s2);
//			}
//		} >> 이런 식으로 생성됨
		
		sc.makeString(s1, s2);
	}
}
