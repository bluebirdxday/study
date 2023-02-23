package com.kimyoji.study.genericex;

import java.util.HashMap;

public class CarFactory {

	private static CarFactory instance = new CarFactory();
	HashMap<String, Car> hashMap = new HashMap<>();
	
	public CarFactory() {}
	
	public static CarFactory getInstance() {
		if(instance == null) {
			instance = new CarFactory();
		}
		return instance;
	}
	

	public Car createCar(String name) {
		
		if(hashMap.containsKey(name)) {
			return hashMap.get(name);
		}
		
		Car car = new Car();
		hashMap.put(name, car);
		return car;
	}
	
}
