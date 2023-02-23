package com.kimyoji.study.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		
		
		FileInputStream fis = null; // FileInputStream : 데이터를 바이트 단위로 읽어 들이는 
		
		
		try {
			
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			return;
		} finally {
			try {
				
				fis.close(); // 파일 입력 스트림 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("항상 수행되는 부분");
		}
		
		System.out.println("여기도 수행됨");
	}
}
