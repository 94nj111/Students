package oop.homework3a;

public class Student extends Human implements StudentBuilder{
	
	private int id;
	private String groupName;
	
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
}
