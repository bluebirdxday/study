
/* 1.
 * EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
 * 단, 입사일-오늘의 별칭은 "근무일수1",
 * 오늘-입사일의 별칭은 "근무일수2"로 하고
 * 모두 정수(내림)처리, 양수가 되도록 처리
 */
SELECT EMP_NAME, 
FLOOR(ABS(HIRE_DATE-SYSDATE)) "근무일수1", 
FLOOR(SYSDATE-HIRE_DATE) "근무일수2"
FROM EMPLOYEE;


/* 2.
 * EMPLOYEE 테이블에서 사번이 홀수인 사원의
 * 사번, 이름, 이메일, 전화번호 조회 
 */
SELECT EMP_ID, EMP_NAME, EMAIL, PHONE
FROM EMPLOYEE
WHERE MOD(EMP_ID, 2)=1;
-- WHERE SUBSTR(EMP_ID, -1, 1) IN (1,3,5,7,9); 이런 방법도 존재함


/* 3.
 * EMPLOYEE 테이블에서 근무한지 20년 이상인 사원의 모든 정보 조회
 */
SELECT *
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) >= 20;
-- WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20;


/* 4. 
 * EMPLOYEE 테이블에서 사원명과 주민번호를 조회
 * 단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
 * 예 : 홍길동 771120-1******
 */
SELECT EMP_NAME, 
       SUBSTR(EMP_NO, 1, 8) || '******' 주민등록번호
       -- REPLACE(EMP_NO, SUBSTR(EMP_NO, 9),'******') 주민등록번호
       -- RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민등록번호  -> RPAD : 오른쪽을 채워라 
FROM EMPLOYEE;


/* 5.
 * EMPLOYEE 테이블에서 사원명, 직급코드, 연봉(원) 조회
 * 단, 연봉은 보너스가 적용된 1년치 급여 + ₩57,000,000 으로 표시
 * (급여 + (급여 * 보너스) )* 12
 */
SELECT EMP_NAME, JOB_CODE, 
TO_CHAR((SALARY + SALARY*NVL(BONUS, 0))*12, 'L999,999,999') "연봉(원)"
FROM EMPLOYEE;



/* 6.
 * EMPLOYEE 테이블에서
 * 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 사원의
 * 사번 사원명 부서코드 입사일 조회
 */
SELECT EMP_ID, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D9') 
AND EXTRACT(YEAR FROM HIRE_DATE) = 2004;
-- AND TO_CHAR(HIRE_DATE, 'YYYY') = '2004'; 이런 방법도 존재 


/* 7. 
 * EMPLOYEE 테이블에서 사원명, 입사일, 입사한 달의 근무일수 조회
 * 단, 입사한 날도 근무일수에 포함해서 +1 할 것
 */
SELECT EMP_NAME, HIRE_DATE, 
LAST_DAY(HIRE_DATE)-HIRE_DATE+1 "입사한 달의 근무 일수"
FROM EMPLOYEE;


/* 8.
 * EMPLOYEE 테이블에서 사원명, 부서코드, 생년월일, 만 나이 조회
 * 단, 생년월일은 주민번호에서 추출해서 ᄋᄋ년 ᄋᄋ월 ᄋᄋ일로 출력되게 함.
 * 나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산.
 */
SELECT EMP_NAME, DEPT_CODE,
TO_CHAR(TO_DATE(SUBSTR(EMP_NO, 1, 6)), 'YY"년" MM"월" DD"일"') 생년월일, 
TRUNC(MONTHS_BETWEEN(SYSDATE, TO_DATE(SUBSTR(EMP_NO, 1, 6) , 'RRMMDD'))/12) "만 나이"
FROM EMPLOYEE;


-------------------------------------------------------------------------------

-- <선택 함수>
-- 여러 가지 경우에 따라 알맞은 결과를 선택하는 함수
-- (if, switch문과 비슷)

-- DECODE(계산식 | 컬럼명, 조건1, 결과1, 조건2, 결과2... [, 아무것도 일치 안할 때])

-- 비교하는 식 또는 컬럼의 값이 일치하는 조건이 있으면 해당 조건의 결과를 반환
-- 만약 일치하는 경우가 없으면 제일 끝 값을 반환
-- 자바의 switch문과 유사함

-- EMPLOYEE테이블에서 모든 사원 사번, 이름, 성별 조회하기
SELECT EMP_ID, EMP_NAME,
	DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') 성별
FROM EMPLOYEE;


-- EMPLOYEE 테이블에서
-- 직급코드가 'J7'인 직원은 급여 + 급여의 10%
-- 직급코드가 'J6'인 직원은 급여 + 급여의 15%
-- 직급코드가 'J5'인 직원은 급여 + 급여의 20%
-- 나머지 직급코드의 직원은 급여 + 급여의 5% 지급
-- 사원명, 직급코드, 급여, 지급급여를 조회

SELECT EMP_NAME, JOB_CODE, SALARY 기존급여,
	DECODE(JOB_CODE, 
	'J7', SALARY + (SALARY*0.1), 
	'J6', SALARY * 1.15,
	'J5', SALARY * 1.2,
	SALARY * 1.05
	) 지급급여
