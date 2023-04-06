package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam5597 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = 0;
		int[] student = new int[30];
		int[] nonSubmit = new int[2];
		
		int count = 0;

		
		for(int i=0; i<28; i++) {
			a = Integer.parseInt(br.readLine());
			student[a-1] = a;
		}
		
		for(int i=0; i<student.length; i++) {
			if(student[i]==0) {
				nonSubmit[count] = i+1;
				count++;
			}
		}
		
		if(nonSubmit[0] > nonSubmit[1]) {
			System.out.println(nonSubmit[1]);
			System.out.println(nonSubmit[0]);
		}
		
	}
}
