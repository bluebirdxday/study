package com.kimyoji.study.ex6;

public class StringTest1 {
	public static void main(String[] args) {
		
		String s1 = new String("test");
		String s2 = "test";
		String s3 = "test";
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(s2 == s3);
		System.out.println(s2.equals(s3));
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		
		
	}
}
