package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;



/** 회원 전용 화면
 * @author 전희진(bluebirdxday@naver.com)
 *
 */
public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	
	/**
	 * 회원 기능 메뉴
	 */
	public void memberMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n===== 회원 기능 ======\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				
				
				System.out.println("9. 메인 메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
			
				switch(input) {
				case 1 : selectMyInfo(); break;
				case 2 : selectMemberList(); break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 9 : 
					System.out.println("\n==== 메인 메뉴로 돌아갑니다 ====\n"); 
					input = 0;
					break;
				case 0 :		
					// JVM 강제 종료 구문
					// 매개변수는 기본 0, 다른 숫자는 오류를 의미
					System.exit(0);
				default : System.out.println("\n*** 메뉴 번호만 입력해주세요 ***\n");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("\n *** 입력 형식이 올바르지 않습니다 ***\n");
				sc.nextLine();
				e.printStackTrace();
			}
			
		}while(input!=0);
		
	}


	/**
	 * 회원 목록 조회(아이디, 이름, 성별)
	 */
	private void selectMemberList() {
		System.out.println("\n====== 회원 목록 조회 =======\n");
		
		
		try {
			
			List<Member> memberList = service.selectMemberList();
			
			if(memberList.isEmpty()) {
				System.out.println("\n====== 조회 결과가 없습니다 =====\n");
				return;
			}
			
			
			for(int i=0; i<memberList.size(); i++) {
				System.out.printf("%d\t%s\t\t%s\t\t%s\n", i+1, memberList.get(i).getMemberId(),
						memberList.get(i).getMemberName(), memberList.get(i).getMemberGender());
			}
			
			
		}catch(Exception e) {
			System.out.println("\n***** 회원 목록 조회 중 예외 발생 *****\n");
			e.printStackTrace();
		}
		
	
	}


	/**
	 * 내 정보 조회
	 */
	private void selectMyInfo() {
		System.out.println("\n====== 내 정보 조회 ======\n");
		
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		System.out.println("회원 번호 : " +  Session.loginMember.getMemberNo());
		System.out.println("아이디 : " + Session.loginMember.getMemberId());
		System.out.println("이름 : " + Session.loginMember.getMemberName());
		
		System.out.println("성별 : " + (Session.loginMember.getMemberGender().equals("F") ? "여" : "남"));
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
		
	}
	
	
	

}
