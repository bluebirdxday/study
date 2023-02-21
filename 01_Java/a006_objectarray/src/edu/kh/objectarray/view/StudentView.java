package edu.kh.objectarray.view;

import java.util.Scanner;

import edu.kh.objectarray.dto.Student;
import edu.kh.objectarray.service.StudentService;

public class StudentView {
	
	// 필드
	private Scanner sc = new Scanner(System.in);
	
	// 여기서만 사용할 수 있는 StudentService클래스를 참조하는 새 service 변수 선언(생성자 사용)
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			System.out.println("----- [학생 관리 프로그램] -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 조회(인덱스)");
			System.out.println("4. 학생 정보 조회(이름)");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 총점 합계, 평균, 최고점, 최저점 조회");
			System.out.println("0. 종료");
			System.out.println("--------------------------------");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			
			System.out.println();
			
			switch(input) {
			case 1 : addStudent(); break;
			case 2 : selectAll(); break;
			case 3 : selectIndex(); break;
			case 4 : selectName(); break;
			case 5 : updateStudent(); break;
			case 6 : sumAvgMaxMin(); break;
			case 0 : System.out.println("[프로그램이 종료됩니다.]");break;
			default : System.out.println("[잘못 입력 하셨습니다.]");
			}
			
			
			System.out.println();
			
			
		}while(input != 0);
		
	}

	/** 1. 학생 정보 추가*/
	private void addStudent() {
		
		System.out.println("[학생 추가]");
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classRoom = sc.nextInt();
		System.out.print("번호 : ");
		int number = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		
		// 학생 추가 서비스 호출
		boolean result = service.addStudent(grade, classRoom, number, name);
		
		if(result) { // true인 경우 == 학생 추가 성공
			System.out.println(name + " 학생이 추가되었습니다.");
		}else { // false인 경우 == 학생 추가 실패
			System.out.println("더 이상 학생을 추가할 수 없습니다.");
			
		}
	}

	/** 2. 학생 전체 조회 */
	private void selectAll() {
		
		System.out.println("[학생 전체 조회]");
		
		// service가 참조하는 객체의 필드 중 studentArr를 반환 받아
		// 각 배열 요소를 화면에 출력
		
		//*************************************************
		// 매개변수, 반환 값으로 참조변수가 사용될 경우
		// 참조하고 있는 주소가 복사된다 --> 얕은 복사
		//*************************************************
		
		Student[] studentList = service.selectAll();  // 주소를 전달받아 얕은 복사 이루어짐
		
		for(int i=0; i<studentList.length; i++) {
			
			if(studentList[i] == null) {				
				break;
			}

			System.out.println(studentList[i].toString());
		}
		
		// NullPointerException
		// -> 참조하고 있는 객체가 없는
		//    참조변수를 이용해서
		//    필드/메서드를 호출할 때 발생하는 에러(예외)
		
		// 해결 방법 : 참조변수가 null인지 여부를 먼저 검사
	}
	
	
	/** 3. 학생 정보 조회(인덱스) */
	private void selectIndex() {
		
		System.out.println("[학생 정보 조회(인덱스)]");
		
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		
		// index에 해당하는 배열요소를 얻어와서 저장
		Student student = service.selectIndex(index);
		
		// 반환받은 index번째 요소가 null이 아닐 경우(학생 정보가 있을 경우)
		// NullPointerException 방지 처리
		if(student != null) {
			System.out.println(student.toString());
		}else {
			System.out.println("해당 인덱스에 학생 정보가 존재하지 않습니다.");
		}

	}

	/* 4. 학생 정보 조회(이름) */
	private void selectName() {
		System.out.println("[4. 학생 정보 조회(이름)]");
		
		System.out.print("조회할 학생의 이름 : ");
		String inputName = sc.next();
		
		// 학생 정보 조회(이름)서비스 호출
		Student[] resultList = service.selectName(inputName);
		
		if(resultList != null) {
			
			for(Student s : resultList) {
				
				if(s==null) break;
				
				System.out.println(s.toString());
			}
			
		}else {
			
			System.out.println("학생 정보가 존재하지 않습니다.");
		}
	}

	/* 5. 학생 정보 수정(인덱스) */
	private void updateStudent() {
		
		System.out.println("[학생 정보 수정(인덱스)]");
		
		System.out.print("인덱스 : ");
		int index = sc.nextInt();
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		// 입력 받은 index번째 학생의 점수를 수정하는 서비스 호출
		// - 수정 성공 시 true / 아니면 false
		
		boolean result = service.updateStudent(index, kor, eng, math);
		
		// 수정 결과에 따라 출력 구문 제어하기
		if(result) 
			System.out.println("수정되었습니다.");
		else
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
	}

	/* 6. 학생 총점 점수 합계, 평균, 최고점, 최저점 */
	
	private void sumAvgMaxMin() {
		
		System.out.println("[점수 합계, 평균, 최고점, 최저점]");
		
		int[] arr = service.sumAvgMaxMin();
		
		// 0번 인덱스 : 합계
		// 1번 인덱스 : 평균
		// 2번 인덱스 : 최고점
		// 3번 인덱스 : 최저점
		
		System.out.println("합계 :  " +  arr[0]);
		System.out.println("평균 :  " +  arr[1]);
		System.out.println("최고점 :  " +  arr[2]);
		System.out.println("최저점 :  " +  arr[3]);
	}
	

}