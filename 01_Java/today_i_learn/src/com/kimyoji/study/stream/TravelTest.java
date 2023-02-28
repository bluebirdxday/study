package com.kimyoji.study.stream;

import java.util.ArrayList;
import java.util.List;

// 세명의 고객을 ArrayList에 추가하고 이에 대한 스트림을 생성하여 수행


/** 예제 시나리오 
 * 1. 고객의 명단을 출력함
 * 2. 여행의 총 비용을 계산함
 * 3. 고객 중 20대 이상인 사람의 이름을 정렬하여 출력
 */
public class TravelTest {
	public static void main(String[] args) {
		
		TravelCustomer tc1 = new TravelCustomer("홍길동", 25 ,300000);
		TravelCustomer tc2 = new TravelCustomer("아무개", 20 ,620000);
		TravelCustomer tc3 = new TravelCustomer("권땡떙", 32 ,567000);
		TravelCustomer tc4 = new TravelCustomer("이름이", 19 ,389000);
		
		List<TravelCustomer> list = new ArrayList<TravelCustomer>();
		
		list.add(tc1);
		list.add(tc2);
		list.add(tc3);
		list.add(tc4);
		
		System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
		
		list.stream().map(c->c.getName()).forEach(s -> System.out.println(s));
		
		int total = list.stream().mapToInt(c->c.getPrice()).sum();
		System.out.println("총 여행 비용은 : " + total + "입니다");
		
		System.out.println("== 20대 이상인 고객 명단 정렬하여 출력 ==");
		
		list.stream().filter(c->c.getAge()>=20).map(c->c.getName()).sorted().forEach(s->System.out.println(s));
		
		
		
	}
}
