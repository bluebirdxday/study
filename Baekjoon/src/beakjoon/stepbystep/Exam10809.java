package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam10809 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		for(int i='a'; i<='z'; i++) {
			boolean abs = false;
			
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j)==i) {
					bw.append(j + " ");
					abs = true;
					break;
				}
			}
			
			if(abs==false)
				bw.append(-1 + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
