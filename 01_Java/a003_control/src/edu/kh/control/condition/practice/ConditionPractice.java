package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		String result;
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		num = sc.nextInt();
		
		if(num<0) {
			result = "양수만 입력해주세요.";
		}else if(num>0 && num%2==0) {
			result = "짝수입니다.";
		}else {
			result = "홀수입니다.";
		}
		
		System.out.println(result);
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		int korean;
		int english;
		int math;
		int sum;
		double average;
		
		System.out.print("국어점수 : ");
		korean = sc.nextInt();
		
		System.out.print("수학점수 : ");
		math = sc.nextInt();
		
		System.out.print("영어점수 : ");
		english = sc.nextInt();
		
		sum = korean + math + english;
		average = sum / 3.0;
		
		if(korean>=40 && math>=40 && english>=40 && average>=60) {
			System.out.println("축하합니다, 합격입니다!");
		}else {
			System.out.println("불합격입니다.");
		}
		
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		int month;
		int day = 0;
		
		System.out.println("1~12 사이의 정수 입력 : ");
		month = sc.nextInt();
		
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 :
			day = 31;
			break;
		case 2 :
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			day = 30;
		}
		
		if(month>=1 && month<=12) {
			System.out.printf("%d월은 %d일까지 있습니다.", month, day);
		}else {
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}
	}

	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		double height;
		double weight;
		double bmi;
		String result;
		
		System.out.print("키(m)를 입력해주세요 : ");
		height = sc.nextDouble();
		
		System.out.println("몸무게(kg)을 입력해주세요 : ");
		weight = sc.nextDouble();
		
		bmi = weight / (height * height);
		
		if(bmi<18.5) {
			result = "저체중";
		}else if(bmi<23) {
			result = "정상체중";
		}else if(bmi<25) {
			result = "과체중";
		}else if(bmi<30) {
			result = "비만";
		}else {
			result = "고도 비만";
		}
		
		System.out.println(result);
		
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		int mid;
		int last;
		int test;
		int atd;
		double midScore;
		double lastScore;
		double testScore;
		double totalScore;
		
		String passOrFail = "";
		
		System.out.print("중간 고사 점수 : ");
		mid = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		last = sc.nextInt();
		
		System.out.print("과제  점수 : ");
		test = sc.nextInt();
		
		System.out.print("출석 횟수 : ");
		atd = sc.nextInt();
		
	
		midScore = mid * 0.2;
		lastScore = last * 0.3;
		testScore = test * 0.3;
		
		totalScore = midScore + lastScore + testScore + atd;
		
		
		System.out.println("================== 결과 ==================");
		
		if(atd < 20*0.7){
			passOrFail = "Fail";
			System.out.printf("%s 출석횟수 부족(%d/20) ", passOrFail,  atd);
		}else {
		
			System.out.println("중간 고사 점수(20) : " + midScore);
			System.out.println("기말 고사 점수(30) : " + lastScore);
			System.out.println("과제 점수     (30) : " + testScore);
			System.out.println("출석 점수     (20) : " + (double)atd);
			System.out.println("총점 : " + totalScore);
	

			if(totalScore<70){ 
				passOrFail = "Fail";
				System.out.printf("%s [점수 미달]", passOrFail);
			}else {
				passOrFail = "Pass";
				System.out.println(passOrFail);
			}
			
		}
	
	}
	
	

}
