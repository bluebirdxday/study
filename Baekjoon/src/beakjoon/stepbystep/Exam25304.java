package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exam25304 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int kind = Integer.parseInt(br.readLine());
		String[] arr = null;
		
		int sum = 0;
		
		for(int i=0; i<kind; i++) {
			arr = br.readLine().split(" ");
			sum += Integer.parseInt(arr[0])* Integer.parseInt(arr[1]);
		}
		
		if(sum==total)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
}
