package com.kimyoji.study.ex6;

class Dog{
	String name;
	String type;
	
	public Dog(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name + type;
	}
	
	
}

public class Q4 {

	public static void main(String[] args) {
		Dog d = new Dog("멍멍이", "진돗개");
		System.out.println(d);
		
	}

	
}
