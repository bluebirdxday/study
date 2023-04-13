package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Exam4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int studentNum = Integer.parseInt(st.nextToken());
			int sum=0;
			int stuOverAvg=0;
			double average=0;
			
			int[] score = new int[studentNum];
			
			for(int j=0; j<studentNum; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			
			average = (double)sum/studentNum;
			
			
			for(int j=0; j<score.length; j++) {
				if((double)score[j]>average) {
					stuOverAvg++;
				}
			}
			
			bw.append(String.format("%2.3f", (double)stuOverAvg/studentNum*100) + "%\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
