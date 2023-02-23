package com.kimyoji.study.map.treemap;

import com.kimyoji.study.collection.Member;

public class MemberTreeMapTest {
	public static void main(String[] args) {
		
		MemberTreeMap mt = new MemberTreeMap();
		
		Member m1 = new Member(1, "권");
		Member m2 = new Member(2, "김");
		Member m3 = new Member(3, "이");
		Member m4 = new Member(4, "박");
		Member m5 = new Member(5, "최");
		
		mt.addMember(m3);
		mt.addMember(m1);
		mt.addMember(m5);
		mt.addMember(m2);
		mt.addMember(m4);
		
		mt.showAllMember();
		
		mt.removeMember(2);
		mt.removeMember(4);
		
		mt.showAllMember();
	}
}
