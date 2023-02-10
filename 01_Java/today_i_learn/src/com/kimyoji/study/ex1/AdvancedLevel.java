package com.kimyoji.study.ex1;

public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("1km/h 속도로 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("10m 점프합니다.");
	}

	@Override
	public void turn() {
		System.out.println("턴 불가능");
	}

	@Override
	public void showMessage() {
		System.out.println("========중급자 레벨입니다=========");
	}

}
