package a01_Test;

public class Subject {
	
	protected String subjectName;
	protected int score;
	
	public Subject(String subjectName, int score) {
		this.subjectName = subjectName;
		this.score = score;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


}
