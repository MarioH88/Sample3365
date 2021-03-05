package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class classWindow {

	private JFrame frmStudentView;
	private JTable classTable;
	private DefaultTableModel classModel;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					classWindow window = new classWindow();
					window.frmStudentView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public classWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentView = new JFrame();
		frmStudentView.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\user.png"));
		frmStudentView.setTitle("VCA - Class View");
		frmStudentView.setBounds(100, 100, 735, 522);
		frmStudentView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStudentView.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 102));
		frmStudentView.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		panel_2.add(verticalStrut);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 255, 102));
		frmStudentView.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[grow]", "[23px,grow]"));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "cell 0 0,alignx center,growy");
		
		JLabel lblNewLabel = new JLabel("Class Options:");
		panel_5.add(lblNewLabel);
		
		JButton newStudBut = new JButton("New Class");
		panel_5.add(newStudBut);
		
		JButton btnEditSelected = new JButton("Edit Class");
		panel_5.add(btnEditSelected);
		btnEditSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editClassDialog eClass = new editClassDialog();
				eClass.newWindow();
			}
		});
		newStudBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateClass cl = new CreateClass();
				cl.newWindow();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmStudentView.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		classTable = new JTable();
		scrollPane.setViewportView(classTable);
		classTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		classModel =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Section #", "Course Name", "Class Type", "Room #", "Employee Full Name", "Time Start", "Time End", "Class Date Start", "Class End Date"
			}
		);
		classTable.setModel(classModel);

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			String sql = "SELECT Class.ClassSection, Course.CourseName, ClassType.ClassType, Room.RoomNum, Employee.FirstName + ' ' + Employee.LastName as EmployeeName, Class.ClassTimeStart, Class.ClassTimeEnd, Class.ClassStartDate, Class.ClassEndDate"
					+ " FROM Class INNER JOIN"
					+ " ClassType ON Class.ClassTypeID = ClassType.ClassTypeID INNER JOIN"
					+ " Employee ON Class.EmployeeID = Employee.EmployeeID INNER JOIN"
					+ " RoomReserve ON Class.RoomReserveID = RoomReserve.RoomReserveID INNER JOIN"
					+ " Room ON RoomReserve.RoomID = Room.RoomID INNER JOIN"
					+ " Course ON Class.CourseID = Course.CourseID";
			PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while(rs.next())
	        {
	            String a = rs.getString("ClassSection");
	            String b = rs.getString("CourseName");
	            String c = rs.getString("ClassType");
	            String d = rs.getString("RoomNum");
	            String e = rs.getString("EmployeeName");
	            String f = rs.getString("ClassTimeStart");
	            String f1 = rs.getString("ClassTimeEnd");
	            String g = rs.getString("ClassStartDate");
	            String g1 = rs.getString("ClassEndDate");

	            classModel.addRow(new Object[]{a, b, c, d, e, f,f1,g,g1});
	        }

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
		
		
		
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 255, 102));
		frmStudentView.getContentPane().add(panel_3, BorderLayout.WEST);
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		panel_3.add(horizontalStrut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 255, 102));
		frmStudentView.getContentPane().add(panel_4, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		panel_4.add(horizontalStrut_1);
		
		JMenuBar menuBar = new JMenuBar();
		frmStudentView.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("File");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Print");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mnNewMenu_1.add(mntmNewMenuItem_1);
	}

}
