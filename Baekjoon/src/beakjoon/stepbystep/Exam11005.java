package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 진법 변환2
public class Exam11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();		
		// 답을 저장하기 위해서 사용(reverse() 메서드로 뒤집기 가능)
		
		int n = Integer.parseInt(st.nextToken());	 	// 10진법 수
		int b = Integer.parseInt(st.nextToken());		// 변환하고자 하는 진법
		
		
		// 10진법 -> B진법 
		// N / 10의 나머지들
		// 나머지가 0과 9 사이면 그대로 10이상이면 알파벳으로 변환
		
		
		while(n>0){

			int num = n%b;    // 나머지
			if(num>9)
				sb.append((char)(num - 10 + 'A'));
			else
				sb.append(num);
			
			n /= b;	
			
		};
		
		System.out.println(sb.reverse());
		
	}
}
