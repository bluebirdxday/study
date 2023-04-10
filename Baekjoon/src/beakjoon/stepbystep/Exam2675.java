package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2675 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			int r;
			String s;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			s = st.nextToken();

				for(int k=0; k<s.length(); k++) {
					for(int j=0; j<r; j++)
						sb.append(s.charAt(k)); 
				}
			sb.append("\n");
		}
	
		System.out.println(sb);
		
	}
}
