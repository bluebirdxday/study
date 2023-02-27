package com.kimyoji.study.stream;

// 스트림을 활용하여 여행객의 여행 비용 계산하기
// 여행 비용은 15세 이상은 100만원, 그 미만은 50만원
// 고객 세명이 패키지 여행을 한다고 가정했을 때 비용 계산과 고객 명단 검색 등을 스트림을 활용하여 구현

public class TravelCustomer {

	private String name;
	private int age;
	private int price;
	
	public TravelCustomer(String name, int age, int price) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "TravelCustomer [name=" + name + ", age=" + age + ", price=" + price + "]";
	}

	
	
	
}
