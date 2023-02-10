package com.kimyoji.study.ex5;

import java.io.IOException;

public class SortTest {
	public static void main(String[] args) throws IOException {
	
		Sort sort = null;
		
		System.out.println("정렬 방식을 선택하시오 : ");
		System.out.println("B : BubbleSort");
		System.out.println("S : HeapSort");
		System.out.println("Q : QuickSort");
		
		int ch = System.in.read();
		
		if(ch=='H' || ch=='h') {
			sort = new HeapSort();
		}else if(ch=='Q' || ch=='q') {
			sort = new QuickSort();
		}else if(ch=='B' || ch=='b'){
			sort = new BubbleSort();
		}else {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		
		int[] array = {1,2,3,4,5};
		
		sort.ascending(array);
		sort.descending(array);
		sort.description();
	}

}
