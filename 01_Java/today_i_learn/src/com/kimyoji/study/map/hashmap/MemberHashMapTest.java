package com.kimyoji.study.map.hashmap;

import com.kimyoji.study.collection.Member;

public class MemberHashMapTest {
	public static void main(String[] args) {
		
		MemberHashMap mh = new MemberHashMap();
		
		Member m1 = new Member(1, "김");
		Member m2 = new Member(2, "황");
		Member m3 = new Member(3, "이");
		Member m4 = new Member(4, "전");
		Member m5 = new Member(5, "최");
		
		mh.addMember(m5);
		mh.addMember(m3);
		mh.addMember(m4);
		mh.addMember(m1);
		mh.addMember(m2);
		
		mh.showAllMember();
		
		mh.removeMember(4);
		mh.removeMember(8);
		
		mh.showAllMember();
	}
}
