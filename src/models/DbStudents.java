package models; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
		
		students.add(new Student("Prezimenovic1", "Imenko1", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RA12/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Prezimenovic2", "Imenko2", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RA21/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Prezimenovic3", "Imenko3", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Prezimenovic4", "Imenko4", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "II21/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Prezimenovic5", "Imenko5", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RI22/2020", 2020, 2, StudentStatus.B));
	}

	public List<Student> getStudents() {
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
		if(rowIndex <= -1)
			return null;
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
			if(student.getAverageGrade() == 0.0)
				return " ";
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
				Set<Subject> subjects = i.getSubjects();
				if(subjects != null) {
					for(Subject s : subjects) {
						s.removeStudentFromListOfFailed(i);
					}
				}
				Set<Grade> grades = i.getGrades();
				if(grades != null) {
					for(Grade g : grades) {
						g.getSubject().removeStudentFromListOfPassed(i);
					}
				}
				
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
