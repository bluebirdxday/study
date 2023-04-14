package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam2738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr1 = new int[n][m];
		int[][] arr2 = new int[n][m];
		
		for(int i=0; i<arr1.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<arr1[i].length; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<arr2.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for(int j=0; j<arr2[i].length; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
				
				bw.append(Integer.toString(arr1[i][j] + arr2[i][j])).append(" ");
			}
			
			bw.append("\n");
		}
	
		
		bw.flush();
		bw.close();
		br.close();
	
	}
}
