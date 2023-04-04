package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam11022 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		String[] arr = null;
		int[][] output = new int[count][2];
		
		for(int i=0; i<count; i++) {
			arr = br.readLine().split(" ");
			output[i][0] = Integer.parseInt(arr[0]);
			output[i][1] = Integer.parseInt(arr[1]);
		}
		
		for(int i=0; i<output.length; i++) {
				System.out.printf("Case #%d: %d + %d = %d\n", 
						i+1, output[i][0], output[i][1], output[i][0] + output[i][1]);
		}
	}
}
