package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class createBusinessContact {

	private JFrame frmVcaCreate;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField middleITextField;
	private JTextField phoneNumberTextField;
	private JTextField addressNumTextField;
	private JTextField emailTextField;
	private JTextField addressStreetTextField;
	private JTextField AddressStreet2TextField;
	private JTextField postalCodeTextField;
	private JTextField cityTextField;
	private JTextField contactIDTextField;
	private JTextField busNameTextField;
	private int titleID;
	private int departmentID;
	private int countryID;
	private int stateID;
	private int busStatusID;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createBusinessContact window = new createBusinessContact();
					window.frmVcaCreate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createBusinessContact() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setTitle("VCA - Create Business Contact");
		frmVcaCreate.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\book.png"));
		frmVcaCreate.setBounds(100, 100, 644, 615);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(135, 206, 235));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JButton createBusContact = new JButton("Create Business Contact");
		panel_3.add(createBusContact);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[grow,center][grow]", "[][][][][][][][][][][][][][][][][][][]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut, "cell 1 0");
		
		JLabel lblNewLabel = new JLabel("Contact ID:");
		panel_4.add(lblNewLabel, "cell 0 1,alignx trailing");
		
		contactIDTextField = new JTextField();
		panel_4.add(contactIDTextField, "cell 1 1,alignx leading,aligny center");
		contactIDTextField.setColumns(7);
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT MAX(ContactID) FROM BusinessContact";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         int s = rs.getInt(1);
	         int q = s +1;
	         contactIDTextField.setText(Integer.toString(q));

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_1 = new JLabel("Business Name:");
		panel_4.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		busNameTextField = new JTextField();
		panel_4.add(busNameTextField, "cell 1 2,alignx leading");
		busNameTextField.setColumns(50);
		
		JLabel lblNewLabel_2 = new JLabel("Title:");
		panel_4.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		JComboBox titleComboBox = new JComboBox();
		panel_4.add(titleComboBox, "cell 1 3,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT TitleNAME FROM Title";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         titleComboBox.addItem(s);

	        }
	        titleComboBox.addItem("");
	        pst.close();
	        rs.close();
	        conn.close();
	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		
		JLabel lblNewLabel_3 = new JLabel("Department:");
		panel_4.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		JComboBox departmentComboBox = new JComboBox();
		panel_4.add(departmentComboBox, "cell 1 4,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT DepartmentName FROM Department";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         departmentComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();
	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_4 = new JLabel("First Name:");
		panel_4.add(lblNewLabel_4, "cell 0 5,alignx trailing");
		
		firstNameTextField = new JTextField();
		panel_4.add(firstNameTextField, "cell 1 5,alignx left");
		firstNameTextField.setColumns(25);
		
		JLabel lblNewLabel_5 = new JLabel("Last Name:");
		panel_4.add(lblNewLabel_5, "cell 0 6,alignx trailing");
		
		lastNameTextField = new JTextField();
		panel_4.add(lastNameTextField, "cell 1 6,alignx left");
		lastNameTextField.setColumns(25);
		
		JLabel lblNewLabel_6 = new JLabel("Middle Initial:");
		panel_4.add(lblNewLabel_6, "cell 0 7,alignx trailing");
		
		middleITextField = new JTextField();
		panel_4.add(middleITextField, "cell 1 7,alignx left");
		middleITextField.setColumns(1);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		panel_4.add(lblNewLabel_7, "cell 0 8,alignx trailing");
		
		emailTextField = new JTextField();
		panel_4.add(emailTextField, "cell 1 8,alignx left");
		emailTextField.setColumns(50);
		
		JLabel lblNewLabel_8 = new JLabel("Phone Number:");
		panel_4.add(lblNewLabel_8, "cell 0 9,alignx trailing");
		
		phoneNumberTextField = new JTextField();
		panel_4.add(phoneNumberTextField, "cell 1 9,alignx left");
		phoneNumberTextField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Address Number:");
		panel_4.add(lblNewLabel_9, "cell 0 10,alignx trailing");
		
		addressNumTextField = new JTextField();
		panel_4.add(addressNumTextField, "flowy,cell 1 10,alignx left");
		addressNumTextField.setColumns(8);
		
		JLabel lblNewLabel_10 = new JLabel("Address Street:");
		panel_4.add(lblNewLabel_10, "cell 0 11,alignx trailing");
		
		addressStreetTextField = new JTextField();
		panel_4.add(addressStreetTextField, "cell 1 11,alignx left");
		addressStreetTextField.setColumns(50);
		
		JLabel lblNewLabel_11 = new JLabel("Address Line 2:");
		panel_4.add(lblNewLabel_11, "cell 0 12,alignx trailing");
		
		AddressStreet2TextField = new JTextField();
		panel_4.add(AddressStreet2TextField, "cell 1 12,alignx left");
		AddressStreet2TextField.setColumns(50);
		
		JLabel lblNewLabel_12 = new JLabel("Postal Code:");
		panel_4.add(lblNewLabel_12, "cell 0 13,alignx trailing");
		
		postalCodeTextField = new JTextField();
		panel_4.add(postalCodeTextField, "cell 1 13,alignx left");
		postalCodeTextField.setColumns(8);
		
		JLabel lblNewLabel_13 = new JLabel("City:");
		panel_4.add(lblNewLabel_13, "cell 0 14,alignx trailing");
		
		cityTextField = new JTextField();
		panel_4.add(cityTextField, "cell 1 14,alignx left");
		cityTextField.setColumns(50);
		
		JLabel lblNewLabel_14 = new JLabel("Country:");
		panel_4.add(lblNewLabel_14, "cell 0 15,alignx trailing");
		
		JComboBox countryComboBox = new JComboBox();
		panel_4.add(countryComboBox, "cell 1 15,alignx left");
		
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
		
		JLabel lblNewLabel_15 = new JLabel("State / Providence:");
		panel_4.add(lblNewLabel_15, "cell 0 16,alignx trailing");
		
		JComboBox stateProvComboBox = new JComboBox();
		panel_4.add(stateProvComboBox, "cell 1 16,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT StateProvName FROM StateProv";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         stateProvComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();
	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		JLabel lblNewLabel_16 = new JLabel("Status:");
		panel_4.add(lblNewLabel_16, "cell 0 17,alignx trailing,aligny center");
		
		JComboBox busStatusComboBox = new JComboBox();
		panel_4.add(busStatusComboBox, "cell 1 17,alignx left");
		
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT BusinessStatus FROM BusinessStatus";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         busStatusComboBox.addItem(s);

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
	        String sql = "SELECT TitleID FROM Title WHERE TitleName = '"+titleComboBox.getSelectedItem().toString()+"'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         titleID = Integer.parseInt(s);

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
	        String sql = "SELECT DepartmentID FROM Department WHERE DepartmentName = '"+departmentComboBox.getSelectedItem().toString()+"'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         departmentID = Integer.parseInt(s);

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
	        String sql = "SELECT CountryID FROM Country WHERE CountryName = '"+countryComboBox.getSelectedItem().toString()+"'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         countryID = Integer.parseInt(s);

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
	        String sql = "SELECT StateID FROM StateProv WHERE StateProvName = '"+stateProvComboBox.getSelectedItem().toString()+"'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         stateID = Integer.parseInt(s);

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
	        String sql = "SELECT BusinessStatusID FROM BusinessStatus WHERE BusinessStatus = '"+busStatusComboBox.getSelectedItem().toString()+"'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         busStatusID = Integer.parseInt(s);

	        }
	        pst.close();
	        rs.close();
	        conn.close();
	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    
	    }
		
		
		
		
		createBusContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			    	String sql = "INSERT INTO BusinessContact (ContactID,BusinessName,TitleID,DepartmentID,LastName,FirstName,MiddleInitial,Email,Phone,AddressNum,AddressStreet,AddressStreet2,PostalCode,City,CountryID,StateID,BusinessStatusID)"
			    			+ "VALUES ("+Integer.parseInt(contactIDTextField.getText())+",'"
			    			+busNameTextField.getText()+"',"
			    			+titleID+","
			    			+departmentID+",'"
			    			+lastNameTextField.getText()+"','"
			    			+firstNameTextField.getText()+"','"
			    			+middleITextField.getText()+"','"
			    			+emailTextField.getText()+"','"
			    			+BigInteger.valueOf(Long.parseLong(phoneNumberTextField.getText()))+"',"
			    			+Integer.parseInt(addressNumTextField.getText())+",'"
			    			+addressStreetTextField.getText()+"','"
			    			+AddressStreet2TextField.getText()+"','"
			    			+postalCodeTextField.getText()+"','"
			    			+cityTextField.getText()+"',"
			    			+countryID+","
			    			+stateID+","
			    			+busStatusID+")";
			    	Statement pst = conn.createStatement();
			        pst.executeUpdate(sql);
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);

				}
			}
		});
		
	}

}
