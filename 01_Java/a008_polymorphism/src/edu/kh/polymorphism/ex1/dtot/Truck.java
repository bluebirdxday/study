package edu.kh.polymorphism.ex1.dtot;

public class Truck extends Car{
	private double weight;
	
	public Truck() {
		super();
	}
	
	public Truck(int wheel, int seat, String fuel, double weight) {
		super(wheel, seat, fuel);
		
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	// Car.toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / " + weight;
	}
	
	public void loading() {
		System.out.println("물건을 많이 실을 수 있다.");
	}
	
	
	
	
}
