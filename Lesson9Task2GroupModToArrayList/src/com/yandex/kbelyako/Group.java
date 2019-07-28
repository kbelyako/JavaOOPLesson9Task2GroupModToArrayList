package com.yandex.kbelyako;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements Comparator<Human>, Military, Serializable {

	// private Student[] group1 = new Student[10];

	private ArrayList<Student> group1 = new ArrayList<Student>();

	public Group() {
		super();

	}

	public ArrayList<Student> getGroup1() {
		return group1;
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public void setGroup1(ArrayList<Student> group1) {
		this.group1 = group1;
	}

	public Group(ArrayList<Student> group1) {
		super();
		this.group1 = group1;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Group [group1=" + group1 + ", name=" + name + "]";
	}

	public void toStringTable() {
		System.out.println("Group name: " + getName());
		for (int i = 0; i < group1.size(); i++) {
			System.out.println(i + 1 + " " + group1.get(i));

		}

	}

	public void addstudent(Student student) {

		group1.add(student);
	}

	public void rmvStudent(Student sudent) {
		group1.remove(sudent);
	}

	
	public ArrayList<Student> sort() {

		ArrayList<Student> groupNew = group1;
		Collections.sort(groupNew);

		return groupNew;
	}

	@Override
	public int compare(Human o1, Human o2) {

		return 0;
	}

	public void sortByParam(String option) {

		Comparator<Human> ageComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return (int) (h1.getAge() - h2.getAge());
			}
		};

		Comparator<Human> fNameComparator = new Comparator<Human>() {

			@Override
			public int compare(Human h1, Human h2) {
				return h1.getfName().compareTo(h2.getfName());
			}
		};
		if (option == "age") {
			Collections.sort(group1, ageComparator);
		}

		if (option == "fname") {
			Collections.sort(group1, fNameComparator);
		}

		if (option == "lname") {
			Collections.sort(group1);
		}

		else {
			System.out.println("Wrong sort option !!!");
		}
		;

	}

	public String findStudentOutString(String lName) {
		Student result = null;
		int counter = 0;

		String strResult = "Search result for last name " + lName + ":";
		for (int i = 0; i <group1.size(); i++) {
			
				if (group1.get(i).getlName() == lName) {
					result = group1.get(i);
					counter = counter + 1;
					strResult = strResult + (char) 0x0D + result.toString();

				}			

		}
		if (result == null) {
			strResult = strResult + (char) 0x0D + "No such student in this group";
		}
		return strResult;

	}

	public ArrayList<Student> findStudent(String lName) {

		ArrayList<Student> fresult = new ArrayList<Student>();
		for (int i = 0; i <= 9; i++) {
			if (group1.get(i).getlName() == lName) {
				fresult.add(group1.get(i));
			}
		}
		return fresult;
	}

	@Override
	public Student[] getMilReadyStudents() {
		Student[] fresult = new Student[10];
		int i = 0;
		for (Student student : group1) {
			if (student == null) {
				continue;
			} else {
				if (student.getSex() == "male" && student.getAge() >= 18) {
					fresult[i] = student;
					i = i + 1;
				}
			}
		}
		System.out.println(Arrays.toString(fresult));
		return fresult;
	}

	public void saveToFile() {
		String fileName = "";
		Scanner in = new Scanner(System.in);
		if (getName() == null) {
			System.out.print("Group has no name, please enter group name: ");
			fileName = (in.next());
			setName(fileName);
		} else
			fileName = (getName());

		try (PrintWriter a = new PrintWriter(fileName + ".txt")) {
			for (int i = 0; i < group1.size(); i++) {
			
					a.println(group1.get(i).toStringToFile());
				// a.println("Green Lamp");
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}

	}

	public static String FiletoString(File f) {
		String[] strinArray = new String[10];
		String str2 = "";
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String str1 = "";
			for (; (str1 = br.readLine()) != null;) {
				if (str2 != "")
					str2 = str2 + ";" + str1;
				else
					str2 = str2 + str1;
			}
		} catch (IOException e) {
			e.printStackTrace();
			// System.out.println("ERROR");
		}
		return str2;

	}

	public static Student studentFromString(String inputString) {

		Student student = new Student("Dummy", "Dummy", "Dummy", 19, "Dummy");

		if (inputString != "") {
			String[] parametrs = inputString.split(" ");

			student.setfName(parametrs[0]);
			student.setlNname(parametrs[2]);
			student.setPatronymic(parametrs[1]);
			student.setSex(parametrs[4]);
			student.setAge(Integer.parseInt(parametrs[3]));
		} else
			student = null;

		return student;
	}

	public static Group groupFromString(String inputString) {
		Group resGroup = new Group();
		String[] array = inputString.split(";");
		// System.out.println("Array: "+Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(""))
				continue;
			else {
				// System.out.println("������� �������
				// �������:"+" "+i+" "+array[i]);
				resGroup.addstudent(Group.studentFromString(array[i]));
			}
			//
		}
		return resGroup;
	}

	public static Group loadGroup(File inputFile) {
		Group resGroup = new Group();
		// resGroup.setName(name);
		resGroup = Group.groupFromString(Group.FiletoString(inputFile));
		resGroup.setName(stripExtension(inputFile.getName()));
		return resGroup;
	}

	static String stripExtension(String str) {
		if (str == null)
			return null;
		int pos = str.lastIndexOf(".");
		if (pos == -1)
			return str;
		return str.substring(0, pos);

	}

}