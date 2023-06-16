package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.board.model.service.BoardService2;
import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board2")
@SessionAttributes({"loginMember"})
public class BoardController2 {

	@Autowired
	private BoardService2 service;
	
	// 게시글 수정 시 상세조회 서비스 호출용도로 선언
	@Autowired
	private BoardService boardService;
	
	// 게시글 작성 화면 전환
	@GetMapping("/{boardCode:[0-9]+}/insert")
	public String boardInsert(@PathVariable("boardCode") int boardCode) {
		// @PathVariable : 주소 값 가져오기 + request scope에 값 올리기
		
		return "board/boardWrite";
	}
	
	// 게시글 작성
	@PostMapping("/{boardCode:[0-9]+}/insert")
	public String boardInsert(
			@PathVariable("boardCode") int boardCode,
			/* @ModelAttribute */ Board board, // 커맨드 객체(필드에 파라미터 담겨있음)
			@RequestParam(value="images", required=false) List<MultipartFile> images,
			@SessionAttribute("loginMember") Member loginMember,
			RedirectAttributes ra
			) throws IllegalStateException, IOException {
		
		// 파라미터 : 제목, 내용, 파일(0~5개)
		// 세션 : 로그인한 회원의 번호
		// 리다이렉트 시 데이터 전달 : RedirectAttributes
		// 작성 성공 시 이동할 게시판 코드 :  @PathVariable("boardCode")
		
		
		/* List<MultipartFile>
		 * - 업로드된 이미지가 없어서 List에 MultipartFile 객체가 추가됨
		 * 
		 * - 단, 업로드된 이미지가 없는 MultipartFile 객체는 
		 * 		파일크기(size)가 0 또는 파일명(getOriginalFileName())이
		 * */
		
		// 1. 로그인한 회원 번호를 얻어와 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());
		
		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);
		
		
		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호 반환 받기
		int boardNo = service.boardInsert(board, images);
		
		// 게시글 삽입 성공 시 
		// -> 방금 삽입한 게시글의 상세 조회 페이지 리다이렉트
		// -> /board/{boardCode}/{boardNo}
		
		String message = null;
		String path = "redirect:";
		
		if(boardNo>0) {		// 성공 시
			message = "게시글이 등록 되었습니다.";
			path += "/board/" + boardCode + "/" + boardNo;
		}else {
			message = "게시글 등록 실패............";
			path += "insert";		
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
	// 게시글 수정 화면 전환
	@GetMapping("/{boardCode}/{boardNo}/update")
	public String boardUpdate(
			@PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo,
			Model model) {
		
		// Model : 데이터 전달용 객체(기본 scope : request)
		
		Map<String, Object> map = new HashMap<>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		Board board = boardService.selectBoard(map);
		
		model.addAttribute("board", board);
		// forward(요청위임:controller가 받은 요청을 그대로 jsp에 반환)
		//	-> request scope 유지
		return "board/boardUpdate";
	}

	
	// 게시글 수정
	@PostMapping("/{boardCode}/{boardNo}/update")
	public String boardUpdate(
			/*@ModelAttribute*/ Board board		// 커맨드 객체(name==필드 경우 필드에 파라미터 세팅)
			, @RequestParam(value="cp", required=false, defaultValue="1") int cp		// 쿼리스트링 유지용도
			, @RequestParam(value="deleteList", required=false) String deleteList		// 삭제할 이미지 순서
			, @RequestParam(value="images", required=false) List<MultipartFile> images	// 업로드된 파일 리스트
			, @PathVariable("boardCode") int boardCode
			, @PathVariable("boardNo") int boardNo
			, RedirectAttributes ra 	// 리다이렉트 시 값 전달용
			) throws IllegalStateException, IOException{
	
		// 1) boardNo, boardCode를 커맨드 객체(board)에 세팅
		board.setBoardCode(boardCode);
		board.setBoardNo(boardNo);
		
		// board(boardCode, boardNo, boardTitle, boardContent)
		
		
		// 3) 게시글 수정 서비스 호출
		int rowCount = service.boardUpdate(board, images, deleteList);
		
		// 4) 결과에 따라 message, path 설정
		String message = null;
		String path = "redirect:";
		
		if(rowCount>0) {
			message = "게시글이 수정되었습니다.";
			path += "/board/" + boardCode +"/" + boardNo + "?cp=" + cp;	// 상세조회 페이지
		}else {
			message = "게시글 수정 실패";
			path += "update";
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	// 게시글 삭제
	@GetMapping("/{boardCode}/{boardNo}/delete")
	public String boardDelete(
			@PathVariable("boardCode") int boardCode, 
			@PathVariable("boardNo") int boardNo,
			RedirectAttributes ra
			) {
		
		// 게시글 삭제 서비스 호출
		int result = service.boardUpdateDel(boardNo);
		
		String path = "redirect:";
		String message = null;
		if(result>0) {
			message = "게시글이 삭제되었습니다.";
			path += "/board/" + boardCode;
		}else {
			message = "게시글 삭제 실패";
			path += "/board/" + boardCode + "/" + boardNo;
		}
		
		ra.addFlashAttribute("message", message);
		
		return path;
	}
	
	
	
}
