package edu.kh.polymorphism.ex1.dtot;

public class LightCar extends Car{

	private double discountOffer;

	public LightCar() {
		super();
	}
	
	public LightCar(int wheel, int seat, String fuel, double discountOffer) {
		super(wheel, seat, fuel); // 부모를 만듦과 동시에 초기화 시켜주는 super 생성자 사용
		
		this.discountOffer = discountOffer;
	}
	
	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}

	@Override
	public String toString() {
		return super.toString() + " /  할인율 : " + discountOffer * 100 + "%";
	}
	
	public void print() {
		System.out.println("고속도로 요금, 주차장 요금, 세금 혜택을 받을 수 있다.");
	}
	
}
