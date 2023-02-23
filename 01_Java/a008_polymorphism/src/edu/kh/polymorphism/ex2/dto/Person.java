package edu.kh.polymorphism.ex2.dto;

public class Person extends Animal{

	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String type, String eatType, String name, int age) {
		super(type, eatType);
		
		this.name = name;
		this.age = age;
	}
	
	// alt + [shift] + s -> r
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	// alt + [shift] + s -> s

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	@Override
	public void breath() {
		System.out.println("코와 입으로 숨을 쉰다.");
	}
	
}
