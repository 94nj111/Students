package oop.homework3a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Group {

	private String groupName;
	private ArrayList<Student> students = new ArrayList<>(10);

	public void saveCSV() throws IOException {
		GroupFileStorage gfs = new GroupFileStorage();
		gfs.saveGroupToCSV(this);
	}

	public Group(String groupName, ArrayList<Student> students) {
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + students + "]";
	}

	public void addStudent(Student student) throws GroupOverflowException, IncorrectDataException {
		if (!studentFindClone(student)) {
			if (this.students.size() < 10) {
				this.students.add(this.students.size(), student);
				student.setGroupName(getGroupName());
				sortStudentsByLatName();
			} else {
				throw new GroupOverflowException("Group is full");
			}
		} else {
			throw new IncorrectDataException("Same student!");
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (Student element : students) {
			if (element.getLastName().equalsIgnoreCase(lastName)) {
				return element;
			}
		}
		throw new StudentNotFoundException("Student not found");
	}

	public boolean removeStudentByID(int id) {
		for (Student element : students) {
			if (element.getId() == id) {
				return students.remove(element);
			}
		}
		return false;
	}

	public boolean studentFindClone(Student student) throws IncorrectDataException {
		for (Student element : students) {
			if (element.equalsToAdd(student)) {
				return true;
			}
		}
		return false;
	}

	public void sortStudentsByLatName() {
		Collections.sort(students, new StudentLastNameComparator());;
	}
}
