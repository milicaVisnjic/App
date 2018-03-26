package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ModificationRectangleListener;
import controller.SelectColorMouseAdapter;
import model.Point;
import model.Rectangle;
import model.Shape;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogPravougaonikModifikacija extends JDialog {

	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtVisina;
	private JTextField txtSirina;
	private JButton btnBojaKonture;
	private JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int visina;
	private int sirina;
	private Rectangle pr1=null;
	

	/**
	 * Create the dialog.
	 */
	public DijalogPravougaonikModifikacija(Shape selectedShape) {
		setModal(true);
		setBounds(100, 100, 358, 264);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		pnlKomande.setLayout(new MigLayout("", "[170.00][166.00,grow]", "[][][][][12.00][17.00]"));
		{
			JLabel lblX = new JLabel("X koordinata tacke gore levo:");
			pnlKomande.add(lblX, "cell 0 0,alignx trailing");
		}
		{
			txtX = new JTextField();
			pnlKomande.add(txtX, "cell 1 0,alignx center");
			txtX.setColumns(10);
			txtX.setText("" + ((Rectangle)selectedShape).getTopLeftPoint().getX());
		}
		{
			JLabel lblY = new JLabel("Y koordinata tacke gore levo:");
			pnlKomande.add(lblY, "cell 0 1,alignx trailing");
		}
		{
			txtY = new JTextField();
			pnlKomande.add(txtY, "cell 1 1,alignx center");
			txtY.setColumns(10);
			txtY.setText(""+ ((Rectangle)selectedShape).getTopLeftPoint().getY());
		}
		{
			JLabel lblVisina = new JLabel("Visina:");
			pnlKomande.add(lblVisina, "cell 0 2,alignx right");
		}
		{
			txtVisina = new JTextField();
			pnlKomande.add(txtVisina, "cell 1 2,alignx center");
			txtVisina.setColumns(10);
			txtVisina.setText("" + ((Rectangle)selectedShape).getHeight());
		}
		{
			JLabel lblSirina = new JLabel("Sirina:");
			pnlKomande.add(lblSirina, "cell 0 3,alignx right");
		}
		{
			txtSirina = new JTextField();
			pnlKomande.add(txtSirina, "cell 1 3,alignx center");
			txtSirina.setColumns(10);
			txtSirina.setText("" + ((Rectangle)selectedShape).getWidth());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			pnlKomande.add(lblBojaKonture, "cell 0 4,alignx right");
		}
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((Rectangle)selectedShape).getColor());
			btnBojaKonture.addMouseListener(new SelectColorMouseAdapter());
			//btnContourColor.setBackground(Color.BLACK);
			pnlKomande.add(btnBojaKonture, "cell 1 4,alignx center,growy");
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			pnlKomande.add(lblBojaUnutrasnjosti, "cell 0 5,alignx right");
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((Rectangle)selectedShape).getInsideColor());
			btnBojaUnutrasnjosti.addMouseListener(new SelectColorMouseAdapter());
			//btnAreaColor.setBackground(Color.WHITE);
			pnlKomande.add(btnBojaUnutrasnjosti, "cell 1 5,alignx center,growy");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ModificationRectangleListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
		}
	}
	
	public Rectangle getPodaci()
	{
		
		return pr1;
	}

	public String getx() {
		return txtX.getText();
	}
	
	public String gety() {
		return txtY.getText();
	}
	public String getVisinaText() {
		return txtVisina.getText();
	}
	public String getSirinaText() {
		return txtSirina.getText();
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.pr1= rectangle;
	}

	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
	
	public JButton getBtnBojaKonture() {
		return btnBojaKonture;
	}
	

}
