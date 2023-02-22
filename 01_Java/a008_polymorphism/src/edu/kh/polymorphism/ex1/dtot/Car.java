package edu.kh.polymorphism.ex1.dtot;

public class Car {
	// 필드
	private int wheel; 
	private int seat;
	private String fuel;
	
	public Car() {
		
	}

	public Car(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seat;
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	// alt + shift + s -> o  : 매개변수 생성자 자동 완성
	// alt + shift + s -> r  : getter/setter 자동 완성
	
	// Object.toString() 오버라이딩
	
	public String toString() {
		return String.format("%d / %d / %s", wheel, seat, fuel);
	}
}
