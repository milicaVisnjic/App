package aplikacija.wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKvadrataCrtanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private int duzinaStranice;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDuzinaStranice = new JLabel("Duzina stranice");
			GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
			gbc_lblDuzinaStranice.insets = new Insets(0, 0, 0, 5);
			gbc_lblDuzinaStranice.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblDuzinaStranice.gridx = 3;
			gbc_lblDuzinaStranice.gridy = 3;
			contentPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.fill = GridBagConstraints.BOTH;
			gbc_txtDuzinaStranice.gridx = 5;
			gbc_txtDuzinaStranice.gridy = 3;
			contentPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							duzinaStranice=Integer.parseInt(txtDuzinaStranice.getText());
							if (duzinaStranice <= 0)
							{
								System.out.println("Duzina stranice mora biti pozitivna!!");
								JOptionPane.showMessageDialog(null, "Duzina stranice mora biti pozitivna");
							}
							else
							{
								setVisible(false);
							}
							
						} catch (Exception e1) {
							
							System.out.println("Nije unet broj");
							JOptionPane.showMessageDialog(null, "Mora broj da se unese");
							
							
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public int getDuzinaStranice()
	{

		return duzinaStranice;
	}

}


