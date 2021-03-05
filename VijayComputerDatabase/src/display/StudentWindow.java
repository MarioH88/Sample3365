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

public class StudentWindow {

	private JFrame frmStudentView;
	private JTable studentTable;

	/**
	 * Launch the application.
	 */
	public static void studWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWindow window = new StudentWindow();
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
	public StudentWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentView = new JFrame();
		frmStudentView.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\user.png"));
		frmStudentView.setTitle("Student View");
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
		
		JLabel lblNewLabel = new JLabel("Student Options:");
		panel_5.add(lblNewLabel);
		
		JButton newStudBut = new JButton("New Student");
		panel_5.add(newStudBut);
		
		JButton btnEditSelected = new JButton("Edit Student");
		panel_5.add(btnEditSelected);
		btnEditSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editStudentDialog eStud = new editStudentDialog();
				eStud.newWindow();
			}
		});
		newStudBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateStudent stud = new CreateStudent();
				stud.createStud();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmStudentView.getContentPane().add(panel_1);
		DefaultTableModel studModel =new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Student ID", "First Name", "Last Name", "Email", "DOB"
				}

			);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		studentTable = new JTable();
		scrollPane.setViewportView(studentTable);
		studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentTable.setModel(studModel);
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			String sql = "SELECT Student.StudentID, Student.FirstName, Student.LastName, Student.Email, Student.DOB"
					+ " FROM Student ORDER BY Student.StudentID";
			PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while(rs.next())
	        {
	            String a = rs.getString("StudentID");
	            String b = rs.getString("FirstName");
	            String c = rs.getString("LastName");
	            String d = rs.getString("Email");
	            String e = rs.getString("DOB");

	            studModel.addRow(new Object[]{a, b, c, d, e});
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
		
		JMenu mnNewMenu = new JMenu("Select / View");
		menuBar.add(mnNewMenu);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Student ID");
		rdbtnmntmNewRadioItem.setSelected(true);
		mnNewMenu.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmFirstName = new JRadioButtonMenuItem("First Name");
		rdbtnmntmFirstName.setSelected(true);
		mnNewMenu.add(rdbtnmntmFirstName);
		
		JRadioButtonMenuItem rdbtnmntmLastName = new JRadioButtonMenuItem("Last Name");
		rdbtnmntmLastName.setSelected(true);
		mnNewMenu.add(rdbtnmntmLastName);
		
		JRadioButtonMenuItem rdbtnmntmMiddleInital = new JRadioButtonMenuItem("Middle Inital");
		rdbtnmntmMiddleInital.setSelected(true);
		mnNewMenu.add(rdbtnmntmMiddleInital);
		
		JRadioButtonMenuItem rdbtnmntmHomePhone = new JRadioButtonMenuItem("Home Phone");
		rdbtnmntmHomePhone.setSelected(true);
		mnNewMenu.add(rdbtnmntmHomePhone);
		
		JRadioButtonMenuItem rdbtnmntmMobilePhone = new JRadioButtonMenuItem("Mobile Phone");
		rdbtnmntmMobilePhone.setSelected(true);
		mnNewMenu.add(rdbtnmntmMobilePhone);
		
		JRadioButtonMenuItem rdbtnmntmEmail = new JRadioButtonMenuItem("Email");
		rdbtnmntmEmail.setSelected(true);
		mnNewMenu.add(rdbtnmntmEmail);
		
		JRadioButtonMenuItem rdbtnmntmGender = new JRadioButtonMenuItem("Gender");
		rdbtnmntmGender.setSelected(true);
		mnNewMenu.add(rdbtnmntmGender);
		
		JRadioButtonMenuItem rdbtnmntmDateOfBirth = new JRadioButtonMenuItem("Date of Birth");
		rdbtnmntmDateOfBirth.setSelected(true);
		mnNewMenu.add(rdbtnmntmDateOfBirth);
		
		JRadioButtonMenuItem rdbtnmntmAddressNum = new JRadioButtonMenuItem("Address Num");
		rdbtnmntmAddressNum.setSelected(true);
		mnNewMenu.add(rdbtnmntmAddressNum);
		
		JRadioButtonMenuItem rdbtnmntmAddressStreet = new JRadioButtonMenuItem("Address Street");
		rdbtnmntmAddressStreet.setSelected(true);
		mnNewMenu.add(rdbtnmntmAddressStreet);
		
		JRadioButtonMenuItem rdbtnmntmPostalCode = new JRadioButtonMenuItem("Postal Code");
		rdbtnmntmPostalCode.setSelected(true);
		mnNewMenu.add(rdbtnmntmPostalCode);
		
		JRadioButtonMenuItem rdbtnmntmCity = new JRadioButtonMenuItem("City");
		rdbtnmntmCity.setSelected(true);
		mnNewMenu.add(rdbtnmntmCity);
		
		JRadioButtonMenuItem rdbtnmntmState = new JRadioButtonMenuItem("State");
		rdbtnmntmState.setSelected(true);
		mnNewMenu.add(rdbtnmntmState);
		
		JRadioButtonMenuItem rdbtnmntmCountry = new JRadioButtonMenuItem("Country");
		rdbtnmntmCountry.setSelected(true);
		mnNewMenu.add(rdbtnmntmCountry);
		
		JRadioButtonMenuItem rdbtnmntmFacebook = new JRadioButtonMenuItem("Facebook");
		rdbtnmntmFacebook.setSelected(true);
		mnNewMenu.add(rdbtnmntmFacebook);
		
		JRadioButtonMenuItem rdbtnmntmInstagram = new JRadioButtonMenuItem("Instagram");
		rdbtnmntmInstagram.setSelected(true);
		mnNewMenu.add(rdbtnmntmInstagram);
		
		JRadioButtonMenuItem rdbtnmntmTwitter = new JRadioButtonMenuItem("Twitter");
		rdbtnmntmTwitter.setSelected(true);
		mnNewMenu.add(rdbtnmntmTwitter);
	}

}
