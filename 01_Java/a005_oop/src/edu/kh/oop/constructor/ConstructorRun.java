package edu.kh.oop.constructor;

public class ConstructorRun {

	public static void main(String[] args) {
		

		// 회원 생성
		
		// 기본 생성자를 이용해서 Mebmer 객체 생성
		Member mem1 = new Member(); 
		
		// 매개변수 생성자를 이용해서 Member 객체 생성
		Member mem2 = new Member("user2", "weriow", "아무개", 13);
		
		Member mem3 = new Member("user3");
		
		System.out.println(Member.programName);
		
		System.out.println("--------------------");
		
	}
	
}
