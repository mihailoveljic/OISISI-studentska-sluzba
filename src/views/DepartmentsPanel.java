package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class DepartmentsPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7445536143269536717L;


	private DepartmentsTable departmentsTable;
	private JButton assignHeadOfDepartment;
	private JScrollPane scrollPane;
	
	public DepartmentsPanel() {
			super();
			setLayout(new BorderLayout());
			departmentsTable = new DepartmentsTable();
			scrollPane = new JScrollPane(departmentsTable);
			add(scrollPane, BorderLayout.CENTER);
			JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			assignHeadOfDepartment = new JButton ("Postavi rukovodioca");
			
			assignHeadOfDepartment.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(departmentsTable.getSelectedRow() >= 0 && departmentsTable.getSelectedRow() < departmentsTable.getRowCount()) {
						DepartmentsMainDialog departmentsMainDialog = (DepartmentsMainDialog) getParent().getParent().getParent().getParent();
						JPanel contentPane = (JPanel) departmentsMainDialog.getContentPane();
						DepartmentsPanel departmentsPanel = (DepartmentsPanel) contentPane.getComponent(0);
						DepartmentsAssignHeadDialog departmentsAssignHeadDialog = new DepartmentsAssignHeadDialog(departmentsPanel);
						departmentsAssignHeadDialog.setVisible(true);
					}else {
						JOptionPane.showMessageDialog((DepartmentsMainDialog) getParent().getParent().getParent().getParent(), "Profesor nije selektovan.", "Upozorenje!", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			commandPanel.add(assignHeadOfDepartment);
			add(commandPanel, BorderLayout.NORTH);
	}

	public DepartmentsTable getDepartmentsTable() {
		return departmentsTable;
	}

	public void setDepartmentsTable(DepartmentsTable departmentsTable) {
		this.departmentsTable = departmentsTable;
	}
	
	public void refresh() {
		AbstractTableModelDepartments abstractTableModelDepartments = (AbstractTableModelDepartments)departmentsTable.getModel();
		abstractTableModelDepartments.fireTableDataChanged();
		validate();
		
	}
	
}
