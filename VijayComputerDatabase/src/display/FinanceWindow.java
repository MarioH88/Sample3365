package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

public class FinanceWindow {

	private JFrame frmVcaFinances;
	private JTable finTable;
	private DefaultTableModel finModel;

	/**
	 * Launch the application.
	 */
	public void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinanceWindow window = new FinanceWindow();
					window.frmVcaFinances.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinanceWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVcaFinances = new JFrame();
		frmVcaFinances.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\resources\\hand.png"));
		frmVcaFinances.setTitle("VCA - Finances");
		frmVcaFinances.setBounds(100, 100, 673, 353);
		frmVcaFinances.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVcaFinances.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 255));
		frmVcaFinances.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[10px]", "[10px]"));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, "cell 0 0,alignx left,aligny top");
		panel_5.setLayout(new MigLayout("", "[89px]", "[23px]"));
		
		JButton btnNewButton = new JButton("New button");
		panel_5.add(btnNewButton, "cell 0 0,alignx left,aligny top");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 0, 255));
		frmVcaFinances.getContentPane().add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 0, 255));
		frmVcaFinances.getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 0, 255));
		frmVcaFinances.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		frmVcaFinances.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		
		finTable = new JTable();
		finModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Pay Date","Employee ID", "Name",  "Total Payment", "Pay Type"
			}
		);
		finTable.setModel(finModel);
		finTable.getColumnModel().getColumn(3).setPreferredWidth(83);
		finTable.getColumnModel().getColumn(4).setPreferredWidth(88);
		scrollPane.setViewportView(finTable);
		
		JMenuBar menuBar = new JMenuBar();
		frmVcaFinances.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
			String sql = "SELECT Employee.EmployeeID,(Employee.FirstName + ' ' + Employee.LastName) as Name, EmpPayHistory.Date, EmpPayHistory.PayAmount, PayType.PayType"
					+ " FROM Employee INNER JOIN"
					+ " PayType ON Employee.PayTypeID = PayType.PayTypeID INNER JOIN"
					+ " EmpPayHistory ON Employee.EmployeeID = EmpPayHistory.EmpID ORDER BY Date DESC";
			PreparedStatement pst = conn.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        
	        while(rs.next())
	        {
	        	String b = rs.getString("Date");
	            String a = rs.getString("EmployeeID");
	            String a1 = rs.getString("Name");
	        
	            String c = rs.getString("PayAmount");
	            String d = rs.getString("PayType");

	            finModel.addRow(new Object[]{b,a,a1,  c, d});
	        }

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
	}

}
