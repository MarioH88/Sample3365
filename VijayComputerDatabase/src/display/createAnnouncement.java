package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import display.CreateStudent.DateLabelFormatter;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.sql.Date;
import java.util.Properties;

import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class createAnnouncement {

	private JFrame frmVcaCreate;
	private JTextField annIDTextField;
	private JDatePickerImpl dateField;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAnnouncement window = new createAnnouncement();
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
	public createAnnouncement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\calendar.png"));
		frmVcaCreate.setTitle("VCA - Create Announcement");
		frmVcaCreate.setBounds(100, 100, 450, 300);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[115px][287px,grow]", "[16px][16px,grow][16px,grow][132px][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Announcement ID:");
		panel.add(lblNewLabel_2, "cell 0 0,alignx right,aligny center");
		
		annIDTextField = new JTextField();
		try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT MAX(AnnouncementID) FROM Announcement";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         int s = rs.getInt(1);
	         int q = s +1;
	         annIDTextField.setText(Integer.toString(q));

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		annIDTextField.setColumns(7);
		annIDTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(annIDTextField, "cell 1 0,alignx left,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("Date of Announcement:");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right,aligny center");
		
		JPanel annPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) annPanel.getLayout();
		flowLayout.setHgap(0);
		panel.add(annPanel, "cell 1 1,alignx left,growy");
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
	    annPanel.add(dateField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Time of Announcement:");
		panel.add(lblNewLabel_1_1, "cell 0 2,alignx right,aligny center");
		
		JPanel timePanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) timePanel.getLayout();
		flowLayout_1.setHgap(0);
		panel.add(timePanel, "cell 1 2,alignx left,growy");
		Date date = new Date(0);
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner = new JSpinner(sm);
		  JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		  de.setBorder(null);
		  spinner.setEditor(de);
		  timePanel.add(spinner);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Announcement Details:");
		panel.add(lblNewLabel_1_1_1, "cell 0 3,growx,aligny center");
		
		JTextArea annTextArea = new JTextArea();
		annTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(annTextArea, "cell 1 3,grow");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" Section Number:");
		panel.add(lblNewLabel_1_1_1_1, "cell 0 4,alignx trailing");
		
		JComboBox classComboBox = new JComboBox();
		panel.add(classComboBox, "cell 1 4,alignx left");
		
		try{
	    	
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    	String sql = "SELECT ClassSection FROM Class";
	        
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         classComboBox.addItem(s);

	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Create Announcement Form");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 255, 255));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_4);
		
		JButton btnNewButton = new JButton("Create");
		panel_4.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int classID = 0;
				
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");

			    	String sql = "SELECT ClassID FROM Class WHERE ClassSection = '"+classComboBox.getSelectedItem().toString()+"'";
			    	PreparedStatement pst = conn.prepareStatement(sql);
			        ResultSet rs = pst.executeQuery();
			        while(rs.next())
			        {
			            String a = rs.getString("ClassID");
			            classID = Integer.parseInt(a);
			        }

				}
				catch(SQLException e1) {
				}
				
				
				try {
					SimpleDateFormat formatT = new SimpleDateFormat("HH:mm:ss");
					String time = formatT.format(spinner.getValue());

			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");

			    	String sql = "INSERT INTO Announcement (ClassID,Date,Time,Announcement,AnnouncementID) VALUES ("+classID+",CAST( '"+dateField.getJFormattedTextField().getText()+"' as date),CAST('"+time+"' AS TIME),'"+annTextArea.getText()+"',"+Integer.parseInt(annIDTextField.getText())+")";
			    	Statement pst = conn.createStatement();
			        pst.executeUpdate(sql);
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);

				}
				catch(Exception e2) {
					e2.printStackTrace();
				}
				finally
				{
					frmVcaCreate.dispose();
				}
			}
		});
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(224, 255, 255));
		frmVcaCreate.getContentPane().add(panel_1_1, BorderLayout.WEST);
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
