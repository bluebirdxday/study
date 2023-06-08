package edu.kh.project.member.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository	// DB연결 의미 + bean 등록 (IOC)
public class AjaxDAO {
	
	
	@Autowired	
	private AjaxMapper mapper;

	// 이메일로 닉네임 조회
	public String selectNickname(String email) {
		//return sqlSession.selectOne("ajaxMapper.selectNickname", email);
		return mapper.selectNickname(email);
	}

	// 닉네임으로 전화번호 조회
	public String selectMemberTel(String nickname) {
		return mapper.selectMemberTel(nickname);
	}

	// 이메일 중복 검사
	public int checkEmail(String email) {
		return mapper.checkEmail(email);
	}

	// 닉네임 중복 검사
	public int checkNickName(String nickname) {
		return mapper.checkNickName(nickname);
	}

	// 이메일로 회원 정보 조회
	public Member selectMember(String email) {
		return mapper.selectMember(email);
	}

	// 이메일이 일부라도 일치하는 모든회원 조회
	public List<Member> selectMemberList(String input) {
		return mapper.selectMemberList(input);
	}

}
