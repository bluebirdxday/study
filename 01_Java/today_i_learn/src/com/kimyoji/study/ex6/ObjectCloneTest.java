package com.kimyoji.study.ex6;

class Point{
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
}

class Circle implements Cloneable{
	
	Point point;
	int radius;
	
	Circle(int x, int y, int radius){
		this.radius = radius;
		point = new Point(x, y);
	}
	
	public String toString() {
		return "원점은 " + point + "이고, 반지름은 " + radius;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}



public class ObjectCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Circle c1 = new Circle(3, 4, 5);
		Circle c2 = (Circle)c1.clone();
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(System.identityHashCode(c1));
		System.out.println(System.identityHashCode(c2));
	}
}
