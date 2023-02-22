package com.kimyoji.study.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;

import com.kimyoji.study.collection.Member;

public class MemberHashMap {
	
	//key 값은 회원 아이디, value는 회원 클래스 
	
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<Integer, Member>();
	}
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId) {
		
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return true;
		}
		System.out.println(memberId + "가 존재하지 않습니다");
		return false;
	}
	
	public void showAllMember() {
		Iterator<Integer> ir = hashMap.keySet().iterator();
		
		if(ir.hasNext()) { // 다음 키가 있으면
			int key = ir.next();  // key 값을 가져와서
			 
			Member member = hashMap.get(key);  // key로부터 value 가져오기
			
			System.out.println(member);
		}
		System.out.println();
	}
	
}
