package aplikacija.wb;

import java.awt.BorderLayout;
import geometrija.Pravougaonik;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import geometrija.Tacka;

public class DijalogPravougaonik extends JDialog {

	private final JPanel pnlDijalog = new JPanel();
	private JTextField txtDuzina;
	private JTextField txtSirina;
	private int x;
	private int y;
	protected int sirina;
	protected int duzina;
	Pravougaonik pravougaonik=null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonik dialog = new DijalogPravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonik() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlDijalog.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlDijalog, BorderLayout.CENTER);
		pnlDijalog.setLayout(null);
		{
			JLabel lblDuzina = new JLabel("Duzina:");
			lblDuzina.setBounds(97, 68, 69, 14);
			pnlDijalog.add(lblDuzina);
		}
		{
			txtDuzina = new JTextField();
			txtDuzina.setBounds(229, 65, 86, 20);
			pnlDijalog.add(txtDuzina);
			txtDuzina.setColumns(10);
		}
		{
			JLabel lblSirina = new JLabel("Sirina:");
			lblSirina.setBounds(97, 93, 69, 14);
			pnlDijalog.add(lblSirina);
		}
		{
			txtSirina = new JTextField();
			txtSirina.setBounds(229, 96, 86, 20);
			pnlDijalog.add(txtSirina);
			txtSirina.setColumns(10);
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
							
							
							duzina=Integer.parseInt(txtDuzina.getText());
							sirina=Integer.parseInt(txtSirina.getText());
					

						if ( duzina <= 0 || sirina <=0 )
								
						{
							System.out.println("greska br mora biti pozitivan!!");
							JOptionPane.showMessageDialog(null, "Greska u unosu, broj mora biti pozitivan!!");
						}
						else
						{
							sirina=Integer.parseInt(txtSirina.getText());
							duzina=Integer.parseInt(txtDuzina.getText());
							setVisible(false);
						}
						
							
						} catch (Exception e1) {
							
							System.out.println("greska pri unosu nije unet broj");
							JOptionPane.showMessageDialog(null, "Greska pri unosu nije unet broj");
						}
						
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}
	public int  getSirina ()
	{
		return sirina;
	}
	public int getDuzina()
	{
		return duzina;
	}

}
