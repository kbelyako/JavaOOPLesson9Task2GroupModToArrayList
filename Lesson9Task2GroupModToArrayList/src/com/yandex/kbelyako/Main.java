//Lesson 9 Task 2) Модифицируйте класс ≪Группа≫ для более удобных методов работы с динамическими массивами.

package com.yandex.kbelyako;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Human person1 = new Human();
		//Human person2 = new Human("Petr", "Ivanovich", "Ivanov", 19, "male");
	//	System.out.println(person2);
		
		// student1=person2;
	//System.out.println(student1);
		Group testGroup = new Group();
		//System.out.println(testGroup);
		
		Student student1 = new Student("Petr", "Ivanovich", "Ivanov", 19,
				"male");
		System.out.println(student1.toString());

		Student student2 = new Student("Evgeniy", "Ivanovich", "Gurin", 19,
				"male");
		
		Student student3 = new Student("Vasiliy", "Aleksandrovich", "Arbuzov",
				19, "male");
		student3.setfName("Alex");
		Student student4 = new Student("Aleksey", "Olegovich", "Vasiliyev", 19,
				"male");
		Student student5 = new Student("Dmitri", "Ivanovich", "Ivanov", 18,
				"male");
		Student student6 = new Student("Olga", "Petrovna", "Kravtsova", 21,
				"female");
		Student student7 = new Student("Petr", "Ivanovich", "Bublikov", 22,
				"male");
		Student student8 = new Student("Vasiliy", "Aleksandrovich", "Kaverin",
				19, "male");
		Student student9 = new Student("Aleksey", "Ivanovich", "Ivanov", 17,
				"male");
		Student student10 = new Student("Dmitri", "Olegovich", "Afanasiev", 18,"male");
				
		Student student11 = new Student("Olga", "Petrovna", "Romashkina", 19,
				"female");
		
			testGroup.addstudent(student1);
			testGroup.addstudent(student2);
			testGroup.addstudent(student10);
			testGroup.addstudent(student3);
			testGroup.addstudent(student5);
			testGroup.addstudent(student9);
			testGroup.addstudent(student1
					);
			testGroup.addstudent(student9);
	
		//System.out.println(testGroup);

testGroup.addstudent(student4);
testGroup.addstudent(student6);
testGroup.addstudent(student7);

testGroup.setName("testGroup1");
testGroup.toStringTable();
testGroup.sort();
testGroup.toStringTable();
testGroup.sortByParam("age");
testGroup.toStringTable();
testGroup.sortByParam("fname");
testGroup.toStringTable();
testGroup.sortByParam("tname");
testGroup.toStringTable();
testGroup.saveToFile();

Group  groupFromFile1 = new Group("GroupfromFile1");
File t = new File("testGroup1.txt");
groupFromFile1=Group.loadGroup(t);
groupFromFile1.toStringTable();

try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream("fil1"))){
OOS.writeObject(testGroup);
} catch(IOException e){
System.out.println("ERROR save group !!!");
}

Group  groupFromFile2 = new Group("GroupfromFile2");
groupFromFile2=null;

try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("fil1"))){
	groupFromFile2=(Group)OIS.readObject();
} catch(IOException |
ClassNotFoundException e){
System.out.println("ERROR load group !!!");
}

groupFromFile2.toStringTable();

Faculty testFaculty= new Faculty("Faculty2");
File storage = new File("Faculty3");
storage.mkdir();

testFaculty.saveGroupToFile(groupFromFile2, "faculty2Group1");
testFaculty.saveGroupToFile(groupFromFile1, "faculty2Group1");

Group  groupFromFile3 = new Group("GroupfromFile3");
groupFromFile3=null;
groupFromFile3=testFaculty.loadGroupFromFile("faculty2Group1");
groupFromFile3.toStringTable();

	}

}