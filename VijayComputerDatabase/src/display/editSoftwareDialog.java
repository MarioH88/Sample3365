package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class editSoftwareDialog {

	private JFrame frame;
	private JTextField softwareTextField;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editSoftwareDialog window = new editSoftwareDialog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editSoftwareDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 146);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[1px][511px]", "[1px]"));
		
		JLabel lblNewLabel = new JLabel("Please enter the \"Software ID#\" to select the software you would like to edit:");
		panel.add(lblNewLabel, "cell 0 0,grow");
		
		softwareTextField = new JTextField();
		panel.add(softwareTextField, "cell 1 0,grow");
		softwareTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 102, 153));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 102, 153));
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editSoftware eSoftware = new editSoftware(Integer.parseInt(softwareTextField.getText()));
				eSoftware.createWindow();
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(153, 102, 153));
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 102, 153));
		frame.getContentPane().add(panel_4, BorderLayout.EAST);
	}

}
