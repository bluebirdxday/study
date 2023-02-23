package edu.kh.polymorphism.ex2.dto;

public class NewCalculator2 implements Calculator, KH{

	@Override
	public int plus(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;
	}

	@Override
	public int multiple(int a, int b) {
		return a*b;
	}

	@Override
	public int devide(int a, int b) {
		return a/b;
	}

	@Override
	public double devide2(int a, int b) {
		return (double)a/b;
	}

	@Override
	public double areaOfCircle(double r) {
		// return Calculator.PI * r * r; // 정확한 표기법
		return r*r*PI; // 상속받은 PI를 자식이 자기 것처럼 사용
	}
 
	
	// 재귀 호출
	@Override
	public int square(int a, int x) {

		if(x==1)
			return a;
		
		return a * square(a, x-1);
	}

	
	@Override
	public void lesson() {
		// TODO Auto-generated method stub
		
	}

}
