package com.kimyoji.study.ex1;

public class MainBoard {

	public static void main(String[] args) {
		
		Player player = new Player();
		
		player.play(1);
		
		AdvancedLevel aLevel = new AdvancedLevel();
		player.upGradeLevel(aLevel);
		player.play(2);
		
		SuperLevel sLevel = new SuperLevel();
		player.upGradeLevel(sLevel);
		player.play(3);
	}

}
