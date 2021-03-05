package display;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editEmpCert {

	private JFrame frmVcaCreate;
	private JTextField serialTextField;
	private JDatePickerImpl dateField;
	private JPanel certdatePanel;
	private int certID;
	private int empID;
	private int empCertID;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editEmpCert window = new editEmpCert(empCertID);
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
	public editEmpCert(int x) {
		empCertID = x;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setTitle("VCA - Edit Employee Certification Assignment");
		frmVcaCreate.setBounds(100, 100, 425, 250);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Edit Employee Certification Assignment");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.SOUTH);

		JButton createEmpCert = new JButton("Edit Employee Certification");
		createEmpCert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			        String sql = "INSERT INTO EmpCert(EmpID,CertID,EmpCert,EmpCertDate) VALUES ("+empID+","+certID+","+Integer.parseInt(serialTextField.getText())+", CAST( '"+dateField.getJFormattedTextField().getText()+"' as date))";
			        Statement pst = conn.createStatement();
			        pst.executeUpdate(sql);
			        System.out.println("Inserted records into the table...");
				}
				catch(SQLException e)
				{
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				 }
				finally {
					frmVcaCreate.dispose();
				}
			}
		});
		
		
		
		panel_2.add(createEmpCert);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][grow]", "[][][][grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Employee Certification ID:");
		panel_4.add(lblNewLabel, "cell 0 0,alignx trailing,aligny center");
		
		serialTextField = new JTextField();
		panel_4.add(serialTextField, "cell 1 0,alignx left");
		serialTextField.setColumns(4);
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT MAX(EmpCert) FROM EmpCert";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         int s = rs.getInt(1);
		         int q = s +1;
		         serialTextField.setText(Integer.toString(q));

		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		JLabel lblNewLabel_1 = new JLabel("Certification:");
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		JComboBox certComboBox = new JComboBox();
		panel_4.add(certComboBox, "cell 1 1,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT CertName FROM Certification";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString("CertName");
	         certComboBox.addItem(s);
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_2 = new JLabel("Employee:");
		panel_4.add(lblNewLabel_2, "cell 0 2,alignx trailing,aligny center");
		
		JComboBox empComboBox = new JComboBox();
		panel_4.add(empComboBox, "cell 1 2,alignx left");
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT CAST(EmployeeID AS VARCHAR)+', '+Employee.FirstName+' '+Employee.LastName as EMP FROM Employee";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString("EMP");
	         empComboBox.addItem(s);
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		
		JLabel lblNewLabel_4 = new JLabel("Certification Date:");
		panel_4.add(lblNewLabel_4, "cell 0 3,alignx trailing,aligny center");
		

		certdatePanel = new JPanel();
		panel_4.add(certdatePanel, "cell 1 3,alignx left,aligny center");
		 UtilDateModel model=new UtilDateModel();
		    Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
		    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		    dateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		    dateField.getJFormattedTextField().setAlignmentX(Component.LEFT_ALIGNMENT);
		    SpringLayout springLayout = (SpringLayout) dateField.getLayout();
		    springLayout.putConstraint(SpringLayout.WEST, dateField.getJFormattedTextField(), 0, SpringLayout.WEST, dateField);
		    certdatePanel.add(dateField);
		  
		    try {
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");

		    	String sql = "SELECT EmployeeID FROM Employee WHERE EmployeeID = '"+empComboBox.getSelectedItem().toString().substring(0,empComboBox.getSelectedItem().toString().indexOf(','))+"'";
		    	PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();
		        while(rs.next())
		        {
		            String a = rs.getString("EmployeeID");
		            empID = Integer.parseInt(a);
		        }

			}
			catch(SQLException e1) {
			}
			try {
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");

		    String sql = "SELECT CertID FROM Certification WHERE CertName = '"+certComboBox.getSelectedItem().toString()+"'";
		    	PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();
		        while(rs.next())
		        {
		            String a = rs.getString("CertID");
		            certID = Integer.parseInt(a);
		        }

			}
			catch(SQLException e1) {
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
