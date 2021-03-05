package display;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;

import java.awt.Adjustable;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.CreateStudent.DateLabelFormatter;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.CardLayout;


public class CalendarWindow {

	private JFrame frmCalendar;

	private JDatePickerImpl dateField;
	private JTable classTable;
	private JTable annTable;
	private JTable empBirthTable;
	private JPanel classPanel;
	private JPanel annPanel;
	private JPanel birthPanel;
	private DefaultTableModel classModel;
	private DefaultTableModel annModel;
	JPanel holderPanel;
	private DefaultTableModel empModel;
	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarWindow window = new CalendarWindow();
					window.frmCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalendarWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalendar = new JFrame();
		frmCalendar.setBackground(new Color(153, 204, 255));
		frmCalendar.getContentPane().setBackground(new Color(255, 204, 204));
		frmCalendar.setTitle("VCA - Calendar");
		frmCalendar.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\googlecalendar.png"));
		frmCalendar.setBounds(100, 100, 1137, 530);
		frmCalendar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmCalendar.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_4);
		frmCalendar.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 204, 255));
		frmCalendar.getContentPane().add(panel_5, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		panel_5.add(verticalStrut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 204, 255));
		frmCalendar.getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		panel_4.add(verticalStrut_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 204, 255));
		frmCalendar.getContentPane().add(panel_3, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		panel_3.add(horizontalStrut);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		frmCalendar.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][]"));
	    UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel2 = new JDatePanelImpl(model, p);
	    
	    JLabel lblNewLabel_2 = new JLabel("Announcement Center");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
	    panel.add(lblNewLabel_2, "cell 0 0,alignx center,aligny center");
	    
	    Component verticalStrut_2 = Box.createVerticalStrut(20);
	    panel.add(verticalStrut_2, "cell 0 2");
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Calendar Options");
	    lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	    panel.add(lblNewLabel_2_1, "cell 0 3,alignx center");
	    
	    JPanel panel_6 = new JPanel();
	    panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panel.add(panel_6, "cell 0 4,grow");
	    panel_6.setLayout(new MigLayout("", "[]", "[][][][][]"));
	    
	    JLabel lblNewLabel = new JLabel("Select Date:");
	    panel_6.add(lblNewLabel, "cell 0 0,alignx center");
	    
	    JPanel datePanel = new JPanel();
	    panel_6.add(datePanel, "cell 0 1");
	    datePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	    FlowLayout flowLayout = (FlowLayout) datePanel.getLayout();
	    dateField = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
	    SpringLayout springLayout = (SpringLayout) dateField.getLayout();
	    springLayout.putConstraint(SpringLayout.WEST, dateField.getJFormattedTextField(), 0, SpringLayout.WEST, dateField);
	    datePanel.add(dateField);
	    
	    JLabel lblNewLabel_1 = new JLabel("Display Options:");
	    panel_6.add(lblNewLabel_1, "cell 0 2,alignx center");
	    lblNewLabel_1.setBorder(null);
	    
	    JPanel panel_2 = new JPanel();
	    panel_6.add(panel_2, "cell 0 3,alignx center,aligny center");
	    panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panel_2.setLayout(new MigLayout("", "[]", "[][][]"));
	    
	    JCheckBox classChkBox = new JCheckBox("Classes");
	    classChkBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	}
	    });
	    classChkBox.setSelected(true);
	    panel_2.add(classChkBox, "cell 0 0");
	    
	    JCheckBox annChkBox = new JCheckBox("Announcments");
	    annChkBox.setSelected(true);
	    panel_2.add(annChkBox, "cell 0 1,aligny baseline");
	    
	    JCheckBox birthdayChkBox = new JCheckBox("Employee Birthdays");
	    birthdayChkBox.setSelected(true);
	    panel_2.add(birthdayChkBox, "cell 0 2");
	    
	    JButton btnNewButton = new JButton("Update");
	    btnNewButton.addActionListener(new ActionListener() {
	    	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
	    		if(classChkBox.isSelected())
	    		{
	    			classPanel.setVisible(true);
	    			classPanel.setMaximumSize(new Dimension(15000,15000));
	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT Class.ClassStartDate, Class.ClassEndDate, Class.ClassID, Room.RoomNum, Employee.FirstName, Employee.LastName FROM Class INNER JOIN RoomReserve ON Class.RoomReserveID = RoomReserve.RoomReserveID INNER JOIN Room ON RoomReserve.RoomID = Room.RoomID INNER JOIN Employee ON Class.EmployeeID = Employee.EmployeeID WHERE datediff(day, ClassStartDate,'"+dateField.getJFormattedTextField().getText()+"') = 0 OR datediff(day, ClassEndDate,'"+dateField.getJFormattedTextField().getText()+"') = 0";
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		            String a = rs.getString("ClassStartDate");
	    		            String b = rs.getString("ClassEndDate");
	    		            String c = rs.getString("ClassID");
	    		            String d = rs.getString("RoomNum");
	    		            String e = rs.getString("FirstName");
	    		            String f = rs.getString("LastName");
	    		            classModel.addRow(new Object[]{a, b, c, d, e, f});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			classPanel.setVisible(false);
	    			classModel.setRowCount(0);
	    			classPanel.setMaximumSize(new Dimension(0,0));
	    		}
	    		if(annChkBox.isSelected())
	    		{
	    			annPanel.setVisible(true);
	    			annPanel.setMaximumSize(new Dimension(15000,15000));
	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT Announcement.Date, Announcement.Time,Room.RoomNum, Announcement.Announcement FROM Announcement INNER JOIN Class ON Announcement.ClassID = Class.ClassID INNER JOIN RoomReserve ON Class.RoomReserveID = RoomReserve.RoomReserveID INNER JOIN Room ON RoomReserve.RoomID = Room.RoomID WHERE datediff(day, ClassStartDate,'"+dateField.getJFormattedTextField().getText()+"') = 0 OR datediff(day, Date,'"+dateField.getJFormattedTextField().getText()+"') = 0";
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		            String a = rs.getString("Date");
	    		            String b = rs.getString("Time");
	    		            String c = rs.getString("RoomNum");
	    		            String d = rs.getString("Announcement");

	    		            annModel.addRow(new Object[]{a, b, c, d});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			annPanel.setVisible(false);
	    			annModel.setRowCount(0);
	    			annPanel.setMaximumSize(new Dimension(0,0));
	    			
	    		}
	    		if(birthdayChkBox.isSelected())
	    		{
	    			birthPanel.setVisible(true);
	    			birthPanel.setMaximumSize(new Dimension(15000,15000));
	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT Employee.DOB, Employee.FirstName, Employee.LastName, Employee.MobilePhone FROM Employee WHERE DATEPART(d,DOB)='"+dateField.getJFormattedTextField().getText().substring(8)+"' AND DATEPART(m,DOB)='"+dateField.getJFormattedTextField().getText().substring(5,7)+"'";
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		            String a = rs.getString("DOB");
	    		            String b = rs.getString("FirstName");
	    		            String c = rs.getString("LastName");
	    		            String d = rs.getString("MobilePhone");

	    		            empModel.addRow(new Object[]{a, b, c, d});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			birthPanel.setVisible(false);
	    			empModel.setRowCount(0);
	    			birthPanel.setMaximumSize(new Dimension(0,0));
	    		}
	    	}
	    });
	    panel_6.add(btnNewButton, "cell 0 4,alignx center");
	    
	    JPanel panel_7 = new JPanel();
	    panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
	    panel.add(panel_7, "flowx,cell 0 1,alignx center,aligny center");
	    panel_7.setLayout(new MigLayout("", "[1px]", "[1px][23px]"));
	    
	    JButton btnNewButton_1 = new JButton("New Announcment");
	    panel_7.add(btnNewButton_1, "cell 0 0,grow");
	    
	    JButton btnNewButton_1_1 = new JButton("Edit Announcement");
	    btnNewButton_1_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		editAnnouncementDialog eAnnoun = new editAnnouncementDialog();
	    		eAnnoun.newWindow();
	    	}
	    });
	    panel_7.add(btnNewButton_1_1, "cell 0 1,alignx left,aligny top");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		createAnnouncement cAnnoun = new createAnnouncement();
	    		cAnnoun.createWindow();
	    	}
	    });
	
		
		holderPanel = new JPanel();
		holderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmCalendar.getContentPane().add(holderPanel, BorderLayout.CENTER);
		holderPanel.setLayout(new MigLayout("", "[grow]", "[grow,fill][grow,fill][grow,fill][][grow][][grow][][][grow]"));
		
		classPanel = new JPanel();
		holderPanel.add(classPanel, "cell 0 0,grow");
		classPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Classes:");
		classPanel.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		classPanel.add(scrollPane, BorderLayout.CENTER);
		
		classTable = new JTable();
		classModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Class Start Date", "Class End Date", "Class ID", "Room", "Employee First Name", "Employee Last Name"
			}
		);
		classTable.setModel(classModel);
		classTable.getColumnModel().getColumn(0).setPreferredWidth(99);
		classTable.getColumnModel().getColumn(1).setPreferredWidth(85);
		classTable.getColumnModel().getColumn(4).setPreferredWidth(115);
		classTable.getColumnModel().getColumn(5).setPreferredWidth(112);
		scrollPane.setViewportView(classTable);
		
		annPanel = new JPanel();
		holderPanel.add(annPanel, "cell 0 1,grow");
		annPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Announcments:");
		annPanel.add(lblNewLabel_4, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		annPanel.add(scrollPane_1);
		
		annTable = new JTable();
		annModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date of Ann.", "Time of Ann.", "Room Number", "Announcement"
			}
		);
		annTable.setModel(annModel);
		annTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		annTable.getColumnModel().getColumn(3).setPreferredWidth(87);
		scrollPane_1.setViewportView(annTable);
		
		birthPanel = new JPanel();
		holderPanel.add(birthPanel, "cell 0 2,grow");
		birthPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Employee Birthdays:");
		birthPanel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		birthPanel.add(scrollPane_2);
		
		empBirthTable = new JTable();
		empModel =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Birthdate", "Employee First Name", "Employee Last Name", "Contact Phone"
			}
		);
		empBirthTable.setModel(empModel);
		empBirthTable.getColumnModel().getColumn(1).setPreferredWidth(111);
		empBirthTable.getColumnModel().getColumn(2).setPreferredWidth(110);
		scrollPane_2.setViewportView(empBirthTable);
}
		
		
	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}}

