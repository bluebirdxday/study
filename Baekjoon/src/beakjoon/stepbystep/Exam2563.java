package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class Exam2563 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];  // 흰색 도화지
		
		int area = 0;  // 넓이
		
		// 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이
		// 색종이 넓이 = 점들의 모임
		
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());		// 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
			int y = Integer.parseInt(st.nextToken());		// 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
			
			// x부터 x+10까지
			// y부터 y+10까지
			
			for(int j=x; j<x+10; j++) {
				for(int z=y; z<y+10; z++) {
					paper[j][z] = true; 
				}
			}
		}
		
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper[i].length; j++) {
				if(paper[i][j]==true)
					area++;
			}
		}
		
		System.out.println(area);
		
	}
}
