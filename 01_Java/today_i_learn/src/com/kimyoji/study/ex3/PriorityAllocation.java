package com.kimyoji.study.ex3;

public class PriorityAllocation implements Scheduler{

	@Override
	public void getNextCall() {
		System.out.println("고객 등급이 높은 고객의 전화를 먼저 가져옵니다.");
	}

	@Override
	public void sendCallAgent() {
		System.out.println("업무 skill이 높은 상담원에게 먼저 배분합니다.");
	}

}
