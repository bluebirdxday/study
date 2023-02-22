package com.kimyoji.study.collection.queue;

import java.util.ArrayList;

class MyQueue{
	private ArrayList<String> arrayQueue = new ArrayList<String>();
	
	public void enQueue(String data) {
		arrayQueue.add(data);
	}
	
	public String deQueue() {
		int len = arrayQueue.size();
		
		if(len==0) {
			System.out.println("큐가 비었습니다.");
			return null;
		}
			
		return arrayQueue.remove(0); // 맨 앞의 자료 반환하고 배열에서 제거
	}
}

public class QueueTest {
	public static void main(String[] args) {
		MyQueue mq = new MyQueue();
		
		mq.enQueue("A");
		mq.enQueue("B");
		mq.enQueue("C");
		
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());
		System.out.println(mq.deQueue());

	}
}
