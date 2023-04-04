package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exam10952 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		while(true) {
			String[] arr = br.readLine().split(" ");
			int a= Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			
			if(a==0 && b==0)
				break;
			
			arrayList.add(a+b);
		}
		
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}
}
