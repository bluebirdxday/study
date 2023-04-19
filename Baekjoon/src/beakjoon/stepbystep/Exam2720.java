package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 세탁소 사장 동혁
public class Exam2720 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int quarter= 25;
		int dime= 10; 
		int nickel= 5;
		
		int t = Integer.parseInt(br.readLine());	// 테스트 케이스의 개수
		
		for(int i=0; i<t; i++) {
			int c = Integer.parseInt(br.readLine());  // 거스름돈(단위:센트) (1달러 == 100센트)
			
			// 124센트 -> 1.24달러
			sb.append(c/quarter).append(" ");
			c %= quarter;
			
			sb.append(c/dime).append(" ");
			c %= dime;
			
			sb.append(c/nickel).append(" ");
			c %= nickel;
			
			sb.append(c).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
