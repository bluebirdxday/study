package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam10813 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());   // 바구니 총 개수
		int m = Integer.parseInt(st.nextToken());  // 교환 (반복)횟수
		
		int[] output = new int[n];
		int temp = 0;
		int i = 0; 
		int j = 0;
		
		for(int z=0; z<n; z++) {
			output[z] = z+1;
		}
		
		for(int z=0; z<m; z++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			
			i = Integer.parseInt(st2.nextToken());  
			j = Integer.parseInt(st2.nextToken());  
			
			temp = output[i-1];
			output[i-1] = output[j-1];
			output[j-1] = temp;
		}
		
		
		for(int z=0; z<output.length; z++)
			System.out.print(output[z] + " ");
		
	}
}
