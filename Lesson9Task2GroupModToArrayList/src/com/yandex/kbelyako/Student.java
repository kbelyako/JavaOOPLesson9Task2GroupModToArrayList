package com.yandex.kbelyako;

public class Student extends Human {

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String fName, String patronymic, String lName, int age, String sex) {
		super(fName, patronymic, lName, age, sex);
		// TODO Auto-generated constructor stub
	
	
	
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return super.compareTo(o);
	}
	
	



	@Override
	public String toString() {
		return "Student [toString()=" + super.toString() + "]";
		
			}

	@Override
	public String toStringToFile() {
		// TODO Auto-generated method stub
		return super.toStringToFile();
	}
	
	

}