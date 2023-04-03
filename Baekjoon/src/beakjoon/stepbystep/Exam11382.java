package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam11382 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b =  Long.parseLong(st.nextToken());
		long c =  Long.parseLong(st.nextToken());
		
		System.out.println(a+b+c);
	}
}


//  (1 ≤ A, B, C ≤ 10^12) 명시한 범위를 주의해서 풀기 -> int형 X,  long형 O
//  그러지 않으면 RuntimeError가 발생한다!!