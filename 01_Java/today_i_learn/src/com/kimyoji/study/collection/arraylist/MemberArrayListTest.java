package com.kimyoji.study.collection.arraylist;

import com.kimyoji.study.collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
		
		MemberArrayList memberArrayList = new MemberArrayList();
		
		memberArrayList.addMember(new Member(100, "홍길동"));
		memberArrayList.addMember(new Member(101, "김아무개"));
		memberArrayList.addMember(new Member(102, "땡땡"));
		
		memberArrayList.showAllMember();
		
		System.out.println();
		
		memberArrayList.removeMember(101);
		memberArrayList.showAllMember();
		
		

	}
}
