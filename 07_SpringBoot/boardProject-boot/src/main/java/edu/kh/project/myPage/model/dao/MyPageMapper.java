package edu.kh.project.myPage.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {
	

	/** 회원 정보 수정 DAO
	 * @param updateMember
	 */
	int updateInfo(Member updateMember);


	/** 회원 비밀번호 조회
	 * @param memberNo
	 */
	String selectEncPw(int memberNo);


	/** 비밀번호 변경
	 * @param member
	 */
	int changePw(Member member);


	/** 회원 탈퇴
	 * @param memberNo
	 */
	int secession(int memberNo);

	/** 프로필 이미지 변경
	 * @param loginMember
	 */
	public int updateProfileImage(Member loginMember);
	
}
