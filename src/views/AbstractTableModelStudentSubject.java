package views;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Subject;
import models.Semester;
import models.Student;
import models.DbStudents;


@SuppressWarnings("serial")
public class AbstractTableModelStudentSubject extends AbstractTableModel {

		Student s = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0));
		@Override
		public int getRowCount() {
			if(s.getSubjects()!=null) {
			return s.getSubjects().size();
			} else return 0;
		}

		@Override
		public int getColumnCount() {
			return 5;
		}
		
		@Override
		public String getColumnName(int column) {
			switch(column)
			{
				case 0:
				{
					return MainFrame.getInstance().getResourceBundle().getString("subjectId");
				}
				case 1:
				{
					return MainFrame.getInstance().getResourceBundle().getString("subjectName");
				}
				case 2:
				{
					return MainFrame.getInstance().getResourceBundle().getString("espb");
				}
				case 3:
				{
					return MainFrame.getInstance().getResourceBundle().getString("yearOfStudy");
				}
				case 4:
				{
					return MainFrame.getInstance().getResourceBundle().getString("semester");
				}
				default:
					return null;
			
			}
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			List<Subject> list= s.getSubjects();
			Subject subject = list.get(rowIndex);
			switch(columnIndex)
			{
				case 0:
				{
					return subject.getId();
				}
				case 1:
				{
					return subject.getName();
				}
				case 2:
				{
					return Integer.toString(subject.getESPB());
				}
				case 3:
				{
					return Integer.toString(subject.getYearOfStudy());
				}
				case 4:
				{
					if(subject.getSemester()==Semester.LETNJI) return MainFrame.getInstance().getResourceBundle().getString("summer");
					else return MainFrame.getInstance().getResourceBundle().getString("winter");
				}
				default:
					return null;
			
			}
		}

		public void updateStudent() {
			s = DbStudents.getInstance().findStudentByIndex((String) StudentTable.getInstance().getValueAt(StudentTable.getInstance().getSelectedRow(), 0));
		}


}
