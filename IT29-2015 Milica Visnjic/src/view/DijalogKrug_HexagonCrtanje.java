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
	private JTextField txtPoluprecnik;
	private int poluprecnik;


	/**
	 * Create the dialog.
	 */
	public DijalogKrug_HexagonCrtanje() {
		setModal(true); 
		setBounds(100, 100, 403, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[92.00][58px][86px]", "[][20px]"));
		{
			JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
			contentPanel.add(lblPoluprecnik, "cell 1 1,alignx center,aligny center");
		}
		{
			txtPoluprecnik = new JTextField();
			contentPanel.add(txtPoluprecnik, "cell 2 1,alignx left,aligny center");
			txtPoluprecnik.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new CircleConfirmationListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public int getPoluprecnik()
	{
		System.out.println("vracam " + poluprecnik);
		return poluprecnik;
	}

	public String getPoluprecnikText() {
		return txtPoluprecnik.getText();
	}

	public void setPoluprecnik(int poluprecnik) {
			this.poluprecnik = poluprecnik;
	}
	
	public boolean isEnteredData() {
		if(poluprecnik > 0) {
			return true;
		}
		return false;
	}

}
