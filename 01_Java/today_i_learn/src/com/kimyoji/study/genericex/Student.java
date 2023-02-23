package com.kimyoji.study.genericex;

public class Student {

	private String studentId;
	private String studentName;
	
	public Student(String studentId, String studentName) {

		this.studentId = studentId;
		this.studentName = studentName;
	}
	

	@Override
	public int hashCode() {
		return Integer.parseInt(studentId);
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s = (Student)obj;
			if(s.studentId == this.studentId)
				return true;
			else
				return false;
		}
		return false;
	}

	
	@Override
	public String toString() {
		return studentId + ":" + studentName;
	}
	
}
