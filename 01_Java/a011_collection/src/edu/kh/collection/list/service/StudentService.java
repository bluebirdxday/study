package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {

	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {

		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 중구", 'M', 75));
		studentList.add(new Student("이철수", 2, 4, 32, "서울시 서대문구", 'M', 60));
		studentList.add(new Student("문숙히", 4, 1, 26, "경기도 안산시", 'F', 92));
		studentList.add(new Student("김민지", 3, 3, 30, "경기도 수원시", 'F', 85));
		studentList.add(new Student("이현주", 2, 4, 5, "서울시 강남구", 'F', 78));
	}
	
	
	/** StudentList에 학생 추가
	 * @param std
	 * @return true
	 */
	public boolean addStudent(Student std) {
		return studentList.add(std);
	}
	
	
	
	/** 학생 전체 조회 서비스
	 * @return studentList
	 */
	public List<Student> selectAll() {
		return studentList;
	}
	
	
	/** 학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s : Student(수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		// e2 set(int index, E e) : 
		// 1) index에 위치하는 요소를 e로 변경     2) 기존에 있던 요소 e2를 반환
		return studentList.set(index, std);  // 기존에 있던 요소를 호출한 곳으로 돌려보냄 (변경 전 학생 정보)
	}


	/** 학생 정보 제거 서비스
	 * @param index
	 * @return s : Student (제거된 학생 정보)
	 */
	public Student removeStudent(int index) {
		
		// E remove(int index) : index번째 요소를 List에서 제거하여 반환
		
		// boolean remove(E e) : List에서 E와 일치하는 요소를 찾아서 있으면 제거하고 true / 없으면 false 반환
		// equals() 메서드 오버라이딩 필수
		return studentList.remove(index);
	}


	public Student searchStudentName(String name) {

	
		
		return null;
	}


	/** 학생 이름 검색 서비스
	    * @param name
	    * @return list:List<Student> 이름이 일치하는 학생 리스트
	    */
	   public List<Student> selectName(String name) {
	      
	      // 1) 검색 결과를 저장할 List<Student> 생성
	      List<Student> list = new ArrayList<Student>();
	      
	      // 2) studentList의 모든 요소를 순차 접근하면서 이름이 일치하는 학생을 
	      //    list에서 추가
	      
	      for(Student s : studentList) {
	         if( s.getName().equals(name) ) list.add(s);
	      }
	      
	      // 3) 검색 결과 반환
	      return list;
	   }

	   /** 학생 주소 검색 서비스
	    * @param input
	    * @return list:List<Student> 검색어가 주소에 포함된 학생 리스트
	    */
	   public List<Student> selectAddress(String input) {
	      
	      List<Student> list = new ArrayList<Student>();
	      
	      for(Student s : studentList) {
	         // String.contains("문자열") : String에 "문자열"이 포함되어 있으면 true 반환
	         if( s.getAddress().contains(input) ) list.add(s);
	      }
	      
	      
	      return list;
	   }


	/** 학년별 검색
	 * @param input
	 * @return list : List<Student> 학년이 일치하는 학생 리스트
	 */
	public List<Student> selectGrade(int input) {
		
		List<Student> list = new ArrayList<>();
		// 제네릭의 타입 추론
		// 생성되는 컬렉션 객체의 제네릭을 별도 작성하지 않아도
		// 참조 변수의 제네릭을 통해 제한되는 타입을 유추(추론)
		
		for(Student s : studentList) {
			if(s.getClassRoom()==input) list.add(s);
		}
		
		return list;
	}


	/** 성별 조회 서비스
	 * @param input
	 * @return list : List<Student> input과 성별이 동일한 학생 리스트
	 */
	public List<Student> selectGender(char input) {
		
		List<Student> list = new ArrayList<>();
		
		
		for(Student s : studentList) {
			if(s.getGender()==input) list.add(s);
		}
	
		
		return list;
	}


	/**
	 * 성적 순서 조회 서비스
	 * @return studentList
	 */
	public List<Student> sortScore() {
		
		// studentList 정렬 (score 내림차순)
		// Collections 클래스 : 컬렉션에 도움되는 유용한 기능을 모은 클래스
		
		// Comparable<T> 인터페이스
		// -> 객체의 기본 정렬 기준을 제공하는 인터페이스
		
		// <?> : 어떤 게 작성될지 모름 == 아무거나 작성 가능
		// <?> void java.util.Collections.sort(List<?> list)
		
		Collections.sort(studentList);
		// studentList에 저장된 객체 Student의 오버라이딩된 compareTo 메서드를 이용해서 정렬
		// -> 현재 큰 숫자가 오른쪽으로 이동하도록 오버라이딩됨
		// -> 오름차순 정렬
		
		// void java.util.Collections.reverse(List<?> list)
		// -> list 순서를 반대로 뒤집음
		// -> 오름차순 > 내림차순
		// Collections.reverse(studentList);
		
		return studentList;
		
//		studentList.stream().map(c->c.getScore()).sorted().forEach(s->System.out.println(s));
	}
	
	
	

	
}
