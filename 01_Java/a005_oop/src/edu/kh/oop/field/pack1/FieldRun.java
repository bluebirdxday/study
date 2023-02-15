package edu.kh.oop.field.pack1;

import edu.kh.oop.field.pack2.FieldTest2;
import edu.kh.oop.field.pack2.FieldTest3;

public class FieldRun extends FieldTest3{
	
	public static void main(String[] args) {
		
		// 클래스를 이용해서 객체(인스턴스) 생성
		
		// FieldTest1/2는 FieldRun과 같은 패키지
		// import 없이 사용 가능
		FieldTest1 f1 = new FieldTest1();
		FieldTest2 f2 = new FieldTest2();
		
		// FieldTest3는 다른 패키지에 존재
		// import가 필요하다!
		FieldTest3 f3 = new FieldTest3();
		
		// 접근제한자 확인
		System.out.println(f1.v1);
		System.out.println(f1.v2);
		System.out.println(f1.v3);
		// System.out.println(f1.v4);
		// The field FieldTest1.v4 is not visible
		// -> private는 다른 클래스에서 보이지 않음!
		
		
		System.out.println(f2.v1);
		// System.out.println(f2.v2);
		// 패키지가 다른 FieldTest2는
		// public만 접근 가능하고 나머지는 불가능
	}
	
	
	public void ex() {
		
		FieldTest3 t3 = new FieldTest3();
		System.out.println(t3.v1); // public 
//		System.out.println(t3.v2); // protected
		
		System.out.println(v2);
		
		// FieldRun이 FieldTest3를 상속받음
		// -> FieldTest3의 필드를 
		// FieldRun이 자신의 것처럼 사용 가능
	}
}
