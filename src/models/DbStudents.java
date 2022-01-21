package models; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import views.MainFrame;

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
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("indexNumber"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("name"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("surname"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("currentYearOfStudy"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("finanseWay"));
		this.columns.add(MainFrame.getInstance().getResourceBundle().getString("avgGrades"));
	}

	private void initStudents() {
		this.students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return students;
	}

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

	public void setStudents(List<Student> students) {
		this.students = students;
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

	public Student findStudentByIndex(String index) {
		for(Student s : students) {
			if(s.getIndex().equals(index))
				return s;
		}
		return null;
	}
}
