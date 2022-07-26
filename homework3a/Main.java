package oop.homework3a;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Group onePiece = new Group();

		Student sanji = new Student();

		try {
			sanji.buildStudent(sanji, onePiece);
		} catch (IncorrectDataException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sanji.toString());
		Student luffy = new Student(1500000000, "");
		luffy.setGender(Gender.male);
		luffy.setLastName("Monkey D.");
		luffy.setName("Luffy");
		Student zoro = new Student(320000000, "");
		zoro.setName("Zoro");
		zoro.setLastName("Roronoa");
		zoro.setGender(Gender.male);
		onePiece.setGroupName("One Piece");

		try {
			onePiece.addStudent(zoro);
		} catch (GroupOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			onePiece.addStudent(luffy);
		} catch (GroupOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(luffy.toString());
		System.out.println(onePiece.toString());
		try {
			System.out.println(onePiece.searchStudentByLastName("Roronoa").toString());
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		onePiece.sortStudentsByLatName();
		System.out.println(onePiece.toString());
		onePiece.removeStudentByID(1500000000);
		System.out.println(onePiece.toString());

		

	}

}