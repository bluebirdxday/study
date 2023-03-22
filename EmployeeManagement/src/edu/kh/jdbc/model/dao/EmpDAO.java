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
	
	
	/** 재직중인 사원 전체 조회 SQL 수행 후 반환
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmpInOffice(Connection conn) throws SQLException {
		
		
		List<Emp> empList = new ArrayList<>();
		
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, NVL(PHONE, '없음') PHONE, EMAIL "
					+ "FROM EMPLOYEE "
					+ "JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE) "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "WHERE ENT_YN = 'N'"
					+ "ORDER BY JOB_CODE";
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				int salary = rs.getInt("SALARY");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
				
				empList.add(new Emp(salary, empName, email, phone, salary, deptTitle, jobName));
				
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
			
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(PHONE, '없음') PHONE, EMAIL, ENT_DATE "
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
				String date = rs.getDate("ENT_DATE").toString();
				
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


	
	public int retireEmp(Connection conn, int input) throws SQLException {
		
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE SET ENT_YN = 'Y' WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}


	
	
	/** 가장 최근 입사한 사원 5명 조회
	 * @param conn 
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Emp> selectFiveLatestEntEmp(Connection conn) throws SQLException {
		
		List<Emp> empList = new ArrayList<>();
		
		try {
			
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE "
					+ "FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE "
					+ "	  FROM EMPLOYEE "
					+ "	  JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) "
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


	
	
	public Map<String, Dept> selectDeptStatistics(Connection conn) throws SQLException {
		
		
		Map<String, Dept> deptLinkedHashMap = new LinkedHashMap<>();
		
		
		try {
			
			String sql = "SELECT DEPT_CODE, DEPT_TITLE, COUNT(EMP_ID) EMP_ID, TRUNC(AVG(SALARY)) SALARY "
					+ "FROM EMPLOYEE "
					+ "JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) "
					+ "GROUP BY DEPT_CODE, DEPT_TITLE "
					+ "ORDER BY DEPT_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				Dept dept = new Dept();
				
				dept.setDepartmentTitle(rs.getString("DEPT_TITLE"));
				dept.setCount(rs.getInt("EMP_ID"));
				dept.setAvgSalary(rs.getInt("SALARY"));
				
				deptLinkedHashMap.put(rs.getString("DEPT_CODE"), dept);
			}
			
			
		}finally {
			
			close(rs);
			close(stmt);
			
		}
		
		return deptLinkedHashMap;
	}


}
