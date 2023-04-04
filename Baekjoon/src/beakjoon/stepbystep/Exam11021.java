package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int count = Integer.parseInt(br.readLine());
		int[] answer = new int[count];
		
		for(int i=0; i<count; i++) {
			String[] arr = br.readLine().split(" ");
			
			answer[i] = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.printf("Case #%d: %d\n", i+1, answer[i]);
		}
	}
}
