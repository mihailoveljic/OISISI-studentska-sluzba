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
		
		students.add(new Student("Petrovic", "Petar", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RA12/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Stefanovic", "Mirko", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RA21/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Jovanovic", "Jovan", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "II12/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Blazic", "Drago", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "II21/2020", 2020, 2, StudentStatus.B));
		students.add(new Student("Dragoljevic", "Stevanka", new Date(2000, 5, 16),
				new Adress("Tolstojeva", "15", "Novi Sad", "Srbija"), "+381694732572",
				"imenkoprezimenovic@gmail.com", "RI22/2020", 2020, 2, StudentStatus.B));
		
		students.get(0).getGrades().add(new Grade(students.get(0), new Subject("1", "MATEMATICKA ANALIZA 1",Semester.ZIMSKI, 1, 1000), 9, new Date(2000-1900, 5, 12)));
		students.get(0).getGrades().add(new Grade(students.get(0), new Subject("9", "SPPURV1",Semester.ZIMSKI, 1, 1000), 7, new Date(2000-1900, 5, 12)));
		students.get(0).getGrades().add(new Grade(students.get(0), new Subject("10", "OISISI",Semester.ZIMSKI, 1, 1000), 10, new Date(2000-1900, 5, 12)));
		
		//String id, String name, Semester semester, int yearOfStudy, int eSPB
		students.get(0).getSubjects().add(new Subject("3", "Web Programiranje", Semester.LETNJI, 3, 8));

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
				List<Subject> subjects = i.getSubjects();
				if(subjects != null) {
					for(Subject s : subjects) {
						s.removeStudentFromListOfFailed(i);
					}
				}
				List<Grade> grades = i.getGrades();
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
