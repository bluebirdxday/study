package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* [문제]
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와
 * 소문자를 구분하지 않는다.
 * 
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
 * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 * 
 * 대문자 A => -65
 * 소문자 a => -97
 */
public class Exam1157 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[26];
		int max = 0;
		int maxCount = 0;
		
		String str = br.readLine().toUpperCase();
		
		for(int i=0; i<str.length(); i++) {
			count[str.charAt(i)-65]++;
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i]>max) {
				max = i;
				maxCount=0;
			}
			
			if(count[i]==max)
				maxCount++;
		}
		

		if(maxCount!=0)
			System.out.println("?");
		
		else
			System.out.println((char)(max+65));
		
	}
}

