package com.kimyoji.study.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.rmi.server.RMIClassLoaderSpi;

public class ThrowsException {

	public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException {
		
		
		FileInputStream fis = new FileInputStream(fileName);
		Class c = Class.forName(className);
		return c;
	}
	
	public static void main(String[] args) {
		
		try {
			ThrowsException test = new ThrowsException();
			test.loadClass("a.txt", "java.lang.String");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}
}
