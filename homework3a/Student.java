package oop.homework3a;

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
}
