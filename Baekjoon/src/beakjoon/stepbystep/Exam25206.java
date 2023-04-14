package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exam25206 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
		float[] score = {4.5f, 4.0f, 3.5f, 3.0f, 2.5f, 2.0f, 1.5f, 1.0f, 0.0f};
		
		float majorSum = 0;  // 전공과목별 (학점*과목평점)의 합
		float scoreSum = 0;  // 학점의 총합
		
		
		for(int i=0; i<20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			st.nextToken();
			float s = Float.parseFloat(st.nextToken());
			String g = st.nextToken();
			
			if(!g.equals("P")) {
				majorSum += s * score[Arrays.binarySearch(grade, g)];
				scoreSum += s;
			}
		}
		
		float average = majorSum/scoreSum;
		System.out.printf("%.6f", average);
			
	}

}
