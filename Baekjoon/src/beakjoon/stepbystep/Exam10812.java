package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] bucket = new int[n+1];
		int[] output = new int[n+1];
		
		
		for(int i=1; i<bucket.length; i++)
			bucket[i] = i;
		
		for(int num=0; num<m; num++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for(int z=i, zz=k; z<=j; z++) {
				// k부터 j까지 돌고 i부터 k까지
				
				output[z] = bucket[zz];
				
				if(zz==j)
					zz = i;
				else
					zz++;
				
			}
			
			for(int z=i; z<=j; z++)
				bucket[z] = output[z];
		}
		
		for(int i=1; i<bucket.length; i++)
			System.out.print(bucket[i] + " ");
		
	}
}
