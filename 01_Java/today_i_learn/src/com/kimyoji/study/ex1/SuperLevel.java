package com.kimyoji.study.ex1;

public class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("3km/h 속도로 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("30m 점프합니다");
	}

	@Override
	public void turn() {
		System.out.println("180도 턴합니다.");
	}

	@Override
	public void showMessage() {
		System.out.println("========최상위 레벨입니다=========");
	}

}
