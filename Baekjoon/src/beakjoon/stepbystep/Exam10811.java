package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exam10811 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n, m, temp = 0;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] bucket = new int[n+1];
		
		for(int z=1; z<=n; z++)
			bucket[z] = z;
		
		for(int z=0; z<m; z++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			for(int k=i; k<=j; k++,i++,j--) {
				temp = bucket[i];
				bucket[i] = bucket[j];
				bucket[j] = temp;
			}
		}
		
		for(int z=1; z<bucket.length; z++) {
			bw.append(bucket[z] + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
