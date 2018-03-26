package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CircleConfirmationListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class DijalogKrug_HexagonCrtanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private int radius;


	/**
	 * Create the dialog.
	 */
	public DijalogKrug_HexagonCrtanje() {
		setModal(true); 
		setBounds(100, 100, 403, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			JLabel lblPoluprecnik = new JLabel("Radius:");
			contentPanel.add(lblPoluprecnik);
		}
		{
			txtRadius = new JTextField();
			contentPanel.add(txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new CircleConfirmationListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public int getRadius()
	{
		return radius;
	}

	public String getRadiusText() {
		return txtRadius.getText();
	}

	public void setRadius(int radius) {
			this.radius = radius;
	}
	
	public boolean isEnteredData() {
		if(radius > 0) {
			return true;
		}
		return false;
	}

}
