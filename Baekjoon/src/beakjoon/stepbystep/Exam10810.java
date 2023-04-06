package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam10810 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int n = Integer.parseInt(arr[0]);  // 가지고 있는 바구니(바구니에는 공을 1개만 넣을 수 있음)
		int m = Integer.parseInt(arr[1]);  // 반복횟수
		
		int[] bucket = new int[n];  // 최종 바구니
		
		for(int z=0; z<m; z++){
			arr = br.readLine().split(" ");
			
			int i = Integer.parseInt(arr[0]);
			int j = Integer.parseInt(arr[1]);
			int k = Integer.parseInt(arr[2]);
			
			for(int o=i; o<j+1; o++) {
				bucket[o-1] = k;
			}
			
		}
		
		for(int o=0; o<bucket.length; o++)
			System.out.print(bucket[o] + " ");
	}
}
