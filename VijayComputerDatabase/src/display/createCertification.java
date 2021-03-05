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

public class createCertification {

	private JFrame frmVcaCreate;
	private JTextField serialTextField;
	private int statusID;
	private int typeID;
	private int softwareID;
	private JTextField nameTextField;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createCertification window = new createCertification();
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
	public createCertification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaCreate = new JFrame();
		frmVcaCreate.setTitle("VCA - Create Certification");
		frmVcaCreate.setBounds(100, 100, 374, 250);
		frmVcaCreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaCreate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Create Certification");
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton createEquipment = new JButton("Create Certification");
		createEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			        String sql = "INSERT INTO Certification (CertID,CertName) VALUES ("+Integer.parseInt(serialTextField.getText())+",'"+nameTextField.getText()+"')";
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
		
		
		
		panel_2.add(createEquipment);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 204));
		frmVcaCreate.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVcaCreate.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Certification ID:");
		panel_4.add(lblNewLabel, "cell 0 0,alignx trailing,aligny center");
		
		serialTextField = new JTextField();
		panel_4.add(serialTextField, "cell 1 0,alignx left");
		serialTextField.setColumns(4);
		
		 try{
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
		        String sql = "SELECT MAX(CertID) FROM Certification";
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
		
		JLabel lblNewLabel_1 = new JLabel("Certification Name:");
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(25);
		panel_4.add(nameTextField, "cell 1 1,alignx left");
		
	}

}
