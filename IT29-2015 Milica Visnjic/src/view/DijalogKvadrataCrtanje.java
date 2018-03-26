package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SquareConfirmationListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class DijalogKvadrataCrtanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private int duzinaStranice;
	private boolean enteredData ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrataCrtanje dialog = new DijalogKvadrataCrtanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKvadrataCrtanje() {
		setModal(true);
		setBounds(100, 100, 410, 126);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[120.00][73px][86px]", "[20px]"));
		{
			JLabel lblDuzinaStranice = new JLabel("Duzina stranice");
			contentPanel.add(lblDuzinaStranice, "cell 1 0,alignx right,aligny bottom");
		}
		{
			txtDuzinaStranice = new JTextField();
			contentPanel.add(txtDuzinaStranice, "cell 2 0,alignx left,growy");
			txtDuzinaStranice.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new SquareConfirmationListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.enteredData = false;
	}
	
	public String getDuzinaText() {
		return txtDuzinaStranice.getText();
	}
	public void setDuzinaStranice(int duzinaStranice) {
		this.enteredData=true;
		this.duzinaStranice = duzinaStranice;
	}
	public int getDuzinaStranice()
	{

		return duzinaStranice;
	}

	public boolean isEnteredData() {
		return enteredData;
	}


}


