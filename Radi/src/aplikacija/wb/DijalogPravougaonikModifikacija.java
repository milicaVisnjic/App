package aplikacija.wb;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Pravougaonik;
import geometrija.Tacka;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogPravougaonikModifikacija extends JDialog {

	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtVisina;
	private JTextField txtSirina;
	JButton btnBojaKonture;
	JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int visina;
	private int sirina;
	Pravougaonik pr1=null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPravougaonikModifikacija dialog = new DijalogPravougaonikModifikacija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonikModifikacija() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		pnlKomande.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][]"));
		{
			JLabel lblX = new JLabel("X koordinata tacke gore levo:");
			pnlKomande.add(lblX, "cell 4 2,alignx trailing");
		}
		{
			txtX = new JTextField();
			pnlKomande.add(txtX, "cell 5 2,alignx center");
			txtX.setColumns(10);
			txtX.setText("" + ((Pravougaonik)GuiCrtanje.getSelektovan()).getGoreLevo().getX());
		}
		{
			JLabel lblY = new JLabel("Y koordinata tacke gore levo:");
			pnlKomande.add(lblY, "cell 4 3,alignx trailing");
		}
		{
			txtY = new JTextField();
			pnlKomande.add(txtY, "cell 5 3,alignx center");
			txtY.setColumns(10);
			txtY.setText(""+ ((Pravougaonik)GuiCrtanje.getSelektovan()).getGoreLevo().getY());
		}
		{
			JLabel lblVisina = new JLabel("Visina:");
			pnlKomande.add(lblVisina, "cell 4 4,alignx left");
		}
		{
			txtVisina = new JTextField();
			pnlKomande.add(txtVisina, "cell 5 4,alignx center");
			txtVisina.setColumns(10);
			txtVisina.setText("" + ((Pravougaonik)GuiCrtanje.getSelektovan()).getVisina());
		}
		{
			JLabel lblSirina = new JLabel("Sirina:");
			pnlKomande.add(lblSirina, "cell 4 5,alignx left");
		}
		{
			txtSirina = new JTextField();
			pnlKomande.add(txtSirina, "cell 5 5,alignx center");
			txtSirina.setColumns(10);
			txtSirina.setText("" + ((Pravougaonik)GuiCrtanje.getSelektovan()).getSirina());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			pnlKomande.add(lblBojaKonture, "cell 4 6,alignx left");
		}
		{
			 btnBojaKonture = new JButton("New button");
			 btnBojaKonture.setBackground(((Pravougaonik)GuiCrtanje.getSelektovan()).getBoja());
			btnBojaKonture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JColorChooser jcc = new JColorChooser();
					Color izborBoje =jcc.showDialog(null, "Izaberite boju za konturu", Color.BLACK);
					btnBojaKonture.setBackground(izborBoje);
				}
			});
			//btnBojaKonture.setBackground(Color.BLACK);
			pnlKomande.add(btnBojaKonture, "cell 5 6,alignx center");
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			pnlKomande.add(lblBojaUnutrasnjosti, "cell 4 7,alignx left");
		}
		{
			 btnBojaUnutrasnjosti = new JButton("New button");
			 btnBojaUnutrasnjosti.setBackground(((Pravougaonik)GuiCrtanje.getSelektovan()).getBojaUnutrasnjosti());
			btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JColorChooser jcc = new JColorChooser();
					Color izborBoje =jcc.showDialog(null, "Izaberite boju za konturu", Color.BLACK);
					btnBojaUnutrasnjosti.setBackground(izborBoje);
				}
			});
			//btnBojaUnutrasnjosti.setBackground(Color.WHITE);
			pnlKomande.add(btnBojaUnutrasnjosti, "cell 5 7,alignx center");
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
							
							x=Integer.parseInt(txtX.getText());
							y=Integer.parseInt(txtY.getText());
							visina=Integer.parseInt(txtVisina.getText());
							sirina=Integer.parseInt(txtSirina.getText());
							
							if (x<=0 || y<=0 || visina<=0 || sirina<=0)
							{
								System.out.println("Greska, broj mora biti pozitivan");
								JOptionPane.showMessageDialog(null, "Greska pri unosu, broj mora biti pozitivan!");
							}
							
							else {
								setVisible(false);
								pr1= new Pravougaonik(new Tacka(x,y), visina, sirina, btnBojaKonture.getBackground(), btnBojaUnutrasnjosti.getBackground());
							}
							
						} catch (Exception e1) {
							
							System.out.println("greska pri unosu, nije unet broj");
							JOptionPane.showMessageDialog(null, "Greska, nije unet broj");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
		}
	}
	
	public Pravougaonik getPodaci()
	{
		
		return pr1;
	}

}
