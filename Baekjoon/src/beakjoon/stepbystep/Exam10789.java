package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 세로 읽기
public class Exam10789 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] word = new char[5][];
		int maxStrLen = 0;
		
		for(int i=0; i<5; i++) {
			String line = br.readLine();
			
			word[i] = new char[line.length()];
			
			for(int j=0; j<line.length(); j++) {
				word[i][j] = line.charAt(j);
			}
			
			
			if(line.length()>maxStrLen)
				maxStrLen = line.length();
		}
		
		
		for(int i=0; i<maxStrLen; i++) {
			// (0,0), (1,0), (2,0) ~ (4,0)
			// word[j][i] -> j의 범위는 0~4로 고정
			// 					-> i의 범위는 최대 길이 문자열까지 
			
			// 반복문 내에 조건문 추가 => word[j] 즉, j행의 열의 길이보다 작을 때만 읽기
			// 										=> 범위를 초과하면 nullpointerException이 발생함 
			//				ex) 철자 4개만 입력한 행의 경우, 배열[행][5]의 값은 존재하지 않기 때문에
			
			// 먼저 받은 문자의 최대 문자열 길이번째 반복해서 읽고
			// 배열에 접근하기 위해 배열의 행이 증가할 때마다 열의 길이를 따져봐서
			// 해당 행의 열의 길이보다 작을 경우만 읽어서 출력하도록 구성
			
			for(int j=0; j<5; j++) {
				if(i<word[j].length)
				System.out.print(word[j][i]);
			}
		}
		
	}
}
