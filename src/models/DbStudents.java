package models; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbStudents {

	private static DbStudents instance = null;

	public static DbStudents getInstance() {
		if (instance == null) {
			instance = new DbStudents();
		}
		return instance;
	}
	
	private List<Student> students;
	private List<String> columns;

	private DbStudents() {	
		initStudents();

		this.columns = new ArrayList<String>();
		this.columns.add("INDEX");
		this.columns.add("IME");
		this.columns.add("PREZIME");
		this.columns.add("GODINA STUDIJA");
		this.columns.add("STATUS");
		this.columns.add("PROSEK");
	}

	@SuppressWarnings("deprecation")
	private void initStudents() {
		this.students = new ArrayList<Student>();
		
		//TODO Citanje iz datoteke
		
		students.add(new Student("Prezimenovic", "Imenko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", 15, "Novi Sad", "Srbija"), "0694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B, 8.71, null, null));
		students.add(new Student("Prezimenovic", "Imenko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", 15, "Novi Sad", "Srbija"), "0694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B, 8.71, null, null));
		students.add(new Student("Prezimenovic", "Imenko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", 15, "Novi Sad", "Srbija"), "0694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B, 8.71, null, null));
		students.add(new Student("Prezimenovic", "Imenko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", 15, "Novi Sad", "Srbija"), "0694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B, 8.71, null, null));
		students.add(new Student("Prezimenovic", "Imenko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", 15, "Novi Sad", "Srbija"), "0694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B, 8.71, null, null));
	}

	public List<Student> getstudents() {
		return students;
	}

//	public void setstudents(List<Student> students) {
//		this.students = students;
//	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.students.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return Integer.toString(student.getCurrentYearOfStudy());
		case 4:
			if(student.getStudentStatus() == StudentStatus.B) {
				return "B";
			}
			else {
				return "S";
			}
		case 5:
			return Double.toString(student.getAverageGrade());
		default:
			return null;
		}
	}

	public void addStudent(String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus) {
		this.students.add(new Student(surname, name, birthDate, adress, phone, email, index,
				enrollmentYear, currentYearOfStudy, studentStatus));
	}

	public void deleteStudent(String index) {
		for (Student i : students) {
			if (i.getIndex() == index) {
				students.remove(i);
				break;
			}
		}
	}

	public void editStudent(String surname, String name, Date birthDate, Adress adress, String phone, String email, String index,
			int enrollmentYear, int currentYearOfStudy, StudentStatus studentStatus, double averageGrade) {
		for (Student i : students) {
			if (i.getIndex() == index) {
				i.setSurname(surname);
				i.setName(name);
				i.setBirthDate(birthDate);
				i.setAdress(adress);
				i.setPhone(phone);
				i.setEmail(email);
				i.setIndex(index);
				i.setEnrollmentYear(enrollmentYear);
				i.setCurrentYearOfStudy(currentYearOfStudy);
				i.setStudentStatus(studentStatus);
				i.setAverageGrade(averageGrade);
			}
		}
	}

}
