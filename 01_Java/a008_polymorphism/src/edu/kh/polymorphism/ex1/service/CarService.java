package edu.kh.polymorphism.ex1.service;

import java.util.Scanner;

import edu.kh.polymorphism.ex1.dtot.Car;
import edu.kh.polymorphism.ex1.dtot.LightCar;
import edu.kh.polymorphism.ex1.dtot.Truck;

public class CarService {
	
	// 다형성 : 객체가 다양한 형태를 지님
	
	// - 상속을 이용한 기술로
	// 부모타입의 참조 변수 하나로 여러 타입의 자식 객체를 참조할 수 있다.
	
	public void ex1() {
		
		// 부모 참조 변수 = 부모 객체
		Car c1 = new Car();
		
		// 업캐스팅
		// 부모 참조 변수 = 자식 객체
		Car c2 = new Truck();
		
		// 부모 참조 변수 = 자식 객체
		Car c3 = new LightCar();
	
		// Truck 객체가 Car로부터 상속 받은 메서드
		c2.setWheel(10);
		c2.setSeat(3);
		c2.setFuel("경유");
		
		// c2의 자료형이 Car -> Truck 객체를 참조하더라도 Car 부분만 볼 수 있음!
		
		// c2.setWeight(2.5); // c2로 접근 불가능하여 에러
	}
	
	public void ex2() {
		/* 업캐스팅 : 자식 객체 -> 부모 객체로 변함 */
		/* 다운 캐스팅 : 부모 객체 -> 자식 객체로 변함 */
		
		// 부모 참조 변수 = 자식 객체
		Car c1 = new LightCar();
		
		// LightCar로 c1을 강제 형변환
		// -> c1이 LightCar 객체를 모두 참조 가능
		// == 다운 캐스팅
		((LightCar)c1).print();

		
		((LightCar)c1).setDiscountOffer(0.7);
		System.out.println(((LightCar)c1).getDiscountOffer());
		
		// 다운 캐스팅 + 얕은 복사(주소만 복사)
		
		LightCar light1 = (LightCar)c1;
		
		light1.print();
		

	}
	
	public void ex3() {
		// 다형성(업캐스팅, 다운캐스팅) + 객체 배열
		
		
		// Car 1차원 배열 == Car 참조변수의 묶음
		Car[] carList = new Car[3];
		
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3);
		carList[2] = new Car(4, 2, "전기");
		
		// 향상된 for문
		for(Car car : carList) {
			System.out.println("바퀴 수 : " + car.getWheel());
			System.out.println("좌석 수 : " + car.getSeat());
			System.out.println("연료 형식 : " + car.getFuel());
			
			// Truck일 경우
			if(car instanceof Truck) {
				Truck truck = (Truck)car;
				System.out.println("최대 적재 하중 : " + truck.getWeight() + "t");
				
			}else if(car instanceof LightCar) {
				LightCar lightCar = (LightCar)car;
				System.out.println("할인율 : " + lightCar.getDiscountOffer() + "%");
				
			}else 
				System.out.println("차종이 등록되어있지 않습니다.");
			
			System.out.println("================================================");

			
			// 참조변수명 instanceof 클래스명
			// -> 참조변수가 참조하는 객체 타입과 클래스의 타입이 일치하면 true 아니면 false
			
			
			// 만약 다운 캐스팅이 잘못될 경우
			// ClassCastException이 발생함
			// ex) LightCar 객체를 Truck 참조변수가 참조하려고 할 때
			
			// 해결 방법 :
			// instanceof를 통해 참조하는 객체의 자료형을 판단하여 적절한 다운 캐스팅 진행
		}
	}
	
	public void ex4() {
		// 객체 배열 + 다형성(업캐스팅) + 매개변수 다형성 + 바인딩(정적/동적)
		
		Car[] carList = new Car[3];
		
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3);
		carList[2] = new Car(4, 2, "전기");
		
		for(Car c : carList) {
			printCar(c);
		}
		
	}
	
	public void printCar(Car c) {
		
		String type = null;
		
		if(c instanceof Truck) type = "[Truck]";
		else if(c instanceof LightCar) type = "[LightCar]";
		else type = "[Car]";
		
		
		System.out.printf("%s에 대한 정보입니다.\n", type);
		System.out.println(c.toString());
		
		// 바인딩 : 메서드 호출 구문과 수행될 메서드를 연결하는 것 (묶는 것)
		
		// 정적 바인딩 : 
		// - "프로그램 실행 전" 컴파일 단계에서 메서드 호출부와 수행될 메서드를 묶는 것
		// - 참조 변수의 자료형을 기준으로 연결함
		
		// 동적 바인딩 
		// - "프로그램 실행 중" 실행할 당시의 객체의 자료형을 기준으로 메서드 호출부와 수행될 메서드를 묶는 것
		// - 참조하는 객체의 자료형을 기준으로 연결함
	}
	
	
	public void ex5() {
		// 반환형의 다양성
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생성할 자동차 종류를 선택하세요 : ");
		System.out.println("1. 트럭");
		System.out.println("2. 경차");
		System.out.println("3. 자동차");
		
		Car c = createCar(sc.nextInt());
		
		System.out.println("차가 생성되었습니다.");
	}
	
	public Car createCar(int num) {
		
		switch(num) {
		case 1 : return new Truck();
		case 2 : return new LightCar();
		case 3: return new Car();
		}
		
		return null;
	}
}
