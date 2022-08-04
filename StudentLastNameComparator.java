package oop.homework3a;

import java.util.Comparator;

public class StudentLastNameComparator implements Comparator <Student>{

	public int compare(Student s1, Student s2) {

		String lastName1 = s1.getLastName();
		String lastName2 = s2.getLastName();

		return lastName1.compareToIgnoreCase(lastName2);
	}

}
