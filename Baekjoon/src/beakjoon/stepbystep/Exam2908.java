package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		String a2 = "";
		String b2 = "";
		
		for(int i=a.length()-1; i>=0; i--) {
			a2 += a.charAt(i);
			b2 += b.charAt(i);
		}
		
		if(Integer.parseInt(a2) > Integer.parseInt(b2))
			System.out.println(a2);
		else
			System.out.println(b2);
		
		br.close();
	}
}
