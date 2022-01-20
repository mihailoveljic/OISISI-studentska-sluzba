package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


import models.DbDepartments;
import models.DbProfessors;
import models.DbStudents;
import models.DbSubjects;
import models.Department;
import models.Professor;
import models.Student;
import models.Subject;

public class  WriterReader {
	
	private static WriterReader instance = null;
	
	@SuppressWarnings("unchecked")
	public void LoadData() {
		try {

			List<Subject> subjects = new ArrayList<>();
			List<Professor> professors = new ArrayList<>();
			List<Department> departments = new ArrayList<>();
			List<Student> students = new ArrayList<>();

		    //Read Student array from file.
		    FileInputStream fis = new FileInputStream("Data" + File.separator + "studentska_sluzba.dat");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    subjects = (List<Subject>) ois.readObject();
		    professors = (List<Professor>) ois.readObject();
		    departments = (List<Department>) ois.readObject();
		    students = (List<Student>) ois.readObject();
		    ois.close();
		    
		    
		    DbSubjects.getInstance().setSubjects(subjects);
		    DbProfessors.getInstance().setProfessors(professors);
		    DbDepartments.getInstance().setDepartments(departments);
		    DbStudents.getInstance().setStudents(students);
		    
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
	}
	
	public void SaveData() {
		try {

			List<Subject> subjects = DbSubjects.getInstance().getSubjects();
			List<Professor> professors = DbProfessors.getInstance().getProfessors();
			List<Department> departments = DbDepartments.getInstance().getDeparments();
			List<Student> students = DbStudents.getInstance().getStudents();

		    //Write Student array to file.
		    FileOutputStream fos = new FileOutputStream("Data" + File.separator + "studentska_sluzba.dat");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(subjects);
		    oos.writeObject(professors);
		    oos.writeObject(departments);
		    oos.writeObject(students);
		    oos.close();
		}
		catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static WriterReader getInstance() {
		if(instance == null)
			return new WriterReader();
		return instance;
	}
}
