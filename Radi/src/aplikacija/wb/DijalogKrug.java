package aplikacija.wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;
	private int poluprecnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKrug dialog = new DijalogKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKrug() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
			GridBagConstraints gbc_lblPoluprecnik = new GridBagConstraints();
			gbc_lblPoluprecnik.insets = new Insets(0, 0, 0, 5);
			gbc_lblPoluprecnik.gridx = 3;
			gbc_lblPoluprecnik.gridy = 2;
			contentPanel.add(lblPoluprecnik, gbc_lblPoluprecnik);
		}
		{
			txtPoluprecnik = new JTextField();
			GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
			gbc_txtPoluprecnik.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPoluprecnik.gridx = 5;
			gbc_txtPoluprecnik.gridy = 2;
			contentPanel.add(txtPoluprecnik, gbc_txtPoluprecnik);
			txtPoluprecnik.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try{
							poluprecnik=Integer.parseInt(txtPoluprecnik.getText());
							
							if (poluprecnik <= 0)
							{
								System.out.println("Poluprecnik je negativan, greska");
								JOptionPane.showMessageDialog(null, "Poluprecnik ne moze da bude negativan!");
							}
							else
							{
								
								setVisible(false);
							}
							
						} catch (Exception e1) {
							
							System.out.println("nije unet broj!!!");
							JOptionPane.showMessageDialog(null, "Greska u unosu, nije unet broj!");
						
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public int getPoluprecnik()
	{
		
		return poluprecnik;
	}

}
