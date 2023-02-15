package com.kimyoji.study.ex6;


class MyDate{
	
	int day;
	int month;
	int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate d = (MyDate)obj;
			if(this.day == d.day && this.month == d.month &&
					this.year == d.year) 
				return true;
			else 
				return false;
		}
		return false;
	}


	@Override
	public int hashCode() {
		return day * 10 + month * 101 + year * 102;
	}
}

public class MyDateTest {
	public static void main(String[] args) {
		
		MyDate date1 = new MyDate(9, 18, 2004);
		MyDate date2 = new MyDate(9, 18, 2004);

		System.out.println(date1.equals(date2));
		System.out.println("date1의 해시코드 : " + date1.hashCode());
		System.out.println("date2의 해시코드 : " + date2.hashCode());
	
		System.out.println("date1의 실제 주소값 : " + System.identityHashCode(date1));
		System.out.println("date2의 실제 주소값 : " + System.identityHashCode(date2));
	}
}
