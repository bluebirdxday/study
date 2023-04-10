package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11720 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum=0;
		
		for(int i=0; i<n; i++) {
			sum += str.charAt(i) - '0';  // char형->int형  : char형 변수 - '0'; 
		}
		
		System.out.println(sum);
	}
}
