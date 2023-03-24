package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	
	
	 
	/** 재직중인 사원 전체 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmpInOffice() throws SQLException {
		
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectEmpInOffice(conn);
		
		close(conn);
		
		return empList;
	}




	/** 퇴직한 사원 전체 조회
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Emp> selectOutgoingEmp() throws SQLException {
		
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectOutgoingEmp(conn);
		
		close(conn);
		
		return empList;
	}




	/** 사번이 일치하는 사원 조회
	 * @param input
	 * @return emp
	 * @throws SQLException 
	 */
	public Emp selectEmpId(int input) throws SQLException {

		
		Connection conn = getConnection();
		
		Emp emp = dao.selectEmpId(conn, input);
		
		close(conn);
		
		return emp;
	}




	/** 사원 정보 추가
	 * @param emp
	 * @return result
	 * @throws SQLException 
	 */
	public int addEmp(Emp emp) throws SQLException {
		
		
		Connection conn = getConnection();
		
		
		int result = dao.addEmp(conn, emp);
		
		
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		close(conn);
		
		
		
		return result;
	}




	/** 사번으로 사원 정보 수정
	 * @param emp
	 * @return result
	 * @throws SQLException 
	 */
	public int updateEmp(Emp emp) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.updateEmp(conn, emp);
		
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		
		close(conn);
		
		
		return result;
	}




	/** 사번으로 사원 정보 삭제(DELETE)
	 * @param input
	 * @return result
	 * @throws SQLException 
	 */
	public int deleteEmp(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.deleteEmp(conn, input);
		
		
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		
		
		close(conn);
		
		
		return result;
	}




	/** 사번이 일치하는 사원 퇴직 처리
	 * @param input
	 * @return result
	 * @throws SQLException 
	 */
	public void retireEmp(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		dao.retireEmp(conn, input);
		
		commit(conn);
		
		close(conn);
		
	}




	/** 가장 최근 입사한 사원 5명 조회
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Emp> selectFiveLatestEntEmp() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Emp> empList = dao.selectFiveLatestEntEmp(conn);
		
		close(conn);
		
		return empList;
	}




	/** 부서별 통계 조회
	 * @return mapList
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> selectDeptStatistics() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Map<String, Object>> mapList = dao.selectDeptStatistics(conn);
		
		close(conn);
		
		return mapList;
	}




	/** 존재하는 사원인지, 퇴직한 사원인지 결과를 반환하는 서비스
	 * @param input
	 * @return check(0 : 없는 사원, 1: 퇴직한 사원, 2: 재직중인 사원)
	 * @throws SQLException
	 */
	public int checkEmployee(int input) throws SQLException {
		
		Connection conn = getConnection();
		
		int check = dao.checkEmployee(conn, input);
		
		close(conn);
		
		return check;
	}



}
