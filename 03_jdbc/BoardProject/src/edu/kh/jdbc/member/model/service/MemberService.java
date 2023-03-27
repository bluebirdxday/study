package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	
	
	private MemberDAO dao = new MemberDAO();

	
	
	/** 회원 목록 조회
	 * @return memberList
	 * @throws Exception 
	 */
	public List<Member> selectMemberList() throws Exception {

		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectMemberList(conn);
		
		close(conn);

		return memberList;
	}



	/** 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(String memberName, 
			String memberGender, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, memberName, memberGender,
				memberNo);
		
		// 트랜잭션 처리
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		return result;
	}



	public int updatePassword(String memberPw, String newPassword, 
			int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, memberPw, newPassword,
				memberNo);
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 숫자 6자리 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
	
		StringBuffer code = new StringBuffer();
		// String : 불변성
		// StringBuffer : 가변성
		
		Random random = new Random();
		
		for(int i=0; i<6; i++) {
			code.append(random.nextInt(10)); 
			// StringBuffer 마지막에 추가(뒤에 이어붙임)
		}
		
		return code.toString();
	}



	public int unRegisterMember(String nowPassword, int memberNo) 
			throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(conn, nowPassword, memberNo);
	
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
}
