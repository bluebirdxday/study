package com.kimyoji.study.exception;

import java.io.IOException;

public class IDFormatException extends IOException{

	public IDFormatException(String message) {  // 생성자의 매개변수로 예외 상황 메세지를 받음
		super(message);
	}
	
}
