package edu.kh.polymorphism.ex2.dto;

public class Fish extends Animal {

	private int fin;
	
	public Fish() {}

	// alt + [shift] + s -> o
	// 생성자
	
	public Fish(String type, String eatType, int fin) {
		super(type, eatType);
		this.fin = fin;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + fin;
	}

	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}
	
	
	
}
