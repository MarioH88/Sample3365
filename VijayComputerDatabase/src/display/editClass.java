package display;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.createAnnouncement.DateLabelFormatter;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class editClass {

	private JFrame frmCreateClass;
	private JFormattedTextField classIDTextField;
	private JLabel textField_5;
	private JTextField maxStudTextField;
	private JDatePickerImpl dateField2;
	private JDatePickerImpl dateField1;
	private int EmpId;
	private int ClassTypeId;
	private int CourseId;
	private int ContactId;
	private int RoomReserveID;
	private int classID;
	private int equipmentID;



	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editClass window = new editClass(classID);
					window.frmCreateClass.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editClass(int x) {
		classID = x;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateClass = new JFrame();
		frmCreateClass.setTitle("VCA - Update Class");
		frmCreateClass.setBounds(100, 100, 520, 517);
		frmCreateClass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreateClass.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmCreateClass.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][][grow,left]", "[][][][][][][][][][][98.00][][]"));
		
		JLabel lblNewLabel = new JLabel("Class ID:");
		panel.add(lblNewLabel, "cell 1 0,alignx trailing,aligny center");
		
		classIDTextField = new JFormattedTextField();
		classIDTextField.setAlignmentY(Component.TOP_ALIGNMENT);
		classIDTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(classIDTextField, "cell 2 0,alignx left");
		classIDTextField.setColumns(8);

		//Employee Assigned Combo Box
		JLabel lblNewLabel_1 = new JLabel("Employee Assigned:");
		panel.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		JComboBox employeeComboBox = new JComboBox();
		panel.add(employeeComboBox, "cell 2 1,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    	String sql="SELECT Employee.FirstName+' '+ Employee.LastName+', '+EmployeeType.EmpTypeName FROM Employee INNER JOIN EmployeeType On Employee.EmployeeTypeID = EmployeeType.TypeID";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()){
	         String s = rs.getString(1);
	         employeeComboBox.addItem(s);
	        }
	        pst.close();
	        rs.close();
	        conn.close();
	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		//Class Type Combo Box
		JLabel lblNewLabel_2 = new JLabel("Class Type:");
		panel.add(lblNewLabel_2, "cell 1 2,alignx trailing");
		JComboBox classTypeComboBox = new JComboBox();
		panel.add(classTypeComboBox, "cell 2 2,alignx left");
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

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT ClassType.ClassType"
	        		+ " FROM Class INNER JOIN"
	        		+ " ClassType ON Class.ClassTypeID = ClassType.ClassTypeID WHERE ClassID ="+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         classTypeComboBox.setSelectedItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Course Name:");
		panel.add(lblNewLabel_3, "cell 1 3,alignx trailing");
		
		JComboBox courseNameComboBox = new JComboBox();
		panel.add(courseNameComboBox, "cell 2 3,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT CourseName FROM Course";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         courseNameComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		JLabel lblNewLabel_4 = new JLabel("Equipment Serial Select:");
		panel.add(lblNewLabel_4, "cell 1 4,alignx trailing");
		
		JComboBox hardwareComboBox = new JComboBox();
		panel.add(hardwareComboBox, "cell 2 4,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT EquipSerialNum FROM Equipment";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         hardwareComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT EquipCheckout.EquipSerialNum, EquipCheckout.HardwareID"
	        		+ " FROM EquipCheckout INNER JOIN"
	        		+ " Class ON EquipCheckout.HardwareID = Class.HardwareID"
	        		+ " WHERE Class.ClassID ="+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString("EquipSerialNum");
	         hardwareComboBox.setSelectedItem(s);
	         equipmentID = Integer.parseInt(rs.getString("HardwareID"));
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_5 = new JLabel("Room Reservation:");
		panel.add(lblNewLabel_5, "cell 1 5,alignx trailing");
		
		JComboBox roomComboBox = new JComboBox();
		panel.add(roomComboBox, "cell 2 5,alignx left");
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT CAST(Room.RoomNum AS varchar) +', '+ CAST(RoomReserve.Reserve AS varchar) AS MOVE "
	        		+ " FROM  RoomReserve INNER JOIN"
	        		+ " Room ON RoomReserve.RoomID = Room.RoomID";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         roomComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_5_1 = new JLabel("Customer Select:");
		panel.add(lblNewLabel_5_1, "cell 1 6,alignx trailing");
		
		JComboBox customerComboBox = new JComboBox();
		panel.add(customerComboBox, "cell 2 6,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT BusinessName from BusinessContact";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         customerComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT BusinessContact.BusinessName"
	        		+ " FROM Class INNER JOIN"
	        		+ " ClassContact ON Class.CustomerID = ClassContact.CustomerId INNER JOIN"
	        		+ " BusinessContact ON ClassContact.ContactId = BusinessContact.ContactID"
	        		+ " WHERE Class.ClassID ="+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         customerComboBox.setSelectedItem(s);
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_6 = new JLabel("Section #:");
		panel.add(lblNewLabel_6, "cell 1 7,alignx trailing");
		
		JFormattedTextField classSecTextField = new JFormattedTextField();
		classSecTextField.setColumns(8);
		classSecTextField.setAlignmentY(0.0f);
		classSecTextField.setAlignmentX(0.0f);
		panel.add(classSecTextField, "cell 2 7,alignx left");
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT ClassSection FROM Class WHERE ClassID = "+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         int s = rs.getInt(1);
	         classSecTextField.setText(Integer.toString(s));
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_7 = new JLabel("Class Start Date");
		panel.add(lblNewLabel_7, "cell 1 8,alignx trailing");

		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "cell 2 8,alignx left,growy");
		
	    UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    dateField1 = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    dateField1.getJFormattedTextField().setAlignmentX(Component.LEFT_ALIGNMENT);
	    SpringLayout sl_dateField1 = (SpringLayout) dateField1.getLayout();
	    sl_dateField1.putConstraint(SpringLayout.WEST, dateField1.getJFormattedTextField(), 0, SpringLayout.WEST, dateField1);
	    panel_5.add(dateField1);
		
		JLabel lblNewLabel_8 = new JLabel("Class End Date");
		panel.add(lblNewLabel_8, "cell 1 9,alignx trailing,aligny baseline");
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, "cell 2 9,alignx left,aligny center");
		UtilDateModel model2=new UtilDateModel();
	    Properties p2 = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);
	    dateField2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
	    dateField2.getJFormattedTextField().setAlignmentX(Component.LEFT_ALIGNMENT);
	    SpringLayout sl_dateField2 = (SpringLayout) dateField2.getLayout();
	    sl_dateField2.putConstraint(SpringLayout.WEST, dateField2.getJFormattedTextField(), 0, SpringLayout.WEST, dateField2);
	    panel_6.add(dateField2);
		
		JLabel lblNewLabel_9 = new JLabel("Time Start");
		panel.add(lblNewLabel_9, "cell 1 10,alignx trailing,aligny center");
		
		JPanel timePanel1 = new JPanel();
		panel.add(timePanel1, "cell 2 10,alignx left,aligny center");
		
		FlowLayout flowLayout_1 = (FlowLayout) timePanel1.getLayout();
		flowLayout_1.setHgap(0);
		Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner = new JSpinner(sm);
		  JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		  de.setBorder(null);
		  spinner.setEditor(de);
		  timePanel1.add(spinner);
		
		JLabel lblNewLabel_9_1 = new JLabel("Time End:");
		panel.add(lblNewLabel_9_1, "cell 1 11,alignx trailing");
		
		JPanel timePanel2 = new JPanel();
		panel.add(timePanel2, "cell 2 11,alignx left,aligny center");
		
		FlowLayout flowLayout_2 = (FlowLayout) timePanel2.getLayout();
		flowLayout_2.setHgap(0);
		Date date2 = new Date();
		  SpinnerDateModel sm2 = 
		  new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner2 = new JSpinner(sm2);
		  JSpinner.DateEditor de2 = new JSpinner.DateEditor(spinner2, "HH:mm:ss");
		  de2.setBorder(null);
		  spinner2.setEditor(de2);
		  timePanel2.add(spinner2);

		  
	
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2, "cell 0 12");
		
		JLabel lblNewLabel_9_2 = new JLabel("Max Number of Students:");
		panel.add(lblNewLabel_9_2, "cell 1 12,alignx trailing");
		
		maxStudTextField = new JTextField();
		maxStudTextField.setColumns(4);
		panel.add(maxStudTextField, "cell 2 12,alignx left");

		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		frmCreateClass.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		frmCreateClass.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);
		
		
		
		textField_5 = new JLabel();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		frmCreateClass.getContentPane().add(textField_5, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		frmCreateClass.getContentPane().add(panel_3, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		panel_3.add(horizontalStrut_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(173, 216, 230));
		frmCreateClass.getContentPane().add(panel_4, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_4.add(horizontalStrut);
		
		
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT NumofStudents FROM Class WHERE ClassID = "+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         int s = rs.getInt(1);
	         maxStudTextField.setText(Integer.toString(s));
	        }
	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT Course.CourseName"
	        		+ " FROM Class INNER JOIN Course ON Class.CourseID = Course.CourseID"
	        		+ " WHERE Class.ClassID ="+classID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         courseNameComboBox.setSelectedItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		  
		  try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT Class.ClassStartDate,Class.ClassEndDate,Class.ClassTimeStart, Class.ClassTimeEnd FROM Class WHERE ClassID = "+classID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){

		         SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		       	spinner.setValue(format.parse((rs.getString("ClassTimeStart"))));
		       	spinner2.setValue(format.parse((rs.getString("ClassTimeEnd"))));
		       	dateField1.getJFormattedTextField().setText(rs.getString("ClassStartDate"));
		       	dateField2.getJFormattedTextField().setText(rs.getString("ClassEndDate"));
		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		  try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT ClassID FROM Class WHERE ClassID = "+classID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         int s = rs.getInt(1);
		         classIDTextField.setText(Integer.toString(s));
		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		  	
		

		JButton btnNewButton_1 = new JButton("Update Class");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	int index = roomComboBox.getSelectedItem().toString().indexOf(',');
			    	int roomNum = Integer.parseInt(roomComboBox.getSelectedItem().toString().substring(0, index));
			    	index = roomComboBox.getSelectedItem().toString().indexOf(' ');
			    	DateLabelFormatter reserveD = new DateLabelFormatter();
			    	
					String s = roomComboBox.getSelectedItem().toString().substring(index+1);
			
			    	String sql = "SELECT RoomReserveID FROM RoomReserve INNER JOIN Room ON RoomReserve.RoomID=Room.RoomID WHERE RoomNum = "+roomNum+" AND Reserve = '"+s+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("RoomReserveID");
			            RoomReserveID = Integer.parseInt(a);
			        }

				}
				catch(SQLException e){
					
				}
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	int index = employeeComboBox.getSelectedItem().toString().indexOf(' ');
			    	String sql = "SELECT CourseID from Course WHERE CourseName = '"+courseNameComboBox.getSelectedItem().toString()+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("CourseID");
			            CourseId = Integer.parseInt(a);
			        }
			        pst.close();
			        rs.close();
			        conn.close();
				}
				catch(SQLException e){

				}
				
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	int index = employeeComboBox.getSelectedItem().toString().indexOf(' ');
			    	String sql = "SELECT EmployeeID from Employee WHERE Employee.FirstName = '"+employeeComboBox.getSelectedItem().toString().substring(0,index)+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("EmployeeID");
			            EmpId = Integer.parseInt(a);
			        }

				}
				catch(SQLException e){
					
				}
				
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	int index = employeeComboBox.getSelectedItem().toString().indexOf(' ');
			    	String sql = "SELECT ClassTypeID from ClassType WHERE ClassType = '"+classTypeComboBox.getSelectedItem().toString()+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("ClassTypeID");
			            ClassTypeId = Integer.parseInt(a);
			        }

				}
				catch(SQLException e){
					
				}	
				

				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	int index = employeeComboBox.getSelectedItem().toString().indexOf(' ');
			    	String sql = "SELECT ClassContact.CustomerId,BusinessContact.BusinessName from ClassContact INNER JOIN BusinessContact ON BusinessContact.ContactID = ClassContact.ContactId WHERE BusinessName ='"+customerComboBox.getSelectedItem().toString()+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        
			        while(rs.next())
			        {
			            String a = rs.getString("CustomerID");
			            ContactId = Integer.parseInt(a);
			        }

				}
				catch(SQLException e){
					
				}
				try {
					
		        	SimpleDateFormat formatT = new SimpleDateFormat("HH:mm:ss");
					String time = formatT.format(spinner.getValue());
					String time2 = formatT.format(spinner2.getValue());
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
					String sql = "UPDATE Class SET ClassID ="+classID+", EmployeeID ="+EmpId+", ClassTypeID ="+ClassTypeId+", CourseID ="+CourseId+", HardwareID ="+equipmentID+", CustomerID = "+ContactId+
		    			", RoomReserveID ="+RoomReserveID+", ClassSection ="+Integer.parseInt(classSecTextField.getText())+", ClassStartDate = CAST( '"+dateField1.getJFormattedTextField().getText()+"' as date),"
		    			+" ClassEndDate = CAST( '"+dateField2.getJFormattedTextField().getText()+"' as date), ClassTimeStart = CAST('"+time+"' AS TIME), ClassTimeEnd = CAST('"+time2+"' AS TIME), NumofStudents = "+Integer.parseInt(maxStudTextField.getText())+" WHERE Class.ClassID = "+classID;
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.executeUpdate();
			        stmt.close();
			        conn.close();

			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1);
			}
			catch(Exception e1){
			      //Handle errors for Class.forName
			      e1.printStackTrace();
			 }
			finally {
				frmCreateClass.dispose();
				
			}
		}});
		panel_2.add(btnNewButton_1);

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
}
}