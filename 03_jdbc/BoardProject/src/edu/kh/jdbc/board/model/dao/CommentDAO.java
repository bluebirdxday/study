package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Comment;

public class CommentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public CommentDAO() {

		try {
			
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	/** 댓글 목록 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception{
		
		List<Comment> commentList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int commentNo = rs.getInt("COMMENT_NO");
				String commentContent = rs.getString("COMMENT_CONTENT");
				int memberNo = rs.getInt("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NM");
				String createDate = rs.getString("CREATE_DT");
				
				Comment c = new Comment();
				c.setCommentNo(commentNo);
				c.setCommentContent(commentContent);
				c.setMemberNo(memberNo);
				c.setMemberName(memberName);
				c.setCreateDate(createDate);
				
				commentList.add(c);
			}

			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}



	public int insertComment(Connection conn, int commentNo, String commentContent, 
			int boardNo, int memberNo) throws Exception {
		
		int result = 0;
		
		
		try {
			
			String sql = prop.getProperty("insertComment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			pstmt.setString(2, commentContent);
			pstmt.setInt(3, memberNo);
			pstmt.setInt(4, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}



	/** 다음 댓글 번호 조회
	 * @param conn
	 * @return commentNo
	 * @throws SQLException
	 */
	public int nextCommentNo(Connection conn) throws Exception {

		int commentNo = 0;
		
		
		try {
			
			String sql = prop.getProperty("nextCommentNo");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next())
				commentNo = rs.getInt(1);
			
		}finally{
			
			close(rs);
			close(stmt);
		}
		
		return commentNo;
	}



	/** 해당 댓글이 현재 게시글의 댓글이며 로그인한 회원이 쓴 댓글이 맞는지 확인
	 * @param conn
	 * @param boardNo
	 * @param commentNo
	 * @param memberNo
	 * @return check 
	 * @throws Exception 
	 */
	public int checkCommentExist(Connection conn, int boardNo, int commentNo, int memberNo) throws Exception {
		
		int check = 0;
		
		try {
			
			String sql = prop.getProperty("checkCommentExist");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, boardNo);
			pstmt.setInt(3, commentNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				check = rs.getInt(1);
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return check;
	}



	/** 댓글 수정
	 * @param conn
	 * @param commentContent
	 * @param commentNo
	 * @return result
	 * @throws Exception 
	 */
	public int updateComment(Connection conn, String commentContent, int commentNo) throws Exception {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	/** 댓글 삭제
	 * @param conn
	 * @param commentNo
	 * @return result
	 */
	public int deleteComment(Connection conn, int commentNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			
			result = pstmt.executeUpdate();
			
		}finally{
			
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
