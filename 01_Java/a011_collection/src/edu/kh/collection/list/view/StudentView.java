package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.list.dto.Student;
import edu.kh.collection.list.service.StudentService;

public class StudentView {

	
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n--- 학생 관리 프로그램 ---\n");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 제거");
				System.out.println("5. 학생 이름 검색");
				System.out.println("6. 학생 주소 검색");
				System.out.println("7. 학년별로 조회");
				System.out.println("8. 성별 조회");
				System.out.println("9. 성적 순서 조회");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.println();
				System.out.print("메뉴 선택 >> ");

				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch(input) {
				case 1 : addStudent(); break;
				case 2 : selectAll(); break;
				case 3 : updateStudent(); break;
				case 4 : removeStudent(); break;
				case 5 : selectName(); break;
				case 6 : selectAddress(); break;
				case 7 : selectGrade(); break;
				case 8 : selectGender(); break;
				case 9 : sortScore(); break;
				case 0 : System.out.println("[프로그램 종료]"); break;
				default : System.out.println("[잘못 입력하셨습니다]");
				
				}
				
			}catch(InputMismatchException e){
				System.out.println("[잘못된 형식의 입력입니다]");
				sc.nextLine(); // 입력 버퍼에 잘못 입력된 내용을 제거
				input = -1; // 반복문이 종료되는 것을 방지
			}
			
			System.out.println();
			
		}while(input!=0);
	}
	
	
	
	/**
	 * 학생 추가하기
	 */
	private void addStudent() {
		System.out.println("\n--- 학생 정보 추가---\n");
		
		Student std = inputStudent();
		
		if(service.addStudent(std)) {
			System.out.println("학생 정보가 추가되었습니다.");
		
		}
		
	}
	
	
	/**
	 * 전체 학생 조회
	 */
	private void selectAll() {
		
		System.out.println("\n--- 전체 학생 조회 ---\n");
		
		List<Student> list = service.selectAll();
		
		// 향상된 for문
		for(Student s : list) {
			System.out.println(s);
		}
	}
	
	
	/**
	 * 학생 정보 수정
	 */
	private void updateStudent() {
		System.out.println("\n--- 학생 정보 수정 ---\n");
		
		System.out.println("<수정할 학생 정보 입력>");
		
		
		Student std = inputStudent();
		
		System.out.println("------------------------------------");
		System.out.print("수정할 학생의 index : ");
		int index = sc.nextInt();
		
		Student s = service.updateStudent(index, std);
		// s == 수정되기 전 학생 정보
		
		System.out.println(s.getName() + "의 정보가 수정되었습니다");
	}
	
	
	/** 학생 전체 정보를 입력 받아 Student 객체로 반환하는 메서드
	 * @return std : Student
	 */
	private Student inputStudent() {
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		System.out.print("반 : ");
		int classRoom = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0);
		// String.toUpperCase() : 모두 대문자로 변경
		// String.toLowerCase() : 모두 소문자로 변경
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		Student std = new Student(name, grade, classRoom, number, address, gender, score);
		// 매개변수는 최대 4개까지 쓰는 것이 좋음
		
		return std;
	}
	
	
	/**
	 * 학생 정보 제거
	 */
	private void removeStudent() {
		System.out.println("\n--- 학생 정보 제거 ---\n");
		System.out.print("삭제할 학생의 인덱스 입력 : ");
		
		int index = sc.nextInt();
		
		// 제거되기 전 학생 정보가 반환됨
		Student s = service.removeStudent(index);
		
		System.out.println(s.getName() + "학생 정보가 제거되었습니다");
	}
	
	
	private void searchStudentName() {
		System.out.println("\n--- 학생 이름 검색 ---\n");
		System.out.print("검색할 학생의 이름 입력 : ");
		
		String name = sc.nextLine();
		
		Student s = service.searchStudentName(name);
	}
	
	
	  private void selectName() {
	      System.out.println("\n--- 학생 이름 검색 ---\n");
	      System.out.print("검색할 학생 이름 : ");
	      String name = sc.nextLine();
	      
	      List<Student> list = service.selectName(name);
	      // 이름 검색하려면 동명이인 때문에 자식 ArrayList보다는 부모인 List(컬렉션) 타입을 참조하는게 좋음
	      
	      // 만약 검색 결과가 없을 경우
	      // list.size() : 리스트에 저장된 객체의 수
//	      if( list.size() == 0 ) {//1 저장된 객체의 수가 0개인 경우
//	         System.out.println("검색 결과 없습니다");
//	      }
	      if( list.isEmpty() ) {//2 .isEmpty : 리스트에 저장된 객체가 없을 경우 반환 값은 true
	         System.out.println("[검색 결과가 없습니다.]");
	      }else {
	         for(Student s : list) System.out.println(s);
	      }
	   }
	   
	   /**
	    * 학생 주소 검색
	    */
	   private void selectAddress() {
	      System.out.println("\n--- 학생 주소 검색 ---\n");
	      System.out.print("주소에 포함된 단어 입력 : ");
	      String input = sc.nextLine();
	      
	      List<Student> list = service.selectAddress(input); // input전달.
	      
	      if (list.isEmpty()) {
	         System.out.println("[검색 결과가 없습니다.]");
	      }else {
	          // 3학년 5반 2번 홍길동 / 주소 : 서울시 중구
	          for(Student s : list) {
	             System.out.printf("%d학년 %d반 %d번 %s / 주소 : %s \n",
	                   s.getGrade(), s.getClassRoom(), s.getNumber(), s.getName(),
	                   s.getAddress(), s.getAddress());
	          }
	      }
	      
	   }

	
	/** 
	 * 학년별 조회
	 */
	private void selectGrade() {
		   System.out.println("\n--- 학년별 조회 ---\n ");
		   
		   System.out.print("조회할 학년을 입력하세요 : ");
		   int input = sc.nextInt();
		   
		   List<Student> list = service.selectGrade(input);
		   
		   if(list.isEmpty()) {
			   System.out.printf("[%d학년 학생이 존재하지 않습니다.]\n", input);
		   }else {
			   
			   for(Student s : list) System.out.println(s);
		   }
	   }
	
	
	/**
	 * 성별 조회
	 */
	private void selectGender() {
		System.out.println("\n--- 성별 조회 ---\n");
		
		char input;
		char gender;
		
		while(true) {
		
			System.out.print("조회할 성별을 입력하세요(M/F) : ");
			input = sc.nextLine().toUpperCase().charAt(0);
			
			if(input=='M' || input=='F') {
				gender = input=='M' ? '남' : '여';
				break;
			}
			
			System.out.println("[M 또는 F만 입력해주세요]");
		}
		
		
		List<Student> list = service.selectGender(input);
		
		if(list.isEmpty())
			System.out.println("[검색 결과가 없습니다.]");
		else {
			
			System.out.printf("[%c학생 목록]\n", gender);
			
			for(Student s : list) {
				System.out.printf("%d학년 %d반 %d번 %s(%c)\n", 
						s.getGrade(), s.getClassRoom(), s.getNumber(), s.getName(), s.getGender());
			}

		}
			
	}
	
	
	/**
	 * 성적 순서 조회
	 */
	private void sortScore() {
		System.out.println("\n--- 성적 순서 조회 ---\n");
		
		// 성적 순서로 정렬
		List<Student> list = service.sortScore();
		
		for(Student s : list) {
			System.out.println(s);
		}
		
		
	}
	
}
