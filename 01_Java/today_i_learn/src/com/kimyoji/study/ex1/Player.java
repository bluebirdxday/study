package com.kimyoji.study.ex1;

public class Player {
	
	private PlayerLevel level;
	
	public Player() {
		level = new BeginnerLevel();
		level.showMessage();
	}

	public PlayerLevel getLevel() {
		return level;
	}

	public void upGradeLevel(PlayerLevel level) {
		this.level = level;
		level.showMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
}
