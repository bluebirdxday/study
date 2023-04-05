package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam10807 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sameNum = 0;
		
		int count = Integer.parseInt(br.readLine());
		
		String[] arr = br.readLine().split(" ");
		
		int findNum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			if(Integer.parseInt(arr[i])==findNum)
				sameNum++;
		}
		
		System.out.println(sameNum);
	}
}
