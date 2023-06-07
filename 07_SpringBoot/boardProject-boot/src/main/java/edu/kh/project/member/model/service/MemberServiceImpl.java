package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
		
		@Autowired
		private MemberDAO dao;
		
		@Autowired	
		private BCryptPasswordEncoder bcrypt;

		@Override
		public Member login(Member inputMember) {	
			
			
			// bcrypt 암호화는 salt가 추가되기 때문에 
			// 계속 비밀번호가 바뀌게 되어 DB에서 비교 불가능
			// -> 별도로 제공해주는 matches(평문, 암호문)
			
			
			// dao 메서드 호출
			Member loginMember = dao.login(inputMember);
			
			if(loginMember!=null) {	// 아이디가 일치하는 회원이 조회된 경우
				
				// 입력한 pw, 암호화된 pw가 같은지 확인
				if(bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
					
					// 비밀번호를 유지하지 않기 위해서 로그인 정보에서 제거
					loginMember.setMemberPw(null);
					
				}else {	// 다를 경우
					loginMember = null;		// 로그인 실패처럼 만듦
				}
			}
			
			return loginMember;
		}

		
		// 회원가입 서비스
		@Transactional(rollbackFor = {Exception.class})	
		@Override
		public int signUp(Member inputMember) {
			
			// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅
			String encPw = bcrypt.encode(inputMember.getMemberPw());
			inputMember.setMemberPw(encPw);
			
			// dao 호출
			int result = dao.signUp(inputMember);
			
			return result;
		}
}
