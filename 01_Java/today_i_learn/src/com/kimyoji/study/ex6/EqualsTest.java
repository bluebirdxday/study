package com.kimyoji.study.ex6;

class Student{
	
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	
	@Override
	public String toString() {
		return studentId + ", " + studentName;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student st = (Student)obj;
			
			if(this.studentId == st.studentId)
				return true;
			else return false;
		}
		return false;
	}


	@Override
	public int hashCode() {
		return studentId;
	}
	
}

public class EqualsTest{
	
	public static void main(String[] args) {
		
		Student s1 = new Student(100, "홍길동");
		Student s2 = new Student(101, "아무개");
		
		System.out.println("홍길동의 hashCode : " + s1.hashCode());
		System.out.println("아무개의 hashCode : " + s2.hashCode());
		
		System.out.println("홍길동의 실제 주소값 : " + System.identityHashCode(s1));
		System.out.println("홍길동의 실제 주소값 : " + System.identityHashCode(s2));
	}
	
}
