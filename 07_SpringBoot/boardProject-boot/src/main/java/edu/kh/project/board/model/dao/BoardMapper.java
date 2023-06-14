package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Mapper
public interface BoardMapper {

	/** 게시판 종류 조회
	 * @return boardTypeList
	 */
	List<Map<String, Object>> selectBoardTypeList();
	
	
	
	/** 특정 게시판의 삭제되지 않은 게시글 수 조회
	 * @param boardCode
	 * @return listCount
	 */
	public int getListCount(int boardCode);


	/** 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds
	 * @return
	 */
	public List<Board> selectBoardList(int boardCode, RowBounds rowBounds);


	/** 게시글 상세조회
	 * @param map
	 * @return board
	 */
	public Board selectBoard(Map<String, Object> map);


	/** 좋아요 여부 확인
	 * @param map
	 * @return result
	 */
	public int boardLikeCheck(Map<String, Object> map);


	/** 좋아요 테이블 삽입
	 * @param paramMap
	 * @return result
	 */
	public int insertBoardLike(Map<String, Integer> paramMap);

	
	/** 좋아요 테이블 삭제
	 * @param paramMap
	 * @return result
	 */
	public int deleteBoardLike(Map<String, Integer> paramMap);


	
	/** 좋아요 개수 조회
	 * @param integer
	 * @return count
	 */
	public int countBoardLike(Integer boardNo);

	
	/** 조회수 증가
	 * @param boardNo
	 * @return result
	 */
	public int updateReadCount(int boardNo);
	
	

	/** 게시글 수 조회 (검색)
	 * @param paramMap
	 * @return listCount
	 */
	public int getSearchListCount(Map<String, Object> paramMap);
	
	

	/** 게시글 목록 조회 (검색)
	 * @param paramMap
	 * @param rowBounds
	 * @return boardList
	 */
	public List<Board> selectSearchBoardList(Map<String, Object> paramMap, RowBounds rowBounds);
	
	
	/** 헤더 검색
	 * @param query
	 * @return list
	 */
	public List<Map<String, Object>> headerSearch(String query);
	

	/** DB 이미지(파일 목록) 조회
	 * @return imageList
	 */
	public List<String> selectImageList();


}
