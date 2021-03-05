package display;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editEquipment {

	private JFrame frmVcaCreate;
	private JTextField serialTextField;
	private int statusID;
	private int typeID;
	private int softwareID;
	private int equipmentID;

	/**
	 * Launch the application.
	 */
	public  void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editEquipment window = new editEquipment(equipmentID);
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
	public editEquipment(int x) {
		equipmentID = x;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setTitle("VCA - Edit Equipment");
		frmVcaCreate.setBounds(100, 100, 374, 250);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Edit Equipment");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton editEquipment = new JButton("Edit Equipment");
		
		
		
		
		panel_2.add(editEquipment);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Serial Number:");
		panel_4.add(lblNewLabel, "cell 0 0");
		
		serialTextField = new JTextField();
		panel_4.add(serialTextField, "cell 1 0,alignx left");
		serialTextField.setColumns(10);
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT EquipSerialNum FROM Equipment WHERE EquipSerialNum = "+equipmentID;
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
		
		JLabel lblNewLabel_1 = new JLabel("Equipment Type:");
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		JComboBox equipTypeComboBox = new JComboBox();
		panel_4.add(equipTypeComboBox, "cell 1 1,alignx left");
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT EquipmentName FROM EquipmentType";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         equipTypeComboBox.addItem(s);
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
		        String sql = "SELECT        EquipmentType.EquipmentName"
		        		+ " FROM            Equipment INNER JOIN"
		        		+ " EquipmentType ON Equipment.EquipTypeID = EquipmentType.EquipmentID WHERE EquipSerialNum = "+equipmentID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         equipTypeComboBox.setSelectedItem(s);
		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		
		JLabel lblNewLabel_2 = new JLabel("Software:");
		panel_4.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		JComboBox softwareComboBox = new JComboBox();
		panel_4.add(softwareComboBox, "cell 1 2,alignx left");
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT SoftwareName FROM Software";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         softwareComboBox.addItem(s);
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
		        String sql = "SELECT Software.SoftwareName"
		        		+ " FROM Software INNER JOIN"
		        		+ " Equipment ON Software.SoftwareID = Equipment.SoftwareID WHERE EquipSerialNum = "+equipmentID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         softwareComboBox.setSelectedItem(s);
		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		JLabel lblStatusid = new JLabel("Equipment Status:");
		panel_4.add(lblStatusid, "cell 0 3,alignx trailing");
		
		JComboBox statusComboBox = new JComboBox();
		panel_4.add(statusComboBox, "cell 1 3,alignx left");
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT EqpStatus FROM EquipmentStatus";
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         statusComboBox.addItem(s);
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
		        String sql = "SELECT EquipmentStatus.EqpStatus"
		        		+ " FROM EquipmentStatus INNER JOIN"
		        		+ " Equipment ON EquipmentStatus.EquipmentStatusID = Equipment.StatusID WHERE EquipSerialNum = "+equipmentID;
		        PreparedStatement pst = conn.prepareStatement(sql);
		        ResultSet rs = pst.executeQuery();

		        while(rs.next()){
		         String s = rs.getString(1);
		         statusComboBox.setSelectedItem(s);
		        }

		        pst.close();
		        rs.close();
		        conn.close();

		    }catch (Exception e){
		        JOptionPane.showMessageDialog(null, e);
		    }
		 
		 
		 
		 editEquipment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
				    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
				        String sql = "SELECT EquipmentStatusID FROM EquipmentStatus WHERE EqpStatus = '"+statusComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         statusID = i;
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
				        String sql = "SELECT EquipmentID FROM EquipmentType WHERE EquipmentName = '"+equipTypeComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         typeID = i;
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
				        String sql = "SELECT SoftwareID FROM Software WHERE SoftwareName = '"+softwareComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         softwareID = i;
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
				        String sql = "SELECT EquipmentStatusID FROM EquipmentStatus WHERE EqpStatus = '"+statusComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         statusID = i;
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
				        String sql = "SELECT EquipmentID FROM EquipmentType WHERE EquipmentName = '"+equipTypeComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         typeID = i;
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
				        String sql = "SELECT SoftwareID FROM Software WHERE SoftwareName = '"+softwareComboBox.getSelectedItem().toString()+"'";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        ResultSet rs = pst.executeQuery();

				        while(rs.next()){
				         int i = rs.getInt(1);
				         softwareID = i;
				        }

				        pst.close();
				        rs.close();
				        conn.close();

				    }catch (Exception e){
				        JOptionPane.showMessageDialog(null, e);
				    }
					try {
				    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
				    	String sql = "UPDATE Equipment SET EquipSerialNum = "+Integer.parseInt(serialTextField.getText())+
				    			", EquipTypeID = "+typeID+
				    			", SoftwareID ="+softwareID+
				    			", StatusID = "+statusID+
				    			" WHERE EquipSerialNum = "+equipmentID;
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
}
