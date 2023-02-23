package edu.kh.polymorphism.ex2.dto;

// 추상 클래스
// 추상 메서드가 포함된 클래스
// 단, 추상 메서드가 없어도 추상 클래스가 될 수 있음 (드묾)
public abstract class Animal {

	private String type;
	private String eatType;
	
	public Animal() {
		super(); // 부모 생성자 호출, 미작성 시 컴파일러가 자동 추가
	}
	
	public Animal(String type, String eatType) {
		this.eatType = eatType;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEatType() {
		return eatType;
	}
	
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}


	// String Object.toString()
	// - 객체가 가지고 있는 필드를 하나의 문자열로 반환하는 용도의 메서드
	// (자식이 오버라이딩해서 사용하길 권장)
	// - 오버라이딩 X -> 패키지명+클래스명@해시코드 문자열 반환
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	
	
	// 추상 메서드 (미완성된 메서드)
	// -> 상속 받은 자식 클래스에서 반드시 오버라이딩 해야함
	// -> 추상 메서드를 포함한 클래스는 반드시 abstract 클래스여야만 함
	public abstract void breath();
	
	
}
