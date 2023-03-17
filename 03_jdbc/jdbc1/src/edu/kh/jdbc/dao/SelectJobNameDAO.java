package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {

	
	public List<Employee2> select(String input) {
	
		List<Employee2> empList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
//			String type = "jdbc:oracle:thin:@";
//			String ip = "localhost";
//			String port = ":1521";
//			String dbName = ":ORCL";
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "blu";
			String pw = "Nj09121007!";
			
			
			conn = DriverManager.getConnection(url, user, pw);
			
			stmt = conn.createStatement();
			
			String condition = null;
			
			if(input.toUpperCase().equals("NULL"))
				condition = "WHERE JOB_NAME IS NULL ";
			else
				condition = "WHERE JOB_NAME = " + "'" + input + "' ";
				
			
			String sql = "SELECT NVL(DEPT_TITLE, '부서없음') AS DEPT_TITLE, JOB_NAME, EMP_NAME, EMAIL "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ "JOIN JOB USING(JOB_CODE) "
					+ condition 
					+ "ORDER BY EMP_NAME ";

		
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
//				String deptTitle = rs.getString("DEPT_TITLE")==null? "부서없음" : rs.getString("DEPT_TITLE");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String empName = rs.getString("EMP_NAME");
				String email = rs.getString("EMAIL");
			
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);
				
				empList.add(emp);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			
				try {
					
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		}
		
		return empList;
		
	}
	
}
