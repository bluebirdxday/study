package edu.kh.exception.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {

	public void ex1() throws IOException {
		// 해당 메서드 내에서
		// 호출한 곳으로 던짐
		
		// 예외 확인하기
		
		// 키보드(System.in) 입력을 효율적으로 읽어오는 객체
		// Scanner보다 기능은 부족하지만 속도는 빠름
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		String input = br.readLine();
		// readLine() : 한 줄 읽어오기 (엔터까지)
		// 빨간줄이 뜨는 이유 ->
		// readLine() 메서드는 IOException이라고 하는 예외를 발생시킬(던질) 가능성이 있기 때문에
		// 그 상황에 대한 대비책(예외처리)을 하라고 경고하는 것
		
		System.out.println("입력 값 : " + input);

	}
	
	public void ex2() {
		// 예외 : 코드 수정으로 해결 가능한 에러
		// 예외 처리 : 예외를 처리할 수 있는 구문
		
		// [예외 처리 1] try ~ catch ~ finally
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// try : { } 내부에 예외가 발생할 것 같은 코드를 작성하고 실행 시도
		try {
			System.out.print("입력 : ");
			String input = br.readLine();
			// public String readLine() throws IOException
			// IOException이라는 Checked Exception을 발생 시키는 메서드
			// -> Exception이 발생할 경우에 재비해서 예외처리 구문 작성(강제)

			/* 예외 강제 발생 */
			// -> 예외 객체를 새로 만들어서 던짐
			throw new IOException();
			
		} catch (IOException e) {
			// catch : try 구문 내에서 던져진 예외가 있을 경우
			// 해당 예외 객체를 잡아채서 catch 구문을 수행해 처리
			
			// catch의 매개변수에는 던져진 예외 객체를 저장할 수 있는 참조 변수를 작성
			System.out.println("키보드 문제로 입력을 진행할 수 없습니다");
			// 발생된 예외가 처리된 후 프로그램이 종료되지 않고 다음 코드가 수행됨
		}
		
		System.out.println("try-catch 수행되도 프로그램이 종료되지 않음");
		
	}
	
	public void ex3() {
		// 입력 받은 두 정수 나누기
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d / %d = %d \n", num1, num2, num1/num2);
			
		}catch(ArithmeticException e) {
			// 산술적 예외를 잡아 처리
			System.out.println("0으로 나눌 수 없습니다");
		}catch(/*InputMismatch*/Exception e) {
			//** catch문 여러개 작성 가능 **
			
			//** 다형성 적용 가능(업캐스팅) **
			// -> 상위 타입 예외를 매개변수로 작성하면 하위 타입의 예외를 모두 처리할 수 있다
			
			// !!! 주의사항 !!!
			// 상위 타입을 처리하는 catch문을 하위 타입을 처리하는 catch문 보다
			// 먼저 작성하면 오류 발생
			// 해결 방법 : 상위 타입 catch를 뒤쪽에 배치해서 하위 타입 catch에 대한 검사가 먼저 진행되게 함
			
			// 스캐너 사용 시 작성법이 잘못되거나 범위를 초과하면 발생하는 예외
			System.out.println("입력이 잘못되었습니다");
		}
		
		finally {
			// finally : 
			// try-catch 구문이 끝난 후 마지막으로 수행
			// ** 예외가 발생되든 말든 무조건 실행 **
			System.out.println("프로그램 종료");
		}
	}
}
