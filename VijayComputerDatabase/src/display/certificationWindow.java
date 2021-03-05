package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

public class certificationWindow {

	private JFrame frmVcaCertification;
	private JTable empCertTable;
	private JTable stuCertTable;
	private DefaultTableModel stuCertModel;
	private DefaultTableModel empCertModel;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					certificationWindow window = new certificationWindow();
					window.frmVcaCertification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public certificationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCertification = new JFrame();
		frmVcaCertification.setTitle("VCA - Certification Center");
		frmVcaCertification.setBounds(100, 100, 695, 446);
		frmVcaCertification.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCertification.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 0));
		frmVcaCertification.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][]"));
		
		JLabel lblCertificationPortal = new JLabel("Certification Portal");
		panel.add(lblCertificationPortal, "cell 0 0,alignx center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_6, "cell 0 1,grow");
		panel_6.setLayout(new MigLayout("", "[89px,grow]", "[23px][]"));
		
		JButton btnNewButton_2 = new JButton("New Certification");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCertification cC = new createCertification();
				cC.createWindow();
			}
		});
		panel_6.add(btnNewButton_2, "cell 0 0,alignx center,aligny top");
		
		JButton btnNewButton_2_1 = new JButton("Edit Certification");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editCertificationDialog eCert = new editCertificationDialog();
				eCert.newWindow();
				
			}
		});
		panel_6.add(btnNewButton_2_1, "cell 0 1,alignx center");
		
		JLabel lblNewLabel = new JLabel("Employee Certifications");
		panel.add(lblNewLabel, "cell 0 3,alignx center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5, "cell 0 4,alignx center,growy");
		panel_5.setLayout(new MigLayout("", "[89px]", "[23px][]"));
		
		JButton btnNewButton = new JButton("Assign Employee Cert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createEmpCertification eC = new createEmpCertification();
				eC.createWindow();
			}
		});
		panel_5.add(btnNewButton, "cell 0 0,alignx center,aligny top");
		
		JButton btnNewButton_1 = new JButton("Edit Employee Cert");
		panel_5.add(btnNewButton_1, "cell 0 1,alignx center,aligny top");
		
		JLabel lblStudentCertifications = new JLabel("Student Certifications");
		panel.add(lblStudentCertifications, "cell 0 6,alignx center");
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5_1, "cell 0 7,alignx center,growy");
		panel_5_1.setLayout(new MigLayout("", "[]", "[][]"));
		
		JButton btnNewButton_1_1 = new JButton("Assign Student Cert");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createStudCertification studC = new createStudCertification();
				studC.createWindow();
			}
		});
		panel_5_1.add(btnNewButton_1_1, "cell 0 0,alignx center");
		
		JButton btnNewButton_1_2 = new JButton("Edit Student Cert");
		panel_5_1.add(btnNewButton_1_2, "cell 0 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 0));
		frmVcaCertification.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 0));
		frmVcaCertification.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 0));
		frmVcaCertification.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 0));
		frmVcaCertification.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_8, "cell 0 0,grow");
		panel_8.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Student Certifications");
		panel_8.add(lblNewLabel_2, "cell 0 0,alignx center");
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, "cell 0 1,grow");
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane);
		
		stuCertTable = new JTable();
		
		stuCertModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Certification Name", "Student ID", "Student Name", "Expected Completion Date"
			}
		);
		stuCertTable.setModel(stuCertModel);
		stuCertTable.getColumnModel().getColumn(0).setPreferredWidth(105);
		stuCertTable.getColumnModel().getColumn(2).setPreferredWidth(127);
		stuCertTable.getColumnModel().getColumn(3).setPreferredWidth(145);
		scrollPane.setViewportView(stuCertTable);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_7, "cell 0 1,grow");
		panel_7.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Employee Certifications");
		panel_7.add(lblNewLabel_1, "cell 0 0,alignx center");
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, "cell 0 1,grow");
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_9.add(scrollPane_1);
		
		empCertTable = new JTable();
		empCertModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Certification Name", "Employee ID", "Employee Name", "Employee Certification Date"
			}
		);
		empCertTable.setModel(empCertModel);
		empCertTable.getColumnModel().getColumn(0).setPreferredWidth(104);
		empCertTable.getColumnModel().getColumn(2).setPreferredWidth(89);
		empCertTable.getColumnModel().getColumn(3).setPreferredWidth(148);
		scrollPane_1.setViewportView(empCertTable);
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			String sql = "SELECT Certification.CertName, StuCompCert.StudentID,(Student.FirstName+' '+ Student.LastName) as StuName, StuCompCert.StuCertDate"
					+ " FROM StuCompCert INNER JOIN"
					+ " Certification ON StuCompCert.CertID = Certification.CertID INNER JOIN"
					+ " Student ON StuCompCert.StudentID = Student.StudentID";
			PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while(rs.next())
	        {
	            String a = rs.getString("CertName");
	            String b = rs.getString("StudentID");
	            String c = rs.getString("StuName");
	            String d = rs.getString("StuCertDate");

	            stuCertModel.addRow(new Object[]{a, b, c, d});
	        }

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			String sql = "SELECT Certification.CertName, StuCompCert.StudentID,(Student.FirstName+' '+ Student.LastName) as StuName, StuCompCert.StuCertDate"
					+ " FROM StuCompCert INNER JOIN"
					+ " Certification ON StuCompCert.CertID = Certification.CertID INNER JOIN"
					+ " Student ON StuCompCert.StudentID = Student.StudentID";
			PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while(rs.next())
	        {
	            String a = rs.getString("CertName");
	            String b = rs.getString("StudentID");
	            String c = rs.getString("StuName");
	            String d = rs.getString("StuCertDate");

	            empCertModel.addRow(new Object[]{a, b, c, d});
	        }

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}

}
