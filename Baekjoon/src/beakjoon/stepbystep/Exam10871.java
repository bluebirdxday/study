package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam10871 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
	
		int n = Integer.parseInt(arr[0]);
		int x = Integer.parseInt(arr[1]);
		
		arr = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			if(x>Integer.parseInt(arr[i])){
				bw.append(arr[i]).append(" ");
			}
		}
		
		bw.flush();
		bw.close();
		
		
	}
}
