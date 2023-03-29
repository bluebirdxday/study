package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;

public class CommentService {


	private CommentDAO dao = new CommentDAO();
	
	
	
	/** 댓글 등록
	 * @param commentContent
	 * @param boardNo
	 * @param memberNo
	 * @return result
	 * @throws SQLException 
	 */
	public int insertComment(String commentContent, int boardNo, 
			int memberNo) throws Exception {
		
		Connection conn = getConnection();

		int commentNo = dao.nextCommentNo(conn);
		
		int result = dao.insertComment(conn, commentNo,
				commentContent, boardNo, memberNo);
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		
		close(conn);
		
		return result;
	}



	/** 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
	 * @param boardNo
	 * @param commentNo
	 * @param memberNo
	 * @return check
	 * @throws Exception 
	 */
	public int checkCommentExist(int boardNo, int commentNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int check = dao.checkCommentExist(conn, boardNo, commentNo, memberNo);
		
		close(conn);
		
		return check;
	}



	/** 댓글 수정
	 * @param commentContent
	 * @param commentNo
	 * @return result
	 * @throws Exception 
	 */
	public int updateComment(String commentContent, int commentNo) throws Exception {

		
		Connection conn = getConnection();
		
		int result = dao.updateComment(conn, commentContent, commentNo);
		
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		
		close(conn);
		
		return result;
	}



	/** 댓글 삭제
	 * @param commentNo
	 * @return result
	 * @throws Exception 
	 */
	public int deleteComment(int commentNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, commentNo);
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		
		close(conn);
		
		return result;
	}


}
