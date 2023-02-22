package com.kimyoji.study.collection.hashset;

import com.kimyoji.study.collection.Member;

public class MemberHashSetTest {
	public static void main(String[] args) {
		
		MemberHashSet hs = new MemberHashSet();
		
		Member m1 = new Member(100, "아무개");
		Member m2 = new Member(101, "홍길동");
		Member m3 = new Member(102, "김씨");
		
		hs.addMember(m1);
		hs.addMember(m2);
		hs.addMember(m3);
		
		hs.showAllMember();
		
		System.out.println(hs.removeMember(1000));
		System.out.println(hs.removeMember(101));
			
		hs.showAllMember();
		
		Member m4 = new Member(102, "원주율");
		hs.addMember(m4);
		hs.showAllMember();
		
	}
}
