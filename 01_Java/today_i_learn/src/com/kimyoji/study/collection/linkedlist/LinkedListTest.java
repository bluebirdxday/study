package com.kimyoji.study.collection.linkedlist;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList<String> mList = new LinkedList<String>();
		
		mList.add("A");
		mList.add("B");
		mList.add("C");
		
		System.out.println(mList);
		
		mList.add(1, "D");
		System.out.println(mList);
		
		mList.addFirst("0");
		System.out.println(mList);
		
		System.out.println(mList.removeLast());
		System.out.println(mList);
	}
}
