package com.yandex.kbelyako;

import java.io.PrintStream;

public class MyException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Not possible to add more then 10 students";
	}


	
	}