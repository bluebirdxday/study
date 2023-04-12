package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam3003 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] chess = { 1,1,2,2,2,8 };
		
		for(int i=0; i<chess.length; i++) {
			sb.append(chess[i] - Integer.parseInt(st.nextToken()));
			sb.append(" ");
		}
		
		System.out.println(sb);
		br.close();
		
		
		
	}
}
