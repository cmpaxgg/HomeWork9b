package com.gmail.cmpaxgg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Voenkom, Serializable {
	private static final long serialVersionUID = 1L;
	private String groupName;
	List<Student> group = new ArrayList<>();

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStudent(Student student) throws MyException {
		if (student == null) {
			throw new IllegalArgumentException("Null student");
		}
		if (group.size() >= 10) {
			throw new MyException();
		}
		group.add(student);
	}

	public Student searchStudent(String lastname) {
		for (Student student : group) {
			if (student.getLastname().equals(lastname)) {
				return student;
			}
		}
		return null;
	}

	public void deleteStudent(String s) {
		for (Iterator<Student> iterator = group.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			if (student.getLastname().equals(s)) {
				iterator.remove();
			}

		}
	}

	public void sortStudentByName() {
		group.sort((a, b) -> {
			if (a == null && b != null) {
				return -1;
			}
			if (a != null && b == null) {
				return 1;
			}
			if (a == null && b == null) {
				return 0;
			} else {
				return a.getName().compareTo(b.getName());
			}
		});
	}

	public void sortStudentByLastName() {
		group.sort((a, b) -> {
			if (a == null && b != null) {
				return -1;
			}
			if (a != null && b == null) {
				return 1;
			}
			if (a == null && b == null) {
				return 0;
			} else {
				return a.getLastname().compareTo(b.getLastname());
			}
		});
	}

	@Override
	public List<Student> getSpecnaz() {
		List<Student> soldiers = new ArrayList<>();
		Iterator<Student> iterator = group.iterator();
		Student temp;
		for (; iterator.hasNext();) {
			temp = iterator.next();
			if (temp.isSex() && temp.getAge() >= 18) {
				soldiers.add(temp);
			}
		}

		return soldiers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Student student : group) {
			if (student != null) {
				sb.append((++i) + ": ").append(student);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
