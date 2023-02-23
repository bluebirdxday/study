package com.kimyoji.study.exception;

public class AutoCloseTest {

	public static void main(String[] args) {
		
		try (AutoCloseObj obj = new AutoCloseObj()) {  // 사용할 리소스 선언
			throw new Exception();
		}catch (Exception e) {
			System.out.println("예외 부분 입니다.");
		}
	}
}
