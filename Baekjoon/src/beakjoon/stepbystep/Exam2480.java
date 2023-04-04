package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
 * 
 * */
public class Exam2480 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		int one = Integer.parseInt(arr[0]);
		int two = Integer.parseInt(arr[1]);
		int three = Integer.parseInt(arr[2]);
		
		int max=0;
		
		int reward = 0;
		
		if(one==two && two==three)
			reward = 10000 + one*1000;
		else if(one==two || one==three || two==three) {
			
			if(one==two || one== three)
				reward = 1000+one*100;
			else 
				reward = 1000+three*100;
			
		}else {
			
			for(int i=0; i<arr.length; i++) {
				if(max<Integer.parseInt(arr[i]))
					max = Integer.parseInt(arr[i]);
			}
			
			reward = max*100;
		}
			
		System.out.println(reward);
		
	}
}
