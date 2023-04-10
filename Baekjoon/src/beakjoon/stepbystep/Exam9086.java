package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exam9086 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			String str = br.readLine();
			bw.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
