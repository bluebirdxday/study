package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee1;

// DAO (Data Access Object) : 데이터에 접근하기 위한 객체
// == DB 연결 역할 객체
public class SelectDepartmentTitleDAO {
	
	
	
	/** 부서명으로 사원 조회
	 * @param departmentTitle
	 * @return empList
	 */
	public List<Employee1> select(String departmentTitle) {
		
		
		//조회 결과를 저장하고 반환할 때 사용할 List를 생성
		List<Employee1> empList = new ArrayList<>();
		
		Connection conn = null;  // DB 연결 정보 저장. Statement 통로
		Statement stmt = null;   // SQL 수행, 결과 반환
		ResultSet rs = null;     // SELECT 수행 결과 저장용 객체
		

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost";
			String port = ":1521";
			String dbName = ":ORCL";
			String user = "blu";
			String pw = "Nj09121007!";
			
			
			
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw);
													// URL

			
			String condition = null;
			
			if(departmentTitle.toLowerCase().equals("null")) 
				condition = "WHERE DEPT_TITLE IS NULL ";
			else
				condition = "WHERE DEPT_TITLE = " + "'" + departmentTitle + "'";
			
			
			// 부서명을 입력 받아 해당 부서에 존재하는 사원의 사번, 이름, 급여, 부서명을
			// 사번 오름차순으로 조회
			String sql = "SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ condition 
//					+ "WHERE DEPT_TITLE = " + "'" + departmentTitle + "'"    // 홑따옴표 주의!!!!!
					+ " ORDER BY EMP_ID";

			
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
			
				
//				String empId = rs.getString("EMP_ID");
				String empId = rs.getString(1);	 				// 조회 결과 컬럼 순서			
				String empName = rs.getString(2);
				int salary = rs.getInt(3);
				String deptTitle = rs.getString(4);
				
				
				// 조회된 컬럼 값을 Employee1 객체에 저장
				Employee1 emp = new Employee1(empId, empName, salary, deptTitle);
				
				// 컬럼 값이 저장된 객체를 empList에 추가
				empList.add(emp);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			
			
			// JDBC 객체 자원 반환
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
