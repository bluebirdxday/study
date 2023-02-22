package com.kimyoji.study.collection;

public class Member implements Comparable<Member>{

	private int memberId;
	private String memberName;
	
	public Member(int memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + "회원님의 아이디는 " + memberId + "입니다.";
	}

	@Override
	public int hashCode() {
		return memberId;
	}
	// 해시 코드가 회원 아이디를 반환하도록 재정의

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			
			if(this.memberId==member.memberId)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public int compareTo(Member member) {
		return this.memberName.compareTo(member.memberName);
		// 추가한 회원 이름과 매개변수로 받은 회원 이름 비교
		
		// 추가한 회원 아이디와 매개변수로 받은 회원 아이디 비교
		// -> return this.memberId-memberId;
		// 새로 추가한 아이디가 더 크면 양수, 그렇지 않으면 음수, 같으면 0 반환
	}
	
	// equals()메서드와 hashCode() 메서드를 재정의 하여 회원 아이디가 같으면 같은 회원임을 구현
	
}
