package edu.kh.inheritance.dto;

public class Parent {

	private int money;
	private String lastName;
	
	public Parent() {
		System.out.println("Parent() 기본 생성자");
		
	}
	
	public Parent(int money, String lastName) {
		this.lastName = lastName;
		this.money = money;
		
		System.out.println("Parent(int, String) 매개변수 생성자");
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return money + " / " + lastName;
	}
	
	
	
}
