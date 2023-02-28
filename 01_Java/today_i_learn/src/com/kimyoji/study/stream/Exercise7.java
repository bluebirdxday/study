package com.kimyoji.study.stream;

import java.util.ArrayList;
import java.util.List;

// 모든 책의 가격의 합
// 책의 가격이 20,000원 이상인 책의 이름을 정렬하여 출력

class Book{
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
}

public class Exercise7 {
	public static void main(String[] args) {
		
		List<Book> list = new ArrayList<>();
		
		Book b1 = new Book("자바", 25000);
		Book b2 = new Book("파이썬", 15000);
		Book b3 = new Book("안드로이드", 30000);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		int total = list.stream().mapToInt(c->c.getPrice()).sum();
		
		System.out.println("모든 책의 가격의 합 : " + total);
		
		System.out.println("==책의 가격이 20,000원 이상인 책의 이름을 정렬 ==");
		list.stream().filter(c->c.getPrice()>=20000).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
	}
}
