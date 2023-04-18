package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진법 변환

// 10진수 -> N진수    :	Integer.toString(10진수, N)
// N진수 -> 10진수 	:   Integer.parseInt(N진수, N)

/*
 * 어떤 진수든 10진수로 바꾸는 방법은 똑같음
	- 각 자리의 10진수 숫자 * 진수의 각 자리수 제곱을 모두 더한 값

	ex) 2진수 1101 일때
	1*2^3 + 1*2^2 + 0*2^1 + 1*2^0 = 13
*/

public class Exam2745 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		String n = st.nextToken();		// 변환하고자 하는 수
		int b = Integer.parseInt(st.nextToken());		// 진법
		
		int num = 0;	
		int ans = 0;  // 답

		// A의 아스키코드 : 65
		// A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
		
		for(int i=0, j=n.length()-1; i<n.length(); i++, j--) {
			char c = n.charAt(i);
			
			if('0'<=c&&c<='9')
				num = c - '0';
			else
				num = c - 55;
			
			ans += num * Math.pow(b, j);	// 특정자리숫자 * b(진법)의 j(자리수)제곱
			
		}
		
		System.out.println(ans);
		
		
		

	}
}
