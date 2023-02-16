package edu.kh.oop.method.service;

import edu.kh.oop.method.dto.User;
import edu.kh.oop.method.view.UserView;

public class UserService {

	
	// 1. 회원 가입
	public User signUp(String userId, String userPw, String userPwConfirm, 
			String userName, char userGender) {
		
		// 전달 받은 값 중 비밀번호, 비밀번호 확인이 일치할 경우
		// User 객체를 생성해서 주소를 반환
		// 만약 일치하지 않은경우 null 반환
		
		User user = null;
		
		if(userPw.equals(userPwConfirm)) {
			// User 객체 생성 후 주소를 user에 저장
			user = new User(userId, userPw, userName, userGender);
		}

		return user;
	}
	
	
	// 2. 로그인
	public void login(String userId, String userPw, User signUpUser) {
		                                            // 가입한 회원 정보
		
		// 아이디 일치 여부 검사
		boolean idCheck = userId.equals(signUpUser.getUserId());

		// 비밀 번호 일치 여부 검사
		boolean pwCheck = userPw.equals(signUpUser.getUserPw());
		
		// 아이디, 비밀번호가 모두 일치하는 경우
		if(idCheck && pwCheck) {
			// 로그인 처리
			
			// UserView에 있는 클래스 변수(static) loginUser에
			// 가입한 회원의 정보를 가지고 있는 객체의 주소를 대입
			
			UserView.loginUser = signUpUser;
		}
	}
	
	// 5. 회원 정보 수정
	// 얕은 복사를 이용해서 회원 정보 업데이트 한것
	// loginUser가 참조하는 주소와 signUpUser가 참조하는 주소가 일치함
	// loginUser를 수정하게 되면 signUpUser까지 영향을 받는 것
	public boolean userUpdate(String userName, char userGender, String userPw) {
		
		// 비밀 번호 일치 여부 확인
		
		// 비밀 번호가 같지 않을 때 
		if(!UserView.loginUser.getUserPw().equals(userPw)) {
			return false;
		}
			
		// 비밀 번호가 일치할 때 
		UserView.loginUser.setUserName(userName);
		UserView.loginUser.setUserGender(userGender);
		
		return true;
	
		
	}
	
	
}
