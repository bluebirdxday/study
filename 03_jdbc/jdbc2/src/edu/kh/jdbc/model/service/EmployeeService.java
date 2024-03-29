package edu.kh.jdbc.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// JDBCTemplate에 있는 static 메서드를 가져와 자신의 것처럼 사용
import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.dto.Employee;

// Model : 데이터 논리 구조 제어(트랜잭션 제어), 데이터 가공 처리
//		   -> 비즈니스 로직

//		   DATO 수행 결과를 View/ Controller로 반환
// -> 프로그램(앱)에 포함되어야 할 데이터에 대한 정의

// Service : 비즈니스 로직
// - 요청에 따른 필요 데이터를 반환 + 트랜잭션 제어 처리(Commit, Rollback)

public class EmployeeService {

	// dao에 여러 SQL을 수행하기 위한 메서드를 각각 작성하여 호출
	private EmployeeDAO dao = new EmployeeDAO();

	
	
	
	/** 전체 사원 정보 반환 서비스
	 * @return empList
	 * @throws SQLException 
	 */
	public List<Employee> selectAll() throws SQLException {
		
		// DB에서 필요한 데이터를 조회하기 위해 DAO 메서드를 호출

		
		// 1. 커넥션 생성
		//    -> Service가 트랜잭션 제어 처리를 위해서는 Connection 객체가 Service에 존재해야함
		//    -> 만약 DAO에서 Connection을 만들고 반환하면 Service 쪽에서 Connection을 사용할 수 없게 됨
		
		// --> 커넥션이 서비스에 있다
		//      -> 다 쓰고 닫아주는 close() 구문이 필요
		//      -> 서비스에 conn.close()를 작성해야함
		
		Connection conn = getConnection();
				
		
		// 2. DAO의 메서드를 호출하여 필요한 결과를 DB에서 조회해서 반환받기
		
		List<Employee> empList = dao.selectAll(conn);
		
		
		// ** DML 구문인 경우 해당 위치에 commit/rollback 구문 작성 **
		
		
		// 3. Connection 반환
		close(conn);    // JDBCTemplate 작성된 메서드 호출
		
		
		// 4. 결과 반환
		
		return empList;
	}




	/** 사원 1명 정보 조회
	 * @param input
	 * @return emp
	 * @throws SQLException 
	 */
	public Employee selectOne(int input) throws SQLException {
		
		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드를 호출(커넥션, input)
		Employee emp = dao.selectOne(conn, input);
		
		// 3. Connection 반환
		close(conn);
		
		
		// 4. 결과 반환
		return emp;
	}




	/** 이름에 글자가 포함된 사원 조회
	 * @param input 
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(String input) throws SQLException {

		
		Connection conn = getConnection();
		
		List<Employee> empList = dao.selectName(conn, input);
		
		conn.close();
		
		return empList;
	}




	/** 급여 범위로 조회
	 * @param input1
	 * @param input2
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAllSalary(int input1, int input2) throws SQLException {
		
		Connection conn = getConnection();
		
		List<Employee> empList = dao.selectAllSalary(conn, input1, input2);
		
		conn.close();
		
		return empList;
	}




	/** 사원 정보 삽입 서비스
	 * @param emp
	 * @return result
	 * @throws SQLException
	 */
	public int insertEmployee(Employee emp) throws SQLException{
		
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		int result = dao.insertEmployee(conn, emp);
		
		
		// 3. 트랜잭션 제어 처리
		// DAO에서 DML(INSERT) 수행
		// -> 트랜잭션에 임시 저장
		// -> 수행 결과에 따라서 commit, rollback 지정
		
		if(result > 0) 
			commit(conn);   // 삽입 성공 시
		else 
			rollback(conn);	// 삽입 실패 시
		
		
		
		// 4. 커넥션 반환
		close(conn);
		
		
		// 5. 결과 반환
		return result;
	}




	/** 회원 정보 수정 서비스
	 * @param emp
	 * @return result
	 */
	public int updateEmployee(Employee emp) throws SQLException{
		
		Connection conn = getConnection();
		
		int result = dao.updateEmployee(conn, emp);
		
		
		if(result > 0) 
			commit(conn);   // 삽입 성공 시
		else 
			rollback(conn);	// 삽입 실패 시
		
		
		close(conn);
		
		return result;
	}




	/** 사원 퇴사 처리 서비스
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int retireEmployee(int input) throws SQLException{

		Connection conn = getConnection();
		
		int result = dao.retireEemployee(conn, input);
		
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		
		close(conn);
		
		
		return result;
	}
	
	
	
}
