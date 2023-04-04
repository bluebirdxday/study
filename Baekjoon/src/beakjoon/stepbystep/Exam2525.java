package beakjoon.stepbystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam2525 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		
		int hour = Integer.parseInt(arr[0]);
		int minute = Integer.parseInt(arr[1]);
		
		int timeToCook = Integer.parseInt(br.readLine());
		int tminute = timeToCook%60;
		int thour = timeToCook/60;
		
		if(minute+tminute >= 60) {
			hour++;
			minute += tminute - 60;
		}else
			minute += tminute;
		
		if(hour+thour>=24) {
			hour += thour - 24;
		}else
			hour += thour;
		
		System.out.println(hour + " " + minute);
		
	}
}
