package display;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Label;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.Box;
import java.awt.Cursor;
import java.awt.SystemColor;

public class SplashScreen {

	private JFrame splashScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen window = new SplashScreen();
					window.splashScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplashScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		splashScreen = new JFrame();
		splashScreen.setForeground(new Color(0, 0, 0));
		splashScreen.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\logo.png"));
		splashScreen.setTitle("Vijay Computer Academy Database Application");
		splashScreen.setBounds(100, 100, 1042, 707);
		splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splashScreen.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		titlePanel.setBackground(new Color(55,97,164));
		splashScreen.getContentPane().add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new MigLayout("", "[14px][][][]", "[grow]"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(new Color(100, 149, 237));
		titlePanel.add(panel, "cell 1 0,grow");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIconTextGap(1);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\VijayComputerDatabase\\resources\\logo.png").getImage().getScaledInstance(75,75,Image.SCALE_SMOOTH)));
		panel.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		titlePanel.add(horizontalStrut, "cell 2 0");
		
		JLabel lblNewLabel_1 = new JLabel("Vijay Computer Academy");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.WHITE);
		titlePanel.add(lblNewLabel_1, "flowy,cell 3 0,alignx center");
		
		JLabel lblNewLabel_2 = new JLabel("Global IT education & training institute since 1990 ");
		lblNewLabel_2.setIconTextGap(0);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		titlePanel.add(lblNewLabel_2, "cell 3 0,alignx center");
		
		JPanel panel_1 = new JPanel();
		splashScreen.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(245, 245, 245));
		panel_1.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new MigLayout("", "[grow,fill][][138.00,grow,fill][][174.00,grow,fill]", "[grow,baseline][][grow,baseline][][grow]"));
		
		
		//Room Reserve Button
		JButton financeButton = new JButton("Room Reservation");
		financeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomRentalWindow fin = new RoomRentalWindow();
				fin.newWindow();
			}
		});
		
		
		//Enrollment Button
		JButton enrollmentButton = new JButton("Student Services");
		buttonPanel.add(enrollmentButton, "cell 0 0,growy");
		enrollmentButton.setPreferredSize(new Dimension(50, 50));
		enrollmentButton.setForeground(new Color(255, 255, 255));
		enrollmentButton.setBackground(new Color(51, 153, 204));
		enrollmentButton.setFont(new Font("Verdana", Font.BOLD, 21));
		enrollmentButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		enrollmentButton.setIconTextGap(15);
		enrollmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollmentWindow enroll = new EnrollmentWindow();
				enroll.newScreen();
			}
		});
		enrollmentButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\VijayComputerDatabase\\resources\\student.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		buttonPanel.add(horizontalStrut_1, "cell 1 0");
		
		JButton btnCertificationCenter = new JButton("Certification Center");
		btnCertificationCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				certificationWindow certWin = new certificationWindow();
				certWin.createWindow();
			}
		});
		btnCertificationCenter.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\cert.png").getImage().getScaledInstance(45,45,Image.SCALE_SMOOTH)));
		btnCertificationCenter.setPreferredSize(new Dimension(25, 25));
		btnCertificationCenter.setIconTextGap(15);
		btnCertificationCenter.setForeground(Color.WHITE);
		btnCertificationCenter.setFont(new Font("Verdana", Font.BOLD, 21));
		btnCertificationCenter.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnCertificationCenter.setBackground(new Color(51, 153, 204));
		buttonPanel.add(btnCertificationCenter, "cell 2 0,grow");
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(5);
		buttonPanel.add(horizontalStrut_1_1, "cell 3 0");
		
		//Employee Services
		JButton employeeSButton = new JButton("Employee Services");
		buttonPanel.add(employeeSButton, "cell 4 0,grow");
		employeeSButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\employee.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		employeeSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeServicesWindow esw = new EmployeeServicesWindow();
				esw.createWindow();
			}
		});
		employeeSButton.setIconTextGap(15);
		employeeSButton.setForeground(new Color(255, 255, 255));
		employeeSButton.setBackground(new Color(51, 153, 204));
		employeeSButton.setFont(new Font("Verdana", Font.BOLD, 18));
		employeeSButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		
		//Calendar Button
		JButton calendarButton = new JButton("Calendar");
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarWindow calWin = new CalendarWindow();
				calWin.newScreen();
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		buttonPanel.add(verticalStrut, "cell 0 1");
		calendarButton.setIconTextGap(15);
		calendarButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\calendar.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		calendarButton.setForeground(new Color(255, 255, 255));
		calendarButton.setBackground(new Color(51, 153, 204));
		calendarButton.setFont(new Font("Verdana", Font.BOLD, 21));
		calendarButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		calendarButton.setPreferredSize(new Dimension(25, 25));
		buttonPanel.add(calendarButton, "cell 0 2,grow");
		financeButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\classroom.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		financeButton.setIconTextGap(15);
		financeButton.setForeground(new Color(255, 255, 255));
		financeButton.setBackground(new Color(51, 153, 204));
		financeButton.setFont(new Font("Verdana", Font.BOLD, 21));
		financeButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		financeButton.setPreferredSize(new Dimension(25, 25));
		buttonPanel.add(financeButton, "cell 2 2,grow");
		
		//Directory Button
		JButton directoryButton = new JButton("Directory");
		directoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DirectoryWindow dir = new DirectoryWindow();
				dir.createWindow();
			}
		});
		directoryButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\book.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		directoryButton.setIconTextGap(15);
		directoryButton.setForeground(new Color(255, 255, 255));
		directoryButton.setBackground(new Color(51, 153, 204));
		directoryButton.setFont(new Font("Verdana", Font.BOLD, 21));
		directoryButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		directoryButton.setPreferredSize(new Dimension(25, 25));
		buttonPanel.add(directoryButton, "cell 4 2,grow");
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		buttonPanel.add(verticalStrut_1, "cell 0 3");
		
		
		//Equipment Button
		JButton equipmentButton = new JButton("Equipment");
		buttonPanel.add(equipmentButton, "cell 2 4,growy");
		equipmentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipmentWindow equWin = new EquipmentWindow();
				equWin.createWindow();
			}
		});
		equipmentButton.setIcon(new ImageIcon(new ImageIcon("VijayComputerDatabase\\\\VijayComputerDatabase\\resources\\laptop.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH)));
		equipmentButton.setIconTextGap(15);
		equipmentButton.setForeground(new Color(255, 255, 255));
		equipmentButton.setBackground(new Color(51, 153, 204));
		equipmentButton.setFont(new Font("Verdana", Font.BOLD, 21));
		equipmentButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		equipmentButton.setPreferredSize(new Dimension(25, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setVgap(10);
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(245, 245, 245));

		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setHgap(25);
		panel_1.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(245, 245, 245));
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setHgap(25);
		panel_1.add(panel_7, BorderLayout.EAST);
		
		
		//Menu Bar
		JMenuBar menuBar = new JMenuBar();
		splashScreen.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem exitNM = new JMenuItem("Exit");
		exitNM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem signOutNM = new JMenuItem("Sign Out");
		signOutNM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splashScreen.dispose();
				MainScreen login = new MainScreen();
				login.newWindow();
				
			}
		});
		mnNewMenu.add(signOutNM);
		mnNewMenu.add(exitNM);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem helpNM = new JMenuItem("Contact Red Cougar Data");
		helpNM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpTicket help = new helpTicket();
				helpTicket.newScreen();
			}
		});
		mnNewMenu_1.add(helpNM);
		
	}

}
