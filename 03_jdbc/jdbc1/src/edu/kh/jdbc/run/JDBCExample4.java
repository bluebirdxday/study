package edu.kh.jdbc.run;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명을 입력하세요 : ");
		String input = sc.nextLine();
		
		SelectJobNameDAO dao = new SelectJobNameDAO();
		List<Employee2> empList = dao.select(input);
		
		if(empList.isEmpty()) {
			System.out.println("검색 결과 없음");
			return;
		}
		
	
		for(Employee2 emp : empList) {
			System.out.println(emp);
		}
		
		
	}
}
