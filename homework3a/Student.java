package oop.homework3a;

import java.util.Objects;

public class Student extends Human {

	private int id;
	private String groupName;
	private StudentBuilder sb = new StudentBuilder();
	


	public void build() throws IncorrectDataException {
		sb.buildStudent(this);
	}
	
	public void build(Group group) throws IncorrectDataException, GroupOverflowException {
		sb.buildStudent(this, group);
	}

	public Student(int id, String groupName) {
		super();
		this.id = id;
		this.groupName = groupName;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + groupName + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(groupName, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(groupName, other.groupName) && id == other.id && super.equals(obj);
	}
	
	
}
