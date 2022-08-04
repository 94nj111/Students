package oop.homework3a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Group onePiece = new Group();
		onePiece.setGroupName("One Piece");

		Student sanji = new Student();

		try {
			sanji.build(onePiece);
		} catch (IncorrectDataException | GroupOverflowException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
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

		try {
			onePiece.addStudent(zoro);
		} catch (GroupOverflowException | IncorrectDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			onePiece.addStudent(luffy);
		} catch (GroupOverflowException | IncorrectDataException e) {
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

		System.out.println(onePiece.toString());
//		onePiece.removeStudentByID(1500000000);
		System.out.println(onePiece.toString());

		try {
			onePiece.saveCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GroupFileStorage gf = new GroupFileStorage();
		File file = new File("D:\\\\Java курсы\\\\oop.homework3a");
		try {
			System.out.println(gf.findFileByGroupName(onePiece.getGroupName(), file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file1 = new File("D:\\Java курсы\\oop.homework3a\\One Piece.csv");

		try {
			System.out.println(gf.loadGroupFromCSV(file1).toString());
		} catch (IOException | GroupOverflowException | IncorrectDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sanji.equals(zoro));
	}

}
