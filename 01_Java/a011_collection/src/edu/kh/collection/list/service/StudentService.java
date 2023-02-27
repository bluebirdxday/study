package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


	@Override
	public int hashCode() {
		return Objects.hash(studentList);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentService other = (StudentService) obj;
		return Objects.equals(studentList, other.studentList);
	}
	
	
	
	
}
