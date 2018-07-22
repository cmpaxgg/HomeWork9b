package com.gmail.cmpaxgg;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group groupOne = new Group();

		try {
			groupOne.addStudent(new Student("Sergey", "Philipov", 21, true, "biology", 1));
			groupOne.addStudent(new Student("Andrey", "Kabanov", 22, true, "biology", 2));
			groupOne.addStudent(new Student("Alexey", "Krasnov", 17, true, "biology", 3));
			groupOne.addStudent(new Student("Nikolay", "Bronzoviy", 22, true, "phisics", 4));
			groupOne.addStudent(new Student("Grisha", "Kamyaniy", 18, true, "phisics", 5));
			groupOne.addStudent(new Student("Elena", "Lomanosova", 21, false, "phisics", 1));
			groupOne.addStudent(new Student("Vyacheslav", "Cherednyk", 24, true, "phisics", 2));
			groupOne.addStudent(new Student("Larisa", "Ivanova", 17, false, "geography", 1));
			groupOne.addStudent(new Student("Nadegda", "Galchina", 21, false, "geography", 3));
			groupOne.addStudent(new Student("Petr", "Velikiy", 25, true, "geography", 5));
			groupOne.addStudent(new Student("Bred", "Pitt", 45, true, "filmography", 100500));// Student number 11
			groupOne.addStudent(new Student("Doroty", "Green", 22, false, "biology", 2));// Student number 12
		} catch (MyException e) {
			System.out.println(groupOne);
			System.out.println(e.getMessage());
			groupOne.sortStudentByName();
			System.out.println(groupOne);
			groupOne.sortStudentByLastName();
			System.out.println(groupOne);

		}

		System.out.println("The army is crying for these guys: " + groupOne.getSpecnaz());
		
		File file = new File("Group.gp");
		try {
			SerializableService.saveGroup(file, groupOne);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Group readGroupOne = null;

		try {
			readGroupOne = (Group) SerializableService.loadGroup(file);

		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