FROM EMPLOYEE;

---------------------------------------------------------------

-- CASE   
--	  WHEN 조건1 THEN 결과 1
--	  WHEN 조건2 THEN 결과 2
--	  WHEN 조건3 THEN 결과 3
-- END

-- DECODE는 계산식|컬럼 값이 딱 떨어지는 경우에만 사용 가능.
-- CASE는 계산식|컬럼 값을 범위로 지정할 수 있다.

-- 성별 CASE 버전
SELECT EMP_ID, EMP_NAME,
-- DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') 성별
	CASE 
		WHEN SUBSTR(EMP_NO, 8, 1) = '1' THEN '남자'
		WHEN SUBSTR(EMP_NO, 8, 1) = '2' THEN '여자'
	END 성별
FROM EMPLOYEE;


-- EMPLOYEE 테이블에서 사번, 이름, 급여, 구분을 조회
-- 구분은 받는 급여에 따라 초급, 중급, 고급으로 조회
-- 급여 500만 이상 = '고급'
-- 급여 300만 이상 ~ 500만 미만 = '중급'
-- 급여 300만 미만 = '초급'

-- 단, 부서코드가 D6인 사원만 직급코드 오름차순으로 조회

SELECT EMP_ID, EMP_NAME, SALARY,
	CASE
		WHEN SALARY >= 5000000 THEN '고급'
		WHEN SALARY >= 3000000 THEN '중급'
		ELSE '초급'
	END 구분
	
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
ORDER BY JOB_CODE /*ASC*/;


/********************************** 그룹 함수 **********************************/

-- SUM(숫자가 기록된 컬럼명) : 합계
-- 모든 사원의 급여 합
SELECT SUM(SALARY) FROM EMPLOYEE;

-- 부서 코드가 'D9'인 사원들의 급여 합
SELECT SUM(SALARY) 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- AVG(숫자가 기록된 컬럼명) : 평균
-- 모든 사원의 급여 평균 조회
SELECT ROUND( AVG(SALARY), 1 ) FROM EMPLOYEE;

-- 모든 사원의 급여 합과 평균 조회
SELECT SUM(SALARY) 합계, ROUND(AVG(SALARY), 1) 평균 
FROM EMPLOYEE;
-->  그룹 함수 여러 개를 동시 작성 가능


-- MAX(컬럼명) : 해당 컬럼의 최대값
-- MIN(컬럼명) : 해당 컬럼의 최소값
-- 타입 제한 X (숫자 : 대/소, 문자열 : 문자 순서, 날짜 : 과거 < 미래)

SELECT MIN(SALARY), MAX(SALARY),
	MIN(EMP_NAME), MAX(EMP_NAME)
	MIN(HIRE_DATE), MAX(HIRE_DATE) 
FROM EMPLOYEE;


-- COUNT(* | 컬럼명) : 조회된 행의 개수를 반환
-- COUNT(*) : NULL을 포함한 모든 행의 개수를 반환
-- COUNT(컬럼명) : 지정된 컬럼의 값이 NULL인 경우를 제외한 행의 개수를 반환
-- COUNT(DISTINCT 컬럼명) 
-- : 지정된 컬럼에서 중복된 값을 제외한 행의 개수를 반환


-- EMPLOYEE 테이블에 존재하는 모든 사원의 수
SELECT COUNT(*) FROM EMPLOYEE;  -- 23


-- EMPLOYEE 테이블에서 부서코드가 있는 사원의 수
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE;  -- 21(NULL 제외)

SELECT COUNT(*) FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL; -- 이렇게도 가능하다

-- EMPLOYEE 테이블에 존재하는 직급코드의 개수
SELECT COUNT(DISTINCT JOB_CODE) FROM EMPLOYEE;  -- 7(중복 제외하고 카운트)


-- EMPLOYEE 테이블의 남자 사원 수 조회
SELECT COUNT(*) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1' ;

-- EMPLOYEE 테이블의 여자 사원 수 조회
SELECT COUNT(*) FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' ;


-- EMPLOYEE 테이블의 남자 사원 수, 여자 사원 수 조회
SELECT COUNT(DECODE(SUBSTR(EMP_NO, 8, 1), '1', 1, NULL)) "남자 사원 수",
	   COUNT(DECODE(SUBSTR(EMP_NO, 8, 1), '2', 1, NULL)) "여자 사원 수"
FROM EMPLOYEE;


SELECT SUM(DECODE(SUBSTR(EMP_NO, 8, 1), '1', 1, NULL)) "남자 사원 수",
	   SUM(DECODE(SUBSTR(EMP_NO, 8, 1), '2', 1, NULL)) "여자 사원 수"
FROM EMPLOYEE;


-- * 서브쿼리를 이용하는 방법 *
SELECT 
	(SELECT COUNT(*) FROM EMPLOYEE WHERE SUBSTR(EMP_NO, 8, 1) = '1') "남자 사원 수",
	(SELECT COUNT(*) FROM EMPLOYEE WHERE SUBSTR(EMP_NO, 8, 1) = '2') "여자 사원 수"
FROM DUAL;


