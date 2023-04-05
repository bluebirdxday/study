package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1번째줄 공백 4, 별 1
// 2번째줄 공백 3, 별 2

// 1~5줄까지 공백 4~0까지, 별1~5개

public class Exam2439 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=1; i<count+1; i++) {
			
			for(int j=count; j>i; j--)
				System.out.print(" ");
			
			for(int z=0; z<i; z++)
				System.out.print("*");
			System.out.println();
		}
	}
}
