package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		int sum = 0;
		int[] array = new int[9];
		
		for(int i=0; i<array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
			
			if(i%2==0) {
				sum += array[i];
			}
		}
		
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	
	}
	
	
	public void practice2() {
		
		int sum = 0;
		int[] array = new int[9];
		
		for(int i=array.length-1; i>=0; i--) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
		
		for(int i=0; i<array.length; i++) {
			if(i%2==1) {
				sum += array[i];
			}
		}
		
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
	}
	
	
	public void practice3() {
		

		int size;
		
		System.out.print("양의 정수 : ");
		size = sc.nextInt();
		
		int array[] = new int[size];
		
		for(int i=0; i<array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
	}
	
	
	public void practice4() {
		
		int value;
		int[] array = new int[5];
		int existence = 0;
		
		for(int i=0; i<array.length; i++) {
			System.out.printf("입력 %d : ", i);
			array[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		value = sc.nextInt();
		
		for(int i=0; i<array.length; i++) {
			if(array[i] == value) {
				existence = i;
			}
		}
		
		if(existence!=0) 
			System.out.println("인덱스 : " + existence);
		else 
			System.out.println("일치하는 값이 존재하지 않습니다.");
	}
	
	
	public void practice5() {
		 
		String str = "";
		char search = ' ';
		int count = 0;
		
		System.out.print("문자열 : ");
		str = sc.next();
		
		System.out.print("문자 : ");
		search = sc.next().charAt(0);
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", str, search);
		
		for(int i=0; i<str.length(); i++) {
			if(search == str.charAt(i)) {
				System.out.print(i + " ");
				count++;
			}
		}
		
		
		if(count==0) {
			System.out.println("존재하지 않음");
		}
		
		System.out.printf("\n%c 개수 : %d", search, count);
	}
	
	
	
	public void practice6() {
		
		int[] array;
		int sum = 0;
		
		System.out.print("정수 : ");
		array = new int[sc.nextInt()];
		
		for(int i=0; i<array.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			array[i] = sc.nextInt();
		}
		
		for(int i : array) {
			System.out.print(i + " ");
			sum += i;
		}
		
		System.out.println();
		System.out.println("총 합 : " + sum);
		
		
	}
	
	
	public void practice7() {
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		char[] array = new char[14];
		
		System.out.print("주민등록번호(-포함) : ");
		
		for(int i=0; i<array.length; i++) {
			if(i<8)
				array[i] = sc.next().charAt(i);
			else
				array[i] = '*';
		}
		
	}
	
	
	public void practice8() {
		
		int input;
		int[] array;
		
		do {
			System.out.print("정수 : ");
			input = sc.nextInt();
			if(input>=3 && input%2==1)
				break;
			else
				System.out.println("다시 입력하세요.");
		}while(true);

		array = new int[input];
		
		for(int i=0, j=0; i<array.length; i++) {
			
			if(i<=array.length/2)
				array[i] = ++j;
			else
				array[i] = --j;			
		}
	
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
	
	
	public void practice9() {
		
		int[] array = new int[10];
		
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*10)+1;
			
			System.out.print(array[i] + " ");
		}
		
		
	}
	
	
	public void practice10() {
	
		int[] array = new int[10];
		int max;
		int min;
		
		System.out.print("발생한 난수 : ");
		
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*10)+1;
			
			System.out.print(array[i] + " ");
		}
		
		max = array[0];
		min = array[0];
		
		for(int i : array) {
			if(i > max)
				max = i;
		}
		
		for(int i : array) {
			if(i < min)
				min = i;
		}
		
		System.out.println();
		System.out.println("최대값 : " + max);
	    System.out.println("최소값 : " + min);
		
	}
	
	
	public void practice11() {
		
		int[] array = new int[10];
		
		for(int i=0; i<array.length; i++) {
			
			array[i] = (int)(Math.random()*10)+1;
			
			for(int j=0; j<i; j++) {
				if(array[i] == array[j]) 
					i--;
			}
		}
		
		for(int i : array) 
			System.out.print(i + " ");
	}
	
	
	public void practice12() {
		
		int[] lotto = new int[6];
		int max=0;
		
		for(int i=0; i<lotto.length; i++) {
			
			lotto[i] = (int)(Math.random()*45)+1;
			
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) 
					i--;
			}
		}
		
		Arrays.sort(lotto);
		
		for(int i : lotto) 
			System.out.print(i + " ");
		
	}
	
	
	public void practice13() {
		
		String str;
		int count = 0;
		
		System.out.print("문자열 : ");
		str = sc.next();
		
		System.out.print("문자열에 있는 문자 : ");
		
		for(int i=0; i<str.length(); i++) {
			
			for(int j=0; j<i; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					i++;
					continue;
				}
			}
			
			count++;
			System.out.print(str.charAt(i));
			
			if(i != str.length()-1)
				System.out.print(", ");
		}
		
		System.out.println();
		System.out.println("문자 개수 : " + count);
		
	}
	
	public void practice14() {
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		String[] str;
		int size;
		
		System.out.print("배열의 크기를 입력하세요 : ");
		size = sc.nextInt();
		
		str = new String[size];
		
	}
	
	
	public void practice15() {
		
		String[][] array = new String[3][3];
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = "(" + i + ", " + j + ")";
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	public void practice16() {
		
		int[][] array = new int[4][4];
		int count = 1;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = count++;
				System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void practice17() {
		
		int[][] array = new int[4][4];
		int count = 16;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = count--;
				System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public void practice18() {
		
		int[][] array = new int[4][4];

		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {

				if(i<array.length-1 && j<array[i].length-1){
					array[i][j] = (int)(Math.random()*10)+1;
				}
			}
		}
		
		
		for(int i=0; i<array.length; i++) {
			
			int sum=0;
			
			for(int j=0; j<array[i].length; j++) {
				
				sum += array[i][j];
				
				if(j==array[i].length-1) {
					array[i][j] = sum;
				}
			}
		}
		
		for(int i=0; i<array.length; i++) {
			
			int sum = 0;
			
			for(int j=0; j<array[i].length; j++) {
				sum += array[j][i];
			
			}
			
			if(i==array.length-1) {
				array[3][i] = sum;
			}
		}
		
		
		// [3][0] => [0][0]  [1][0]  [2][0]
		
		for(int[] i : array) {
			for(int j : i) {
				System.out.printf("%3d", j);
			}
			System.out.println();
		}
		
	}
	
	public void practice19() {
		
	}
	
	public void practice20() {
		
	}
	
	public void practice21() {
		
	}
	
	public void practice22() {
		
	}
	
	public void practice23() {
		
	}
	
	public void practice24() {
		
	}
	
}
