package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2444 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=count; i++) {
			
			for(int j=count-1; j>=i; j--)
				System.out.print(" ");
			// 공백
			
			for(int j=1; j<=2*i-1; j++) 
				System.out.print("*");
			// 별
			
			System.out.println();
		}
		
		
		for(int i=count-1; i>0; i--) {
			
			for(int j=i; j<count; j++) {
				System.out.print(" ");
			}
			
			for(int j=i*2-1; j>0; j--)
				System.out.print("*");
			
			System.out.println();
		}
		
	}
}
