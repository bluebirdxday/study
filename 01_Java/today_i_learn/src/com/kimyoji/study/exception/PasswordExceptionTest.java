package com.kimyoji.study.exception;

import java.util.Scanner;

public class PasswordExceptionTest {

	private String password;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PasswordException {
		if(password==null) {
			throw new PasswordException("비밀번호 null");
		}else if(password.matches("[a-zA-Z]+")) {
			throw new PasswordException("문자열로만 이루어짐");
		}else if(password.length()<5) {
			throw new PasswordException("비밀번호 길이 5미만");
		}
		
		this.password = password;
	}

	public static void main(String[] args) {
		
		// 예외 상황 : 비밀번호가 null인 경우, 문자열로만 이루어진 경우, 5자 미만인 경우
		
		System.out.print("비밀번호를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		
		String pass = sc.next();
		
		PasswordExceptionTest test = new PasswordExceptionTest();
		
		try{
			
			test.setPassword(pass);
			
		}catch(PasswordException e) {
			System.out.println(e.getMessage());
		}
		
//		String pass = new String("abc");
//		System.out.println(pass.matches("[a-zA-Z]+")); 
//		// 문자열로만 이루어졌는지 알아보려면 matches() 메서드 사용
//		
//		String pass2 = new String("abc1");
//		System.out.println(pass2.matches("[a-zA-Z]+"));
		
	}
}
