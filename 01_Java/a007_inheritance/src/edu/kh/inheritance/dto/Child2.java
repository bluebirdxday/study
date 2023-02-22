package edu.kh.inheritance.dto;

public class Child2 extends Parent{

	private String house;
	
	public Child2() {
		System.out.println("Child2() 기본 생성자");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
	
	// @Override : 컴파일러에게 해당 메서드는 재정의 되었다는 것을 알려주는 컴퓨터용 주석
	// -> 오버라이딩 형식이 맞는지 검사 진행
	// 자식이 상속받은 getMoney()을 다시 작성(재정의)
	@Override
	public int getMoney() {
		System.out.println(super.getMoney() + 500);
		return super.getMoney() + 500;
	}
	
	
}
