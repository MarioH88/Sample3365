package display;

import net.codejava.sql.JavaConnectionSQL;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class editStudent {

	private JFrame frmCreateStudent;
	private JFormattedTextField studentIDTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleInitialTextField;
	private JTextField homePhTextField;
	private JTextField emailTextField;
	private JDatePickerImpl dateField;
	private JTextField addressNumTextField;
	private JTextField addressStreetTextField;
	private JTextField postalCodeTextField;
	private JTextField cityTextField;
	private JTextField facebookTextField;
	private JTextField instagramTextField;
	private JTextField twitterTextField;
	private JTextField mobilePhTextField;
	private JTextField address2StreetTextField;
	private final ButtonGroup CreateStudentButtonGroup = new ButtonGroup();
	private int genderId;
	private String genderName;
	private String countryName;
	private String stateName;

	private static int getStudentID ;

	/**
	 * Launch the application.
	 */
	public static void editStud() {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editStudent window = new editStudent();
					window.frmCreateStudent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void getStudent(int id)
	{
		 getStudentID = id;
	}
	
	
	public editStudent() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmCreateStudent = new JFrame();
		frmCreateStudent.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\resources\\user.png"));
		frmCreateStudent.setTitle("VCA - Edit Student");
		frmCreateStudent.setBounds(100, 100, 604, 660);
		frmCreateStudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreateStudent.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmCreateStudent.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing,aligny center");
		
		
		//Set new Primary Key by 1
		studentIDTextField = new JFormattedTextField();

		
		
		
		studentIDTextField.setAlignmentY(Component.TOP_ALIGNMENT);
		studentIDTextField.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(studentIDTextField, "cell 1 0,alignx left");
		studentIDTextField.setColumns(8);

		JLabel lblNewLabel_1 = new JLabel("First Name:");
		panel.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		firstNameTextField = new JTextField();
		panel.add(firstNameTextField, "cell 1 1,alignx left");
		firstNameTextField.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		panel.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		lastNameTextField = new JTextField();
		panel.add(lastNameTextField, "cell 1 2,alignx left");
		lastNameTextField.setColumns(30);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Initial:");
		panel.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		middleInitialTextField = new JTextField();
		middleInitialTextField.setColumns(1);
		panel.add(middleInitialTextField, "cell 1 3,alignx left");
		
		JLabel lblNewLabel_4 = new JLabel("Home Phone:");
		panel.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		MaskFormatter mf1 = null;
		try {
			mf1 = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    mf1.setPlaceholderCharacter('_');
		
		homePhTextField = new JFormattedTextField(mf1);
		homePhTextField.setColumns(8);
	
		panel.add(homePhTextField, "cell 1 4,alignx left,aligny center");
		
		JLabel lblNewLabel_5 = new JLabel("Mobile Phone:");
		panel.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		MaskFormatter mf2 = null;
		try {
			mf2 = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    mf2.setPlaceholderCharacter('_');
		
		mobilePhTextField = new JFormattedTextField(mf2);
		mobilePhTextField.setColumns(8);
		

		panel.add(mobilePhTextField, "cell 1 5,alignx left");
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		panel.add(lblNewLabel_6, "cell 0 6,alignx trailing");
		
		emailTextField = new JTextField();
		emailTextField.setColumns(35);
		panel.add(emailTextField, "cell 1 6,alignx left");
		
		//Gender
		JLabel lblNewLabel_7 = new JLabel("Gender");
		panel.add(lblNewLabel_7, "cell 0 7,alignx trailing");

		JComboBox genderComboBox = new JComboBox();
		panel.add(genderComboBox, "cell 1 7,alignx left");
		
		
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT GenderName FROM Gender";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         genderComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
	    
		
		
		JLabel lblNewLabel_8 = new JLabel("Date of Birth:");
		panel.add(lblNewLabel_8, "cell 0 8,alignx trailing,aligny baseline");
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(0);
		panel.add(panel_3, "cell 1 8,alignx left,aligny center");
	    UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    dateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    SpringLayout springLayout = (SpringLayout) dateField.getLayout();
	    springLayout.putConstraint(SpringLayout.WEST, dateField.getJFormattedTextField(), 0, SpringLayout.WEST, dateField);
	    panel_3.add(dateField);
	
	    


		
		JLabel lblNewLabel_9 = new JLabel("Address Num:");
		panel.add(lblNewLabel_9, "cell 0 9,alignx trailing");
		
		addressNumTextField = new JTextField();
		addressNumTextField.setColumns(10);
		panel.add(addressNumTextField, "cell 1 9,alignx left");
		
		JLabel lblNewLabel_9_1 = new JLabel("Address Street:");
		panel.add(lblNewLabel_9_1, "cell 0 10,alignx trailing");
		
		addressStreetTextField = new JTextField();
		addressStreetTextField.setColumns(30);
		panel.add(addressStreetTextField, "cell 1 10,alignx left");
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Address Line 2:");
		panel.add(lblNewLabel_9_1_1, "cell 0 11,alignx trailing");
		
		address2StreetTextField = new JTextField();
		address2StreetTextField.setColumns(30);
		panel.add(address2StreetTextField, "cell 1 11,alignx left");
		
		JLabel lblNewLabel_9_2 = new JLabel("Postal Code:");
		panel.add(lblNewLabel_9_2, "cell 0 12,alignx trailing");
		
		postalCodeTextField = new JTextField();
		postalCodeTextField.setColumns(8);
		panel.add(postalCodeTextField, "cell 1 12,alignx left");
		
		JLabel lblNewLabel_9_2_1 = new JLabel("City:");
		panel.add(lblNewLabel_9_2_1, "cell 0 13,alignx trailing");
		
		cityTextField = new JTextField();
		cityTextField.setColumns(30);
		panel.add(cityTextField, "cell 1 13,alignx left");
		
		JLabel lblNewLabel_9_2_2 = new JLabel("Country:");
		panel.add(lblNewLabel_9_2_2, "cell 0 14,alignx trailing");
		
		JComboBox countryComboBox = new JComboBox();
		panel.add(countryComboBox, "cell 1 14,alignx left");
		
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT CountryName FROM Country";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         countryComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_10 = new JLabel("State / Providence:");
		panel.add(lblNewLabel_10, "cell 0 15,alignx trailing,aligny center");
		
		JComboBox stateComboBox = new JComboBox();
		panel.add(stateComboBox, "cell 1 15,alignx left");
		
	    try{
	    	
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    	String sql = "SELECT StateProvName FROM StateProv";
	        
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         stateComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		
		JLabel lblNewLabel_10_1 = new JLabel("Facebook:");
		panel.add(lblNewLabel_10_1, "cell 0 16,alignx trailing");
		
		facebookTextField = new JTextField();
		facebookTextField.setColumns(30);
		panel.add(facebookTextField, "cell 1 16,alignx left");
		
		JLabel lblNewLabel_10_2 = new JLabel("Instagram Handle:");
		panel.add(lblNewLabel_10_2, "cell 0 17,alignx trailing");
		
		instagramTextField = new JTextField();
		instagramTextField.setColumns(20);
		panel.add(instagramTextField, "cell 1 17,alignx left");
		
		JLabel lblNewLabel_10_3 = new JLabel("Twitter Handle:");
		panel.add(lblNewLabel_10_3, "cell 0 18,alignx trailing");
		
		twitterTextField = new JTextField();
		twitterTextField.setColumns(20);
		panel.add(twitterTextField, "cell 1 18,alignx left");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		frmCreateStudent.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
		
		JButton createStudentButton2 = new JButton("Update Student");
		panel_1.add(createStudentButton2);
		
		
		
		createStudentButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BigInteger big = new BigInteger(homePhTextField.getText().replace("(", "").replace(")","").replace("-", ""));
					BigInteger big1 = new BigInteger(mobilePhTextField.getText().replace("(", "").replace(")","").replace("-", ""));
					
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			        
			    	String sql = "UPDATE Student "
			    			+ "SET StudentID ="+Integer.parseInt(studentIDTextField.getText())+",LastName ='"+lastNameTextField.getText()+"',FirstName ='"+
					firstNameTextField.getText()+"',MiddleInital = '"+middleInitialTextField.getText()+"', HomePhone ="+big+",MobilePhone="+big1+",Email ='"+emailTextField.getText()+"', Gender ="+(genderComboBox.getSelectedIndex()+1)+", DOB = CAST('"+dateField.getJFormattedTextField().getText()+"' as date), AddressNum ='"+Integer.parseInt(addressNumTextField.getText())+"', AddressStreet ='"+
							addressStreetTextField.getText()+"', AddressStreet2 ='"+address2StreetTextField.getText()+"', PostalCode ='"+postalCodeTextField.getText()+"',City ='"+cityTextField.getText()+"',CountryID ="+(countryComboBox.getSelectedIndex()+1)+", StateID ="+(stateComboBox.getSelectedIndex()+1)+",FaceBookHandle ='"+facebookTextField.getText()+"',InstagramHandle ='"+instagramTextField.getText()+"',TwitterHandle ='"+twitterTextField.getText()+"' WHERE StudentID ="+getStudentID;
			    	Statement pst = conn.createStatement();
			        pst.executeUpdate(sql);
			        System.out.println("Updated records into the table...");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				 }
				finally {
					frmCreateStudent.dispose();
				}
			}});
		CreateStudentButtonGroup.add(createStudentButton2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		frmCreateStudent.getContentPane().add(panel_2, BorderLayout.NORTH);
		
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_2_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(176, 196, 222));
		frmCreateStudent.getContentPane().add(panel_4, BorderLayout.EAST);
		
		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1_1_1.setPreferredSize(new Dimension(10, 0));
		horizontalStrut_1_1_1_1.setMinimumSize(new Dimension(10, 0));
		panel_4.add(horizontalStrut_1_1_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(176, 196, 222));
		frmCreateStudent.getContentPane().add(panel_5, BorderLayout.WEST);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_1_1.setPreferredSize(new Dimension(10, 0));
		horizontalStrut_1_1_1.setMinimumSize(new Dimension(10, 0));
		panel_5.add(horizontalStrut_1_1_1);
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT Gender.GenderID, Gender.GenderName,Country.CountryName,StateProv.StateProvName FROM Gender INNER JOIN Student ON Gender.GenderID = Student.Gender INNER JOIN"
	        		+ " Country ON Student.CountryID = Country.CountryID INNER JOIN"
	        		+ " StateProv ON Student.StateID = StateProv.StateID"
	        		+ " WHERE StudentID = "+getStudentID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next())
	        {
	        	genderName = rs.getString("GenderName");
	        	countryName = rs.getString("CountryName");
	        	stateName = rs.getString("StateProvName");
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
	        String sql = "SELECT * FROM Student WHERE StudentID = "+getStudentID;
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next())
	        {
	        	studentIDTextField.setText((rs.getString("StudentID")));
	        	lastNameTextField.setText((rs.getString("LastName")));
	        	firstNameTextField.setText((rs.getString("FirstName")));
	        	middleInitialTextField.setText((rs.getString("MiddleInital")));
	        	homePhTextField.setText(rs.getString("HomePhone"));
	        	mobilePhTextField.setText(rs.getString("MobilePhone"));
	        	emailTextField.setText(rs.getString("Email"));
	        	genderComboBox.setSelectedItem(genderName);
	        	dateField.getJFormattedTextField().setText(rs.getString("DOB"));;
	        	addressNumTextField.setText(rs.getString("AddressNum"));
	        	addressStreetTextField.setText(rs.getString("AddressStreet"));
	        	address2StreetTextField.setText(rs.getString("AddressStreet2"));
	        	postalCodeTextField.setText(rs.getString("PostalCode"));
	        	cityTextField.setText(rs.getString("City"));
	        	countryComboBox.setSelectedItem(countryName);
	        	stateComboBox.setSelectedItem(stateName);
	        	facebookTextField.setText(rs.getString("FaceBookHandle"));
	        	instagramTextField.setText(rs.getString("InstagramHandle"));
	        	twitterTextField.setText(rs.getString("TwitterHandle"));



	        }
	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
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

