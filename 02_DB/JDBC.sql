SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, NVL(PHONE, '없음') PHONE, EMAIL
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN JOB USING(JOB_CODE)
WHERE ENT_YN = 'N'
ORDER BY JOB_CODE;


SELECT EMP_ID, EMP_NAME, NVL(PHONE, '없음') PHONE, EMAIL, ENT_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
ORDER BY ENT_DATE;



SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, HIRE_DATE, ENT_YN
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID = 200;


UPDATE EMPLOYEE 
SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ?;


SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE
	  FROM EMPLOYEE
	  JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE)
	  ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;


SELECT DEPT_TITLE, COUNT(EMP_ID) EMP_ID, TRUNC(AVG(SALARY)) SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY DEPT_CODE;


-- 입력 받은 사번의 사원이 존재하지 않으면 0
-- 사원은 있는데 퇴직처리된 사원이면 1
-- 사원도 있고 재직중인 사원이면 2 조회

SELECT CASE
	-- 존재하지 않는 사원?
	WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200) = 0
	THEN 0
	-- 존재하지만 퇴직한 사원?
	WHEN (SELECT COUNT(*) FROM EMPLOYEE 
		  WHERE EMP_ID = 200 AND ENT_YN = 'Y') = 1
	THEN 1
	-- 존재는 하지만 퇴직하지 않은 사원!
	ELSE 2
	END "CHECK" -- CASE문에 별칭 붙임
FROM DUAL;











