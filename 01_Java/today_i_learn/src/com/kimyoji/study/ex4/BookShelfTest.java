package com.kimyoji.study.ex4;

public class BookShelfTest {
	public static void main(String[] args) {
		
		Queue queue = new BookShelf();
		queue.enQueue("태백산맥");
		queue.enQueue("토지");
		
		
		System.out.println(queue.getSize());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}
