package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.print.*;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBoxMenuItem;

public class DirectoryWindow {

	private JFrame frmVijayComputerDirectory;
	private JTable studentTable;
	private JTable empTable;
	private JTable busTable;
	private DefaultTableModel studModel;
	private DefaultTableModel empModel;
	private DefaultTableModel busModel;
	private JPanel tablePanel;

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectoryWindow window = new DirectoryWindow();
					window.frmVijayComputerDirectory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DirectoryWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVijayComputerDirectory = new JFrame();
		frmVijayComputerDirectory.setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\communicate.png"));
		frmVijayComputerDirectory.setTitle("VCA - Directory");
		frmVijayComputerDirectory.setBounds(100, 100, 1330, 502);
		frmVijayComputerDirectory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmVijayComputerDirectory.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Print");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Student Directory");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					studentTable.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Employee Directory");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					empTable.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Business Directory");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					busTable.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Hide Info");
		menuBar.add(mnNewMenu_2);
		
		JCheckBoxMenuItem phoneChkBox = new JCheckBoxMenuItem("Phone Numbers");
		phoneChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (phoneChkBox.isSelected() == false){
					studentTable.getColumnModel().getColumn(4).setMinWidth(0);
					studentTable.getColumnModel().getColumn(4).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(4).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(5).setMinWidth(0);
					studentTable.getColumnModel().getColumn(5).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(5).setPreferredWidth(0);
					
					empTable.getColumnModel().getColumn(5).setMinWidth(0);
					empTable.getColumnModel().getColumn(5).setMaxWidth(0);
					empTable.getColumnModel().getColumn(5).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(6).setMinWidth(0);
					empTable.getColumnModel().getColumn(6).setMaxWidth(0);
					empTable.getColumnModel().getColumn(6).setPreferredWidth(0);
					
					busTable.getColumnModel().getColumn(8).setMinWidth(0);
					busTable.getColumnModel().getColumn(8).setMaxWidth(0);
					busTable.getColumnModel().getColumn(8).setPreferredWidth(0);
				}
				else
				{
				    final int width = 85;
					studentTable.getColumnModel().getColumn(4).setMinWidth(15);
					studentTable.getColumnModel().getColumn(4).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(4).setMinWidth(width);
					studentTable.getColumnModel().getColumn(5).setMinWidth(15);
					studentTable.getColumnModel().getColumn(5).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(5).setMinWidth(width);
					
					empTable.getColumnModel().getColumn(5).setMinWidth(15);
					empTable.getColumnModel().getColumn(5).setMaxWidth(width);
					empTable.getColumnModel().getColumn(5).setMinWidth(width);
					empTable.getColumnModel().getColumn(6).setMinWidth(15);
					empTable.getColumnModel().getColumn(6).setMaxWidth(width);
					empTable.getColumnModel().getColumn(6).setMinWidth(width);
					
					busTable.getColumnModel().getColumn(8).setMinWidth(15);
					busTable.getColumnModel().getColumn(8).setMaxWidth(width);
					busTable.getColumnModel().getColumn(8).setMinWidth(width);
				}
			}});
		
		JCheckBoxMenuItem nameChkBox = new JCheckBoxMenuItem("Contact Names");
		nameChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameChkBox.isSelected()==false)
				{
					studentTable.getColumnModel().getColumn(1).setMinWidth(0);
					studentTable.getColumnModel().getColumn(1).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(1).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(2).setMinWidth(0);
					studentTable.getColumnModel().getColumn(2).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(2).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(3).setMinWidth(0);
					studentTable.getColumnModel().getColumn(3).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(3).setPreferredWidth(0);
					
					empTable.getColumnModel().getColumn(1).setMinWidth(0);
					empTable.getColumnModel().getColumn(1).setMaxWidth(0);
					empTable.getColumnModel().getColumn(1).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(2).setMinWidth(0);
					empTable.getColumnModel().getColumn(2).setMaxWidth(0);
					empTable.getColumnModel().getColumn(2).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(3).setMinWidth(0);
					empTable.getColumnModel().getColumn(3).setMaxWidth(0);
					empTable.getColumnModel().getColumn(3).setPreferredWidth(0);
					
					busTable.getColumnModel().getColumn(2).setMinWidth(0);
					busTable.getColumnModel().getColumn(2).setMaxWidth(0);
					busTable.getColumnModel().getColumn(2).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(3).setMinWidth(0);
					busTable.getColumnModel().getColumn(3).setMaxWidth(0);
					busTable.getColumnModel().getColumn(3).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(4).setMinWidth(0);
					busTable.getColumnModel().getColumn(4).setMaxWidth(0);
					busTable.getColumnModel().getColumn(4).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(5).setMinWidth(0);
					busTable.getColumnModel().getColumn(5).setMaxWidth(0);
					busTable.getColumnModel().getColumn(5).setPreferredWidth(0);
				}
				else
				{
					final int width = 65;
					studentTable.getColumnModel().getColumn(1).setMinWidth(15);
					studentTable.getColumnModel().getColumn(1).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(1).setMinWidth(width);
					studentTable.getColumnModel().getColumn(2).setMinWidth(15);
					studentTable.getColumnModel().getColumn(2).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(2).setMinWidth(width);
					studentTable.getColumnModel().getColumn(3).setMinWidth(15);
					studentTable.getColumnModel().getColumn(3).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(3).setMinWidth(width);
					
					empTable.getColumnModel().getColumn(1).setMinWidth(15);
					empTable.getColumnModel().getColumn(1).setMaxWidth(width);
					empTable.getColumnModel().getColumn(1).setMinWidth(width);
					empTable.getColumnModel().getColumn(2).setMinWidth(15);
					empTable.getColumnModel().getColumn(2).setMaxWidth(width);
					empTable.getColumnModel().getColumn(2).setMinWidth(width);
					empTable.getColumnModel().getColumn(3).setMinWidth(15);
					empTable.getColumnModel().getColumn(3).setMaxWidth(width);
					empTable.getColumnModel().getColumn(3).setMinWidth(width);
					
					busTable.getColumnModel().getColumn(2).setMinWidth(15);
					busTable.getColumnModel().getColumn(2).setMaxWidth(width);
					busTable.getColumnModel().getColumn(2).setMinWidth(width);
					busTable.getColumnModel().getColumn(3).setMinWidth(15);
					busTable.getColumnModel().getColumn(3).setMaxWidth(width);
					busTable.getColumnModel().getColumn(3).setMinWidth(width);
					busTable.getColumnModel().getColumn(4).setMinWidth(15);
					busTable.getColumnModel().getColumn(4).setMaxWidth(width);
					busTable.getColumnModel().getColumn(4).setMinWidth(width);
					busTable.getColumnModel().getColumn(5).setMinWidth(15);
					busTable.getColumnModel().getColumn(5).setMaxWidth(width);
					busTable.getColumnModel().getColumn(5).setMinWidth(width);
				}
			}
		});
		nameChkBox.setSelected(true);
		mnNewMenu_2.add(nameChkBox);
		
		JCheckBoxMenuItem emailChkBox = new JCheckBoxMenuItem("Email");
		emailChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (emailChkBox.isSelected()==false)
				{
					studentTable.getColumnModel().getColumn(6).setMinWidth(0);
					studentTable.getColumnModel().getColumn(6).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(6).setPreferredWidth(0);
					
					empTable.getColumnModel().getColumn(7).setMinWidth(0);
					empTable.getColumnModel().getColumn(7).setMaxWidth(0);
					empTable.getColumnModel().getColumn(7).setPreferredWidth(0);
					
					busTable.getColumnModel().getColumn(7).setMinWidth(0);
					busTable.getColumnModel().getColumn(7).setMaxWidth(0);
					busTable.getColumnModel().getColumn(7).setPreferredWidth(0);
					
				}
				else
				{
					final int width = 65;
					studentTable.getColumnModel().getColumn(6).setMinWidth(15);
					studentTable.getColumnModel().getColumn(6).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(6).setPreferredWidth(width);
					
					empTable.getColumnModel().getColumn(7).setMinWidth(15);
					empTable.getColumnModel().getColumn(7).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(7).setPreferredWidth(width);
					
					busTable.getColumnModel().getColumn(7).setMinWidth(15);
					busTable.getColumnModel().getColumn(7).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(7).setPreferredWidth(width);
					
				}
			}
		});
		emailChkBox.setSelected(true);
		mnNewMenu_2.add(emailChkBox);
		
		JCheckBoxMenuItem socialMediaChkBox = new JCheckBoxMenuItem("Social Media");
		socialMediaChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (socialMediaChkBox.isSelected()==false)
				{
					studentTable.getColumnModel().getColumn(14).setMinWidth(0);
					studentTable.getColumnModel().getColumn(14).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(14).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(15).setMinWidth(0);
					studentTable.getColumnModel().getColumn(15).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(15).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(16).setMinWidth(0);
					studentTable.getColumnModel().getColumn(16).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(16).setPreferredWidth(0);
					
					empTable.getColumnModel().getColumn(15).setMinWidth(0);
					empTable.getColumnModel().getColumn(15).setMaxWidth(0);
					empTable.getColumnModel().getColumn(15).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(16).setMinWidth(0);
					empTable.getColumnModel().getColumn(16).setMaxWidth(0);
					empTable.getColumnModel().getColumn(16).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(17).setMinWidth(0);
					empTable.getColumnModel().getColumn(17).setMaxWidth(0);
					empTable.getColumnModel().getColumn(17).setPreferredWidth(0);
					
				}
				else
				{
					final int width = 65;
					studentTable.getColumnModel().getColumn(14).setMinWidth(15);
					studentTable.getColumnModel().getColumn(14).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(14).setMinWidth(width);
					studentTable.getColumnModel().getColumn(15).setMinWidth(15);
					studentTable.getColumnModel().getColumn(15).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(15).setMinWidth(width);
					studentTable.getColumnModel().getColumn(16).setMinWidth(15);
					studentTable.getColumnModel().getColumn(16).setMaxWidth(width);
					studentTable.getColumnModel().getColumn(16).setMinWidth(width);
					
					
					empTable.getColumnModel().getColumn(15).setMinWidth(15);
					empTable.getColumnModel().getColumn(15).setMaxWidth(width);
					empTable.getColumnModel().getColumn(15).setMinWidth(width);
					empTable.getColumnModel().getColumn(16).setMinWidth(15);
					empTable.getColumnModel().getColumn(16).setMaxWidth(width);
					empTable.getColumnModel().getColumn(16).setMinWidth(width);
					empTable.getColumnModel().getColumn(17).setMinWidth(15);
					empTable.getColumnModel().getColumn(17).setMaxWidth(width);
					empTable.getColumnModel().getColumn(17).setMinWidth(width);
				}
			}
		});
		socialMediaChkBox.setSelected(true);
		mnNewMenu_2.add(socialMediaChkBox);
		
		JCheckBoxMenuItem statusChkBox = new JCheckBoxMenuItem("Status");
		statusChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(statusChkBox.isSelected()==false)
				{
					empTable.getColumnModel().getColumn(4).setMinWidth(0);
					empTable.getColumnModel().getColumn(4).setMaxWidth(0);
					empTable.getColumnModel().getColumn(4).setPreferredWidth(0);
					
					busTable.getColumnModel().getColumn(6).setMinWidth(0);
					busTable.getColumnModel().getColumn(6).setMaxWidth(0);
					busTable.getColumnModel().getColumn(6).setPreferredWidth(0);
				}
				else
				{
					final int width = 100;
					empTable.getColumnModel().getColumn(4).setMinWidth(15);
					empTable.getColumnModel().getColumn(4).setMaxWidth(width);
					empTable.getColumnModel().getColumn(4).setMinWidth(width);
					
					busTable.getColumnModel().getColumn(6).setMinWidth(15);
					busTable.getColumnModel().getColumn(6).setMaxWidth(width);
					busTable.getColumnModel().getColumn(6).setMinWidth(width);
				}
			}
		});
		statusChkBox.setSelected(true);
		mnNewMenu_2.add(statusChkBox);
		
		JCheckBoxMenuItem addressChkBox = new JCheckBoxMenuItem("Addresses");
		addressChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addressChkBox.isSelected()==false)
				{
					studentTable.getColumnModel().getColumn(7).setMinWidth(0);
					studentTable.getColumnModel().getColumn(7).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(7).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(8).setMinWidth(0);
					studentTable.getColumnModel().getColumn(8).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(8).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(9).setMinWidth(0);
					studentTable.getColumnModel().getColumn(9).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(9).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(10).setMinWidth(0);
					studentTable.getColumnModel().getColumn(10).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(10).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(11).setMinWidth(0);
					studentTable.getColumnModel().getColumn(11).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(11).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(12).setMinWidth(0);
					studentTable.getColumnModel().getColumn(12).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(12).setPreferredWidth(0);
					studentTable.getColumnModel().getColumn(13).setMinWidth(0);
					studentTable.getColumnModel().getColumn(13).setMaxWidth(0);
					studentTable.getColumnModel().getColumn(13).setPreferredWidth(0);
					
					empTable.getColumnModel().getColumn(8).setMinWidth(0);
					empTable.getColumnModel().getColumn(8).setMaxWidth(0);
					empTable.getColumnModel().getColumn(8).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(9).setMinWidth(0);
					empTable.getColumnModel().getColumn(9).setMaxWidth(0);
					empTable.getColumnModel().getColumn(9).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(10).setMinWidth(0);
					empTable.getColumnModel().getColumn(10).setMaxWidth(0);
					empTable.getColumnModel().getColumn(10).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(11).setMinWidth(0);
					empTable.getColumnModel().getColumn(11).setMaxWidth(0);
					empTable.getColumnModel().getColumn(11).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(12).setMinWidth(0);
					empTable.getColumnModel().getColumn(12).setMaxWidth(0);
					empTable.getColumnModel().getColumn(12).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(13).setMinWidth(0);
					empTable.getColumnModel().getColumn(13).setMaxWidth(0);
					empTable.getColumnModel().getColumn(13).setPreferredWidth(0);
					empTable.getColumnModel().getColumn(14).setMinWidth(0);
					empTable.getColumnModel().getColumn(14).setMaxWidth(0);
					empTable.getColumnModel().getColumn(14).setPreferredWidth(0);
					
					busTable.getColumnModel().getColumn(9).setMinWidth(0);
					busTable.getColumnModel().getColumn(9).setMaxWidth(0);
					busTable.getColumnModel().getColumn(9).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(10).setMinWidth(0);
					busTable.getColumnModel().getColumn(10).setMaxWidth(0);
					busTable.getColumnModel().getColumn(10).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(11).setMinWidth(0);
					busTable.getColumnModel().getColumn(11).setMaxWidth(0);
					busTable.getColumnModel().getColumn(11).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(12).setMinWidth(0);
					busTable.getColumnModel().getColumn(12).setMaxWidth(0);
					busTable.getColumnModel().getColumn(12).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(13).setMinWidth(0);
					busTable.getColumnModel().getColumn(13).setMaxWidth(0);
					busTable.getColumnModel().getColumn(13).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(14).setMinWidth(0);
					busTable.getColumnModel().getColumn(14).setMaxWidth(0);
					busTable.getColumnModel().getColumn(14).setPreferredWidth(0);
					busTable.getColumnModel().getColumn(15).setMinWidth(0);
					busTable.getColumnModel().getColumn(15).setMaxWidth(0);
					busTable.getColumnModel().getColumn(15).setPreferredWidth(0);
				}
				else
				{
					final int width = 65;

					studentTable.getColumnModel().getColumn(7).setMinWidth(15);
					studentTable.getColumnModel().getColumn(7).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(7).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(8).setMinWidth(15);
					studentTable.getColumnModel().getColumn(8).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(8).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(9).setMinWidth(15);
					studentTable.getColumnModel().getColumn(9).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(9).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(10).setMinWidth(15);
					studentTable.getColumnModel().getColumn(10).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(10).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(11).setMinWidth(15);
					studentTable.getColumnModel().getColumn(11).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(11).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(12).setMinWidth(15);
					studentTable.getColumnModel().getColumn(12).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(12).setPreferredWidth(width);
					studentTable.getColumnModel().getColumn(13).setMinWidth(15);
					studentTable.getColumnModel().getColumn(13).setMaxWidth(1000);
					studentTable.getColumnModel().getColumn(13).setPreferredWidth(width);
					
					empTable.getColumnModel().getColumn(8).setMinWidth(15);
					empTable.getColumnModel().getColumn(8).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(8).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(9).setMinWidth(15);
					empTable.getColumnModel().getColumn(9).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(9).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(10).setMinWidth(15);
					empTable.getColumnModel().getColumn(10).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(10).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(11).setMinWidth(15);
					empTable.getColumnModel().getColumn(11).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(11).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(12).setMinWidth(15);
					empTable.getColumnModel().getColumn(12).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(12).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(13).setMinWidth(15);
					empTable.getColumnModel().getColumn(13).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(13).setPreferredWidth(width);
					empTable.getColumnModel().getColumn(14).setMinWidth(15);
					empTable.getColumnModel().getColumn(14).setMaxWidth(10000);
					empTable.getColumnModel().getColumn(14).setPreferredWidth(width);
					
					busTable.getColumnModel().getColumn(9).setMinWidth(15);
					busTable.getColumnModel().getColumn(9).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(9).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(10).setMinWidth(15);
					busTable.getColumnModel().getColumn(10).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(10).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(11).setMinWidth(15);
					busTable.getColumnModel().getColumn(11).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(11).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(12).setMinWidth(15);
					busTable.getColumnModel().getColumn(12).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(12).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(13).setMinWidth(15);
					busTable.getColumnModel().getColumn(13).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(13).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(14).setMinWidth(15);
					busTable.getColumnModel().getColumn(14).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(14).setPreferredWidth(width);
					busTable.getColumnModel().getColumn(15).setMinWidth(15);
					busTable.getColumnModel().getColumn(15).setMaxWidth(1000);
					busTable.getColumnModel().getColumn(15).setPreferredWidth(width);
				}
			}
		});
		addressChkBox.setSelected(true);
		mnNewMenu_2.add(addressChkBox);
		phoneChkBox.setSelected(true);
		mnNewMenu_2.add(phoneChkBox);
		frmVijayComputerDirectory.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tablePanel = new JPanel();
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmVijayComputerDirectory.getContentPane().add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
		
		JPanel studentPanel = new JPanel();
		tablePanel.add(studentPanel, "cell 0 0,grow");
		studentPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Student Directory:");
		studentPanel.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		studentPanel.add(scrollPane, BorderLayout.CENTER);
		
		studentTable = new JTable();
		studModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "First Name", "Middle Initial", "Last Name", "Home Phone", "Mobile Phone", "Email", "Address #", "Address Street", "Address Line 2", "Postal Code", "City", "State / Prov", "Country", "Facebook", "Instagram", "Twitter"
			}
		);
		studentTable.setModel(studModel);
		scrollPane.setViewportView(studentTable);
		
		JPanel empPanel = new JPanel();
		tablePanel.add(empPanel, "cell 0 1,grow");
		empPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Employee Directory:");
		empPanel.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		empPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		empTable = new JTable();
		empModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "First Name", "Middle Initial", "Last Name", "Status", "Home Phone", "Mobile Phone", "Email", "Address #", "Address Street", "Address Line 2", "Postal Code", "City", "State / Prov", "Country", "Facebook", "Instagram", "Twitter"
			}
		);
		empTable.setModel(empModel);
		scrollPane_1.setViewportView(empTable);
		
		JPanel busPanel = new JPanel();
		tablePanel.add(busPanel, "cell 0 2,grow");
		busPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Business Directory:");
		busPanel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		busPanel.add(scrollPane_2, BorderLayout.CENTER);
		
		busTable = new JTable();
		busModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Contact ID", "Business Name", "Title", "First Name", "Middle Initial", "Last Name", "Business Status", "Email", "Phone", "Address #", "Address Street", "Address Line 2", "Postal Code", "City", "State / Prov", "Country"
			}
		);
		busTable.setModel(busModel);
		scrollPane_2.setViewportView(busTable);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		frmVijayComputerDirectory.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		panel_1.add(verticalStrut_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(230, 230, 250));
		frmVijayComputerDirectory.getContentPane().add(panel_4, BorderLayout.EAST);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel_4.add(horizontalStrut);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		frmVijayComputerDirectory.getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new MigLayout("", "[grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Directory Selects:");
		panel_3.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_5, "cell 0 1,alignx center,aligny top");
		panel_5.setLayout(new MigLayout("", "[]", "[][][][][]"));
		
		JCheckBox studChkBox = new JCheckBox("Students");
		studChkBox.setSelected(true);
		panel_5.add(studChkBox, "cell 0 1");
		
		JCheckBox empChkBox = new JCheckBox("Employees");
		empChkBox.setSelected(true);
		panel_5.add(empChkBox, "cell 0 2");
		
		JCheckBox busChkBox = new JCheckBox("Business Contacts");
		busChkBox.setSelected(true);
		panel_5.add(busChkBox, "flowy,cell 0 3,aligny bottom");
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(studChkBox.isSelected())
	    		{
	    			studentPanel.setVisible(true);
	    			studentPanel.setMaximumSize(new Dimension(15000,15000));

	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT Student.StudentID, Student.FirstName, Student.MiddleInital, Student.LastName, Student.HomePhone, Student.MobilePhone, Student.Email, Student.AddressNum, Student.AddressStreet, Student.AddressStreet2, Student.PostalCode, Student.City, StateProv.StateAbvr, Country.CountryAbvr, Student.FaceBookHandle, Student.InstagramHandle, Student.TwitterHandle FROM Student INNER JOIN StateProv ON Student.StateID = StateProv.StateID INNER JOIN Country ON Student.CountryID = Country.CountryID";
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		            String a = rs.getString("StudentID");
	    		            String b = rs.getString("FirstName");
	    		            String c = rs.getString("MiddleInital");
	    		            String d = rs.getString("LastName");
	    		            String e1 = rs.getString("HomePhone");
	    		            String f = rs.getString("MobilePhone");
	    		            String g = rs.getString("Email");
	    		            String h = rs.getString("AddressNum");
	    		            String i = rs.getString("AddressStreet");
	    		            String i2 = rs.getString("AddressStreet2");
	    		            String j = rs.getString("PostalCode");
	    		            String k = rs.getString("City");
	    		            String l = rs.getString("StateAbvr");
	    		            String m = rs.getString("CountryAbvr");
	    		            String n = rs.getString("FacebookHandle");
	    		            String o = rs.getString("InstagramHandle");
	    		            String p = rs.getString("TwitterHandle");
	    		            studModel.addRow(new Object[]{a, b, c, d, e1, f,g,h,i,i2,j,k,l,m,n,o,p});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			studentPanel.setVisible(false);
	    			studModel.setRowCount(0);
	    			studentPanel.setMaximumSize(new Dimension(0,0));

	    		}
	    		if(empChkBox.isSelected())
	    		{
	    			empPanel.setVisible(true);
	    			empPanel.setMaximumSize(new Dimension(15000,15000));

	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT Employee.EmployeeID, Employee.FirstName, Employee.MiddleInitial, Employee.LastName, EmployeeStatus.Status, Employee.HomePhone, Employee.MobilePhone, Employee.Email, Employee.AddressNum,Employee.AddressStreet,Employee.AddressStreet2, Employee.PostalCode, Employee.City, StateProv.StateProvName, Country.CountryName, Employee.FacebookHandle, Employee.InstagramHandle, Employee.TwitterHandle FROM Employee INNER JOIN StateProv ON Employee.StateProvinceID = StateProv.StateID INNER JOIN Country ON Employee.CountryID = Country.CountryID INNER JOIN EmployeeStatus ON Employee.EmployeeStatusID = EmployeeStatus.EmpStatusID";	    				
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		        	String a = rs.getString("EmployeeID");
	    		            String b = rs.getString("FirstName");
	    		            String c = rs.getString("MiddleInitial");
	    		            String d = rs.getString("LastName");
	    		            String d1 = rs.getString("Status");
	    		            String e1 = rs.getString("HomePhone");
	    		            String f = rs.getString("MobilePhone");
	    		            String g = rs.getString("Email");
	    		            String h = rs.getString("AddressNum");
	    		            String i = rs.getString("AddressStreet");
	    		            String i2 = rs.getString("AddressStreet2");
	    		            String j = rs.getString("PostalCode");
	    		            String k = rs.getString("City");
	    		            String l = rs.getString("StateProvName");
	    		            String m = rs.getString("CountryName");
	    		            String n = rs.getString("FacebookHandle");
	    		            String o = rs.getString("InstagramHandle");
	    		            String p = rs.getString("TwitterHandle");
	    		            empModel.addRow(new Object[]{a, b, c, d,d1,e1,f,g,h,i,i2,j,k,l,m,n,o,p});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			empPanel.setVisible(false);
	    			empModel.setRowCount(0);
	    			empPanel.setMaximumSize(new Dimension(0,0));

	    		}
	    		if(busChkBox.isSelected())
	    		{
	    			busPanel.setVisible(true);
	    			busPanel.setMaximumSize(new Dimension(15000,15000));

	    			try {
	    				Connection conn = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER;databaseName=ProductionDB","sa","Cougarnet2020!");
	    				String sql = "SELECT BusinessContact.ContactID, BusinessContact.BusinessName, Title.TitleNAME, BusinessContact.FirstName, BusinessContact.MiddleInitial, BusinessContact.LastName, BusinessStatus.BusinessStatus,BusinessContact.Email, BusinessContact.Phone, BusinessContact.AddressNum, BusinessContact.AddressStreet,BusinessContact.AddressStreet2, BusinessContact.PostalCode, BusinessContact.City, StateProv.StateProvName, Country.CountryName FROM BusinessContact INNER JOIN BusinessStatus ON BusinessContact.BusinessStatusID = BusinessStatus.BusinessStatusID INNER JOIN Title ON BusinessContact.TitleID = Title.TitleID INNER JOIN Country ON BusinessContact.CountryID = Country.CountryID INNER JOIN StateProv ON BusinessContact.StateID = stateProv.StateID";
	    				PreparedStatement pst = conn.prepareStatement(sql);
	    		        ResultSet rs = pst.executeQuery();
	    		        
	    		        while(rs.next())
	    		        {
	    		        	String a = rs.getString("ContactID");
	    		        	String a1 = rs.getString("BusinessName");
	    		        	String a2 = rs.getString("TitleNAME");
	    		            String b = rs.getString("FirstName");
	    		            String c = rs.getString("MiddleInitial");
	    		            String d = rs.getString("LastName");
	    		            String d1 = rs.getString("BusinessStatus");
	    		            String e1 = rs.getString("Email");
	    		            String f = rs.getString("Phone");
	    		            String h = rs.getString("AddressNum");
	    		            String i = rs.getString("AddressStreet");
	    		            String i2 = rs.getString("AddressStreet2");
	    		            String j = rs.getString("PostalCode");
	    		            String k = rs.getString("City");
	    		            String l = rs.getString("StateProvName");
	    		            String m = rs.getString("CountryName");

	    		            busModel.addRow(new Object[]{a,a1,a2, b, c, d,d1,e1,f,h,i,i2,j,k,l,m});
	    		        }

	    			} catch (SQLException e1) {
	    				JOptionPane.showMessageDialog(null, e1);
	    			}
	    		}
	    		else
	    		{
	    			busPanel.setVisible(false);
	    			busModel.setRowCount(0);
	    			busPanel.setMaximumSize(new Dimension(0,0));

	    		}
	    	}
	    });
		panel_5.add(updateButton, "cell 0 4,alignx center,aligny center");
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_2, "cell 0 2");
		
		JLabel lblNewLabel_4 = new JLabel("Business Contacts:");
		panel_3.add(lblNewLabel_4, "cell 0 3,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel, "cell 0 4,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("New Business Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createBusinessContact contact = new createBusinessContact();
				contact.createWindow();
			}
		});
		panel.setLayout(new MigLayout("", "[89px,center]", "[23px][]"));
		panel.add(btnNewButton, "cell 0 0,alignx center,aligny center");
		
		JButton btnNewButton_1 = new JButton("Edit Business Contact");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editBusinessContactDialog diablo = new editBusinessContactDialog();
				diablo.newWindow();
			}
		});
		panel.add(btnNewButton_1, "cell 0 1,alignx center,aligny top");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		frmVijayComputerDirectory.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		panel_2.add(verticalStrut);
	}

}
