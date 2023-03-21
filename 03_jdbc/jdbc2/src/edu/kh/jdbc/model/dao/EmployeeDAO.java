package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	
	private PreparedStatement pstmt;
	// -> 외부 변수(값)를 SQL에 삽입할 준비가 된 Statement
	
	
	// PreparedStatement는 Statement 클래스의 자식 클래스로 SQL 구문에 ? 기호를 작성해서 
	// SQL에 작성되어지는 리터럴 값을 동적으로 제어하는 기능을 가짐
	
	// ( ? 기호 = placeholder )
	
	
	
	
	
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
			
//			String sql = "SELECT EMP_ID, EMP_NAME, NVL(JOB_NAME, '없음') JOB_NAME, SALARY "
//					+ "FROM EMPLOYEE "
//					+ "JOIN JOB USING(JOB_CODE) "
//					+ "WHERE SALARY BETWEEN " + input1
//					+ "AND " + input2
//					+ " ORDER BY SALARY DESC";
//			
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
			
			
			// -----------------------------------------------------------------------------------------
			
			// ** PreparedStatement 사용하기 **
			
			// SQL 작성
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(JOB_NAME, '없음') JOB_NAME, SALARY "
			+ "FROM EMPLOYEE "
			+ "JOIN JOB USING(JOB_CODE) "
			+ "WHERE SALARY BETWEEN ? AND ? "
			+ "ORDER BY SALARY DESC";
			// -> 값이 동적으로 추가되는 부분을 ?기호(placeholder)로 작성
			
			
			// SQL을 수행하고 결과를 반환 받을 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// PreparedStatement에 추가된 SQL 구문에서 미완성된 (?)<- 부분에 알맞은 값을 추가
		    
			// pstmt.set자료형(순서, 값)
			// -> 순서번째 ?에 값을 세팅
			//    (자료형은 값에 맞게 지정)
			
			pstmt.setInt(1, input1);
			pstmt.setInt(2, input2);
			
			
			// 준비가 완료된 PreparedStatement를 이용해 SQL 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			// PreparedStatement 객체 생성 시 SQL이 담겨져 있기 때문에 
			// SQL 수행 구문에서 따로 매개변수를 작성하지 않음
			
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				
				// Employee 객체를 생성해서 컬럼 값을 세팅
				// (기본 생성자 + setter)
				// empList.add(new Employee(empId, empName, jobName, salary));  
				// -> 이런 것보다 보통 기본생성자 + setter 방식이 많이 쓰임!!!!!!!!!!!!!
				
				Employee emp = new Employee();
				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				
				empList.add(emp);
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}



	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Employee emp) throws SQLException{
		
		// ** DML 수행 시 영향을 끼친 행의 개수가 반환됨
		// (삽입된 행의 개수, 수정된 행의 개수, 삭제된 행의 개수)
		// -> 행의 개수 == 숫자(정수) == int 사용
		
		// 1. 결과를 저장할 변수/객체 선언
		int result = 0;
		
		
		try {
			
			// 2. PreparedStatment 객체 생성
			
			// 1) SQL 작성
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
			
			// 2. PreparedStatement 객체 생성 후 placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			
			// 3. SQL 수행 후 결과 반환 받기
			// executeQuery() : SELECT 수행 후 ResultSet 반환
			// executeUpdate() : DML 수행 후 결과 행의 개수 반환
			result = pstmt.executeUpdate();
			
			// ** SELECT와 다르게 옮겨 담는 과정이 없음!! **
			
			
		}finally {
			
			// 4. JDBC 객체 자원 반환
			close(pstmt);
			// -> Statement를 close() 하는 메서드 호출
			//    (매개변수에 다형성 업캐스팅 적용)
			
		}
		
		
		// 5. 결과 반환
		return result;
	}



	/** 사원 정보를 수정하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn 
	 * @param emp
	 * @return result
	 * @throws SQLException 
	 */
	public int updateEmployee(Connection conn, Employee emp) throws SQLException {
		
		
		int result = 0;
		
		
		try {
			
			String sql = "UPDATE EMPLOYEE "
					+ "SET EMAIL = ?, PHONE = ?, SALARY = ? "
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			
			// set자료형()으로 ?에 값을 세팅할 때
			// 자료형에 맞는 DB 리터럴 표기법으로 변환돼서 세팅됨
			
			// setString()  -> 'hong_gd@naver.com'
			// setInt()     -> 1200000
			// setDouble()  -> 0.2
			// setDate(순서, java.sql.Date)  -> DB DATE 타입 (잘 안씀)
			pstmt.setString(1, emp.getEmail()); 
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
		    pstmt.setInt(4, emp.getEmpId());
			
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
		}
		
		
		return result;
	}



	/** 사원 퇴사 처리 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEemployee(Connection conn, int input) throws SQLException {

		int result = 0;
		
		
		try {
			
			String sql = "UPDATE EMPLOYEE SET ENT_YN = 'Y', ENT_DATE = SYSDATE "
					+ "WHERE EMP_ID = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			
			result = pstmt.executeUpdate();
			
			
		}finally{
			
			close(pstmt);
		}
		
		
		return result;
	}
	
}
