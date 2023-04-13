package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 각 문자가 연속해서 나타나는 경우 -> 그룹 단어로 취급
// ex) ccaazzzbb, kin -> 그룹단어  /  aabbccb -> 그룹단어X

// 그룹 단어의 개수를 출력

// 생각해낸 방안
// 문자열을 CharAt으로 돌고 (인덱스가 알파벳 순서인)정수형 배열에 
// 값을 증가시켜 저장하는데 만약 배열에 저장된 값을 불러올 때 
// 문자가 이전의 문자와 일치하지 않으면서 저장된 숫자가 0이 아니라면
// 그룹 단어가 아니므로 반복문을 종료시키고 다음 단어를 검사함

public class Exam1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int wordCount = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			int[] count = new int[26];
			// 알파벳 총 26개
			// 'A' = 65 , 'a' = 97
			
			char before='0';
			
			for(int j=0; j<str.length(); j++) {
				
				char curr = str.charAt(j);
				
				if(before!=curr && count[curr-97]!=0)
					break;
				
				count[curr-97]++;
				before = curr;
				
				if(j==str.length()-1)
					wordCount++;
			}
			
		}
		
		System.out.println(wordCount);
	}
}
