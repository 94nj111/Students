package oop.homework3a;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

	private String groupName;
	private Student[] students = new Student[10];

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}

	public void addStudent(Student student) throws GroupOverflowException {
		if (findFreeIndex() != null) {
			student.setGroupName(getGroupName());
			students[findFreeIndex()] = student;
		} else {
			throw new GroupOverflowException("It's full");
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		if (findIndex(lastName) != null) {
			return students[findIndex(lastName)];
		} else {
			throw new StudentNotFoundException("Student not found");
		}
	}

	public boolean removeStudentByID(int id) {
		if (findIndex(id) != null) {
			students[findIndex(id)] = null;
			return true;

		} else {
			return false;
		}
	}

	public Integer findIndex(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getId() == id)
				return i;
		}
		return null;
	}

	public Integer findIndex(String lastName) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(lastName))
				return i;
		}
		return null;
	}

	public Integer findFreeIndex() {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null)
				return i;
		}
		return null;
	}
	
	public void sortStudentsByLatName() {
		Arrays.sort(this.getStudents(), Comparator.nullsLast(new StudentLastNameComparator()));
	}
}
