package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam1546 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	 	double max = 1.0;
	 	double sum = 0;
	 	
	 	int n = Integer.parseInt(st.nextToken());
	 	double[] score = new double[n];
	 	
	 	st = new StringTokenizer(br.readLine(), " ");
	 	
	 	for(int i=0; i<n; i++) 
	 		score[i] = Integer.parseInt(st.nextToken());
	 	
	 	for(int i=0; i<n; i++) {
	 		if(max<score[i])
	 			max = score[i];
	 	}
	 	
	 	
	 	for(int i=0; i<n; i++) {
	 		score[i] = score[i]/max*100;
	 		sum += score[i];
	 	}
	 	
	 	System.out.println(sum/n);
	 	
	}
}
