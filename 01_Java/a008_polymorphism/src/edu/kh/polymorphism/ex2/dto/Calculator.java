package edu.kh.polymorphism.ex2.dto;

// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드, 기능명 제공

public interface Calculator {

	public static final double PI = 3.14;
	final int MAX_NUM = 100_000_000; // 1억
	int MIN_NUM = -100_000_000; // -1억
	
	
	// alt + shift + j 
	// 주석 자동완성
	/**
	 * @param a
	 * @param b
	 * @return a와 b의 합
	 */

	public abstract int plus(int a, int b);
	
	/** 
	 * @param a
	 * @param b
	 * @return a와 b의 빼기
	 */
	int minus(int a, int b);
	
	
	/**
	 * @param a
	 * @param b
	 * @return a에서 b의 곱
	 */
	int multiple(int a, int b);
	

	/**
	 * @param a
	 * @param b
	 * @return a에서 b를 나눈 몫
	 */
	int devide(int a, int b);
	
	
	/** 나누기 소수점까지 연산
	 * @param a
	 * @param b
	 * @return 실수값
	 */
	double devide2(int a, int b);
	

	
	/**
	 * @param r
	 * @return 원의 넓이
	 */
	double areaOfCircle(double r);
	
	
	/** a의 x 거듭 제곱(a^x)
	 * @param a
	 * @param x
	 * @return (a^x)
	 */
	int square(int a, int x);
}
