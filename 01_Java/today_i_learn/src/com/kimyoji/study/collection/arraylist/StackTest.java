package com.kimyoji.study.collection.arraylist;

import java.util.ArrayList;

class MyStack{
	
	private ArrayList<String> arrayStack = new ArrayList<String>();
	
	public void push(String data) {
		arrayStack.add(data);
	}
	
	public String pop() {
		int len = arrayStack.size();
		
		if(len==0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		
		return(arrayStack.remove(len-1));
	}
	
}


public class StackTest {

	public static void main(String[] args) {
		
		MyStack ms = new MyStack();
		
		ms.push("A");
		ms.push("B");
		ms.push("C");
		
		System.out.println(ms.toString());
		
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		System.out.println(ms.pop());
	}
}
