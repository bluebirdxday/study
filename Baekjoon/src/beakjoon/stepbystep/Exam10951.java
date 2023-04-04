package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exam10951 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(true) {
			
			 st = new StringTokenizer(br.readLine());
			 
			 if(!st.hasMoreElements())
				 break;
			 
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());

			 arr.add(a+b);
		}
		
		for(Integer i : arr) {
			System.out.println(i);
		}
	}
}
