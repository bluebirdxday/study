package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Dept;
import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	// SELECT : executeQuery()
	// DML : executeUpdate()
	// PreparedStatement -> ?(placeholder)사용 시 
	
	
	
	/** 재직중인 사원 전체 조회 SQL 수행 후 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmpInOffice(Connection conn) throws SQLException {
		
		
		List<Emp> empList = new ArrayList<>();
		
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, SALARY, NVL(PHONE, '없음') PHONE, EMAIL "
					+ "FROM EMPLOYEE "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ "WHERE ENT_YN = 'N'"
					+ "ORDER BY JOB_CODE";
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
				
				empList.add(new Emp(empId, empName, email, phone, salary, deptTitle, jobName));
				
			}
			
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		
		return empList;
	}


	/** 퇴직한 사원 전체 조회 SQL 수행 후 반환
	 * @param conn
	 * @return emp
	 * @throws SQLException
	 */
	public List<Emp> selectOutgoingEmp(Connection conn) throws SQLException {
		
		
		List<Emp> empList = new ArrayList<>();
		
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(PHONE, '없음') PHONE, EMAIL, "
					+ "TO_CHAR(ENT_DATE, 'YYYY\"년\" MM\"월\" DD\"일\"') ENT_DATE "
					+ "FROM EMPLOYEE "
					+ "WHERE ENT_YN = 'Y' "
					+ "ORDER BY ENT_DATE";
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String date = rs.getString("ENT_DATE");
				
				empList.add(new Emp(empId, empName, phone, email, date));
			}
			
			
			
		}finally {
			
			close(rs);
			close(stmt);
		}
		
		return empList;
	}


	/** 사번이 일치하는 사원 조회 SQL 수행 후 반환
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException 
	 */
	public Emp selectEmpId(Connection conn, int input) throws SQLException {
		
		
		Emp emp = null;
		
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, HIRE_DATE, ENT_YN "
					+ "FROM EMPLOYEE "
					+ "JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "WHERE EMP_ID = ?";
		
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);

			rs = pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				
				
				
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				Date hireDate = rs.getDate("HIRE_DATE");
				String entYN = rs.getString("ENT_YN");
				
				
				emp = new Emp();

				
				emp.setEmpId(empId);
				emp.setEmpName(empName);
				emp.setDepartmentTitle(deptTitle);
				emp.setJobName(jobName);
				emp.setSalary(salary);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setHireDate(hireDate);
				emp.setEntYN(entYN);
			}

			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return emp;
	}


	
	/** 사원 정보 추가 SQL 수행 후 반환
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException 
	 */
	public int addEmp(Connection conn, Emp emp) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO EMPLOYEE "
					+ "VALUES(SEQ_EMP_ID.NEXTVAL, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			
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
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}


	
	
	/** 사번으로 사원 정보 수정
	 * @param conn
	 * @param emp
	 * @return result
	 * @throws SQLException 
	 */
	public int updateEmp(Connection conn, Emp emp) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE "
					+ "SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ?"
					+ "WHERE EMP_ID = ?";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			
			
			result = pstmt.executeUpdate();
						
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	/** 사번으로 사원 정보 삭제(DELETE) SQL 수행 후 반환
	 * @param conn
	 * @param input
	 * @return result
	 * @throws SQLException 
	 */
	public int deleteEmp(Connection conn, int input) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}


	
	public void retireEmp(Connection conn, int input) throws SQLException {
		
		
		try {
			
			String sql = "UPDATE EMPLOYEE SET ENT_YN = 'Y',"
					+ "ENT_DATE = SYSDATE WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
	}


	
	
	/** 가장 최근 입사한 사원 5명 조회
	 * @param conn 
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Emp> selectFiveLatestEntEmp(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, HIRE_DATE "
					+ "FROM (SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, HIRE_DATE "
					+ "	  FROM EMPLOYEE "
					+ "	  LEFT JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) "
					+ "	  ORDER BY HIRE_DATE DESC) "
					+ "WHERE ROWNUM <= 5";
			
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Emp emp = new Emp();
				
				emp.setEmpId(rs.getInt("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setDepartmentTitle(rs.getString("DEPT_TITLE"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				
				empList.add(emp);
			}
			
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return empList;
	}


	
	
	/** 부서별 통계 조회 SQL 수행 후 결과 반환
	 * @param conn
	 * @return mapList
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectDeptStatistics(Connection conn) throws SQLException {
		
		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		
		try {
			
			// 2. SQL 작성 후 수행
			String sql = "SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균 "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) "
					+ "GROUP BY DEPT_CODE, DEPT_TITLE "
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String deptTitle = rs.getString("DEPT_TITLE");
				int count = rs.getInt("인원");
				int salaryAvg = rs.getInt("평균");
				
				Map<String, Object> map = new LinkedHashMap<>();  // 입력 순서가 유지되는 Map
				
				map.put("deptTitle", deptTitle);
				map.put("count", count);
				map.put("avg", salaryAvg);
				
				mapList.add(map);
				
			}
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		// 5. 결과 반환
		return mapList;
	}


	
	/** 존재하는 사원인지, 퇴직한 사원인지 조회하는 SQL 수행 후 결과 반환
	 * @param conn
	 * @param input
	 * @return check
	 * @throws SQLException
	 */
	public int checkEmployee(Connection conn, int input) throws SQLException{

		int check = 0;
		
		try {
			
			String sql = "SELECT CASE "
					+ "	WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = ?) = 0 "
					+ "	THEN 0 "
					+ "	WHEN (SELECT COUNT(*) FROM EMPLOYEE "
					+ "		  WHERE EMP_ID = ? AND ENT_YN = 'Y') = 1 "
					+ "	THEN 1 "
					+ "	ELSE 2 "
					+ "	END \"CHECK\" "
					+ "FROM DUAL";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			pstmt.setInt(2, input);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check = rs.getInt("CHECK");
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return check;
	}


}
