package com.yandex.kbelyako;

import java.io.Serializable;
import java.util.Comparator;

public class Human implements Comparable,Serializable {

	private String fName;
	private String patronymic;
	private String lName;

	private int age;
	private String sex;

	public Human(String fName, String patronymic, String lName, int age,
			String sex) {
		super();
		this.fName = fName;
		this.patronymic = patronymic;
		this.lName = lName;
		this.age = age;
		this.sex = sex;
	}

	public Human() {
		super();
		
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		if (fName.matches("[a-zA-Z]+")) {
			if (fName.length() >= 2) {
				this.fName = fName;
			} else
				throw new IllegalArgumentException("To short");

		} else
			throw new IllegalArgumentException("You enter unacceptable char");

	}

	public String getlName() {
		return lName;
	}

	public void setlNname(String lName) {
		if (lName.matches("[a-zA-Z]+")) {
			this.lName = lName;
		} else
			throw new IllegalArgumentException("You enter unacceptable char");
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		if (patronymic.matches("[a-zA-Z]+")) {
			this.patronymic = patronymic;
		} else
			throw new IllegalArgumentException("You enter unacceptable char");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 16) {
			this.age = age;
		} else
			throw new IllegalArgumentException("Impossible age");

	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		if (sex.matches("male") || sex.matches("Male") || sex.matches("MALE")
				|| sex.matches("female") || sex.matches("Female")
				|| sex.matches("FEMALE")) {
			this.sex = sex;
		} else
			throw new IllegalArgumentException("Impossible sex");

	}

	@Override
	public int compareTo(Object o) {

		if (o == null) {
			// System.out.println("I found null");
			return -1;
		}

		Human person = (Human) o;

		return this.lName.compareToIgnoreCase(person.getlName());

	}

	@Override
	public String toString() {
		return "Human [fName=" + fName + ", patronymic=" + patronymic
				+ ", lName=" + lName + ", age=" + age + ", sex=" + sex + "]";
	}

	public String toStringToFile() {
		return fName + " " + patronymic + " " + lName + " " + age + " " + sex;
	}

}