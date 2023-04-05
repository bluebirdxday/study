package beakjoon.stepbystep;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// StringBuilder 사용하기!!!!

/*
 * - Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.StringTokenizer.nextToken(StringTokenizer.java:347) 에러
 * 
 * 테스트를 위해 콘솔창에서 값을 모두 쓰고 난 후 엔터를 입력하게 되면, 결국 빈 문자열("")이기 때문에 
 * st객체에서는 반환 할 토큰이 존재하지 않게 됨
 * EOF는 데이터가 없는 상태이고, 엔터, 스페이스 같은 모든 키보드 입력은 데이터가 존재함
 * 
 * IDE나 콘솔 입력에서 EOF를 주고싶을 때 어떻게 할 수 있는 방법이 없기 때문에
 * (즉, 입력이 끝인지, 단순 대기상태인지 알 수 없기 때문에) 
 * EOF 상태를 알리는 매크로같이 단축키를 만들게 되었는데,
 *  윈도우의 경우는 ctrl + Z, 리눅스계열의 경우 ctrl + D가 이에 해당됨
 *  
 *  백준 채점 서버의 경우 우분투를 사용
 *  
 *  
 *  결론 : 
 *  1) BufferedReader에서 br.readLine()으로 한 줄을 읽고, 
 *  		이를 StringTokenizer에 해당 입력 문자열을 넣음
 *  2) 근데, 마지막에 엔터만 입력했으면 "" 문자열이 str 에 들어감 즉, str = ""; 빈 문자열 상태
 *  3) 그 다음에 StringTokenizer st에 문자열을 넣고, " "(공백) 단위로 구분
 *  4) 이 때 st 객체 안에는 이미 문자열이 ""(공백없는 빈 문자열) 자체에서 
 *      검사할 수 있는 문자가 없기 때문에 뽑아낼 수 있는 토큰(공백으로 분리 된 문자열)이 없어 
 *      토큰을 뽑으려고 할 경우 NoSuchElementException이 발생
 *      
 *    -> EOF를 알리는 일종의 단축키처럼 매크로를 써서 ctrl+d 혹은 ctrl+z 를 입력하여 EOF를 알리는 것
 * 
 * */

public class Exam10951 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		String str;
		
		while((str=br.readLine())!=null) {
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(a+b).append("\n");
		}
		System.out.println(sb);
	}
}

