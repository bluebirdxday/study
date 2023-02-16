package edu.kh.oop.method.dto;

// DTO(Data Transfer Object) : 값 전달용 객체 
public class User {
	
	// 아이디, 비밀번호, 이름, 성별(M/F)
	
	private String userId;
	private String userPw;
	private String userName;
	private char userGender;

	// 생성자
	public User() {
		
	}

	// 매개변수 생성자(오버로딩)
	public User(String userId, String userPw, 
			String userName, char userGender) {
		
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
	}
	
	// 메서드
	// toString() : 객체가 가지고 있는 모든 필드 값을
	// 하나의 문자열로 표기하여 반환


	public String toString() {

		return String.format("%s / %s / %s / %c", 
				userId, userPw, userName, userGender);
				
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
