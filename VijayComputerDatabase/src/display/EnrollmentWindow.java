package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.Component;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.CalendarWindow.DateLabelFormatter;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;

public class EnrollmentWindow {

	private JFrame frmEnrollmentWindow;
	private JTable classTable;
	private DefaultTableModel classMod;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnrollmentWindow window = new EnrollmentWindow();
					window.frmEnrollmentWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	*/
	public EnrollmentWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrollmentWindow = new JFrame();
		frmEnrollmentWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\user.png"));
		frmEnrollmentWindow.setTitle("VCA - Enrollment");
		frmEnrollmentWindow.setBounds(100, 100, 1009, 527);
		frmEnrollmentWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEnrollmentWindow.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		frmEnrollmentWindow.getContentPane().add(panel, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(15);
		panel.add(verticalStrut_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		frmEnrollmentWindow.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new MigLayout("", "[grow]", "[center][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Class View Options:");
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8, "cell 0 1");
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_2 = new JLabel("Select Class Type:");
		panel_8.add(lblNewLabel_2);
		
		JComboBox classTypeComboBox = new JComboBox();
		panel_8.add(classTypeComboBox);
		
		
		//Update Button
		JButton btnNewButton_2 = new JButton("Update");
		panel_8.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "";
				if( classTypeComboBox.getSelectedItem().toString().equals("All"))
				{
					sql = "SELECT ClassType.ClassType, Class.ClassID, Course.CourseName, Room.RoomNum, BusinessContact.BusinessName, Class.ClassTimeStart, Class.ClassTimeEnd, Class.ClassStartDate, Class.ClassEndDate"
    						+ " FROM Class INNER JOIN"
    						+ " RoomReserve ON Class.RoomReserveID = RoomReserve.RoomReserveID INNER JOIN"
    						+ " Room ON RoomReserve.RoomID = Room.RoomID INNER JOIN"
    						+ " ClassType ON Class.ClassTypeID = ClassType.ClassTypeID INNER JOIN"
    						+ " ClassContact ON Class.CustomerID = ClassContact.CustomerId INNER JOIN"
    						+ " Course ON Class.CourseID = Course.CourseID INNER JOIN"
    						+ " BusinessContact ON ClassContact.ContactId = BusinessContact.ContactID";
				}
				else
				{
					sql = "SELECT ClassType.ClassType, Class.ClassID, Course.CourseName, Room.RoomNum, BusinessContact.BusinessName, Class.ClassTimeStart, Class.ClassTimeEnd, Class.ClassStartDate, Class.ClassEndDate"
    						+ " FROM Class INNER JOIN"
    						+ " RoomReserve ON Class.RoomReserveID = RoomReserve.RoomReserveID INNER JOIN"
    						+ " Room ON RoomReserve.RoomID = Room.RoomID INNER JOIN"
    						+ " ClassType ON Class.ClassTypeID = ClassType.ClassTypeID INNER JOIN"
    						+ " ClassContact ON Class.CustomerID = ClassContact.CustomerId INNER JOIN"
    						+ " Course ON Class.CourseID = Course.CourseID INNER JOIN"
    						+ " BusinessContact ON ClassContact.ContactId = BusinessContact.ContactID"
    						+ " WHERE ClassType ='"+classTypeComboBox.getSelectedItem().toString()+"'";
				}
    			classMod.setRowCount(0);

    			 try {
    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
    				PreparedStatement pst = conn.prepareStatement(sql);
    		        ResultSet rs = pst.executeQuery();
    		        
    		        while(rs.next())
    		        {
    		            String a = rs.getString("ClassType");
    		            String b = rs.getString("ClassID");
    		            String c = rs.getString("CourseName");
    		            String d = rs.getString("RoomNum");
    		            String e = rs.getString("BusinessName");
    		            String f = rs.getString("ClassTimeStart");
    		            String g = rs.getString("ClassTimeEnd");
    		            String f1 = rs.getString("ClassStartDate");
    		            String g1 = rs.getString("ClassEndDate");
    		            classMod.addRow(new Object[]{a, b, c, d, e, f,g,f1,g1});
    		        }

    			} catch (SQLException e1) {
    				JOptionPane.showMessageDialog(null, e1);
    			}	
    			}
    			
    			

	
			
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Edit Students & Classes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNewLabel_1, "cell 0 4,alignx center");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_6, "cell 0 5,grow");
		panel_6.setLayout(new MigLayout("", "[grow]", "[center][]"));
		
		JPanel panel_2 = new JPanel();
		panel_6.add(panel_2, "cell 0 0,grow");
		
		JButton btnNewButton_1 = new JButton("Class Portal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classWindow casa = new classWindow();
				casa.newWindow();
			}
		});
		panel_2.add(btnNewButton_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_6.add(panel_2_1, "cell 0 1,growx,aligny center");
		
		JButton btnNewButton = new JButton("Student Portal");
		panel_2_1.add(btnNewButton);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_1.add(panel_7, "cell 0 7,alignx center,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("VijayComputerDatabase\\VijayComputerDatabase\\resources\\logo.png"));
		panel_7.add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentWindow sw = new StudentWindow();
				sw.studWindow();
			}
		});
		UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(60, 179, 113));
		frmEnrollmentWindow.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new MigLayout("", "[1px]", "[]"));
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT ClassType FROM ClassType";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         classTypeComboBox.addItem(s);

		        }
		        classTypeComboBox.addItem("All");
		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmEnrollmentWindow.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);
		
		classTable = new JTable();
		classMod = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Class Type", "Class ID #", "Course Name", "Room #", "Business Name", "Class Time Start", "Class Time End", "Class Start Date", "Class End Date"
			}
		);
		classTable.setModel(classMod);
		classTable.getColumnModel().getColumn(1).setPreferredWidth(72);
		classTable.getColumnModel().getColumn(3).setPreferredWidth(49);
		classTable.getColumnModel().getColumn(4).setPreferredWidth(86);
		classTable.getColumnModel().getColumn(5).setPreferredWidth(97);
		classTable.getColumnModel().getColumn(6).setPreferredWidth(81);
		scrollPane.setViewportView(classTable);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(60, 179, 113));
		frmEnrollmentWindow.getContentPane().add(panel_5, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(15);
		panel_5.add(horizontalStrut);
		
		JMenuBar menuBar = new JMenuBar();
		frmEnrollmentWindow.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Print");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					final MessageFormat headerFormat= new MessageFormat("Class Information");
					final MessageFormat footerFormat= new MessageFormat("- {0} -");
					classTable.print(PrintMode.FIT_WIDTH,headerFormat,footerFormat);
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
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
