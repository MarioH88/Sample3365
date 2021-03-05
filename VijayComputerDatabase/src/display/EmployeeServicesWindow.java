package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class EmployeeServicesWindow {

	private JFrame frmVcaEmployee;
	private JTable empTable;
	private DefaultTableModel empModel;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeServicesWindow window = new EmployeeServicesWindow();
					window.frmVcaEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeServicesWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaEmployee = new JFrame();
		frmVcaEmployee.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\skills.png"));
		frmVcaEmployee.setTitle("VCA - Employee Services");
		frmVcaEmployee.setBounds(100, 100, 715, 345);
		frmVcaEmployee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaEmployee.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		frmVcaEmployee.getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Sort by status:");
		panel_7.add(lblNewLabel_2);
		
		JComboBox statuscomboBox = new JComboBox();
		panel_7.add(statuscomboBox);
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT Status FROM EmployeeStatus";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         statuscomboBox.addItem(s);

	        }
	        statuscomboBox.addItem("All");
	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empModel.setRowCount(0);
				
				
				try {
					String sql = "";
					if(statuscomboBox.getSelectedItem().toString().equals("All"))
					{
						sql= "SELECT DISTINCT EmployeeStatus.Status,Employee.EmployeeID, Employee.FirstName, Employee.MiddleInitial, Employee.LastName, EmployeeType.EmpTypeName FROM EmpCert INNER JOIN "+
		                         " Employee ON EmpCert.EmpID = Employee.EmployeeID INNER JOIN "+
		                         " EmployeeStatus ON Employee.EmployeeStatusID = EmployeeStatus.EmpStatusID INNER JOIN EmployeeType ON Employee.EmployeeTypeID = EmployeeType.TypeID "
		                         + " ORDER BY EmployeeID ASC ";
					}
					else
					{
						sql= "SELECT DISTINCT EmployeeStatus.Status,Employee.EmployeeID, Employee.FirstName, Employee.MiddleInitial, Employee.LastName, EmployeeType.EmpTypeName FROM EmpCert INNER JOIN "+
					                         " Employee ON EmpCert.EmpID = Employee.EmployeeID INNER JOIN "+
					                         " EmployeeStatus ON Employee.EmployeeStatusID = EmployeeStatus.EmpStatusID INNER JOIN EmployeeType ON Employee.EmployeeTypeID = EmployeeType.TypeID "
					                         + " WHERE EmployeeStatus.Status = '"+statuscomboBox.getSelectedItem().toString()+"'  ORDER BY EmployeeID ASC ";
					}
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
					PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("Status");
			            String b = rs.getString("EmployeeID");
			            String c = rs.getString("FirstName");
			            String d = rs.getString("MiddleInitial");
			            String e = rs.getString("LastName");
			            String f = rs.getString("EmpTypeName");

			            empModel.addRow(new Object[]{a, b, c, d,e,f});
			        }

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		panel_7.add(okButton);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 182, 193));
		frmVcaEmployee.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frmVcaEmployee.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		empTable = new JTable();
		empModel =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STATUS", "Employee ID", "First Name", "Middle Initial", "Last Name", "Employee Type"
			}
		);
		empTable.setModel(empModel);
		empTable.getColumnModel().getColumn(5).setPreferredWidth(83);
		scrollPane.setViewportView(empTable);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 182, 193));
		frmVcaEmployee.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new MigLayout("", "[137.00,left]", "[][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Employee Services:");
		panel_3.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_6, "flowx,cell 0 1,alignx center,aligny center");
		panel_6.setLayout(new MigLayout("", "[75px]", "[23px][]"));
		
		JButton btnNewButton_3 = new JButton("Finances");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FinanceWindow fin = new FinanceWindow();
				fin.createWindow();
			}
		});
		panel_6.add(btnNewButton_3, "flowy,cell 0 0,alignx center,aligny center");
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut, "cell 0 2");
		
		JLabel lblNewLabel = new JLabel("Employee Portal:");
		panel_3.add(lblNewLabel, "cell 0 3,alignx center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_5, "cell 0 4,growx,aligny center");
		panel_5.setLayout(new MigLayout("", "[115px]", "[23px][]"));
		
		JButton btnNewButton_1 = new JButton("Create Employee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateEmployee cEmp = new CreateEmployee();
				cEmp.newWindow();
			}
		});
		panel_5.add(btnNewButton_1, "cell 0 0,alignx left,aligny top");
		
		JButton btnNewButton_2 = new JButton("Edit Employees");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editEmployeeDialog lucifer = new editEmployeeDialog();
				lucifer.newWindow();
			}
		});
		panel_5.add(btnNewButton_2, "cell 0 1,alignx center,aligny center");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 182, 193));
		frmVcaEmployee.getContentPane().add(panel_4, BorderLayout.EAST);
		
		JMenuBar menuBar = new JMenuBar();
		frmVcaEmployee.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

	}

}
