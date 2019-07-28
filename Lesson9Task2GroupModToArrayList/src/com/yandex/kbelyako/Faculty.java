package com.yandex.kbelyako;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Faculty {

	private Group[] faculty;
	private String name;
	private File storage;

	public Faculty(String name) {
		super();
		this.faculty = faculty;
		this.name = name;
		//this.storage = new File(name);
		mkFaculty();

	}

	public void mkFaculty() {
		File root = new File(".");
		int i=check(root, name);
		
		if (i==1)
		{
			System.out.println("Faculty with such name already exist !!!");
		}
		else {
			this.storage = new File(name);
			storage.mkdir();
		}
		
	}

	public void saveGroupToFile(Group group, String fileName) {
		
		if (check(storage, fileName) == 1) {
			System.out.println("Group with such name already exist in this faculty !!!");
		}
		else {
			
			try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(storage + "/" + fileName))) {
				OOS.writeObject(group);
			} catch (IOException e) {
				System.out.println("ERROR save group !!!");
			}
			
		}


	}

	public Group loadGroupFromFile(String fileName) {
		Group group = null;

		if (check(storage, fileName) == 1) {
			try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(storage + "/" + fileName))) {
				group = (Group) OIS.readObject();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("ERROR load group !!!");
			}

		}
		else {
			System.out.println("No such group in this faculty !!!");
		}

		return group;

	}

	public int check(File folder, String file) {
		int i = -1;
		for (File item : folder.listFiles()) {
			if (item.getName().equals(file)) {
				i = 1;
				break;
			}

		}
		return i;
	}

}