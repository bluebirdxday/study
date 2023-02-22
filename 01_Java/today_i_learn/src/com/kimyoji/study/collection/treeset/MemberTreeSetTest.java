package com.kimyoji.study.collection.treeset;

import com.kimyoji.study.collection.Member;

public class MemberTreeSetTest {
	public static void main(String[] args) {
		
		MemberTreeSet ts = new MemberTreeSet();
		
		Member m3 = new Member(3, "차");
		Member m1 = new Member(1, "김");
		Member m4 = new Member(4, "오");
		Member m2 = new Member(2, "장");
		
		ts.addMember(m3);
		ts.addMember(m1);
		ts.addMember(m4);
		ts.addMember(m2);
		
		ts.showAllMember();
		
		ts.removeMember(5);
		ts.removeMember(1);
		
		ts.showAllMember();
		
	}
}
