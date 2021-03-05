package display;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class helpSent extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		try {
			helpSent dialog = new helpSent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public helpSent() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("VijayComputerDatabase\\VijayComputerDatabase\\resources\\logo.png"));
		setTitle("Ticket Recieved");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 102, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new MigLayout("", "[274px,grow,center]", "[14px,grow][grow]"));
				{
					JLabel lblNewLabel = new JLabel("Your help ticket is being submitted to Red Cougar Data!");
					panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny bottom");
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Sorry for any inconvience! Please remember to submit the email.");
					panel_1.add(lblNewLabel_1, "cell 0 1,alignx center,aligny top");
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 102, 204));
			getContentPane().add(panel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 102, 204));
			getContentPane().add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 102, 204));
			getContentPane().add(panel, BorderLayout.EAST);
		}
	}

}
