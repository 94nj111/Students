package oop.homework3a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) throws IOException {
		File list = new File(gr.getGroupName() + ".csv");
		list.createNewFile();
		String toSave = "";
		Student[] arr = gr.getStudents();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				toSave += arr[i].getGroupName() + ";" + arr[i].getId() + ";" + arr[i].getLastName() + ";"
						+ arr[i].getName() + ";" + arr[i].getGender() + System.lineSeparator();
			}
		}
		OutputStream os = new FileOutputStream(list);
		byte[] bytes = toSave.getBytes();
		os.write(bytes);
	}

	public Group loadGroupFromCSV(File file) throws IOException, GroupOverflowException {
		Group read = new Group();
		read.setGroupName(file.getName().substring(0, file.getName().indexOf(".")));
		Scanner sc = new Scanner(file);
		for (int j = 0; sc.hasNextLine(); j++) {
			Student student = new Student();
			student = fromString(sc.nextLine());
			read.addStudent(student);
		}
		return read;
	}
	
	public Student fromString (String str) {
		Student student = new Student();
		String[] arr = str.split(";");
		student.setGroupName(arr[0]);
		student.setId(Integer.valueOf(arr[1]));
		student.setLastName(arr[2]);
		student.setName(arr[3]);
		student.setGender(Gender.valueOf(arr[4]));
		return student;
	}

	public File findFileByGroupName(String groupName, File workFolder) throws FileNotFoundException {
		File[] search = workFolder.listFiles();
		String name = groupName + ".csv";
		for (int i = 0; i < search.length; i++) {
			if (search[i].getName().equalsIgnoreCase(name)) {
				return search[i];
			}
		}
		throw new FileNotFoundException("File not found");
	}

}
