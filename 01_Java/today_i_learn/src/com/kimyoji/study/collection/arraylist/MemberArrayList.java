package com.kimyoji.study.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

import com.kimyoji.study.collection.Member;

public class MemberArrayList {
	// 메서드 3개 제공, 회원 추가/삭제/전체회원출력 

	ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	//  매개변수로 전달받은 회원을 ArrayList의 맨 뒤에 추가
	
	
	public boolean removeMember(int memberId) {
		
		/*
		 * for(int i=0; i<arrayList.size(); i++) { 
		 * Member member = arrayList.get(i); 
		 * // get(i)는 순차관리를 하는 배열에서 사용하는 메서드
		 * 
		 * int tempId = member.getMemberId(); 
		 * if(tempId==memberId) {
		 * arrayList.remove(i); return true; 
		 * } }
		 */
		
		Iterator<Member> ir = arrayList.iterator();
		
		while(ir.hasNext()) {
			Member member = ir.next();
			
			int tempId = member.getMemberId();
		
			if(tempId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	
	public void showAllMember() {
		for(Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}
}
