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
		
		char[] array = new char[14];
		String input;
		
		
		System.out.print("주민등록번호(-포함) : ");
		input = sc.next();
		
		
		for(int i=0; i<array.length; i++) {
			if(i<8)
				array[i] = input.charAt(i);
			else
				array[i] = '*';
		}
		
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]);
		
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
		
		String[] array=null;
		String[] newArray=null;
		int size;
		char moreInput;
		int moreInputCount=0;
		
		System.out.print("배열의 크기를 입력하세요 : ");
		size = sc.nextInt();
		sc.nextLine();
		
		array = new String[size];
		
		for(int i=0; i<array.length; i++) {
			System.out.printf("%d번째 문자열 : ", i+1);
			array[i] = sc.nextLine();
		}
		
		while(true){
			
			System.out.print("더 값을 입력하시겠습니까? (Y/N) : ");
			moreInput = sc.next().charAt(0);
			
			if(moreInput=='N' || moreInput=='n')
				break;
			
			if(moreInput=='Y' || moreInput=='y') {
				
				System.out.print("더 입력하고 싶은 개수 : ");
				moreInputCount = sc.nextInt();
				sc.nextLine();
				
				newArray = new String[array.length + moreInputCount];
				
				
				System.arraycopy(array, 0, newArray, 0, array.length);
	
				
				for(int i=array.length; i<newArray.length; i++) {
					System.out.printf("%d번째 문자열 : ", i+1);
					newArray[i] = sc.nextLine();
				}

				array = newArray;
			}
			
		}
		
		
		if(newArray==null) 
			System.out.println(Arrays.toString(array));
		else
			System.out.println(Arrays.toString(newArray));
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
		int total = 0;

		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				if(i<array.length-1 && j<array[i].length-1){
					array[i][j] = (int)(Math.random()*10)+1;
					
					total += array[i][j];
				}
			}
		}
		
		
		array[3][3] = total;
		
		
		for(int i=0; i<array.length-1; i++) {
			
			int sum=0;
			
			for(int j=0; j<array[i].length; j++) {
				
				sum += array[i][j];
				
				if(j==array[i].length-1) {
					array[i][j] = sum;
				}
			}
		}
		
		for(int i=0; i<array.length-1; i++) {
			
			int sum = 0;
			
			for(int j=0; j<array[i].length; j++) {
				
				sum += array[j][i];
				
				if(j==array[i].length-1) {
					array[j][i] = sum;
				}
			}
		}

		
		for(int[] i : array) {
			for(int j : i) {
				System.out.printf("%4d", j);
			}
			System.out.println();
		}
		
	}
	

	public void practice19() {
		
		int rowSize;
		int colSize;
		char[][] array;
		
		while(true) {
			
			System.out.print("행 크기 : ");
			rowSize = sc.nextInt();
			
			if(rowSize<1 || rowSize>10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}else
				break;
		}
			
		
		while(true) {
			
			System.out.print("열 크기 : ");
			colSize = sc.nextInt();
			
			if(colSize<1 || colSize>10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}else
				break;
		}
		
		array = new char[rowSize][colSize];
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = (char)(Math.random()*('Z'-'A'+1)+'A');
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	public void practice20() {
		
		int rowSize;
		int colSize;
		char[][] array;
		char index = 'a';
		
		System.out.print("행의 크기 : ");
		rowSize = sc.nextInt();
	
		array = new char[rowSize][];
		
		for(int i=0; i<array.length; i++) {
			System.out.printf("%d열의 크기 : ", i);
			colSize = sc.nextInt();
			array[i] = new char[colSize];
		}
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = index++;
				System.out.print(array[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	public void practice21() {
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] array1 = new String[3][2];
		String[][] array2 = new String[3][2];
		
		int index = 0;
		
		System.out.println("== 1분단 ==");
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length; j++) {
				array1[i][j] = students[index];
				System.out.print(array1[i][j] + " ");
				index++;
			}
			System.out.println();
		}
		
		
		System.out.println("== 2분단 ==");
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				array2[i][j] = students[index];
				System.out.print(array2[i][j] + " ");
				index++;
			}
			System.out.println();
		}
	}
	
	
	public void practice22() {
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] array1 = new String[3][2];
		String[][] array2 = new String[3][2];
		
		int index = 0;
		String studentName;
		String leftOrRight = "";
		int bundan=0;
		int row=0;
		
		System.out.println("== 1분단 ==");
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length; j++) {
				array1[i][j] = students[index];
				System.out.print(array1[i][j] + " ");
				index++;
			}
			System.out.println();
		}
		
		
		System.out.println("== 2분단 ==");
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				array2[i][j] = students[index];
				System.out.print(array2[i][j] + " ");
				index++;
			}
			System.out.println();
		}
		
		System.out.println("======================================");
		System.out.print("검색할 학생의 이름을 입력하세요 : ");
		studentName = sc.next();
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length; j++) {
				if(studentName.equals(array1[i][j])) {
					bundan = 1;
					row = i+1;
					leftOrRight = j==0 ? "왼쪽" : "오른쪽";
				}
			}
		}
		
		for(int i=0; i<array2.length; i++) {
			for(int j=0; j<array2[i].length; j++) {
				if(studentName.equals(array2[i][j])) {
					bundan = 2;
					row = i+1;
					leftOrRight = j==0 ? "왼쪽" : "오른쪽";
				}
			}
		}
		
		System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",
				studentName, bundan, row, leftOrRight);
	}
	
	
	public void practice23() {
		
		String[][] array = new String[6][6];
		int index1=0;
		int index2=0;
		int rowIndex;
		int colIndex;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				if(i==0 && j>0) {
					array[i][j] = Integer.toString(index1++);
				}else if(j==0 && i>0) {
					array[i][j] = Integer.toString(index2++);
				}else {
					array[i][j] = " ";
				}
			}
		}
		
		System.out.print("행 인덱스 입력 : ");
		rowIndex = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		colIndex = sc.nextInt();
		
		array[rowIndex+1][colIndex+1] = "X";
		
		for(String[] i : array) {
			for(String j : i) {
				System.out.printf(" %s ", j);
			}
			System.out.println();
		}
	}
	
	public void practice24() {
		
		String[][] array = new String[6][6];
		int index1=0;
		int index2=0;
		int rowIndex;
		int colIndex;
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				
				if(i==0 && j>0) {
					array[i][j] = Integer.toString(index1++);
				}else if(j==0 && i>0) {
					array[i][j] = Integer.toString(index2++);
				}else {
					array[i][j] = " ";
				}
			}
		}
		
		while(true) {
			
			System.out.print("행 인덱스 입력 : ");
			rowIndex = sc.nextInt();
			
			if(rowIndex==99) {
				System.out.println("프로그램 종료");
				break;
			}
			
			System.out.print("열 인덱스 입력 : ");
			colIndex = sc.nextInt();
			
			array[rowIndex+1][colIndex+1] = "X";
			
			for(String[] i : array) {
				for(String j : i) {
					System.out.printf(" %s ", j);
				}
				System.out.println();
			}
		}
		
	}
	
	
	public void challenge() {
		
		int[][] array;
		int bingoSize;
		int search;
		
		System.out.print("빙고판 크기 지정 : ");
		bingoSize = sc.nextInt();
		
		array = new int[bingoSize][bingoSize];
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				array[i][j] = (int)(Math.random()*bingoSize*bingoSize)+1;
			}
		}
		
		for(int[] i : array) {
			for(int j : i) {
				System.out.printf("%4d", j);
			}
			System.out.println();
		}
		
		
		while(true){
			
			int bingoCount=0;
			boolean existence = false;
			int diagonalBingoCheck=0;
			int diagonalBingoCheck2=0;
			
			
			System.out.println("============== 빙고 게임 시작 ==============");
			System.out.print("정수를 입력하시오 : ");

			search = sc.nextInt();
			
			
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array[i].length; j++) {
					if(search==array[i][j]) {
						array[i][j] = 0;
						existence = true;
					}
				}
			}
			
			for(int[] i : array) {
				for(int j : i) {
					
					System.out.printf("%4d", j);
				}
				System.out.println();
			}
			
			
			if(existence==false) {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
				
			
			for(int i=0; i<array.length; i++) {
				
				int bingoCheck=0;
				
				for(int j=0; j<array[i].length; j++) {

					if(array[i][j]==0)
						bingoCheck++;
				}
				
				if(bingoCheck==bingoSize)
					bingoCount++;
			} // row 빙고체크
			
			
			for(int i=0; i<array.length; i++) {
				
				int bingoCheck=0;
				
				for(int j=0; j<array[i].length; j++) {

					if(array[j][i]==0)
						bingoCheck++;
				}
				
				if(bingoCheck==bingoSize)
					bingoCount++;
			} // col 빙고체크
			
			
			for(int i=0; i<array.length; i++) {

				if(array[i][i]==0)
					diagonalBingoCheck++;
				
				if(diagonalBingoCheck==bingoSize) 
					bingoCount++;
			} // 대각선1 빙고체크 (\)
			
			
			for(int i=0, j=array.length-1; i<bingoSize; i++, j--) {

				if(array[j][i]==0) 
						diagonalBingoCheck2++;
				
				if(diagonalBingoCheck2==bingoSize)
					bingoCount++;
			} // 대각선2 빙고체크 (/)

			
			System.out.printf("현재 %d 빙고\n\n", bingoCount);
			
			if(bingoCount>=3) {
				System.out.println("***** BINGO!! *****");
				break;
			}
			
		}
		
	}
}
