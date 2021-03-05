package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.CreateStudent.DateLabelFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class NewReturnCheckout {

	private JFrame frmVcaReturn;
	private JDatePickerImpl dateField;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewReturnCheckout window = new NewReturnCheckout();
					window.frmVcaReturn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewReturnCheckout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaReturn = new JFrame();
		frmVcaReturn.setTitle("VCA - Return Equipment");
		frmVcaReturn.setBounds(100, 100, 450, 300);
		frmVcaReturn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaReturn.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		frmVcaReturn.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		frmVcaReturn.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Return Equipment Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		frmVcaReturn.getContentPane().add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 255, 250));
		frmVcaReturn.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_5);
		
		JButton btnReturnEquipment = new JButton("Return Equipment");
		panel_5.add(btnReturnEquipment);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaReturn.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][grow]", "[][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Select Equipment to be returned:");
		panel_4.add(lblNewLabel_1, "cell 0 0,alignx trailing,aligny center");
		
		JComboBox equipmentComboBox = new JComboBox();
		panel_4.add(equipmentComboBox, "cell 1 0,alignx left,aligny center");
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT EquipSerialNum FROM EquipCheckout WHERE ReturnDate = null OR ReturnTime = null";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         equipmentComboBox.addItem(s);

		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		JLabel lblNewLabel_2 = new JLabel("Date Returned:");
		panel_4.add(lblNewLabel_2, "cell 0 1,alignx trailing,aligny center");
		UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    dateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    SpringLayout springLayout = (SpringLayout) dateField.getLayout();
	    springLayout.putConstraint(SpringLayout.WEST, dateField.getJFormattedTextField(), 0, SpringLayout.WEST, dateField);
	    panel_4.add(dateField, "alignx left,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Time Returned:");
		panel_4.add(lblNewLabel_3, "cell 0 2,alignx trailing,aligny center");
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, "cell 1 2,alignx left,aligny center");
		Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner = new JSpinner(sm);
		  JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		  de.setBorder(null);
		  spinner.setEditor(de);
		  panel_7.add(spinner);
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
