package a01_Test;

import java.util.ArrayList;

public class Student {

	private String studentName;
	private int studentId;
	
	ArrayList<Subject> arraylist;
	
	public Student() {
		this.studentName = "아무개";
		this.studentId = 0;
	}
	
	public Student(String studentName, int studentId) {
		this.studentId = studentId;
		this.studentName = studentName;
		
		arraylist = new ArrayList<Subject>();
	}
	
}
