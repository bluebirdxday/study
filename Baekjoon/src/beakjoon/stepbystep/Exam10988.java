package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int check = 1;
		
		for(int i=0, j=str.length()-1; i<str.length()/2; i++, j--) {
		
				if(str.charAt(i)!=str.charAt(j)) {
					check = 0;
					break;
				}
		}
		
		System.out.println(check);
		
	}
}
