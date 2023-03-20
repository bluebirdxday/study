package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.dto.Employee;

// DAO (Data Access Object) : DB 접근용 객체
public class EmployeeDAO {

	
	// JDBC 구문이 여러 번 작성될 예정
	// -> JDBC 객체 참조 변수가 계속 작성될 예정 -> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;

	
	/** 전체 사원 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {

		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
		
			
			// 1) SQL 작성
			
			// 사번, 이름, 부서명, 직급명, 전화번호
			// 직급코드 오름차순
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "ORDER BY JOB_CODE";
					
					
			stmt = conn.createStatement();  // Statement 객체 생성
			rs = stmt.executeQuery(sql);
			
			
			// 3. 조회 결과 1행씩 접근하여 컬럼값을 얻어와 List에 담기
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				
				empList.add(new Employee(Integer.parseInt(empId), empName, deptTitle, jobName, phone));
			}
			
			
			
		}finally {
			
			// catch문 -> thorws 구문으로 예외처리
			
			// 4. JDBC 객체 자원 반환 (단, conn 뻬고)
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


	
	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return emp
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException{

		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성

		
		
		try {


			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "WHERE EMP_ID = " + input;
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3. 조회 결과가 있는지 확인 후 == 1행 조회 성공
			//    있으면 Employee 객체 생성 후 emp 대입
			
			
			if(rs.next()) {
			// 1행 조회에서는 while문보다 if문 권장
				
				// DB에서 값을 얻어올 때 "숫자"(문자열로 된 숫자) 형태일 경우
				// getInt()를 작성하면 자동으로 int 형변환 진행
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				
				emp = new Employee(empId, empName, deptTitle, jobName, phone);
			}
			
			
		}finally {
			// 4. JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
			
		}
		
		// 5. 결과 반환
		return emp;
	}



	/** 글자 포함 이름 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		
		try {

			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "WHERE EMP_NAME LIKE '%"  + input + "%' "
					+ "ORDER BY EMP_ID";
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				String phone = rs.getString("PHONE");
				
				empList.add(new Employee(empId, empName, deptTitle, jobName, phone));
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}

		
		return empList;
	}



	/** 급여 범위로 조회 SQL 수행 후 결과 반환 메서드
	 *  사번, 이름, 직급명, 급여 조회
		급여 내림차순
	 * @param conn
	 * @param input1
	 * @param input2
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Employee> selectAllSalary(Connection conn, int input1, int input2) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(JOB_NAME, '없음') JOB_NAME, SALARY "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "WHERE SALARY BETWEEN " + input1
					+ "AND " + input2
					+ " ORDER BY SALARY DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				empList.add(new Employee(empId, empName, jobName, salary));
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}
	
}
