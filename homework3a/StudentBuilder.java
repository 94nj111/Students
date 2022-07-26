package oop.homework3a;

import java.util.Scanner;

public interface StudentBuilder {

	public default Student buildStudent(Student studentToBuild) throws IncorrectDataException {

		nameBuilder(studentToBuild);
		lastNameBuilder(studentToBuild);
		genderBuilder(studentToBuild);
		idBuilder(studentToBuild);

		return studentToBuild;
	}
	
	public default Student buildStudent(Student studentToBuild, Group group) throws IncorrectDataException, GroupOverflowException {

		nameBuilder(studentToBuild);
		lastNameBuilder(studentToBuild);
		genderBuilder(studentToBuild);
		idBuilder(studentToBuild);
		group.addStudent(studentToBuild);

		return studentToBuild;
	}
	
	
	
	public default void nameBuilder(Student studentToBuild) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's name: ");
		studentToBuild.setName(sc.nextLine());

	}

	public default void lastNameBuilder(Student studentToBuild) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's lastname: ");
		studentToBuild.setLastName(sc.nextLine());

	}

	public default void genderBuilder(Student studentToBuild) throws IncorrectDataException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose student's gender (Input male/female): ");
		String gen = sc.nextLine().toLowerCase();
		if (gen.equals("male") || gen.equals("female")) {
			studentToBuild.setGender(Gender.valueOf(gen));
		} else {
			throw new IncorrectDataException("Incorrect data");
		}
	}

	public default void idBuilder(Student studentToBuild) throws IncorrectDataException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input student's ID: ");
		if (sc.hasNextInt()) {
			studentToBuild.setId(sc.nextInt());
		} else {
			throw new IncorrectDataException("Incorrect data");
		}

	}
	

}
