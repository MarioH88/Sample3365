package display;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import display.CreateStudent.DateLabelFormatter;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RoomRentalWindow {

	private JFrame frmVcaRoom;
	private JTable roomTable;
	private DefaultTableModel roomModel;


	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomRentalWindow window = new RoomRentalWindow();
					window.frmVcaRoom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomRentalWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaRoom = new JFrame();
		frmVcaRoom.setTitle("VCA - Room Reservation");
		frmVcaRoom.setBounds(100, 100, 687, 374);
		frmVcaRoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaRoom.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		frmVcaRoom.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[117px,grow]", "[][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Room Reservation");
		panel.add(lblNewLabel_2, "cell 0 0,alignx center,aligny center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5, "cell 0 1,grow");
		panel_5.setLayout(new MigLayout("", "[117px]", "[23px][]"));
		
		//Room Rental Button
		JButton btnNewButton = new JButton("New Room Reservation");
		panel_5.add(btnNewButton, "cell 0 0,alignx center,aligny center");
		
		JButton btnNewButton_1 = new JButton("Edit Room Reservation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editRoomReserveDialog lucifer2 = new editRoomReserveDialog();
				lucifer2.newWindow();
			}
		});
		panel_5.add(btnNewButton_1, "cell 0 1,alignx center,aligny center");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRoomReserve nrr = new createRoomReserve();
				nrr.createWindow();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		frmVcaRoom.getContentPane().add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 248, 220));
		frmVcaRoom.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 248, 220));
		frmVcaRoom.getContentPane().add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Sort Room Reservations:");
		panel_3.add(lblNewLabel_1);
		 UtilDateModel model=new UtilDateModel();
		    Properties p = new Properties();
	        p.put("text.today", "Today");
	        p.put("text.month", "Month");
	        p.put("text.year", "Year");
		    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		    
		    JButton okButton = new JButton("OK");
		    
		    
		    JComboBox ordercomboBox = new JComboBox();
		    panel_3.add(ordercomboBox);
		    ordercomboBox.addItem("Ascending");
		    ordercomboBox.addItem("Descending");
		    panel_3.add(okButton);
		
		    okButton.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String way ="";
		    		
		    		if(ordercomboBox.getSelectedItem().toString().equals("Ascending"))
		    		{
		    			way = "ASC";
		    		}
		    		else
		    			way = "DESC";
		    		
		    		roomModel.setRowCount(0);
		    		try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT RoomReserve.Reserve, Room.RoomNum, RoomReserve.TimeStart, RoomReserve.TimeEnd"
	    						+ " FROM RoomReserve INNER JOIN"
	    						+ " Room ON RoomReserve.RoomID = Room.RoomID ORDER BY Reserve "+way;
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		            String a = rs.getString("Reserve");
	    		            String b = rs.getString("RoomNum");
	    		            String c = rs.getString("TimeStart");
	    		            String d = rs.getString("TimeEnd");
	    		            roomModel.addRow(new Object[]{a, b, c, d});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
		    		
		    	}
		    });
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaRoom.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		
		roomTable = new JTable();
		roomModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Reservation Date", "Room Number", "Time Start", "Time End"
			}
		);
		roomTable.setModel(roomModel);
		roomTable.getColumnModel().getColumn(0).setPreferredWidth(94);
		roomTable.getColumnModel().getColumn(1).setPreferredWidth(83);
		scrollPane.setViewportView(roomTable);
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
