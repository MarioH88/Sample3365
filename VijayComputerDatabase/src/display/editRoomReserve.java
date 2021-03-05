package display;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
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
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.createAnnouncement.DateLabelFormatter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editRoomReserve {

	private JFrame frmVcaCreate;
	private JTextField serialTextField;
 JDatePickerImpl dateField;
	private int roomID;
	private int roomReserveID;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editRoomReserve window = new editRoomReserve(roomReserveID);
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
	public editRoomReserve(int x) {
		roomReserveID = x;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setTitle("VCA - Edit Room Reservation");
		frmVcaCreate.setBounds(100, 100, 401, 294);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Edit Room Reservation");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton editEquipment = new JButton("Edit Reservation");
		
		
		
		
		panel_2.add(editEquipment);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Room Reserve ID:");
		panel_4.add(lblNewLabel, "cell 0 0,alignx trailing,aligny center");
		
		serialTextField = new JTextField();
		panel_4.add(serialTextField, "cell 1 0,alignx left");
		serialTextField.setColumns(4);
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT RoomReserveID FROM RoomReserve WHERE RoomReserveID = "+roomReserveID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         int s = rs.getInt(1);
		         serialTextField.setText(Integer.toString(s));

		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		JLabel lblNewLabel_1 = new JLabel("Room:");
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		JComboBox roomcomboBox = new JComboBox();
		panel_4.add(roomcomboBox, "cell 1 1,alignx left");
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT RoomNum FROM Room";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         int s = rs.getInt(1);
		        roomcomboBox.addItem(Integer.toString(s));

		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Reservation Date:");
		panel_4.add(lblNewLabel_1_1, "cell 0 2,alignx right");
		
		JPanel resPanel = new JPanel();
		panel_4.add(resPanel, "cell 1 2,alignx left,aligny center");
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
		    resPanel.add(dateField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Time Start:\r\n");
		panel_4.add(lblNewLabel_1_2, "cell 0 3,alignx right");
		
		JPanel timeStartPanel = new JPanel();
		panel_4.add(timeStartPanel, "cell 1 3,alignx left,aligny center");
		Date date = new Date(0);
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner = new JSpinner(sm);
		  JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm:ss");
		  de.setBorder(null);
		  spinner.setEditor(de);
		  timeStartPanel.add(spinner);
		
		JLabel lblNewLabel_1_3 = new JLabel("Time End:");
		panel_4.add(lblNewLabel_1_3, "cell 0 4,alignx right");
		
		JPanel timeEndPanel = new JPanel();
		panel_4.add(timeEndPanel, "cell 1 4,alignx left,aligny center");
		Date date2 = new Date(0);
		  SpinnerDateModel sm2 = 
		  new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
		  JSpinner spinner2 = new JSpinner(sm2);
		  JSpinner.DateEditor de2 = new JSpinner.DateEditor(spinner2, "HH:mm:ss");
		  de.setBorder(null);
		  spinner2.setEditor(de2);
		  timeEndPanel.add(spinner2);
		
		  
		  try {
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");

		    	String sql = "SELECT RoomID FROM Room WHERE RoomNum = '"+roomcomboBox.getSelectedItem().toString()+"'";
		    	PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();
		        while(rs.next())
		        {
		            String a = rs.getString("RoomID");
		            roomID = Integer.parseInt(a);
		        }

			}
			catch(SQLException e1) {
			}
			 
		  try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT * FROM RoomReserve WHERE RoomReserveID = "+roomReserveID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();
		        while(rs.next())
		        {
		        	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

		        	roomcomboBox.setSelectedIndex(rs.getInt("RoomID")-1);
		        	dateField.getJFormattedTextField().setText((rs.getString("Reserve")));
		        	spinner.setValue(format.parse(rs.getString("TimeStart")));
		        	spinner2.setValue(format.parse(rs.getString("TimeEnd")));


		        }
		        pst.close();
		        rs.close();
		        conn.close();

		    }
			catch (SQLException e1){
		        JOptionPane.showMessageDialog(null, e1);
		    }
			catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		  
		  
		  
		  
		  editEquipment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						
						SimpleDateFormat formatT = new SimpleDateFormat("HH:mm:ss");
						String time = formatT.format(spinner.getValue());
						String time2 = formatT.format(spinner2.getValue());
						
				    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
				        String sql = "UPDATE RoomReserve "
				        		+ "SET RoomReserveID = "+Integer.parseInt(serialTextField.getText())+","
				        				+ "RoomID = "+(roomcomboBox.getSelectedIndex()+1)+","
				        						+ "Reserve = CAST( '"+dateField.getJFormattedTextField().getText()+"' as date),"
				        								+ "TimeStart = CAST('"+time+"' AS TIME), "
				        										+ "TimeEnd = CAST('"+time2+"' AS TIME) "
				        												+ "WHERE RoomReserveID = "+roomReserveID;
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
