package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2941 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int wordCount=0;
		
		for(int i=0; i<str.length(); i++) {
			
			char word = str.charAt(i);
			
			// word : c && 다음 값 : = / 다음값 : -
			if(word=='c' && i<str.length()-1) {
				if(str.charAt(i+1)=='=' || str.charAt(i+1)=='-')
					i++;
			}
			
			// word : d && 다음 값 : z, 다다음값 : =  / 다음 값 : -
			else if(word=='d' && i<str.length()-1) {
				if(str.charAt(i+1)=='-')
					i++;
				else if(str.charAt(i+1)=='z' && i<str.length()-2)
					if(str.charAt(i+2)=='=')
						i+=2;
			}
			
			// word : l / word : n  &&  다음값 : j
			else if((word=='l' || word=='n') && i<str.length()-1) {
				if(str.charAt(i+1)=='j')
					i++;
			}
			
			// word : s / word : z  && 다음값 : =
			else if((word=='s'  || word=='z') && i<str.length()-1)
				if(str.charAt(i+1)=='=')
					i++;
			
			wordCount++;
		}
		
		System.out.println(wordCount);

	}
}
