package aplikacija.wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKvadrat extends JDialog {
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzinaIviceKvadrata;
	public int x;
	public int y;
	public String BojaIvice;
	boolean dugmeOK=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogKvadrat dialog = new DijalogKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogKvadrat() {

		setModal(true);

		JLabel lblX = new JLabel("X koordinata tacke gore levo:");
		lblX.setBounds(30, 44, 162, 14);
		getContentPane().add(lblX);

		txtX = new JTextField();
		txtX.setBounds(208, 41, 86, 20);
		getContentPane().add(txtX);
		txtX.setColumns(10);

		JLabel lblPoruka = new JLabel("New label");
		lblPoruka.setBounds(229, 44, 46, 14);
		getContentPane().add(lblPoruka);
		JLabel lblY = new JLabel("Y koordinata tacke gore levo:");
		lblY.setBounds(30, 69, 162, 14);
		getContentPane().add(lblY);

		txtY = new JTextField();
		txtY.setBounds(208, 72, 86, 20);
		getContentPane().add(txtY);
		txtY.setColumns(10);

		JLabel lblBojaIvice = new JLabel("Boja ivice:");
		lblBojaIvice.setBounds(33, 148, 139, 14);
		getContentPane().add(lblBojaIvice);

		JComboBox cbxBojaIvice = new JComboBox();
		cbxBojaIvice.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Crvena", "Plava", "Zuta", "Roza", "Bela", "Ljubicasta", "Zelena"}));
		cbxBojaIvice.setBounds(208, 145, 86, 20);
		getContentPane().add(cbxBojaIvice);

		JLabel lblDuzinaIviceKvadrata = new JLabel("Duzina ivice kvadrata:");
		lblDuzinaIviceKvadrata.setBounds(33, 112, 139, 14);
		getContentPane().add(lblDuzinaIviceKvadrata);

		txtDuzinaIviceKvadrata = new JTextField();
		txtDuzinaIviceKvadrata.setBounds(208, 109, 86, 20);
		getContentPane().add(txtDuzinaIviceKvadrata);
		txtDuzinaIviceKvadrata.setColumns(10);

		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
		lblBojaUnutrasnjosti.setBounds(30, 185, 128, 14);
		getContentPane().add(lblBojaUnutrasnjosti);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Plava", "Bela", "Ljubicasta", "Crvena", "Zuta", "Zelena", "Roza"}));
		comboBox.setBounds(208, 182, 86, 20);
		getContentPane().add(comboBox);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							setVisible(false);
							dugmeOK=true;
						} catch (Exception e1)
						{

							lblPoruka.setText("Greska u unosu");
						}



					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);


			}
			{
				JButton cancelButton = new JButton("Odustani");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}




	}
	// vraca kvadrat
	public Kvadrat getPodaci(){
		Kvadrat k = new Kvadrat(new Tacka(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText())), Integer.parseInt(txtDuzinaIviceKvadrata.getText()));
		return k;
	}
}
