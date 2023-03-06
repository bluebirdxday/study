package com.kimyoji.study.stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("input.text")) {
			
			int i;
			while((i = fis.read()) != -1) {
				System.out.println((char)i);
			}
			
			System.out.println("end");
			
		}catch(NullPointerException e){
			
			e.printStackTrace();
			
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
	}
			
}
