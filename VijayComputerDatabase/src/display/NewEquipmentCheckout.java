package display;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.CreateStudent.DateLabelFormatter;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class NewEquipmentCheckout {

	private JFrame frmVcaEquipment;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel66;
	private JDatePickerImpl dateField;


	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEquipmentCheckout window = new NewEquipmentCheckout();
					window.frmVcaEquipment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewEquipmentCheckout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaEquipment = new JFrame();
		frmVcaEquipment.setTitle("VCA - Equipment Checkout Form");
		frmVcaEquipment.setBounds(100, 100, 481, 412);
		frmVcaEquipment.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaEquipment.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 222, 179));
		frmVcaEquipment.getContentPane().add(panel, BorderLayout.WEST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 222, 179));
		frmVcaEquipment.getContentPane().add(panel_1, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_1.add(horizontalStrut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 222, 179));
		frmVcaEquipment.getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("VCA Equipment Checkout");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 25));
		panel_2.add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		frmVcaEquipment.getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 222, 179));
		panel_3.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_6);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("You agree to the VCA Equipment Checkout Policy");
		panel_6.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("New Checkout");
		panel_6.add(btnNewButton);
		
		Component verticalStrut = Box.createVerticalStrut(35);
		panel_5.add(verticalStrut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaEquipment.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][grow]", "[grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Equipment Checkout Number:");
		panel_4.add(lblNewLabel_4, "cell 0 0,alignx trailing");
		
		textField_1 = new JTextField();
		panel_4.add(textField_1, "cell 1 0,alignx left,aligny center");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hardware Type:");
		panel_4.add(lblNewLabel, "cell 0 1,alignx trailing");
		
		JComboBox hardwareTypecomboBox = new JComboBox();
		panel_4.add(hardwareTypecomboBox, "cell 1 1,alignx leading,aligny center");
		
	    try{
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	        String sql = "SELECT EquipmentName from EquipmentType";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while(rs.next()){
	         String s = rs.getString(1);
	         hardwareTypecomboBox.addItem(s);
	        }

	        pst.close();
	        rs.close();
	        conn.close();

	    }catch (Exception e){
	        JOptionPane.showMessageDialog(null, e);
	    }
		
		JLabel lblNewLabel_1 = new JLabel("Equipment Serial Number:");
		panel_4.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		textField = new JTextField();
		panel_4.add(textField, "cell 1 2,alignx leading,aligny center");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Checkout Date:");
		panel_4.add(lblNewLabel_2, "cell 0 3,alignx trailing");
		
		panel66 = new JPanel();
		panel_4.add(panel66, "cell 1 3,alignx left,aligny center");
	    UtilDateModel model=new UtilDateModel();
	    Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
	    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
	    dateField = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    SpringLayout springLayout = (SpringLayout) dateField.getLayout();
	    springLayout.putConstraint(SpringLayout.WEST, dateField.getJFormattedTextField(), 0, SpringLayout.WEST, dateField);
	    panel66.add(dateField);
	    
		
		JLabel lblNewLabel_3 = new JLabel("Checkout Time:");
		panel_4.add(lblNewLabel_3, "cell 0 4,alignx trailing");
		
		JPanel timePanel = new JPanel();
		panel_4.add(timePanel, "cell 1 4,alignx leading,aligny center");
		Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner = new JSpinner(sm);
		  JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		  de.setBorder(null);
		  spinner.setEditor(de);
		  timePanel.add(spinner);
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
